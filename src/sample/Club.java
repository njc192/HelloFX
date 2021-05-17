package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class Club implements Suit{
    private Path path;

    public Club(){
        Circle leftCircle = new Circle(40.3,20.5,8.5);
        Circle rightCircle = new Circle(59.7,20.5,8.5);
        Circle topCircle = new Circle(50.0,5.0,8.5);

        Rectangle filler = new Rectangle(45,10,10,10);


        Polygon t2 = new Polygon();
        t2.getPoints().addAll(50.0,15.0,45.0,35.0,55.0,35.0);


        path = (Path) Shape.union(leftCircle,rightCircle);
        path = (Path) Shape.union(path,topCircle);
        path = (Path) Shape.union(path,t2);
        path = (Path) Shape.union(path,filler);
    }

    @Override
    public Path getSuitShape() {
        return path;
    }

    @Override
    public Color getColor() {
        return Color.BLACK;
    }
}
