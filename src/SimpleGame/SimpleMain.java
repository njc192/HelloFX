package SimpleGame;

import javafx.application.Application;
import javafx.stage.Stage;

public class SimpleMain extends Application {

    @Override
    public void init() throws Exception {
        super.init();
    }
    @Override
    public void start(Stage stage) throws Exception {

        stage.show();

    }

    public static void main(String[] args) {
        new SimpleFrame();
    }
}
