package dev.schriever.tennis_game;

import lombok.Data;

@Data
public class Player {
    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
        score = 0;
    }
}
