package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Card(Rank.ACEofDIAMONDS).getCard();
        primaryStage.setScene(new Scene(root, 750, 750,Color.WHITE));
        primaryStage.show();

    }


    public static void main(String[] args) {

        launch(args);
    }

}
