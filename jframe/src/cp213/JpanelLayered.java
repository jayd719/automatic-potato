package cp213;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class JpanelLayered extends JFrame {

    JpanelLayered() {

	JLayeredPane layeredPane = new JLayeredPane();
	layeredPane.setBounds(0, 0, 500, 500);
	layeredPane.setBackground(Color.green);

	JLabel label1 = new JLabel();
	label1.setOpaque(true);
	label1.setBackground(Color.black);
	label1.setBounds(50, 50, 100, 100);

	JLabel label2 = new JLabel();
	label2.setOpaque(true);
	label2.setBackground(Color.red);
	label2.setBounds(75, 75, 100, 100);

	JLabel label3 = new JLabel();
	label3.setOpaque(true);
	label3.setBackground(Color.blue);
	label3.setBounds(100, 100, 100, 100);

	layeredPane.add(label1, Integer.valueOf(0));
	layeredPane.add(label2, Integer.valueOf(2));
	layeredPane.add(label3, Integer.valueOf(1));

	this.setTitle("J Layered Plane");
	this.setSize(800, 800);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setLayout(null);

	this.add(layeredPane);
	this.setVisible(true);
    }

}
