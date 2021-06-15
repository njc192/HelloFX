package hangman;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HangMain extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        DictionaryLoader dictLoader = new DictionaryLoader();
        String string = dictLoader.getRandomString();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hangman.fxml"));
        HangmanController hangmanController = new HangmanController(string);
        loader.setController(hangmanController);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}
