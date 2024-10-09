package cp213;

/**
 * Inherited class in simple example of inheritance / polymorphism.
 *
 * @author Jashandeep Singh, 169018282
 * @version 2022-02-25
 */
public class CAS extends Professor {

    private String term = null;

    /**
     * CAS constructor
     *
     * @param lastName   - CAS last name(surname): defined in person.
     * @param firstName  - CAS first name (given name): defined in person.
     * @param department - CAS department: defined in the Professor.
     * @param term       - term for which CAS has been hired for.
     */
    public CAS(final String lastName, final String firstName, final String department, final String term) {
	super(lastName, firstName, department);
	this.term = term;
    }

    /**
     * Getter for term.
     *
     * @return this.term
     */
    public String getTerm() {
	return this.term;
    }

    @Override
    public String toString() {
	return (super.toString() + "\nTerm: " + this.term);
    }

}
