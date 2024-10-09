package cp213;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
	Display display = new Display();
	display.setSize(100, 100);

	ButtonsPanel bp = new ButtonsPanel(display);

	final JFrame f = new JFrame("Calculator");
//	f.setResizable(false);
	f.setSize(500, 900);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	f.setLayout(new BorderLayout());
	f.add(display, BorderLayout.NORTH);
	f.add(bp, BorderLayout.CENTER);
	f.setVisible(true);

    }

}
