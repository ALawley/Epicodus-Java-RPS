public class RockPaperScissors {
  public static void main(String[] args) {

  }
  public static Boolean checkWinner(String input1, String input2) {
    Boolean result = false;
    if (input1 == "Rock" && input2 == "Scissors"){
      result = true;
    } else if (input1 == "Scissors" && input2 == "Paper"){
      result = true;
    } else if (input1 == "Paper" && input2 == "Rock"){
      result = true;
    }
    return result;
  }

}
