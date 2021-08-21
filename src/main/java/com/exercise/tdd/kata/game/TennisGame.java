package com.exercise.tdd.kata.game;

import com.exercise.tdd.kata.game.player.Player;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;

@NoArgsConstructor
@Controller
public class TennisGame {

  private List<String> setPoints = new ArrayList(Arrays.asList("love", "fifteen", "thirty", "forty"));

  public String viewScore(List<Player> playerList) {
    if (playerList == null || playerList.size() != 2) {
      return "To start the Game we need 2 players"
          ;
    } else if (playerList.get(0) == null || playerList.get(1) == null) {
      return "Please, send a valid player";
    }
    Player player1 = playerList.get(0);
    Player player2 = playerList.get(1);
    if (player1.getScore() == player2.getScore()) {
      return player1.getScore() > 2 ? "deuce" : setPoints.get(player1.getScore()) + " all";
    } else {
      if (Math.max(player1.getScore(), player2.getScore()) > 3) {

        return diffResult(player1, player2);

      } else {
        return setPoints.get(player1.getScore()) + " - " + setPoints.get(player2.getScore());
      }
    }
  }

  private String diffResult(Player player1, Player player2) {
    int diff = Math.abs(player1.getScore() - player2.getScore());

    if (diff > 2) {
      return "Impossible score according to the rules";
    } else if (diff == 1){
      return "Advantage " + ((player1.getScore() > player2.getScore())? player1.getName(): player2.getName());
    } else{
      return  "Game over the winner is " + ((player1.getScore() > player2.getScore())? player1.getName(): player2.getName());
    }
  }
}