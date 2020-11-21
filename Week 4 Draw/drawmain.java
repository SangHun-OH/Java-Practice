package Prac4;

import javax.swing.JFrame;

public class drawmain {

	public static void main(String[] args) {

		JFrame application = new JFrame("DrawPanel");
		draw panel = new draw();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.add(panel);
		application.setSize(500, 500);
		application.setVisible(true);

	}

}
