package com.beck.tobias.rockpaperscissor.service;

import com.beck.tobias.rockpaperscissor.persistence.domain.Game;
import com.beck.tobias.rockpaperscissor.persistence.domain.Weapon;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ServiceTest {

    @Autowired
    private GameService service;


    @Test
    public void createLoadAndCompareGame() {
        Game game = new Game();
        service.createNewGame(game);
        assertThat(service.loadGame(game.getGameId())).isEqualTo(game);
    }

    @Test
    public void createPlayAndSaveGame() {
        Game game = new Game();
        Game playedGame;
        service.createNewGame(game);
        playedGame = service.playGame(game.getGameId(), Weapon.ROCK);

        assertThat(playedGame).isEqualTo(service.loadGame(game.getGameId()));
    }

}
