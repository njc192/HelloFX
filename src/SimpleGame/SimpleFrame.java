package SimpleGame;

import SnakeGame.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class SimpleFrame extends JFrame implements ComponentListener {

    private SimplePanel simplePanel;
    public SimpleFrame()
    {
        simplePanel = new SimplePanel();
        this.add(simplePanel);
        this.setTitle("Simple" );
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.addComponentListener(this);
    }

    @Override
    public void componentResized(ComponentEvent e) {

    }

    @Override
    public void componentMoved(ComponentEvent e) {
        Point location = this.getLocationOnScreen();
        simplePanel.setWindowOffset(new Point(location.x + 8, location.y + 32));
        this.update(getGraphics());
    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }
}
