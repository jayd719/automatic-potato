package cp213;

/**
 * Inherited class in simple example of inheritance / polymorphism.
 *
 * @author Jashandeep Singh, 196018282
 * @version 2022-02-25
 */
public class IA extends Student {

    private String course = null;

    /**
     * IA constructor
     *
     * @param lastName  - IA last name (surname): defined in person
     * @param firstName - IA first name (given name): defined in person
     * @param id        - IA id: defined in student.
     * @param course    - course IA has been hired to help
     */
    public IA(final String lastName, final String firstName, final String id, final String course) {
	super(lastName, firstName, id);
	this.course = course;
    }

    /**
     * getter for course.
     *
     * @return this.course
     */
    public String getCourse() {
	return this.course;
    }

    /**
     * Creates formatted string version of IA.
     */
    @Override
    public String toString() {
	return (super.toString() + "\nCourse: " + this.course);
    }

}
