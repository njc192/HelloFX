package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Path;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public class Heart implements Suit{
    private Polygon triangle;
    private Path path;
    private static Color COLOR = Color.RED;


    public Heart()
    {
        triangle = new Polygon();
        triangle.getPoints().addAll(50.0,18.0,
                                         35.0,0.0,
                                         65.0,0.0);
        triangle.setFill(Color.RED);
        Arc arc = new Arc(43.3,0.0,8.5,10.5,0,180.0);
        Arc arc2 = new Arc(56.7,0.0,8.5,10.5,0,180.0);

        Shape s = Shape.union(triangle,arc);
        s = Shape.union(s,arc2);

        path = (Path)s ;
        path.setFill(Color.RED);

    }

    public Path getHeart()
    {
        return path;
    }

    @Override
    public Path getSuitShape() {
        return getHeart();
    }

    @Override
    public Color getColor() {
        return COLOR;
    }
}
