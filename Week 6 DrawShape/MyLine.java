package polyShape;

import java.awt.*;

public class MyLine extends MyShape {
    public int x_2, y_2;

    public MyLine(int x1, int y1, int x2, int y2) {
        super(x1, y1);
        x_2 = x2;
        y_2 = y2;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(this.color);
        g.drawLine(x1, y1, x_2, y_2);
    }
}