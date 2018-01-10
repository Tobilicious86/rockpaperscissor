package com.beck.tobias.rockpaperscissor.persistence;

import com.beck.tobias.rockpaperscissor.persistence.domain.Game;
import com.beck.tobias.rockpaperscissor.persistence.domain.Weapon;
import com.beck.tobias.rockpaperscissor.persistence.repository.GameRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@RunWith(SpringRunner.class)
public class GameRepositoryTest {

    @Autowired
    private GameRepository gameRepository;

    @Test
    public void insertGame(){
        Game game = new Game();
        game.setPlayerWeapon(Weapon.PAPER);
        gameRepository.save(game);

        Game loadedGame = gameRepository.findOne(game.getGameId());

        assertThat(loadedGame).isEqualTo(game);

        //ID is set
        assertThat(loadedGame.getGameId()).isNotNull();

    }



}
