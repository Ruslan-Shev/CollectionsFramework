package org.example;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Player> players;

    public Game() {
        players = new ArrayList<>();
    }

    public void register(Player player) {
        players.add(player);
    }

    private Player findPlayerByName(String name) throws NotRegisteredException {
        for (Player player : players) {
            if (player.name.equals(name)) {
                return player;
            }
        }
        throw new NotRegisteredException("Player not registered");
    }

    public int round(String playerName1, String playerName2) throws NotRegisteredException {
        Player player1 = findPlayerByName(playerName1);
        Player player2 = findPlayerByName(playerName2);

        if (player1.strength > player2.strength) {
            return 1;
        } else if (player1.strength < player2.strength) {
            return 2;
        } else {
            return 0;
        }
    }
}
