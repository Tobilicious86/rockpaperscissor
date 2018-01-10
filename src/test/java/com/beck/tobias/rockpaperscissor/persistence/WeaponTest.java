package com.beck.tobias.rockpaperscissor.persistence;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@Ignore
@DataJpaTest
@RunWith(SpringRunner.class)
public class WeaponTest {
/**
    Game game = new Game();
    GameService service = new GameService();

    @Test
    public void paperVsRock(){
    game.setPlayerWeapon(Weapon.PAPER);
    game.setCpuWeapon(Weapon.ROCK);




    }

    @Test
    public void paperVsScissor(){
    game.setPlayer(Weapon.PAPER);
    game.setCpu(Weapon.SCISSOR);
    assertThat(service.findWinner(game)).isEqualTo(Winner.CPU);

    }

    @Test
    public void paperVSPaper(){
    game.setPlayer(Weapon.PAPER);
    game.setCpu(Weapon.PAPER);



    assertEquals(service.findWinner(game),Winner.DRAW);

    }

    @Test
    public void rockVsPaper(){
    game.setPlayer(Weapon.ROCK);
    game.setCpu(Weapon.PAPER);


        try {
    assertEquals(service.findWinner(game),Winner.CPU);
        } catch (WeaponException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void rockVsScissor(){
    game.setPlayer(Weapon.ROCK);
    game.setCpu(Weapon.SCISSOR);


        try {
    assertEquals(service.findWinner(game),Winner.PLAYER);
        } catch (WeaponException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void rockVsRock(){
    game.setPlayer(Weapon.ROCK);
    game.setCpu(Weapon.ROCK);

        try {
    assertEquals(service.findWinner(game),Winner.DRAW);
        } catch (WeaponException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void scissorVsRock(){
    game.setPlayer(Weapon.SCISSOR);
    game.setCpu(Weapon.ROCK);


        try {
    assertEquals(service.findWinner(game),Winner.CPU);
        } catch (WeaponException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void scissorVsPaper(){
    game.setPlayer(Weapon.SCISSOR);
    game.setCpu(Weapon.PAPER);


        try {
    assertEquals(service.findWinner(game), Winner.PLAYER);
        } catch (WeaponException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void scissorVsScissor(){
    game.setPlayer(Weapon.SCISSOR);
    game.setCpu(Weapon.SCISSOR);


        try {
    assertEquals(service.findWinner(game),Winner.DRAW);
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

 */
}
