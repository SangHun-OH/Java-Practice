package smartShape;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SmartShape {

	public static void main(String[] args) {
		
		String type = JOptionPane.showInputDialog("������ Type �Է�.");
		if (!type.equals("Rect") && !type.equals("Circle") && !type.equals("Line")) {
			System.out.println(type);
			System.exit(0);
		}

		DrawPanel panel = new DrawPanel(type);
		
		JFrame application = new JFrame("SmartShape_2");

		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.add(panel);
		application.setSize(1000, 1000);
		application.setVisible(true);
	
		while (true) {
			int shapeCount = panel.ShapeNum();
			String select = JOptionPane.showInputDialog(null, String.format("���� �ٲ� ������ ��ȣ �Է�. ������ ���� : %d", shapeCount));
			int x = Integer.parseInt(select);
			if(x == -1) {
				System.exit(0);
			}
			if (x <= 0 || x > shapeCount) {
				continue;
			}

			panel.ChangeColor(x);
		}
	}
}
