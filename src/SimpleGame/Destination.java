package SimpleGame;

import java.awt.*;

public class Destination {
    int x;
    int y;

    public Destination(int x,int y)
    {
        this.x = x;
        this.y = y;
    }

    public Point getDestination()
    {
        return new Point(x,y);
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public void setDestination(int x,int y)
    {
        this.x = x;
        this.y = y;
    }

    public String toString()
    {
        return new Point(x,y).toString();
    }
}
