package cp213;

import java.text.DecimalFormat;
import java.time.LocalDate;

/**
 * Tests the Student class.
 *
 * @author Jashandeep Singh
 * @version 2023-09-30
 */
public class Main {

    public static void main(String[] args) {
	final String line = "-".repeat(40);
	int id = 123456;
	String surname = "Brown";
	String forename = "David";
	LocalDate birthDate = LocalDate.parse("1962-10-25");
	Student student = new Student(id, surname, forename, birthDate);
	System.out.println("New Student:");
	System.out.println(student);
	System.out.println(line);
	System.out.println("Test Getters");

	// call getters here
	System.out.println(student.getForename());
	System.out.println(student.getSurname());
	System.out.println(student.getBirthDate());

	System.out.println(line);
	System.out.println("Test Setters");

	student.setBirthDate(LocalDate.parse("1960-10-25"));
	student.setForename("Jashandeep");
	student.setSurname("Singh");
	System.out.println("Updated Student:");
	System.out.println(student);
	System.out.println(line);
	System.out.println("Test compareTo");

	// create new Students - call comparisons here
	Student s2 = new Student(12342, "John", "Miller", LocalDate.parse("1999-10-25"));
	System.out.println(student.compareTo(s2));
	System.out.println(student.toString());

	char n = 'Y';
	System.out.printf("\n %c \n %3c \n %5c", n, n, n);

	byte b = 100;
	short s = 10000;
	int i = 100000;
	long l = 1000000;
	float f = 123.4f;
	double d = 1.234e2;
	System.out.println("");
	s = b;
	i = s;
	l = i;
	f = l;
	d = f;
	System.out.println(s + " " + i + " " + l + " " + f + " " + d);

	DecimalFormat paƩern00dot000 = new DecimalFormat("00.000");
	double d1 = 12.3456789;
	System.out.println(paƩern00dot000.format(d1));

	double value = 12.123;
	System.out.printf("Start%8.2fEnd", value);
	System.out.println();
	System.out.printf("Start%-8.2fEnd", value);
	System.out.println();

	int input = 7;
	int output = ++input + ++input + ++input;
	System.out.println(output);

    }

}
