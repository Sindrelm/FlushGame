package ntnu.idi.flushgame2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import ntnu.idi.flushgame2.modules.Card;
import ntnu.idi.flushgame2.modules.DeckOfCards;
import ntnu.idi.flushgame2.modules.Hand;
import ntnu.idi.flushgame2.modules.Suit;
import ntnu.idi.flushgame2.views.CardView;
import ntnu.idi.flushgame2.views.HandView;
import ntnu.idi.flushgame2.views.HomeView;

public class Start extends Application {

  public static StackPane root;
  private static DeckOfCards deck;

  @Override
  public void start(Stage stage) throws IOException {
    root = new StackPane();
    root.setPadding(new Insets(40));
    root.setBackground(new Background(new BackgroundFill(Color.web("#006B3C"), null, null)));


    HomeView.display();

    Scene scene = new Scene(root, 1000, 400);
    root.prefWidthProperty().bind(scene.widthProperty());
    root.prefHeightProperty().bind(scene.heightProperty());
    stage.setTitle("Hello!");
    stage.setScene(scene);
    stage.show();
  }


  public static void main(String[] args) {
    launch();
  }
}