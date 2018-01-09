package com.beck.tobias.rockpaperscissor.service;

import com.beck.tobias.rockpaperscissor.persistence.domain.Game;
import com.beck.tobias.rockpaperscissor.persistence.domain.GameStatus;
import com.beck.tobias.rockpaperscissor.persistence.domain.Weapon;
import com.beck.tobias.rockpaperscissor.persistence.exceptions.WeaponException;
import com.beck.tobias.rockpaperscissor.persistence.repository.GameRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;


@Service
@RequiredArgsConstructor
@Getter
public class GameService {

    @Autowired
    private GameRepository gameRepository;
    private Game game;

    /**
     * Load the Game with
     * @param id
     */
    public void loadGame(Long id) {

        if(gameRepository.existsGameByGameId(id)){
            this.game = gameRepository.findOne(id);
        }
    }

    /**
     * Creates a new Game and put it to Repository
     * @param game
     */
    public void createGame(Game game){
        game.setStatus(GameStatus.WaitForPlayerInput);
        gameRepository.save(game);
        this.game =game;
    }

    /**
     * Choose a random weapon
     * @return a random Weapon
     */
    public Weapon randomWeapon(){
        return Weapon.values()[new Random().nextInt(Weapon.values().length)];
    }


    /**
     * get All not finished Games
     * @return List of not finished Games
     */
    public List<Game> findNotFinishedGames(){
        return gameRepository.findByStatusNot(GameStatus.Finish);
    }

    /**
     * Looking for a winner in a Normal Game
     * @param game
     * @return the Winner of a normal Game
     * @throws WeaponException
     */
    public Game.Winner findWinner(Game game) throws WeaponException {

        if (game.getPlayer().equals(game.getCpu())) {
            return Game.Winner.DRAW;
        } else if (game.getPlayer().equals(Weapon.Paper)) {
            if (game.getCpu().equals(Weapon.Rock)) {
                return Game.Winner.PLAYER;
            } else {
                return Game.Winner.CPU;
            }

        } else if (game.getPlayer().equals(Weapon.Rock)) {
            if (game.getCpu().equals(Weapon.Scissor)) {
                return Game.Winner.PLAYER;
            } else {
                return Game.Winner.CPU;
            }
        } else if (game.getPlayer().equals(Weapon.Scissor)) {
            if (game.getCpu().equals(Weapon.Paper)) {
                return Game.Winner.PLAYER;
            } else {
                return Game.Winner.CPU;
            }
        }
        else{
            throw new WeaponException(game.getPlayer().toString());
        }


    }


}
