package polyShape;

import java.awt.*;

public class MyOval extends MyShape {
    public int wid, hei;

    public MyOval(int x1, int y1, int width, int height) {
        super(x1, y1);
        wid = width;
        hei = height;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(this.color);
        g.drawOval(x1, y1, wid, hei);
    }
}