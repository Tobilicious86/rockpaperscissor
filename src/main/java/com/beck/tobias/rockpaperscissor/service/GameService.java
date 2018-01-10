package com.beck.tobias.rockpaperscissor.service;

import com.beck.tobias.rockpaperscissor.persistence.domain.Game;
import com.beck.tobias.rockpaperscissor.persistence.domain.GameState;
import com.beck.tobias.rockpaperscissor.persistence.domain.Weapon;
import com.beck.tobias.rockpaperscissor.persistence.exceptions.GameNotFoundException;
import com.beck.tobias.rockpaperscissor.persistence.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class GameService {
    @Autowired
    private GameRepository gameRepository;


    /**
     * Creates a new Game and put it to Repository
     * @param game that should be created
     */
    public void createNewGame(Game game) {
        game.setStatus(GameState.WAIT_FOR_PLAYER_INPUT);
        gameRepository.save(game);
    }

    /**
     * Loads a Game with a given ID and returns it
     * @param id of the Game
     * @return the Game with given ID throws GameNotFoundException if game does not exist
     */
    public Game loadGame(Long id) {
        if (gameRepository.exists(id)) {
            return gameRepository.findOne(id);
        } else {
            throw new GameNotFoundException(id);
        }
    }

    /**
     * Loads Game with ID and plays it with Player Weapon
     *
     * @param id           of the Game that should be played
     * @param playerWeapon weapon of Player
     * @return finished Game
     */
    public Game playGame(Long id, Weapon playerWeapon) {
        Game game = loadGame(id);
        game.play(playerWeapon);
        saveGame(game);
        return game;
    }

    /**
     * Save a Game in Repository
     *
     * @param game that should be saved
     */
    public void saveGame(Game game) {
        gameRepository.save(game);
    }

    /**
     * List of Games with status
     *
     * @param status of the Games you are looking for
     * @return a List of Games
     */
    public List<Game> getGameByStatus(GameState status) {
        return gameRepository.findByStatus(status);
    }

    /**
     * Load List from Repo
     *
     * @return a list with all Games
     */
    public List<Game> getAllGames() {
        return gameRepository.allGames();
    }

}
