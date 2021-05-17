package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Path;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public class Spade implements Suit{

    private Path path;
    public Spade()
    {

        Polygon triangle = new Polygon();
        triangle.getPoints().addAll(50.0,0.0,35.0,18.0,65.0,18.0);

        Arc arc = new Arc(43.3,18.0,8.5,10.5,180,180.0);
        Arc arc2 = new Arc(56.7,18.0,8.5,10.5,180,180.0);

        Polygon t2 = new Polygon();
        t2.getPoints().addAll(50.0,25.0,45.0,35.0,55.0,35.0);

        path = (Path) Shape.union(triangle,arc);
        path = (Path) Shape.union(path,arc2);
        path = (Path) Shape.union(path,t2);

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
