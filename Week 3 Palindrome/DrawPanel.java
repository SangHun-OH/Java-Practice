import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawPanel extends JPanel {
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		int width = getWidth();
		int height = getHeight();
		
		for (int i=0; i <= 15; i++)
		{
			// x1, y1, x2, y2
			g.drawLine(0, height/15*i, width/15*i, height);
		}
	}
}
