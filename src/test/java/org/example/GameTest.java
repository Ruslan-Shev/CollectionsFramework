package org.example;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {
    @Test
    public void testRound() throws NotRegisteredException {
        Game game = new Game();
        org.example.Player player1 = new org.example.Player(1, "Alice", 10);
        org.example.Player player2 = new org.example.Player(2, "Bob", 5);
        game.register(player1);
        game.register(player2);

        int result = game.round("Alice", "Bob");
        assertEquals(1, result);

        result = game.round("Bob", "Alice");
        assertEquals(2, result);

        player2.strength = 10;
        result = game.round("Alice", "Bob");
        assertEquals(0, result);
    }

    @Test(expected = NotRegisteredException.class)
    public void testRoundNotRegistered() throws NotRegisteredException {
        Game game = new Game();
        org.example.Player player1 = new org.example.Player(1, "Alice", 10);
        game.register(player1);

        game.round("Alice", "Bob");
    }
}