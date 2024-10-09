package cp213;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class ActionKey extends JButton implements ActionListener {
    private Object func;

    public ActionKey(final String val, final Object Display) {
	this.func = Display;
	this.setText(val);
	this.setSize(25, 25);
	this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	if (e.getSource() == this) {
	    Object ob = this.func;
	    ob.toString();
	}

    }

}