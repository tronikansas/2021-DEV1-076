package com.exercise.tdd.kata.game;

import com.exercise.tdd.kata.game.player.Player;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TennisGame {

  private List<String> setPoints = new ArrayList(Arrays.asList("love", "fifteen", "thirty", "forty"));

  @PostMapping("/viewScore")
  public String viewScore(@RequestBody List<Player> playerList) {
    if (playerList == null || playerList.size() != 2 ||
        playerList.get(0) == null || playerList.get(1) == null) {
      return "To start the Game we need 2 players";
    }

    Player player1 = playerList.get(0);
    Player player2 = playerList.get(1);
    if(player1.getName() == null || "".equals(player1.getName()) || player2.getName()== null || "".equals(player2.getName())){
      return "The Players must have a name";
    }
    if(player1.getScore() == player2.getScore()){
      return player1.getScore() > 2 ? "deuce": setPoints.get(player1.getScore()) + " all";
    }else{
      if(Math.max(player1.getScore(), player2.getScore()) > 3){
        return diffResult(player1, player2);
      }else{
        return setPoints.get(player1.getScore()) + " - " + setPoints.get(player2.getScore());
      }
    }
  }

  private String diffResult(Player player1, Player player2) {
    int diff = Math.abs(player1.getScore() - player2.getScore());
      return  (diff == 1 ? "Advantage " : "Game over the winner is ") + getPlayerWithHigherScore(player1, player2);
  }

  private String getPlayerWithHigherScore(Player player1, Player player2) {
    return player1.getScore() > player2.getScore()? player1.getName(): player2.getName();
  }
}