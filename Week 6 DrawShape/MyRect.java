package polyShape;

import java.awt.*;

public class MyRect extends MyShape {

    public int wid, hei;

    public MyRect(int x1, int y1, int width, int height) {
        super(x1, y1);
        wid = width;
        hei = height;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(this.color);
        g.drawRect(x1, y1, wid, hei);
    }
}
