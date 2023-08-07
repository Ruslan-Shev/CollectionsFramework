package org.example;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        org.example.Player player1 = new org.example.Player(1, "Alice", 10);
        org.example.Player player2 = new org.example.Player(2, "Bob", 5);
        game.register(player1);
        game.register(player2);

        try {
            int result = game.round("Alice", "Bob");
            System.out.println(result); // 1
        } catch (NotRegisteredException e) {
            System.out.println(e.getMessage());
        }
    }
}