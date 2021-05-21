package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
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


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        Deck deck = new Deck();

        Group deckHolder = new Group();

        Card empty = new Card("Empty");
        empty.flipCard();
        deckHolder.getChildren().add(empty.getCard());


        HBox root = new HBox(10);

        FlowPane cards = new FlowPane();
        cards.setHgap(10);
        cards.setVgap(10);

        HBox.setHgrow(cards, Priority.ALWAYS);


        deckHolder.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (!deck.isEmpty())
                {

                    Card card = deck.getNextCard();
                    cards.getChildren().add(card.getCard());
                    if (deck.isEmpty())
                    {
                        empty.flipCard();
                    }
                }

            }
        });

//        deckHolder.setOnDragDetected(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent mouseEvent) {
//                Dragboard db = cards.startDragAndDrop(TransferMode.ANY);
//                ClipboardContent content = new ClipboardContent();
//
//                Card card = deck.peek();
//
//                content.putImage(card.getImage());
//                db.setContent(content);
//                mouseEvent.consume();
//            }
//        });

        root.getChildren().add(cards);
        root.getChildren().add(deckHolder);
        primaryStage.setScene(new Scene(root, 750, 750,Color.WHITE));
        primaryStage.show();

    }


    public static void main(String[] args) {

        launch(args);
    }
}
