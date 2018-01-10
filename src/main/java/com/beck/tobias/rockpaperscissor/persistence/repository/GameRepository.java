package com.beck.tobias.rockpaperscissor.persistence.repository;

import com.beck.tobias.rockpaperscissor.persistence.domain.Game;
import com.beck.tobias.rockpaperscissor.persistence.domain.GameState;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Saving the GameData
 */
@Repository
public interface GameRepository extends CrudRepository<Game, Long> {

     /**
      * To find Games by Status, Used for History
      * @param status State of Games you are looking for
      * @return List of Games with State
      */
     List<Game> findByStatus(GameState status);

     @Query("select g from Game g")
     List<Game> allGames();

}
