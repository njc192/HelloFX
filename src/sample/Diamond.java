package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Path;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public class Diamond implements Suit{
    private Polygon top_triangle;
    private Polygon botton_triangle;
    private static Color COLOR = Color.RED;

    public Diamond()
    {
        top_triangle = new Polygon();
        top_triangle.getPoints().addAll(50.0,0.0, 37.5,18.0, 62.5,18.0);

        botton_triangle = new Polygon();
        botton_triangle.getPoints().addAll(50.0,36.0, 37.5,18.0,62.5,18.0);
    }


    private Path getDiamond()
    {
        Path shape = (Path)Shape.union(top_triangle,botton_triangle);
        shape.setFill(Color.RED);
        return shape;
    }
    public Path getSuitShape() {
        return getDiamond();
    }

    @Override
    public Color getColor() {
        return COLOR;
    }

}
