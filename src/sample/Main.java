package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        Card Card1 = new Card(Rank.JACKofHEARTS);
        Card Card2 = new Card(Rank.TWOofDIAMONDS);
        Card Card3 = new Card(Rank.SEVENofCLUBS);
        Card Card4 = new Card(Rank.QUEENofSPADES);
        Group card1 = Card1.getCard();
        Group card2 = Card2.getCard();
        Group card3 = Card3.getCard();
        Group card4 = Card4.getCard();

        HBox root = new HBox(10.0);
        root.getChildren().addAll(card1,card2,card3,card4);
        primaryStage.setScene(new Scene(root, 750, 750,Color.WHITE));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
