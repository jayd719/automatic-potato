package cp213;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.math.BigDecimal;
import java.util.HashMap;

/**
 * Stores a HashMap of MenuItem objects and the quantity of each MenuItem
 * ordered. Each MenuItem may appear only once in the HashMap.
 *
 * @author Jashandeep Singh
 * @author Abdul-Rahman Mawlood-Yunis
 * @author David Brown
 * @version 2023-09-06
 */
public class Order implements Printable {

    /**
     * The current tax rate on menu items.
     */
    public static final BigDecimal TAX_RATE = new BigDecimal(0.13);

    // Attributes
    private static final String orderFormat = "%-12s %-2d@ $%6.2f = $%6.2f";
    private static final String subTotal = "%-27s$%6.2f";
    private static final String itemFormat = "%5.2f";

    private HashMap<MenuItem, Integer> order = new HashMap<MenuItem, Integer>();

    /**
     * Increments the quantity of a particular MenuItem in an Order with a new
     * quantity. If the MenuItem is not in the order, it is added.
     *
     * @param item     The MenuItem to purchase - the HashMap key.
     * @param quantity The number of the MenuItem to purchase - the HashMap value.
     */
    public void add(final MenuItem item, final int quantity) {
	if (order.containsKey(item)) {
	    order.replace(item, order.get(item) + quantity);

	} else {
	    order.put(item, quantity);
	}
    }

    /**
     * Calculates the total value of all MenuItems and their quantities in the
     * HashMap.
     *
     * @return the total price for the MenuItems ordered.
     */
    public BigDecimal getSubTotal() {
	BigDecimal subTotal = new BigDecimal(0);

	for (MenuItem menuItem : order.keySet()) {
	    int qty = order.get(menuItem);
	    subTotal = subTotal.add(menuItem.getPrice().multiply(new BigDecimal(qty)));
	}

	return subTotal;
    }

    /**
     * Calculates and returns the total taxes to apply to the subtotal of all
     * MenuItems in the order. Tax rate is TAX_RATE.
     *
     * @return total taxes on all MenuItems
     */
    public BigDecimal getTaxes() {
	float taxes_ = Float.valueOf(String.format(itemFormat, this.getSubTotal().multiply(TAX_RATE)));
	BigDecimal taxes = new BigDecimal(taxes_);

	return taxes;
    }

    /**
     * Calculates and returns the total price of all MenuItems order, including tax.
     *
     * @return total price
     */
    public BigDecimal getTotal() {
	BigDecimal total = this.getSubTotal().add(this.getTaxes());

	return total;
    }

    /*
     * Implements the Printable interface print method. Prints lines to a Graphics2D
     * object using the drawString method. Prints the current contents of the Order.
     */
    @Override
    public int print(final Graphics graphics, final PageFormat pageFormat, final int pageIndex)
	    throws PrinterException {
	int result = PAGE_EXISTS;

	if (pageIndex == 0) {
	    final Graphics2D g2d = (Graphics2D) graphics;
	    g2d.setFont(new Font("MONOSPACED", Font.PLAIN, 12));
	    g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
	    // Now we perform our rendering
	    final String[] lines = this.toString().split("\n");
	    int y = 100;
	    final int inc = 12;

	    for (final String line : lines) {
		g2d.drawString(line, 100, y);
		y += inc;
	    }
	} else {
	    result = NO_SUCH_PAGE;
	}
	return result;
    }

    /**
     * Returns a String version of a receipt for all the MenuItems in the order.
     */
    @Override
    public String toString() {
	String returnString = "";

	for (MenuItem menuItem : order.keySet()) {
	    int qty = order.get(menuItem);
	    returnString += String.format(orderFormat, menuItem.getName(), qty, menuItem.getPrice(),
		    menuItem.getPrice().multiply(new BigDecimal(qty))) + "\n";
	}
	returnString += "\n";
	returnString += String.format(subTotal, "Subtotal:", this.getSubTotal());
	returnString += "\n";
	returnString += String.format(subTotal, "Taxes:", this.getTaxes());
	returnString += "\n";
	returnString += String.format(subTotal, "Total:", this.getTotal());

	return returnString;
    }

    /**
     * Replaces the quantity of a particular MenuItem in an Order with a new
     * quantity. If the MenuItem is not in the order, it is added. If quantity is 0
     * or negative, the MenuItem is removed from the Order.
     *
     * @param item     The MenuItem to update
     * @param quantity The quantity to apply to item
     */
    public void update(final MenuItem item, final int quantity) {

	if (order.containsKey(item)) {
	    if (quantity < 1) {
		order.remove(item);
	    } else {
		order.replace(item, quantity);

	    }

	} else {
	    if (quantity > 0) {
		order.put(item, quantity);
	    }

	}

    }
}