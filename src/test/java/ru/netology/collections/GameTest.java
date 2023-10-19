package ru.netology.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class GameTest {

    Player player1 = new Player(23, "Artem", 120);
    Player player2 = new Player(31, "Denis", 190);
    Player player3 = new Player(36, "Marat", 90);
    Player player4 = new Player(44, "Pavel", 190);


    @Test
    public void shouldWinFirstPlayer() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        int actual = game.round("Denis", "Artem");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWinSecondPlayer() {
        Game game = new Game();
        game.register(player3);
        game.register(player4);
        int actual = game.round("Marat", "Pavel");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotWin() {
        Game game = new Game();
        game.register(player2);
        game.register(player4);
        int actual = game.round("Denis", "Pavel");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowExceptionIfFirstPlayerNotExist() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class,()->{
            game.round("Anna", "Denis");
        });
    }

    @Test
    public void shouldThrowExceptionIfSecondPlayerNotExist() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class,()->{
            game.round("Artem", "Ivan");
        });
    }
}
