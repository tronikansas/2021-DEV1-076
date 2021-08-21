package com.exercise.tdd.kata.game;

import com.exercise.tdd.kata.game.player.Player;
import java.util.ArrayList;
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

    Assertions.assertEquals("To start the Game we need 2 players", tennisGame.viewScore(playersList));
  }

  @Test
  public void testSendingPlayerWithoutName(){
    TennisGame tennisGame = new TennisGame();
    List<Player> playersList = new ArrayList<Player>();
    playersList.add(new Player("Roger Federer",0));
    playersList.add(new Player());

    Assertions.assertEquals("The Players must have a name", tennisGame.viewScore(playersList));
  }

  @ParameterizedTest
  @CsvSource({
      "0, 0, love all",
      "1, 1, fifteen all",
      "2, 2, thirty all",
      "3, 3, deuce",
      "7, 4, Impossible score according to the rules",
      "4, 7, Impossible score according to the rules",
      "0, 1, love - fifteen",
      "2, 1, thirty - fifteen",
      "3, 1, forty - fifteen",
      "5, 4, Advantage Nadal",
      "5, 6, Advantage Federer",
      "5, 7, Game over the winner is Federer",
      "6, 4, Game over the winner is Nadal"
  })
  public void testScoreResults(int playerOneScore, int playerTwoScore, String messageExpected){
    TennisGame tennisGame = new TennisGame();
    List<Player> playersList = new ArrayList<Player>();
    playersList.add(new Player("Nadal",playerOneScore));
    playersList.add(new Player("Federer",playerTwoScore));

    Assertions.assertEquals(messageExpected, tennisGame.viewScore(playersList));
  }
}