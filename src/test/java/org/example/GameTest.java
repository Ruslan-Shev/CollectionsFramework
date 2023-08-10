package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {
    @Test
    public void testRound() throws NotRegisteredException {
        Game game = new Game();
        Player player1 = new Player(1, "Alice", 10);
        Player player2 = new Player(2, "Bob", 5);
        game.register(player1);
        game.register(player2);

        int result = game.round("Alice", "Bob");
        assertEquals(1, result);
    }

    @Test
    public void testRoundTie() throws NotRegisteredException {
        Game game = new Game();
        Player player1 = new Player(1, "Alice", 10);
        Player player2 = new Player(2, "Bob", 10);
        game.register(player1);
        game.register(player2);

        int result = game.round("Alice", "Bob");
        assertEquals(0, result);
    }

    @Test(expected = NotRegisteredException.class)
    public void testRoundNotRegistered() throws NotRegisteredException {
        Game game = new Game();
        Player player1 = new Player(1, "Alice", 10);
        game.register(player1);

        game.round("Alice", "Bob");
    }

    @Test
    public void testRoundPlayer2Wins() throws NotRegisteredException {
        Game game = new Game();
        Player player1 = new Player(1, "Alice", 5);
        Player player2 = new Player(2, "Bob", 10);
        game.register(player1);
        game.register(player2);

        int result = game.round("Alice", "Bob");
        assertEquals(2, result);
    }
}
