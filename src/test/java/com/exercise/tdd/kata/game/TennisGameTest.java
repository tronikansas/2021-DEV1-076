package com.exercise.tdd.kata.game;

import static org.junit.jupiter.api.Assertions.*;

import com.exercise.tdd.kata.game.player.Player;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class TennisGameTest {

  @Test
  public void testStartingAGameWithOnePlayer(){
    TennisGame tennisGame = new TennisGame();
    List<Player> playersList = new ArrayList<Player>();
    playersList.add(new Player("Roger Federer",0));

    Assertions.assertEquals("To start the Game we need 2 players", tennisGame.viewScore(playersList));
  }

  @Test
  public void testSendingANullPlayer(){
    TennisGame tennisGame = new TennisGame();
    List<Player> playersList = new ArrayList<Player>();
    playersList.add(new Player("Roger Federer",0));
    playersList.add(null);

    Assertions.assertEquals("Please, send a valid player", tennisGame.viewScore(playersList));
  }

  @ParameterizedTest
  @CsvSource({
      "0, 0, love all",
      "1, 1, fifteen all",
      "2, 2, thirty all",
      "3, 3, deuce"
  })
  public void testScoreResults(int playerOneScore, int playerTwoScore, String messageExpected){
    TennisGame tennisGame = new TennisGame();
    List<Player> playersList = new ArrayList<Player>();
    playersList.add(new Player("Rafael Nadal",playerOneScore));
    playersList.add(new Player("Roger Federer",playerTwoScore));

    Assertions.assertEquals(messageExpected, tennisGame.viewScore(playersList));
  }
}