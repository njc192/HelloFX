package sample;

import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Card {

    private Group group;
    private Rectangle card;
    private Path suitShape;
    private StackPane stackPane;
    private Text text_bRank;
    private Text text_tRank;


    private static final int CARDWIDTH = 100;
    private static final int CARDHEIGHT = 150;
    private static final int CARDROUNDNESS = 25; //currently the only value for the roundness of the corners of the card


    public Card(Rank rank)
    {
        this(rank,CARDWIDTH,CARDHEIGHT,Color.BLACK);

    }

    public Card(Rank rank, int cardWidth, int cardHeight, Color cardBorderColor)
    {
        card = new Rectangle(cardWidth,cardHeight, Color.WHITE);
        card.setArcHeight(CARDROUNDNESS);
        card.setArcWidth(CARDROUNDNESS);
        card.setStroke(cardBorderColor);
        suitShape = rank.getShape();

        text_bRank = new Text();
        text_tRank = new Text();
        stackPane = new StackPane(card);

        group = new Group();



        stackPane.setPrefHeight(card.getHeight());
        stackPane.setPrefWidth(card.getWidth());


        stackPane.getChildren().addAll(suitShape,initializeRank(rank));


        group.getChildren().add(stackPane);
    }

    private AnchorPane initializeRank(Rank rank)
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


    public Group getCard()
    {
        return group;
    }


}
