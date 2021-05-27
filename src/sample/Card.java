package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;

public class Card {

    private Group group;
//    private Rectangle card;
//    private Path suitShape;
    private Rank rank;




    private Image image_card_back = new Image("file:///C:\\Users\\njc19\\IdeaProjects\\HelloFX\\res\\img\\trippy.jpg");
    private boolean showingBack = false;


    private static final int CARDWIDTH = 100;
    private static final int CARDHEIGHT = 150;
    private static final int CARDROUNDNESS = 25; //currently the only value for the roundness of the corners of the card


    public Card(Rank rank)
    {
        this(rank,CARDWIDTH,CARDHEIGHT,Color.BLACK);

    }

    public Card(Rank rank, int cardWidth, int cardHeight, Color cardBorderColor)
    {
        this.rank = rank;
        try
        {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("card.fxml"));
            CardController cardController = new CardController(rank);
            loader.setController(cardController);
            group = loader.load();



        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        //group = new Group();

        //StackPane front = getFrontFace();

        //group.getChildren().add(front);
        group.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                System.out.println("push the button");
            }
        });
    }
//
//    public Card(String string)
//    {
//        if (string.equals("Empty"))
//        {
//            card = new Rectangle(CARDWIDTH,CARDHEIGHT,Color.WHITE);
//            card.setArcHeight(CARDROUNDNESS);
//            card.setArcWidth(CARDROUNDNESS);
//            card.setStroke(Color.BLACK);
//            group = new Group();
//            StackPane sp = new StackPane(card);
//            Text text = new Text();
//            text.setFont(new Font(25));
//
//
//            BorderPane bp = new BorderPane();
//            text.setText("EMPTY");
//
//            bp.setCenter(text);
//
//            sp.getChildren().add(bp);
//
//            group.getChildren().add(sp);
//
//
//        }
//    }
//
//    private StackPane getFrontFace()
//    {
//
//
//        suitShape = rank.getShape();
//
//        StackPane front = new StackPane(card);
//
//        front.setPrefHeight(card.getHeight());
//        front.setPrefWidth(card.getWidth());
//
//
//
//        front.getChildren().addAll(suitShape);
//
//
//        return front;
//
//    }

//    private AnchorPane initializeRank()
//    {
//
//        AnchorPane anchorPane = new AnchorPane();
//
//
//        anchorPane.getChildren().addAll(text_bRank,text_tRank);
//        AnchorPane.setTopAnchor(text_tRank,10.0);
//        AnchorPane.setRightAnchor(text_tRank,card.getWidth()-card.getWidth()/4);
//        AnchorPane.setBottomAnchor(text_bRank,10.0);
//        AnchorPane.setLeftAnchor(text_bRank,card.getWidth()-(card.getWidth()/4));
//
//        return anchorPane;
//    }



//    public void flipCard()
//    {
//        StackPane sp;
//        if (showingBack)
//        {
//            card.setFill(Color.WHITE);
//            sp = getFrontFace();
//            showingBack = false;
//        }
//        else
//        {
//            card.setFill(new ImagePattern(image_card_back));
//            sp = new StackPane(card);
//            showingBack = true;
//        }
//
//        group.getChildren().add(sp);
//
//    }
//
//    public void showBack()
//    {
//        card.setFill(new ImagePattern(image_card_back));
//        StackPane sp = new StackPane(card);
//        showingBack = true;
//
//        group.getChildren().add(sp);
//    }



    public Group getCard()
    {
        return group;
    }


    @Override
    public String toString() {
        return "Card{"+
                "rank=" + rank +
                ", showingBack=" + showingBack +
                '}';
    }

    public Image getImage()
    {
        return image_card_back;
    }
}
