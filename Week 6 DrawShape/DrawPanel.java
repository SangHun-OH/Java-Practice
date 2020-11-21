package polyShape;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;


class DrawPanel extends Frame {
	private Random randomNumbers = new Random();

    static public Color[] colors = {Color.red, Color.green, Color.blue, Color.yellow, Color.black};

    private Button[] selectShape;
    private Button[] selectColor = {new Button("Red"), new Button("Green"), new Button("Blue"), new Button("Yellow"), new Button("Black")};
    private Button hide = new Button("Hide");
    private Button restore = new Button("Restore");
    private Button exit = new Button("Exit");
    
    int selected = 0;
    int numShape = 5;
    boolean hiding = false;
    private MyShape[] shapes;

    public DrawPanel() {
        super("Smart Shape 3 for Poly");
        
        GridLayout gl = new GridLayout();

        Panel selectShapePanel = new Panel(gl);
        Panel visible = new Panel(gl);

        numShape = numShape + randomNumbers.nextInt(6);
        
        exit = new Button("Exit");
        exit.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
        		System.exit(0);
            }
        	
        });
        
        hide = new Button("Hide");
        hide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hiding = true;
                repaint();
            }
        });

        restore = new Button("Restore");
        restore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hiding = false;
                repaint();
            }
        });

        selectShape = new Button[numShape];
        for (int i = 0; i < numShape; i++) {
            selectShape[i] = new Button("C" + (i + 1));
            int lastI = i;
            selectShape[lastI].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    selected = lastI;
                }
            });
            selectShapePanel.add(selectShape[i]);
        }

        for (int i = 0; i < 5; i++) {
            int lastI = i;
            selectColor[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    shapes[selected].setColor(colors[lastI]);
                    repaint();
                }
            });
            selectShapePanel.add(selectColor[i]);
        }

        shapes = new MyShape[numShape];
        
        int shapeType = randomNumbers.nextInt(3);
        
        for (int i = 0; i < numShape; i++) {
            
            int x1 = randomNumbers.nextInt(450);
            int y1 = randomNumbers.nextInt(450);

            if (shapeType == 0) {              
                int x2 = randomNumbers.nextInt(950);
                int y2 = randomNumbers.nextInt(950);
                
                if (x2 == x1) 
                    x2 = x2+5;                
                if (y2 == y1)
                	y2 = y2+5;                
                shapes[i] = new MyLine(x1, y1, x2, y2);
            } else if (shapeType == 1) {
                int width = 5 + randomNumbers.nextInt(450);
                int height = 5 + randomNumbers.nextInt(450);
                shapes[i] = new MyRect(x1, y1, width, height);
            } else {
                int width = 5 + randomNumbers.nextInt(450);
                int height = 5 + randomNumbers.nextInt(450);
                shapes[i] = new MyOval(x1, y1, width, height);
            }
        }

        visible.add(hide);
        visible.add(restore);
        visible.add(exit);

        add("North", selectShapePanel);
        add("South", visible);
        
        setSize(1000, 1000);
        setVisible(true);
    }

    public void repaint() {
        super.repaint();
    }

    public void paint(Graphics g) {
        if(!hiding) {
            for (int i = 0; i < numShape; i++) {
                shapes[i].draw(g);
            }
        } 
    }
}