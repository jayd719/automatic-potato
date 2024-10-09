package cp213;

import java.awt.GridLayout;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ButtonsPanel extends JPanel {

    public ButtonsPanel(final Display display) {

	this.setLayout(new GridLayout(8, 2));

	this.add(new RegularKey("1", display));
	this.add(new RegularKey("2", display));
	this.add(new RegularKey("3", display));
	this.add(new RegularKey("4", display));
	this.add(new RegularKey("5", display));
	this.add(new RegularKey("6", display));
	this.add(new RegularKey("7", display));
	this.add(new RegularKey("8", display));
	this.add(new RegularKey("9", display));
	this.add(new RegularKey("0", display));
	this.add(new ActionKey("=", display.clearDisplay()));
	this.add(new RegularKey("C", display));
	this.add(new RegularKey("+", display));
	this.add(new RegularKey("-", display));
	this.add(new RegularKey("/", display));
	this.add(new RegularKey("*", display));
	this.add(new RegularKey("(", display));
	this.add(new RegularKey(")", display));
	this.add(new RegularKey("{", display));
	this.add(new RegularKey("}", display));
	this.add(new RegularKey("[", display));
	this.add(new RegularKey("]", display));
	this.add(new RegularKey("%", display));
	this.add(new RegularKey(".", display));

    }

}
