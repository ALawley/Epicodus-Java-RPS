import org.junit.*;
import static org.junit.Assert.*;

public class RockPaperScissorsTest {

  @Test
  public void checkWinner_rockBeatsScissors_true() {
    RockPaperScissors testRockPaperScissors = new RockPaperScissors();
    assertEquals(true, testRockPaperScissors.checkWinner("Rock", "Scissors"));
  }
  @Test
  public void checkWinner_scissorsBeatsPaper_true() {
    RockPaperScissors testRockPaperScissors = new RockPaperScissors();
    assertEquals(true, testRockPaperScissors.checkWinner("Scissors", "Paper"));
  }
  @Test
  public void checkWinner_paperBeatsRock_true() {
    RockPaperScissors testRockPaperScissors = new RockPaperScissors();
    assertEquals(true, testRockPaperScissors.checkWinner("Paper", "Rock"));
  }
  @Test
  public void checkWinner_paperDoesntBeatPaper_false() {
    RockPaperScissors testRockPaperScissors = new RockPaperScissors();
    assertEquals(false, testRockPaperScissors.checkWinner("Paper", "Paper"));
  }
  @Test
  public void checkWinner_paperDoesntBeatScissors_false() {
    RockPaperScissors testRockPaperScissors = new RockPaperScissors();
    assertEquals(false, testRockPaperScissors.checkWinner("Paper", "Scissors"));
  }
  @Test
  public void whoWins_playerOneWins() {
    RockPaperScissors testRockPaperScissors = new RockPaperScissors();
    assertEquals("Player One Wins!", testRockPaperScissors.whoWins("Paper", "Rock"));
  }
  @Test
  public void whoWins_playerTwoWins() {
    RockPaperScissors testRockPaperScissors = new RockPaperScissors();
    assertEquals("Player Two Wins!", testRockPaperScissors.whoWins("Paper", "Scissors"));
  }
  @Test
  public void whoWins_draw() {
    RockPaperScissors testRockPaperScissors = new RockPaperScissors();
    assertEquals("Draw!", testRockPaperScissors.whoWins("Paper", "Paper"));
  }
  @Test
  public void computerPlayer_shouldBeAString_true() {
    RockPaperScissors testRockPaperScissors = new RockPaperScissors();
    String computerChoice =  testRockPaperScissors.computerPlayer();
    assertEquals(true, computerChoice instanceof String);
  }
}
