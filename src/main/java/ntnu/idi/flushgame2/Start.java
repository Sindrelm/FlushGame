package ntnu.idi.flushgame2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
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

  public static Pane root;
  private static DeckOfCards deck;

  @Override
  public void start(Stage stage) throws IOException {
    root = new Pane();
    root.setPadding(new Insets(40));

    HomeView.display();

    Scene scene = new Scene(root, 1000, 400);
    stage.setTitle("Hello!");
    stage.setScene(scene);
    stage.show();
  }


  public static void main(String[] args) {
    launch();
  }
}