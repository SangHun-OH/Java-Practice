package paint;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class PaintPanel extends JPanel {

	private JList ColorList;
	private JRadioButton setRadio[] = new JRadioButton[6];

	String[] setColor = { "Black", "Red", "Green", "Blue", "Yellow", "White" };
	String[] setSize = { "3", "5", "8", "12", "16", "20" };

	int tk=3;
	private int count = 0;
	private final int maxShape = 100;

	numShape[] shape = new numShape[100];

	public PaintPanel() {

		ColorList = new JList(setColor);
		ColorList.setVisibleRowCount(5);
		ColorList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		add(new JScrollPane(ColorList));
		
		ButtonGroup gp = new ButtonGroup();
		for (int i = 0; i < 6; i++) {
			if (i == 0)
				setRadio[i] = new JRadioButton(setSize[i], true);
			else
				setRadio[i] = new JRadioButton(setSize[i], false);
			gp.add(setRadio[i]);
			add(setRadio[i]);
			setRadio[i].addItemListener(new MyItemListener());
		}

		for (int i = 0; i < maxShape; i++) {
			shape[i] = null;
		}

		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent event) {
				shape[count] = new numShape();
				shape[count].setColor(ColorList.getSelectedIndex());
				shape[count].setThick(tk);
			}

			public void mouseReleased(MouseEvent event) {
				count += 1;
				if (count >= maxShape) {
					count = 0;
				}
			}
		});

		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent event) {
				if (shape[count].pointCount < shape[count].points.length) {
					shape[count].points[shape[count].pointCount] = event.getPoint();
					shape[count].pointCount++;
					repaint();
				}
			}
		});
	}

	class MyItemListener implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.DESELECTED)
				tk = 3;
			else if (setRadio[0].isSelected())
				tk = 3;
			else if (setRadio[1].isSelected())
				tk = 5;
			else if (setRadio[2].isSelected())
				tk = 8;
			else if (setRadio[3].isSelected())
				tk = 12;
			else if (setRadio[4].isSelected())
				tk = 16;
			else
				tk = 20;
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (int i = 0; i < maxShape; i++) {
			if (shape[i] != null)
				shape[i].DrawPen(g);
		}
	}
}

class numShape {
	private Color colorSet = Color.BLACK;
	private int thick;
	public int pointCount = 0;
	public Point[] points = new Point[10000];

	public numShape() {
	}
	
	public void setColor(int c) {
		if (c == 0) {
			colorSet = Color.BLACK;
		} else if (c == 1) {
			colorSet = Color.RED;
		} else if (c == 2) {
			colorSet = Color.GREEN;
		} else if (c == 3) {
			colorSet = Color.BLUE;
		} else if (c == 4) {
			colorSet = Color.YELLOW;
		} else if (c == 5) {
			colorSet = Color.WHITE;
		}
	}
	
	 public void setThick(int t) {
	      thick = t;
	   }

	public void DrawPen(Graphics g) {
		g.setColor(colorSet);
		for (int i = 0; i < pointCount; i++) {
			g.fillOval(points[i].x, points[i].y, thick, thick);
		}
	}
}
