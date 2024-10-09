package cp213;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class TextField extends JFrame implements ActionListener {
    JButton button = new JButton("add name");
    JTextField txt = new JTextField();

    TextField() {
	this.setTitle("Hello World");
	this.setSize(800, 800);

	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	this.setLayout(new FlowLayout());
//	frame.add(redPanel);
//	frame.add(bluePanel);
//	frame.add(label);

	button.addActionListener(this);

	txt.setPreferredSize(new Dimension(500, 100));

	this.add(txt);
	this.add(button);
	this.pack();
	this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
	if (e.getSource() == button) {
	    System.out.println("Hello " + txt.getText());

	}

    }

}
