package polyShape;

import java.awt.*;

public abstract class MyShape {

    public Color color;

    public boolean visible;

    public int x1, y1;

    public MyShape(int x_1, int y_1) {
        this.color = Color.black;
        x1 = x_1;
        y1 = y_1;
    }

    public abstract void draw(Graphics g);

    public void setVisible() {
        this.visible = !visible;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
