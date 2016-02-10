
import java.util.Random;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class RockPaperScissors {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

   get("/", (request, response) -> {
     Map<String, Object> model = new HashMap<String, Object>();
     model.put("template", "templates/home.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

   get("/OnePlayer", (request, response) -> {
     Map<String, Object> model = new HashMap<String, Object>();
     model.put("template", "templates/OnePlayer.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

   get("/TwoPlayers", (request, response) -> {
     Map<String, Object> model = new HashMap<String, Object>();
     model.put("template", "templates/TwoPlayers.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

   get("/checkWinnerOne", (request, response) -> {
     Map<String, Object> model = new HashMap<String, Object>();
     model.put("template", "templates/checkWinner.vtl");

     String player1 = request.queryParams("player1");
     String player2 = computerPlayer();
     String result = whoWins(player1, player2);

     model.put("result", result);
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());


   get("/checkWinnerTwo", (request, response) -> {
     Map<String, Object> model = new HashMap<String, Object>();
     model.put("template", "templates/checkWinner.vtl");

     String player1 = request.queryParams("player1");
     String player2 = request.queryParams("player2");
     String result = whoWins(player1, player2);

     model.put("result", result);
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());



  }
  public static Boolean checkWinner(String input1, String input2) {
    Boolean result = false;
    if (input1.equals("Rock") && input2.equals("Scissors")){
      result = true;
    } else if (input1.equals("Scissors") && input2.equals("Paper")){
      result = true;
    } else if (input1.equals("Paper") && input2.equals("Rock")){
      result = true;
    }
    return result;
  }
  public static String whoWins(String player1, String player2) {
    String result = "";
    if (checkWinner(player1, player2)) {
      result = "Player One Wins!";
    } else if (checkWinner(player2, player1)) {
      result = "Player Two Wins!";
    } else {
      result = "Draw!";
    }
    return result;
  }
  public static String computerPlayer() {
    String result = "";
    Integer randomNum = 0;
    Random myRandomGenerator = new Random();
    randomNum = myRandomGenerator.nextInt(3);
    if (randomNum == 0) {
      result = "Rock";
    } else if (randomNum == 1) {
      result = "Scissors";
    } else {
      result = "Paper";
    }
    return result;
  }

}
