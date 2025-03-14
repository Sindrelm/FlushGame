module ntnu.idi.flushgame2 {
  requires javafx.controls;
  requires javafx.fxml;
  requires java.desktop;
  requires javafx.media;

  opens ntnu.idi.flushgame2 to javafx.fxml;
  exports ntnu.idi.flushgame2;
}