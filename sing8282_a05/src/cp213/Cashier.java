package cp213;

import java.util.Scanner;

/**
 * Wraps around an Order object to ask for MenuItems and quantities.
 *
 * @author Jashandeep Singh
 * @author Abdul-Rahman Mawlood-Yunis
 * @author David Brown
 * @version 2023-09-06
 */
public class Cashier {

    // Attributes
    private Menu menu = null;

    /**
     * Constructor.
     *
     * @param menu A Menu.
     */
    public Cashier(Menu menu) {
	this.menu = menu;
    }

    /**
     * Prints the menu.
     */
    private void printCommands() {
	System.out.println("\nMenu:");
	System.out.println(menu.toString());
	System.out.println("Press 0 when done.");
	System.out.println("Press any other key to see the menu again.\n");
    }

    /**
     * Asks for commands and quantities. Prints a receipt when all orders have been
     * placed.
     *
     * @return the completed Order.
     */
    public Order takeOrder() {
	System.out.println("Welcome to WLU Foodorama!");
	this.printCommands();

	Scanner keyboard = new Scanner(System.in);
	int input_ = -1;
	Order order = new Order();

	while (input_ != 0) {
	    System.out.print("Command: ");
	    if (keyboard.hasNextInt() == true) {
		input_ = keyboard.nextInt();

		if (input_ == 0) {
		} else if (input_ > 0 && input_ <= this.menu.size()) {

		    System.out.print("How many do you want? ");
		    if (keyboard.hasNextInt() == true) {
			int qty = keyboard.nextInt();
			if (qty > 0) {
			    MenuItem menuItem = this.menu.get(input_ - 1);
			    order.add(menuItem, qty);

			} else {
			    System.out.println("Not a valid number");
			}

		    } else {
			System.out.println("Not a valid number");
		    }

		} else {
		    this.printCommands();
		}

	    } else {
		System.out.println("Not a valid number");
		this.printCommands();
		keyboard.next();
		// run_ = false;

	    }

	}
	keyboard.close();
	System.out.println("Receipt");
	System.out.println(order.toString());
	return order;
    }
}