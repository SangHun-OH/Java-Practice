package smartShape;


import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class MyShape {
    
    public int x1;
    public int y1;
    public int x2;
    public int y2;    
    private Color color;
	private Random randomNumbers = new Random();

    
    public MyShape(int Mx1, int My1, int Mx2, int My2, Color Mcolor)
    {
    	color=Mcolor;
        x1 = Mx1;
        y1 = My1;
        x2 = Mx2;
        y2 = My2;
    }    
    public void DrawLine(Graphics g) {        
        g.setColor(color);
        int x3 = randomNumbers.nextInt(450);
        int y3 = randomNumbers.nextInt(450);
        g.drawLine(x1, y1, x2+x3, y2+y3);
    }
    
    public void DrawRect(Graphics g) {        
        g.setColor(color);
        g.drawRect(x1, y1, x2, y2);
    }
    public void DrawCircle(Graphics g) {
        g.setColor(color);
        g.drawOval(x1, y1, x2, y2);
    }
}
