package cp213;

import javax.swing.JSlider;

@SuppressWarnings("serial")
public class MySlider extends JSlider {

    MySlider(final int y) {
	this.setMaximum(255);
	this.setMinimum(0);
	this.setBounds(100, y, 300, 50);
	this.setPaintTicks(true);
	this.setMajorTickSpacing(100);

    }
}
