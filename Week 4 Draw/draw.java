package Prac4;

import java.awt.Graphics;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class draw extends JPanel {

	private Random randomNumbers = new Random();
	private String type;

	public draw() {

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int x, y;
		boolean a = true;

		while (a) {

			String type = JOptionPane.showInputDialog("도형의 Type 입력.");
			
			x = randomNumbers.nextInt(400);
			y = randomNumbers.nextInt(400);
			
			switch(type) {
			case "Rect":
				g.drawRect(x, y, 50, 50);
				break;
			case "Circle":
				g.drawOval(x, y, 50, 50);
				break;
			case "Triangle":
				int[] xb = { x, x, x + 50 };
				int[] yb = { y, y + 50, y };
				g.drawPolygon(xb, yb, 3);
				break;
			case "Line":
				g.drawLine(x, y, x+50, y);
				break;
			case "Exit":
				a = false;
				System.out.println("exit");
				break;
			}
			
			if (type.equals("Exit")) {
				System.exit(0);
			}
		}
	}
}
