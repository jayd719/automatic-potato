package cp213;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class RegularKey extends JButton implements ActionListener {
    private Display display;

    public RegularKey(final String val, final Display display) {
	this.display = display;
	this.setText(val);
	this.setSize(25, 25);
	this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	if (e.getSource() == this) {
	    this.display.attendToDisplay(this.getText());
	}

    }

}
