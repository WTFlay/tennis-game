package dev.schriever.tennis_game;

public class Game {
    private final Player player1;
    private final Player player2;

    public Game(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public void play(String[] wins) {
        for (String win: wins) {
            if (win.equals(player1.getName())) {
                if (player2.getScore() == 55) {
                    player2.setScore(player2.getScore() - 15);
                } else if (player1.getScore() == 30) {
                    player1.setScore(player1.getScore() + 10);
                } else {
                    player1.setScore(player1.getScore() + 15);
                }
            } else {
                if (player1.getScore() == 55) {
                    player1.setScore(player1.getScore() - 15);
                } else if (player2.getScore() == 30) {
                    player2.setScore(player2.getScore() + 10);
                } else {
                    player2.setScore(player2.getScore() + 15);
                }
            }
        }
    }

    public String getResult() {
        if (player1.getScore() > player2.getScore()) {
            return getPlayerScore(player1, player2);
        } else if (player2.getScore() > player1.getScore()) {
            return getPlayerScore(player2, player1);
        } else if (player1.getScore() == 40) {
            return "DEUCE";
        } else if (player1.getScore() > 0) {
            return player1.getScore() + "e";
        }
        return player1.getName() + " 0 - " + player2.getName() + " 0";
    }

    private String getPlayerScore(Player player1, Player player2) {
        if (player1.getScore() == 55) {
            if (player2.getScore() == 40) {
                return player1.getName() + " ADVANTAGE";
            } else {
                return player1.getName() + " WIN";
            }
        } else if (player1.getScore() == 70) {
            return player1.getName() + " WIN";
        }
        return player1.getName() + " " + player1.getScore();
    }
}
