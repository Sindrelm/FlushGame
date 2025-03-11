package ntnu.idi.flushgame2.views;

import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;
import ntnu.idi.flushgame2.Start;

public class WinView {

  public static void displayWinSequence() {
    StackPane winText = createText();
    setTextTransition(winText);

    Start.root.getChildren().add(winText);


  }

  private static StackPane createText() {
    Text title = new Text("WIN WIN WIN");
    Text titleAccent = new Text("WIN WIN WIN");
    title.setFill(Color.PURPLE);
    titleAccent.setFill(Color.CORNFLOWERBLUE);

    title.setFont(new Font("Arial Bold", 100));
    titleAccent.setFont(new Font("Arial Bold", 100));

    title.setLineSpacing(15);
    titleAccent.setLineSpacing(15);

    StackPane titlePane = new StackPane();
    titlePane.setAlignment(Pos.CENTER);

    titlePane.getChildren().addAll(titleAccent, title);
    titleAccent.setTranslateX(3.5);
    titleAccent.setTranslateY(3.5);
    return titlePane;
  }

  private static void setTextTransition(StackPane text) {
    text.setTranslateX(-700);
    TranslateTransition transition = new TranslateTransition(Duration.seconds(2), text);
    transition.setByX(700);
    transition.setCycleCount(1);
    transition.play();
  }
}
