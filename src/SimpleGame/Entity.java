package SimpleGame;

import javafx.geometry.BoundingBox;

import javax.swing.*;
import java.awt.*;

public class Entity extends JPanel {
    int x,y,centerx,centery;
    private BoundingBox b;
    private Color color;
    int unitSize = 10;
    private Destination destination;
    public Entity(int x,int y, BoundingBox bound)
    {
        this.x = x;
        this.y = y;
        centerx = x + unitSize/2;
        centery = y + unitSize/2;

        b = bound;
        this.color = Color.GREEN;

        this.setPreferredSize(new Dimension(unitSize,unitSize));
        this.setBackground(color);
        this.setBounds(0,0,unitSize,unitSize);
        destination = null;

    }

    public Color getColor()
    {
        return color;
    }

    public void moveLeft()
    {
        x = x -unitSize;
        centerx = x + unitSize/2;
    }

    public void moveRight()
    {
        x = x + unitSize;
        centerx = x + unitSize/2;
    }

    public void moveUp()
    {
        y = y-unitSize;
        centery = y + unitSize/2;
    }

    public void moveDown()
    {
        y = y+unitSize;
        centery = y+unitSize/2;
    }

    public void setColor(Color c)
    {
        this.color = c;
    }

    public String toString()
    {
        return "Entity \n x:" + x+ " y:"+y;
    }

    public void setDestination(Destination d)
    {
        destination= d;
    }

    public Destination getDestination()
    {
        if (destination == null)
        {
            return null;
        }

        return destination;
    }



}
