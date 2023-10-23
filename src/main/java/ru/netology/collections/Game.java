package ru.netology.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {
    HashMap<String, Integer> players = new HashMap<>();

    public void register(Player player) {
        players.put(player.getName(), player.getStrength());
    }

    public int round(String playerName1, String playerName2) {
        Integer player1;
        Integer player2;
        if (players.containsKey(playerName1)) {
            player1 = players.get(playerName1);
        } else {
            throw new NotRegisteredException(
                    "Игрок с именем " + playerName1 + " не найден");
        }
        if (players.containsKey(playerName2)) {
            player2 = players.get(playerName2);
        } else {
            throw new NotRegisteredException(
                    "Игрок с именем " + playerName2 + " не найден");
        }

        if (player1 > player2) {
            return 1;
        } else if (player1 < player2) {
            return 2;
        } else {
            return 0;
        }
    }
}
