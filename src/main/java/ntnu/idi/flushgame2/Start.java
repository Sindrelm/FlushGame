package ntnu.idi.flushgame2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import ntnu.idi.flushgame2.modules.DeckOfCards;
import ntnu.idi.flushgame2.modules.CardPlayer;
import ntnu.idi.flushgame2.views.HomeView;

public class Start extends Application {

  public static StackPane root;
  public static CardPlayer player;
  private static DeckOfCards deck;

  @Override
  public void start(Stage stage) throws IOException {
    player = new CardPlayer();

    root = new StackPane();
    root.setPadding(new Insets(40));
    root.setBackground(new Background(new BackgroundFill(Color.web("#006B3C"), null, null)));


    HomeView.display();

    Scene scene = new Scene(root, 1300, 700);
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