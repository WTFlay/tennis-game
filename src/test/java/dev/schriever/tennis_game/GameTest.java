package dev.schriever.tennis_game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {

    private Game game;

    @BeforeEach
    public void setUp() {
        String player1 = "P1";
        String player2 = "P2";
        game = new Game(player1, player2);
    }

    @Test
    public void testGame_whenNoPoints_shouldReturnNullGame() {
        String[] wins = new String[]{};

        game.play(wins);

        assertEquals("P1 0 - P2 0", game.getResult());
    }

    @Test
    public void testGame_whenOnePointToP1_shouldReturnP1With15() {
        String[] wins = new String[]{ "P1" };

        game.play(wins);

        assertEquals("P1 15", game.getResult());
    }

    @Test
    public void testGame_whenOnePointToP2_shouldReturnP2With15() {
        String[] wins = new String[]{ "P2" };

        game.play(wins);

        assertEquals("P2 15", game.getResult());
    }

    @Test
    public void testGame_whenOnePointToBoth_shouldReturn15e() {
        String[] wins = new String[]{ "P1", "P2" };

        game.play(wins);

        assertEquals("15e", game.getResult());
    }

    @Test
    public void testGame_whenTwoPointToBoth_shouldReturn30e() {
        String[] wins = new String[]{ "P1", "P2", "P1", "P2" };

        game.play(wins);

        assertEquals("30e", game.getResult());
    }

    @Test
    public void testGame_whenTreePointWin_shouldReturn40() {
        String[] wins = new String[]{ "P1", "P1", "P1" };

        game.play(wins);

        assertEquals("P1 40", game.getResult());
    }

    @Test
    public void testGame_whenTreePointToBoth_shouldReturnDeuce() {
        String[] wins = new String[]{ "P1", "P1", "P1", "P2", "P2", "P2" };

        game.play(wins);

        assertEquals("DEUCE", game.getResult());
    }

    @Test
    public void testGame_whenPlayer1Advantage_shouldReturnP1Advantage() {
        String[] wins = new String[]{ "P1", "P1", "P1", "P2", "P2", "P2", "P1" };

        game.play(wins);

        assertEquals("P1 ADVANTAGE", game.getResult());
    }

    @Test
    public void testGame_whenPlayer1AdvantageAndPlayer2WinPoint_shouldReturnDeuce() {
        String[] wins = new String[]{ "P1", "P1", "P1", "P2", "P2", "P2", "P1", "P2" };

        game.play(wins);

        assertEquals("DEUCE", game.getResult());
    }

    @Test
    public void testGame_whenPlayer1Win() {
        String[] wins = new String[]{ "P1", "P1", "P1", "P1" };

        game.play(wins);

        assertEquals("P1 WIN", game.getResult());
    }

    @Test
    public void testGame_whenPlayersDeuceAndPlayer1WinTowLast_shouldReturnP1Win() {
        String[] wins = new String[]{ "P1", "P1", "P1", "P2", "P2", "P2", "P1", "P1" };

        game.play(wins);

        assertEquals("P1 WIN", game.getResult());
    }

    @Test
    public void testGame_whenPlayersMultipleDeuce_shouldReturnDeuce() {
        String[] wins = new String[]{ "P1", "P2", "P1", "P2", "P1", "P2", "P1", "P2", "P1", "P2", "P1", "P2" };

        game.play(wins);

        assertEquals("DEUCE", game.getResult());
    }
}
