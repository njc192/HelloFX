package sample;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.Stack;

public class Card {

    private Group group;
    private Rectangle card;
    private Path suitShape;
    private Rank rank;

    private Text text_bRank;
    private Text text_tRank;
    private Image image_card_back;
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
        image_card_back = new Image("file:///C:\\Users\\njc19\\IdeaProjects\\HelloFX\\res\\img\\trippy.jpg");

        card = new Rectangle(cardWidth,cardHeight, Color.WHITE);



        card.setArcHeight(CARDROUNDNESS);
        card.setArcWidth(CARDROUNDNESS);
        card.setStroke(cardBorderColor);


        group = new Group();

        StackPane front = getFrontFace();

        group.getChildren().add(front);
        group.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                flipCard();
            }
        });
    }

    private StackPane getFrontFace()
    {


        suitShape = rank.getShape();

        text_bRank = new Text();
        text_tRank = new Text();


        StackPane front = new StackPane(card);

        front.setPrefHeight(card.getHeight());
        front.setPrefWidth(card.getWidth());



        front.getChildren().addAll(suitShape,initializeRank());


        return front;

    }

    private AnchorPane initializeRank()
    {

        AnchorPane anchorPane = new AnchorPane();

        Text t = rank.getText();
        t.setFont(new Font(25));
        t.setFill(Color.WHITE);
        t.setStroke(rank.getColor());

        setRank(t);

        anchorPane.getChildren().addAll(text_bRank,text_tRank);
        AnchorPane.setTopAnchor(text_tRank,10.0);
        AnchorPane.setRightAnchor(text_tRank,card.getWidth()-card.getWidth()/4);
        AnchorPane.setBottomAnchor(text_bRank,10.0);
        AnchorPane.setLeftAnchor(text_bRank,card.getWidth()-(card.getWidth()/4));

        return anchorPane;
    }

    private void setRank(Text rank)
    {

        text_tRank.setText(rank.getText());
        text_bRank.setText(rank.getText());

        text_tRank.setStroke(rank.getStroke());
        text_bRank.setStroke(rank.getStroke());

        text_tRank.setFill(rank.getFill());
        text_bRank.setFill(rank.getFill());

        text_tRank.setFont(rank.getFont());
        text_bRank.setFont(rank.getFont());
    }

    public void flipCard()
    {
        StackPane sp;
        if (showingBack)
        {
            card.setFill(Color.WHITE);
            sp = getFrontFace();
            showingBack = false;
        }
        else
        {
            card.setFill(new ImagePattern(image_card_back));
            sp = new StackPane(card);
            showingBack = true;
        }

        group.getChildren().add(sp);

    }


    public Group getCard()
    {
        return group;
    }


    @Override
    public String toString() {
        return "Card{" + rank.getSuit()+
                "rank=" + rank +
                ", showingBack=" + showingBack +
                '}';
    }
}
