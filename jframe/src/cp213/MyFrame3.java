package cp213;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class MyFrame3 extends JFrame implements KeyListener {

    MyFrame3() {
	this.setTitle("Hello World");
	this.setSize(800, 800);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setLayout(null);

	this.addKeyListener(this);
	this.getContentPane().setBackground(new Color(123, 50, 250));

	this.setVisible(true);

    }

    @Override
    public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub

    }

    @Override
    public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub

    }

}
