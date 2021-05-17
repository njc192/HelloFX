package chapter1;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ClockOne extends Application {

    private final Text txtTime = new Text();

    private volatile boolean enough = false;

    Thread timer = new Thread(() -> {

        while(!enough)
        {
            final String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:MM:ss"));
            try
            {
               Thread.sleep(1000);
            }
            catch (InterruptedException ex)
            { }
            Platform.runLater(() -> {
                txtTime.setText(time);
            });
        }
    });
    @Override
    public void init() throws Exception {
        super.init();
    }

    @Override
    public void start(Stage stage) throws Exception {
        //Layout Manager
        BorderPane root = new BorderPane();

        root.setCenter(txtTime);
        //creating a scene and configuring the stage
        Scene scene = new Scene(root,200,150);
        stage.initStyle(StageStyle.UTILITY);
        stage.setScene(scene);

        timer.start();
        stage.show();

    }

    @Override
    public void stop() throws Exception {
        enough = true;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
