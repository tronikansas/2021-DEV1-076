package com.exercise.tdd.kata.game;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;

@NoArgsConstructor
@Controller
public class TennisGame {

  public String viewScore(){

    return "love all";
  }
}
