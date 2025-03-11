package ntnu.idi.flushgame2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import ntnu.idi.flushgame2.modules.Suit;
import ntnu.idi.flushgame2.views.CardView;

public class Start extends Application {

  @Override
  public void start(Stage stage) throws IOException {
    VBox root = new VBox();
    root.getChildren().add(CardView.getSuitImage(Suit.HEARTS));
    Scene scene = new Scene(root);
    stage.setTitle("Hello!");
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}