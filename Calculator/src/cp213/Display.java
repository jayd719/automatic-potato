package cp213;

import java.awt.Font;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Display extends JLabel {

    public Display() {
	this.setText("");
	this.setSize(100, 50);
	this.setFont(new Font("Arail", Font.BOLD, 20));

    }

    public void attendToDisplay(final String val) {
	this.setText(this.getText() + val);
    }

    public boolean clearDisplay() {
	this.setText("");
	return true;
    }

    public boolean backSpace() {
	this.setText(this.getText().substring(0, this.getText().length() - 2));
	return true;
    }
}
