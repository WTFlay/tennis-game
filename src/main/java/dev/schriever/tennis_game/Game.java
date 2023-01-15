package dev.schriever.tennis_game;

public class Game {
    private String player1;
    private int player1Score;
    private String player2;
    private int player2Score;

    public Game(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void play(String[] wins) {
        for (String win: wins) {
            if (win.equals(player1)) {
                if (player2Score == 55) {
                    player2Score -= 15;
                } else if (player1Score == 30) {
                    player1Score += 10;
                } else {
                    player1Score += 15;
                }
            } else {
                if (player1Score == 55) {
                    player1Score -= 15;
                } else if (player2Score == 30) {
                    player2Score += 10;
                } else {
                    player2Score += 15;
                }
            }
        }
    }

    public String getResult() {
        if (player1Score > player2Score) {
            return getPlayerScore(player1Score, player2Score, player1);
        } else if (player2Score > player1Score) {
            return getPlayerScore(player2Score, player1Score, player2);
        } else if (player1Score == 40) {
            return "DEUCE";
        } else if (player1Score > 0) {
            return player1Score + "e";
        }
        return player1 + " 0 - " + player2 + " 0";
    }

    private String getPlayerScore(int player1Score, int player2Score, String player1) {
        if (player1Score == 55) {
            if (player2Score == 40) {
                return player1 + " ADVANTAGE";
            } else {
                return player1 + " WIN";
            }
        } else if (player1Score == 70) {
            return player1 + " WIN";
        }
        return player1 + " " + player1Score;
    }
}
