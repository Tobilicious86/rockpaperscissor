package com.beck.tobias.rockpaperscissor.controller;

import com.beck.tobias.rockpaperscissor.persistence.domain.Game;
import com.beck.tobias.rockpaperscissor.persistence.domain.GameStatus;
import com.beck.tobias.rockpaperscissor.persistence.domain.Weapon;
import com.beck.tobias.rockpaperscissor.persistence.exceptions.WeaponException;
import com.beck.tobias.rockpaperscissor.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * RestController of Rock, Paper, Scissor
 */
@RestController
public class GameController {

    GameService service;


    @Autowired
    public GameController(GameService service){
        this.service = service;
    }

    /**
     * Quick Game, choose Weapon and it starts,
     * when Option is "withBrunnen" more Weapons are possible,
     * all others will be set as normal and a normal Rock Paper Scissor Game
     * @param weapon
     * @param option
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/playagame")
    public Game playAGame (@RequestParam(value = "weapon") Weapon weapon, @RequestParam(value = "type", required = false, defaultValue = "normal") String option) throws WeaponException {

        Game game = new Game();
        Weapon weaponPlayer;
        Weapon weaponCpu;
        String typeOfGame;

        typeOfGame = option;

        if (!typeOfGame.equals("withBrunnen")) {

            try {
                weaponPlayer = weapon;
            } catch (IllegalArgumentException e) {
                game.setStatus(GameStatus.Error);

                throw new WeaponException(weapon.toString());

            }
            weaponCpu = service.randomWeapon();

            game.setCpu(weaponCpu);
            game.setPlayer(weaponPlayer);

            service.getGameRepository().save(game);
            game.setWinner(service.findWinner(game));
            game.setStatus(GameStatus.Finish);

            service.getGameRepository().save(game);
            return game;

        }
        else {
            return new Game();
        }
    }



    /**
     * Starts a new Empty Game and add it to Repository
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/newGame")
    @ResponseStatus(HttpStatus.CREATED)
    public HttpHeaders newGame(){
        Game game = new Game();
        service.createGame(game);

       HttpHeaders headers = new HttpHeaders();
        headers.setLocation(linkTo(GameController.class).slash(game.getGameId()).toUri());

        return headers;
    }

    /**
     * Returns a List with all not Finished Games
     * @return List of open Games
     */
    @RequestMapping(method = RequestMethod.GET, value="/openGames")
    @ResponseStatus(HttpStatus.OK)
    public List<Game> showOpenGames(){
        return service.findNotFinishedGames();
    }

    /**
     * loads the Game with
     * @param id
     * @return Game with ID in Parameter
     */
    @RequestMapping(method = RequestMethod.GET, value = "/game/{id}")
    public Game getGame(@PathVariable Long id){
        service.loadGame(id);
        Game game = service.getGame();
        return game;
    }
    @ExceptionHandler
    @RequestMapping(method = RequestMethod.PUT, value = "/game/{id}/play")
    public void playGame (@PathVariable Long id, @RequestParam(value = "weapon") Weapon weapon) throws WeaponException {
        service.loadGame(id);

        try {
            service.getGame().setPlayer(weapon);
        }catch(IllegalArgumentException e){
            throw new WeaponException(weapon.toString());
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "game/hist")
    public List<Game> showHist(){
        return service.getGameRepository().findByStatus(GameStatus.Finish);
    }

}
