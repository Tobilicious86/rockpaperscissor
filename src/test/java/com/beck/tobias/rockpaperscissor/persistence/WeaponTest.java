package com.beck.tobias.rockpaperscissor.persistence;

import com.beck.tobias.rockpaperscissor.persistence.domain.Game;
import com.beck.tobias.rockpaperscissor.persistence.domain.GameState;
import com.beck.tobias.rockpaperscissor.persistence.domain.Weapon;
import com.beck.tobias.rockpaperscissor.persistence.domain.Winner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@RunWith(SpringRunner.class)
public class WeaponTest {


    @Test
    public void rockVsPaper(){

        Game game = new Game().setPlayerWeapon(Weapon.ROCK).setCpuWeapon(Weapon.PAPER);
        game.determineWinner();
        assertThat(Winner.CPU).isEqualTo(game.getWinner());
    }

    @Test
    public void rockVsScissor(){
        Game game = new Game().setPlayerWeapon(Weapon.ROCK).setCpuWeapon(Weapon.SCISSOR);
        game.determineWinner();
        assertThat(Winner.PLAYER).isEqualTo(game.getWinner());
    }

    @Test
    public void rockVsRock(){
        Game game = new Game().setPlayerWeapon(Weapon.ROCK).setCpuWeapon(Weapon.ROCK);
        game.determineWinner();
        assertThat(Winner.DRAW).isEqualTo(game.getWinner());
    }

    @Test
    public void paperVsScissor() {

        Game game = new Game().setPlayerWeapon(Weapon.PAPER).setCpuWeapon(Weapon.SCISSOR);
        game.determineWinner();
        assertThat(Winner.CPU).isEqualTo(game.getWinner());
    }

    @Test
    public void paperVsRock() {
        Game game = new Game().setPlayerWeapon(Weapon.PAPER).setCpuWeapon(Weapon.ROCK);
        game.determineWinner();
        assertThat(Winner.PLAYER).isEqualTo(game.getWinner());
    }

    @Test
    public void paperVsPaper() {
        Game game = new Game().setPlayerWeapon(Weapon.PAPER).setCpuWeapon(Weapon.PAPER);
        game.determineWinner();
        assertThat(Winner.DRAW).isEqualTo(game.getWinner());
    }

    @Test
    public void scissorVsRock(){

        Game game = new Game().setPlayerWeapon(Weapon.SCISSOR).setCpuWeapon(Weapon.ROCK);
        game.determineWinner();
        assertThat(Winner.CPU).isEqualTo(game.getWinner());
    }

    @Test
    public void scissorVsPaper(){
        Game game = new Game().setPlayerWeapon(Weapon.SCISSOR).setCpuWeapon(Weapon.PAPER);
        game.determineWinner();
        assertThat(Winner.PLAYER).isEqualTo(game.getWinner());
    }

    @Test
    public void scissorVsScissor(){
        Game game = new Game().setPlayerWeapon(Weapon.SCISSOR).setCpuWeapon(Weapon.SCISSOR);
        game.determineWinner();
        assertThat(Winner.DRAW).isEqualTo(game.getWinner());
    }

    @Test
    public void playAGame() {
        Game game = new Game();
        game.play(Weapon.ROCK);

        assertThat(game.getStatus()).isEqualTo(GameState.FINISH);
    }


}
