package com.exercise.tdd.kata.game;

import com.exercise.tdd.kata.game.player.Player;
import java.util.List;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;

@NoArgsConstructor
@Controller
public class TennisGame {

  public String viewScore(List<Player> playerList){
    if(playerList.get(0).getScore() == playerList.get(1).getScore()){
      if(playerList.get(0).getScore() == 0){
        return "love all";
      }
    }
    return "score  fail";
  }
}
