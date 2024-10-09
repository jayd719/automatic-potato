package cp213;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class RBG extends JFrame implements ChangeListener {
    JSlider slider1;
    JSlider slider2;
    JSlider slider3;
    JPanel panel;

    RBG() {
	this.setTitle("RBG Color Picker");
	this.setSize(500, 500);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setLayout(null);
	this.setResizable(false);
	this.setBackground(Color.black);

	slider1 = new MySlider(100);
	slider2 = new MySlider(200);
	slider3 = new MySlider(300);
	panel = new JPanel();

	slider1.addChangeListener(this);
	slider2.addChangeListener(this);
	slider3.addChangeListener(this);

	panel.setBounds(0, 0, 500, 500);
	panel.setLayout(null);
	panel.setBackground(new Color(slider1.getValue(), slider2.getValue(), slider3.getValue()));

	panel.add(slider1);
	panel.add(slider2);
	panel.add(slider3);
	this.add(panel);

	this.setVisible(true);

    }

    @Override
    public void stateChanged(ChangeEvent e) {

	panel.setBackground(new Color(slider1.getValue(), slider2.getValue(), slider3.getValue()));

    }

}
