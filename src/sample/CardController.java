package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Path;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class CardController implements Initializable {


    private Rank rank;

    public CardController(Rank cardRank)
    {
        rank = cardRank;
    }
    @FXML
    private Text text_bRank;

    @FXML
    private Text text_tRank;

    @FXML
    private StackPane holder;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setRank();
        setPath(rank.getShape());
    }

    void setPath(Path p)
    {
        holder.getChildren().add(p);
    }


    void setRank()
    {
        Text text = rank.getText();
        text.setFont(new Font(25));
        text.setFill(Color.WHITE);
        text.setStroke(this.rank.getColor());
        text.setStrokeWidth(10);
        text_tRank.setText(text.getText());
        text_bRank.setText(text.getText());

        text_tRank.setStroke(text.getStroke());
        text_bRank.setStroke(text.getStroke());

        text_tRank.setFill(text.getFill());
        text_bRank.setFill(text.getFill());

        text_tRank.setFont(text.getFont());
        text_bRank.setFont(text.getFont());
    }
}
