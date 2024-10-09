package cp213;

import java.time.LocalDate;

/**
 * Student class definition.
 *
 * @author Jashandeep Singh
 * @version 2023-09-30
 */
public class Student implements Comparable<Student> {

    // Attributes
    private LocalDate birthDate = null;
    private String forename = "";
    private int id = 0;
    private String surname = "";

    /**
     * Instantiates a Student object.
     *
     * @param id        student ID number
     * @param surname   student surname
     * @param forename  name of forename
     * @param birthDate birthDate in 'YYYY-MM-DD' format
     */
    public Student(int id, String surname, String forename, LocalDate birthDate) {
	this.id = id;
	this.surname = surname;
	this.forename = forename;
	this.birthDate = birthDate;

	return;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString() Creates a formatted string of student data.
     */
    @Override
    public String toString() {
	String string = "Name:      " + surname + ", " + forename + "\nID:        " + id + "\nBirthdate: " + birthDate;
	return string;

    }

    /*
     *
     * (non-Javadoc)
     *
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(final Student target) {
	int result = 0;

	result = surname.compareTo(target.surname);
	if (result == 0) {
	    result = forename.compareTo(target.forename);
	    if (result == 0) {
		result = Integer.compare(id, target.id);
	    }
	}

	return result;
    }

    // getters and setters defined here

    /**
     * Sets student ID of object
     *
     * @param student ID number
     */
    public void setId(int id) {
	this.id = id;
    }

    /**
     * Sets surname of student object
     *
     * @param surname
     */
    public void setSurname(String surname) {
	this.surname = surname;
    }

    /**
     * Sets forename of object
     *
     * @param forename to set
     */
    public void setForename(String forename) {
	this.forename = forename;
    }

    /**
     * Sets birth date of object
     *
     * @param birthDate
     */
    public void setBirthDate(LocalDate birthDate) {
	this.birthDate = birthDate;
    }

    /**
     * gets student id of student object
     *
     * @return returns ID of the student object
     */
    public int getId() {
	return id;
    }

    /**
     * gets forename of the student object
     *
     * @return String forename
     */
    public String getForename() {
	return forename;
    }

    /**
     * gets surname of the student object
     *
     * @return string surname
     */
    public String getSurname() {
	return surname;
    }

    /**
     * gets birth date of the student object
     *
     * @return LocalDate BirthDate
     */
    public LocalDate getBirthDate() {
	return birthDate;
    }
}
