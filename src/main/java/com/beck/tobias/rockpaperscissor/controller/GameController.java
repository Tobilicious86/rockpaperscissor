package com.beck.tobias.rockpaperscissor.controller;

import com.beck.tobias.rockpaperscissor.persistence.domain.Game;
import com.beck.tobias.rockpaperscissor.persistence.domain.GameState;
import com.beck.tobias.rockpaperscissor.persistence.domain.Weapon;
import com.beck.tobias.rockpaperscissor.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;


/**
 * RestController of Rock, Paper, Scissor
 */
@RequestMapping(value = "/games")
@RestController
public class GameController {

    private GameService service;

    @Autowired
    public GameController(GameService service){
        this.service = service;
    }

    /**
     * Starts a quick Game
     * @param weapon player Plays with
     * @return a game
     */
    @RequestMapping(method = RequestMethod.POST, value = "/playnewgame")
    @ResponseStatus(HttpStatus.OK)
    public Game playAGame(@RequestParam(value = "weapon") Weapon weapon) {
        Game game = new Game();
        service.createNewGame(game);
        playGame(game.getGameId(), weapon);
        service.saveGame(game);

        return game;
    }

    /**
     * Creates a new empty Game
     * @return a new URL for the created Game
     */
    @RequestMapping(method = RequestMethod.POST, value = "/newGame")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity newGame() {
        Game game = new Game();
        service.createNewGame(game);

       HttpHeaders headers = new HttpHeaders();
        headers.setLocation(linkTo(GameController.class).slash(game.getGameId()).toUri());

        return new ResponseEntity(headers, HttpStatus.MOVED_PERMANENTLY);
    }

    /**
     * Get-Method to get a Game with given ID
     * @param id of Game
     * @return a Game with given id
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Game getGame(@PathVariable Long id){

        return service.loadGame(id);
    }

    /**
     * Loads a game with ID and sets the player Weapon and plays the Game
     *
     * @param id           of Game that should be loaded
     * @param playerWeapon Weapon of player
     * @return the played Game
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Game playGame(@PathVariable Long id, @RequestParam(value = "weapon") Weapon playerWeapon) {
        Game game = service.loadGame(id);

        return service.playGame(game.getGameId(), playerWeapon);


    }

    /**
     * History of finished Games
     *
     * @return a List with all finished Games
     */
    @RequestMapping(method = RequestMethod.GET, value = "/hist")
    @ResponseStatus(HttpStatus.OK)
    public List<Game> showHist() {
        return service.getGameByStatus(GameState.FINISH);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/")
    @ResponseStatus(HttpStatus.OK)
    public List<Game> showAllGames() {
        return service.getAllGames();
    }


}
