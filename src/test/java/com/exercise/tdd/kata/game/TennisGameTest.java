package com.exercise.tdd.kata.game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TennisGameTest {


  @Test
  public void testLoveAll(){
    TennisGame tennisGame = new TennisGame();
    Assertions.assertEquals("love all", tennisGame.viewScore());
  }
}