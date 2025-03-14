package ntnu.idi.flushgame2.music;

import java.net.URL;
import java.util.Objects;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import ntnu.idi.flushgame2.views.CardView;

public class MusicPlayer {

  private static MediaPlayer mediaPlayer;

  public void play() {
    String filePath = "/ntnu/idi/flushgame2/music/casino.mp3";

    URL resource = Objects.requireNonNull(getClass().getResource(filePath));
    Media media = new Media(resource.toExternalForm()); // Convert to valid URI
    mediaPlayer = new MediaPlayer(media);
    mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE); // Loop the music
    mediaPlayer.play();
  }

}