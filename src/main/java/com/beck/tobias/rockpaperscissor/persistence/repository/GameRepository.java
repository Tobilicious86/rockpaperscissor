package com.beck.tobias.rockpaperscissor.persistence.repository;

import com.beck.tobias.rockpaperscissor.persistence.domain.Game;
import com.beck.tobias.rockpaperscissor.persistence.domain.GameStatus;
import com.sun.org.apache.bcel.internal.generic.Select;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


/**
 * Saving the GameData
 */
@Repository
public interface GameRepository extends CrudRepository<Game, Long> {

     /**
      * Search for Game via gameID
      * @param gameID
      * @return
      */
     Optional<Game> findByGameId(Long gameID);

     /**
      * Check if Game gameID exists
      * @param gameID
      * @return
      */
     boolean existsGameByGameId(Long gameID);

     /**
      * Looking for Games with Status not! ToFindOpenGames
      * @param status
      * @return
      */
     List<Game> findByStatusNot(GameStatus status);

     /**
      * To find Games by Status, Used for History
      * @param status
      * @return
      */
     List<Game> findByStatus (GameStatus status);

     /**
      * To find Games by Winner and Status to find ended Games and their winner
      * @param winner
      * @param status
      * @return
      */
     List<Game> findByWinnerAndAndStatus (Game.Winner winner, GameStatus status);



}
