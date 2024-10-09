package cp213;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Utilities for working with Food objects.
 *
 * @author Jashandeep Singh, 169018282
 * @version 2023-05-07
 */
public class FoodUtilities {

    /**
     * Determines the average calories in a list of foods. No rounding necessary.
     * Foods list parameter may be empty.
     *
     * @param foods a list of Food
     * @return average calories in all Food objects
     */
    public static int averageCalories(final ArrayList<Food> foods) {

	int averageCal = 0;
	int totalCals = 0;

	for (int i = 0; i < foods.size(); i++) {
	    totalCals += foods.get(i).getCalories();
	}
	averageCal = totalCals / foods.size();

	return averageCal;
    }

    /**
     * Determines the average calories in a list of foods for a particular origin.
     * No rounding necessary. Foods list parameter may be empty.
     *
     * @param foods  a list of Food
     * @param origin the origin of the Food
     * @return average calories for all Foods of the specified origin
     */
    public static int averageCaloriesByOrigin(final ArrayList<Food> foods, final int origin) {

	int items = 0;
	int totalCals = 0;

	for (int i = 0; i < foods.size(); i++) {
	    Food curr = foods.get(i);

	    if (curr.getOrigin() == origin) {
		totalCals += curr.getCalories();
		items++;
	    }
	}

	return totalCals / items;
    }

    /**
     * Creates a list of foods by origin.
     *
     * @param foods  a list of Food
     * @param origin a food origin
     * @return a list of Food from origin
     */
    public static ArrayList<Food> getByOrigin(final ArrayList<Food> foods, final int origin) {

	ArrayList<Food> originList = new ArrayList<Food>();

	int i = 0;
	while (i < foods.size()) {
	    Food curr = foods.get(i);
	    if (curr.getOrigin() == origin) {
		originList.add(curr);
	    }
	    i++;
	}

	return originList;
    }

    /**
     * Creates a Food object by requesting data from a user. Uses the format:
     *
     * <pre>
    Name: name
    Origins
     0 Canadian
     1 Chinese
    ...
    11 English
    Origin: origin number
    Vegetarian (Y/N): Y/N
    Calories: calories
     * </pre>
     *
     * @param keyboard a keyboard Scanner
     * @return a Food object
     */
    public static Food getFood(final Scanner keyboard) {

	System.out.print("Name: ");
	String name = keyboard.nextLine();

	System.out.println(Food.originsMenu());
	int origin = -1;
	while (origin < 0 || origin > Food.ORIGINS.length) {
	    System.out.print("Origin: ");
	    origin = keyboard.nextInt();
	}

	System.out.print("Vegetarian (Y/N): ");
	char veg = keyboard.next().charAt(0);

	boolean isVeg = false;
	if (veg == 'Y') {
	    isVeg = true;
	}

	System.out.print("Calories: ");
	int calories = keyboard.nextInt();

	Food newFood = new Food(name, origin, isVeg, calories);

	return newFood;
    }

    /**
     * Creates a list of vegetarian foods.
     *
     * @param foods a list of Food
     * @return a list of vegetarian Food
     */
    public static ArrayList<Food> getVegetarian(final ArrayList<Food> foods) {

	ArrayList<Food> vegetarianList = new ArrayList<Food>();
	int i = 0;
	while (i < foods.size()) {
	    Food curr = foods.get(i);
	    if (curr.isVegetarian()) {
		vegetarianList.add(curr);
	    }
	    i++;
	}

	return vegetarianList;
    }

    /**
     * Creates and returns a Food object from a line of string data.
     *
     * @param line a vertical bar-delimited line of food data in the format
     *             name|origin|isVeget==tarian|calories
     * @return the data from line as a Food object
     */
    public static Food readFood(final String line) {

	String values[] = line.split("\\|");

	Food newFood = new Food(values[0], Integer.parseInt(values[1]), Boolean.parseBoolean(values[2]),
		Integer.parseInt(values[3]));

	return newFood;
    }

    /**
     * Reads a file of food strings into a list of Food objects.
     *
     * @param fileIn a Scanner of a Food data file in the format
     *               name|origin|isVegetarian|calories
     * @return a list of Food
     */
    public static ArrayList<Food> readFoods(final Scanner fileIn) {

	ArrayList<Food> foods = new ArrayList<Food>();
	while (fileIn.hasNextLine()) {
	    String line = fileIn.nextLine();
	    foods.add(readFood(line));

	}

	return foods;
    }

    /**
     * Searches for foods that fit certain conditions.
     *
     * @param foods        a list of Food
     * @param origin       the origin of the food; if -1, accept any origin
     * @param maxCalories  the maximum calories for the food; if 0, accept any
     * @param isVegetarian whether the food is vegetarian or not; if false accept
     *                     any
     * @return a list of foods that fit the conditions specified
     */
    public static ArrayList<Food> foodSearch(final ArrayList<Food> foods, final int origin, final int maxCalories,
	    final boolean isVegetarian) {

	ArrayList<Food> someFoods = new ArrayList<Food>();
	int i = 0;
	while (i < foods.size()) {
	    Food curr = foods.get(i);
	    if ((curr.getOrigin() == origin || origin == -1) && (curr.getCalories() <= maxCalories || maxCalories == 0)
		    && curr.isVegetarian() == isVegetarian)
		someFoods.add(curr);

	    i++;

	}
	return someFoods;
    }

    /**
     * Writes the contents of a list of Food to a PrintStream.
     *
     * @param foods a list of Food
     * @param ps    the PrintStream to write to
     */
    public static void writeFoods(final ArrayList<Food> foods, PrintStream ps) {

	int i = 0;
	while (i < foods.size()) {
	    foods.get(i).write(ps);

	    i++;
	}

    }
}
