package ntnu.idi.flushgame2.views;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import ntnu.idi.flushgame2.Start;

public class HomeView {

  public static void display() {
    VBox homeBox = new VBox();

    homeBox.getChildren().addAll(createTitle(), createButtons());

    Start.root.getChildren().clear();
    Start.root.getChildren().add(homeBox);

  }


  private static StackPane createTitle() {
    Text title = new Text("CASINO");
    Text titleAccent = new Text("CASINO");
    title.setFill(Color.DARKRED);
    titleAccent.setFill(Color.ORANGERED);

    title.setFont(new Font("Arial Bold", 100));
    titleAccent.setFont(new Font("Arial Bold", 100));

    StackPane titlePane = new StackPane();
    titlePane.setAlignment(Pos.CENTER);

    titlePane.getChildren().addAll(titleAccent, title);
    titleAccent.setTranslateX(3);
    titleAccent.setTranslateY(3);

    return titlePane;
  }

  private static HBox createButtons() {
    Button flushGameButton = new Button("Flush Game");
    flushGameButton.setOnAction(e -> startFlushGame());

    HBox buttonsBox = new HBox();
    buttonsBox.setAlignment(Pos.CENTER);

    buttonsBox.getChildren().add(flushGameButton);

    return buttonsBox;
  }

  private static void startFlushGame() {
    FlushGameView.display();
  }
}
