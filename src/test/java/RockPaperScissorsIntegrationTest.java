import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class RockPaperScissorsIntegrationTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
      goTo("http://localhost:4567/");
      assertThat(pageSource()).contains("Play Rock Paper Scissors!");
  }
  @Test
  public void playerOneWins() {
      goTo("http://localhost:4567/TwoPlayers");
      click("#p1rock");
      click("#p2scissors");
      submit(".btn");
      assertThat(pageSource()).contains("Player One Wins!");
  }
  @Test
  public void playerTwoWins() {
      goTo("http://localhost:4567/TwoPlayers");
      click("#p1rock");
      click("#p2paper");
      submit(".btn");
      assertThat(pageSource()).contains("Player Two Wins!");
  }
  @Test
  public void Draw() {
      goTo("http://localhost:4567/TwoPlayers");
      click("#p1rock");
      click("#p2rock");
      submit(".btn");
      assertThat(pageSource()).contains("Draw!");
  }

}
