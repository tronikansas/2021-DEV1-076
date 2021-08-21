package com.exercise.tdd.kata.game;

import com.exercise.tdd.kata.game.player.Player;
import java.util.List;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;

@NoArgsConstructor
@Controller
public class TennisGame {

  public String viewScore(List<Player> playerList){
    if(playerList == null || playerList.size() != 2){
      return "To start the Game we need 2 players"
;   }else if(playerList.get(0) == null || playerList.get(1) == null){
      return "Please, send a valid player";
    }
    if(playerList.get(0).getScore() == playerList.get(1).getScore()){
      if(playerList.get(0).getScore() == 0){
        return "love all";
      }else if(playerList.get(0).getScore() == 15){
        return "fifteen all";
      }
    }
    return "score  fail";
  }
}
