package com.exercise.tdd.kata.game;

import static org.junit.jupiter.api.Assertions.*;

import com.exercise.tdd.kata.game.player.Player;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TennisGameTest {


  @Test
  public void testLoveAll(){
    TennisGame tennisGame = new TennisGame();
    List<Player> playersList = new ArrayList<Player>();
    playersList.add(new Player("Rafael Nadal",0));
    playersList.add(new Player("Roger Federer",0));

    Assertions.assertEquals("love all", tennisGame.viewScore(playersList));
  }
}