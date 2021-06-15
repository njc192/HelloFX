package hangman;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class HangmanController implements Initializable {

    @FXML
    HBox word_box;
    @FXML
    Circle hangman_head;
    @FXML
    Line hangman_body;
    @FXML
    Line hangman_right_leg;
    @FXML
    Line hangman_left_leg;
    @FXML
    Line hangman_right_arm;
    @FXML
    Line hangman_left_arm;
    @FXML
    Line hangman_rope;




    private Node [] hangmanParts;
    private String word;
    private int wrong_count;
    private int correct_count;

    public HangmanController(String word)
    {
        this.word = word;
        System.out.println(word);
        wrong_count = 0;
        correct_count =0;
        hangmanParts = new Node[7];

    }

    public void guess(ActionEvent event)
    {


        if (event.getSource() instanceof Button)
        {
            Button b = (Button) event.getSource();
            b.setDisable(true);
            char letter = b.getText().toLowerCase(Locale.ROOT).charAt(0);
            if (word.contains(""+letter))
            {
                for (int i = 0; i < word.length(); i++)
                {
                    if (word.charAt(i) == letter)
                    {
                        ((Text)((StackPane)word_box.getChildren().get(i)).getChildren().get(0)).setText(""+letter);
                        correct_count++;
                    }
                }
            }
            else
            {
                hangmanParts[wrong_count++].setVisible(true);
            }

            if (correct_count == word.length())
            {
                System.out.println("win");
                for (int i = 0; i < word.length(); i++)
                {
                    Text t = ((Text)((StackPane)word_box.getChildren().get(i)).getChildren().get(0));
                    t.setFill(Color.BLUE);
                    t.setText(""+word.charAt(i));
                }
            }

            if (wrong_count > hangmanParts.length -1 )
            {
                System.out.println("LOST");
                for (int i = 0; i < word.length(); i++)
                {
                    Text t = ((Text)((StackPane)word_box.getChildren().get(i)).getChildren().get(0));
                    t.setFill(Color.RED);
                    t.setText(""+word.charAt(i));
                }

            }

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (int i = 0; i < word.length(); i++)
        {
            StackPane pane = new StackPane();
            Text text = new Text("_ ");
            text.setFont(new Font(50));
            pane.getChildren().add(text);

            //pane.setBackground(new Background(new BackgroundFill(Color.RED,null,null)));
            word_box.getChildren().add(pane);
        }


        hangmanParts[0] = hangman_rope;
        hangmanParts[1] = hangman_head;
        hangmanParts[2] = hangman_body;
        hangmanParts[3] = hangman_left_arm;
        hangmanParts[4] = hangman_right_arm;
        hangmanParts[5] = hangman_right_leg;
        hangmanParts[6] = hangman_left_leg;


        for (int i = 0; i < hangmanParts.length; i++)
        {
            hangmanParts[i].setVisible(false);
        }

    }
}
