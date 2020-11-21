package smartShape;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;

public class DrawPanel extends JPanel {
	private MyShape[] shape;
	private String type;
	private Random randomNumbers = new Random();

	public int count;

	public DrawPanel(String s) {
		setBackground(Color.white);
		type = s;
		count = 5 + randomNumbers.nextInt(15);
		shape = new MyShape[count];
		for (int i = 0; i < count; i++) {
			int x1 = randomNumbers.nextInt(450);
			int y1 = randomNumbers.nextInt(450);
			int x2 = randomNumbers.nextInt(450);
			int y2 = randomNumbers.nextInt(450);

			shape[i] = new MyShape(x1, y1, x2, y2, Color.black);
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (MyShape i : shape) {
			if (i != null) {
				if (type.equals("Rect")) {
					i.DrawRect(g);
				}
				if (type.equals("Line")) {
					i.DrawLine(g);
				}
				if (type.equals("Circle")) {
					i.DrawCircle(g);
				}
			}
		}
	}
	public int ShapeNum() {
		return count;
	}
	
	public void ChangeColor(int x) {
		x = x-1;
		shape[x] = new MyShape(shape[x].x1, shape[x].y1, shape[x].x2, shape[x].y2, Color.red);
		repaint();
	}
}