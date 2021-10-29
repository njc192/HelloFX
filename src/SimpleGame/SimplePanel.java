package SimpleGame;

import javafx.geometry.BoundingBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;

public class SimplePanel extends JPanel {
    private static final int SCREEN_WIDTH = 1300;
    private static final int SCREEN_HEIGHT = 750;
    private Entity entity;
    private Timer timer;
    private Point windowOffset;

    private boolean ability_1 = false;
    BoundingBox b = new BoundingBox(0,0,SCREEN_WIDTH,SCREEN_HEIGHT);
    public SimplePanel()
    {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.pink);
        entity = new Entity(50,50,b);
        setFocusable(true);
        addKeyListener(new MyKeyAdapter());
        addMouseListener(new MyMouseAdapter());
    }



    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g)
    {

        if (ability_1)
        {
            drawLine(g);
            ability_1 = false;
        }
        g.setColor(entity.getColor());

        g.fillRect(entity.x,entity.y,entity.unitSize, entity.unitSize);
    }

    public void drawLine(Graphics g)
    {

        PointerInfo mouseLocation = MouseInfo.getPointerInfo();
        Point point = mouseLocation.getLocation();
        int windx = point.x - windowOffset.x - entity.centerx;
        int windy = point.y - windowOffset.y - entity.centery;
        System.out.println(entity);
        System.out.println("WindowOffset x:" + windowOffset );
        System.out.println("Mouse " + point);
        System.out.println("Mouse FixedOffset: x:" + windx + " y:" + windy);
        int dx = entity.centerx - (windx);
        int dy = entity.centery - (windy);

        System.out.println("DX: " + dx + " DY:" + dy );
        double unitVector = Math.sqrt(Math.pow(dx,2)+ Math.pow(dy,2));
        Graphics2D g2 = (Graphics2D)g.create();

        System.out.println("unit x: " + windx/unitVector + " y:" + windy/unitVector  );
        Line2D line = new Line2D.Double(entity.centerx,entity.centery,windx/unitVector*10000, windy/unitVector*10000);
        g2.draw(line);
        g2.dispose();
    }




    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch(e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    System.out.println("left");
                    entity.moveLeft();
                    entity.setColor(Color.BLACK);
                    break;
                case KeyEvent.VK_RIGHT:
                    System.out.println("right");
                    entity.moveRight();
                    entity.setColor(Color.RED);
                    break;
                case KeyEvent.VK_UP:
                    System.out.println("up");
                    entity.setColor(Color.YELLOW);
                    entity.moveUp();
                    break;
                case KeyEvent.VK_DOWN:
                    System.out.println("down");
                    entity.setColor(Color.ORANGE);
                    entity.moveDown();
                    break;
                case KeyEvent.VK_Q:
                    System.out.println("Q press");
                    ability_1 = true;
            }
            repaint();
        }
    }

    public class MyMouseAdapter extends MouseAdapter
    {
        @Override
        public void mousePressed(MouseEvent e)
        {
            System.out.println("clicked");
            System.out.println(e.getPoint());
            System.out.println(e.getLocationOnScreen());
            entity.setDestination(new Destination(e.getX(),e.getY()));
            if(timer == null)
            {
                timer = new Timer(75, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        if (entity.getDestination() != null)
                        {
                            Destination destination = entity.getDestination();
                            if (destination.getX() - entity.x < entity.unitSize*-1)
                            {
                                entity.moveLeft();
                            }
                            if (destination.getY() - entity.y < entity.unitSize*-1)
                            {
                                entity.moveUp();
                            }
                            if (destination.getX() - entity.x > entity.unitSize)
                            {
                                entity.moveRight();
                            }
                            if (destination.getY() - entity.y > entity.unitSize)
                            {
                                entity.moveDown();
                            }
                            if (Math.abs(destination.getY() - entity.y)  < entity.unitSize && Math.abs(destination.getX() - entity.x) < entity.unitSize)
                            {
                                entity.setDestination(null);
                                timer.stop();
                                timer = null;
                            }
                            repaint();
                        }
                    }

                });
                timer.start();
            }




        }
    }

    public void setWindowOffset(Point p)
    {
        windowOffset = p;
    }
}
