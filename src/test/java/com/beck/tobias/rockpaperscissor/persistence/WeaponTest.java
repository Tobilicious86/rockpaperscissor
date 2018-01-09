package com.beck.tobias.rockpaperscissor.persistence;

import com.beck.tobias.rockpaperscissor.persistence.domain.Game;
import com.beck.tobias.rockpaperscissor.persistence.domain.Weapon;
import com.beck.tobias.rockpaperscissor.persistence.exceptions.WeaponException;
import com.beck.tobias.rockpaperscissor.service.GameService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;

@DataJpaTest
@RunWith(SpringRunner.class)
public class WeaponTest {

    Game game = new Game();
    GameService service = new GameService();

    @Test
    public void paperVsRock(){
        game.setPlayer(Weapon.Paper);
        game.setCpu(Weapon.Rock);


        try {
            assertEquals("Paper beats Rock",service.findWinner(game),Game.Winner.PLAYER);
        } catch (WeaponException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void paperVsScissor(){
        game.setPlayer(Weapon.Paper);
        game.setCpu(Weapon.Scissor);


        try {
            assertEquals(service.findWinner(game),Game.Winner.CPU);
        } catch (WeaponException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void paperVSPaper(){
        game.setPlayer(Weapon.Paper);
        game.setCpu(Weapon.Paper);


        try {
            assertEquals(service.findWinner(game),Game.Winner.DRAW);
        } catch (WeaponException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void rockVsPaper(){
        game.setPlayer(Weapon.Rock);
        game.setCpu(Weapon.Paper);


        try {
            assertEquals(service.findWinner(game),Game.Winner.CPU);
        } catch (WeaponException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void rockVsScissor(){
        game.setPlayer(Weapon.Rock);
        game.setCpu(Weapon.Scissor);


        try {
            assertEquals(service.findWinner(game),Game.Winner.PLAYER);
        } catch (WeaponException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void rockVsRock(){
        game.setPlayer(Weapon.Rock);
        game.setCpu(Weapon.Rock);

        try {
            assertEquals(service.findWinner(game),Game.Winner.DRAW);
        } catch (WeaponException e) {
            e.printStackTrace();
        }
    }

    /*

     */

    @Test
    public void scissorVsRock(){
        game.setPlayer(Weapon.Scissor);
        game.setCpu(Weapon.Rock);


        try {
            assertEquals(service.findWinner(game),Game.Winner.CPU);
        } catch (WeaponException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void scissorVsPaper(){
        game.setPlayer(Weapon.Scissor);
        game.setCpu(Weapon.Paper);


        try {
            assertEquals(service.findWinner(game),Game.Winner.PLAYER);
        } catch (WeaponException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void scissorVsScissor(){
        game.setPlayer(Weapon.Scissor);
        game.setCpu(Weapon.Scissor);


        try {
            assertEquals(service.findWinner(game),Game.Winner.DRAW);
        } catch (WeaponException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void weaponRandom(){
        List<Weapon> weaponsrandom1 = new ArrayList<Weapon>();
        List<Weapon> weaponsrandom2 = new ArrayList<Weapon>();

        for (int i = 0; i < 10; i++) {
            weaponsrandom1.add(service.randomWeapon());
            weaponsrandom2.add(service.randomWeapon());

        }
        assertNotEquals(weaponsrandom1, weaponsrandom2);
    }


}
