package cp213;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * The GUI for the Order class.
 *
 * @author Jashandeep Singh
 * @author Abdul-Rahman Mawlood-Yunis
 * @author David Brown
 * @version 2023-09-06
 */
@SuppressWarnings("serial")
public class OrderPanel extends JPanel {

    // Attributes

    private static final String itemFormat = "$%5.2f";

    private Menu menu = null; // Menu attached to panel.
    private final Order order = new Order(); // Order to be printed by panel.
    // GUI Widgets
    private final JButton printButton = new JButton("Print");
    private final JLabel subtotalLabel = new JLabel("0");
    private final JLabel taxLabel = new JLabel("0");
    private final JLabel totalLabel = new JLabel("0");

    private JLabel nameLabels[] = null;
    private JLabel priceLabels[] = null;
    // TextFields for menu item quantities.
    private JTextField quantityFields[] = null;

    /**
     * Displays the menu in a GUI.
     *
     * @param menu The menu to display.
     */
    public OrderPanel(final Menu menu) {
	this.menu = menu;
	this.nameLabels = new JLabel[this.menu.size()];
	this.priceLabels = new JLabel[this.menu.size()];
	this.quantityFields = new JTextField[this.menu.size()];

	for (int i = 0; i < this.menu.size(); i++) {
	    MenuItem mI = this.menu.getItem(i);

	    nameLabels[i] = new JLabel(mI.getName());

	    JLabel jLabel = new JLabel(String.format(itemFormat, mI.getPrice()));
	    jLabel.setHorizontalAlignment(JLabel.RIGHT);
	    priceLabels[i] = jLabel;

	    JTextField jTextF = new JTextField("0");
	    jTextF.addFocusListener(new QuantityListener(mI));
	    jTextF.setHorizontalAlignment(JTextField.RIGHT);
	    quantityFields[i] = jTextF;
	}

	this.layoutView();
	this.registerListeners();
    }

    /**
     * Implements an ActionListener for the 'Print' button. Prints the current
     * contents of the Order to a system printer or PDF.
     */
    private class PrintListener implements ActionListener {

	@Override
	public void actionPerformed(final ActionEvent e) {

	    if (e.getSource() == printButton) {
		PrinterJob printer = PrinterJob.getPrinterJob();
		printer.setPrintable(order);

		if (printer.printDialog()) {
		    try {
			printer.print();
		    } catch (PrinterException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		    }

		}

	    }

	}
    }

    /**
     * Implements a FocusListener on a JTextField. Accepts only positive integers,
     * all other values are reset to 0. Adds a new MenuItem to the Order with the
     * new quantity, updates an existing MenuItem in the Order with the new
     * quantity, or removes the MenuItem from the Order if the resulting quantity is
     * 0.
     */
    private class QuantityListener implements FocusListener {
	private MenuItem item = null;

	QuantityListener(final MenuItem item) {
	    this.item = item;
	}

	@Override
	public void focusGained(FocusEvent e) {
	    JTextField element = (JTextField) e.getSource();
	    if (element.getText().compareTo("0") == 0) {
		element.setText("");
	    } else {
		element.getHighlighter();
	    }

	}

	@Override
	public void focusLost(FocusEvent e) {
	    JTextField element = (JTextField) e.getSource();
	    try {
		int qty = Integer.parseInt(element.getText());
		order.update(this.item, qty);

		subtotalLabel.setText(String.format(itemFormat, order.getSubTotal()));
		taxLabel.setText(String.format(itemFormat, order.getTaxes()));
		totalLabel.setText(String.format(itemFormat, order.getTotal()));

	    } catch (NumberFormatException k) {
		element.setText("0");
	    }

	}

	// your code here
    }

    /**
     * Layout the panel.
     */
    private void layoutView() {

	this.setLayout(new GridLayout(this.menu.size() + 5, 3));
	this.setBorder(new EmptyBorder(5, 15, 5, 15));
	this.add(new JLabel("Item"));
	this.add(new JLabel("Price"));
	this.add(new JLabel("Quantity"));
	for (int i = 0; i < this.menu.size(); i++) {
	    this.add(nameLabels[i]);
	    this.add(priceLabels[i]);
	    this.add(quantityFields[i]);
	}

	subtotalLabel.setHorizontalAlignment(JLabel.RIGHT);
	taxLabel.setHorizontalAlignment(JLabel.RIGHT);
	totalLabel.setHorizontalAlignment(JLabel.RIGHT);

	this.add(new JLabel("Subtotal:"));
	this.add(new JLabel(""));
	this.add(subtotalLabel);
	this.add(new JLabel("Tax:"));
	this.add(new JLabel(""));
	this.add(taxLabel);
	this.add(new JLabel("Total:"));
	this.add(new JLabel(""));
	this.add(totalLabel);
	this.add(new JLabel(""));
	this.add(printButton);

    }

    /**
     * Register the widget listeners.
     */
    private void registerListeners() {
	// Register the PrinterListener with the print button.
	this.printButton.addActionListener(new PrintListener());

	// your code here
    }

}