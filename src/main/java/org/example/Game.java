package org.example;

import java.util.ArrayList;
import java.util.List;

class Game {
    List<org.example.Player> players;

    public Game() {
        players = new ArrayList<>();
    }

    public void register(org.example.Player player) {
        players.add(player);
    }

    public int round(String playerName1, String playerName2) throws NotRegisteredException {
        org.example.Player player1 = null;
        org.example.Player player2 = null;

        for (org.example.Player player : players) {
            if (player.name.equals(playerName1)) {
                player1 = player;
            } else if (player.name.equals(playerName2)) {
                player2 = player;
            }
        }

        if (player1 == null || player2 == null) {
            throw new NotRegisteredException("One or both players are not registered");
        }

        if (player1.strength > player2.strength) {
            return 1;
        } else if (player1.strength < player2.strength) {
            return 2;
        } else {
            return 0;
        }
    }
}