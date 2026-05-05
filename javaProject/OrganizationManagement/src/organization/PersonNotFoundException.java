package organization;

// thrown when trying to remove person that doesnt exist
public class PersonNotFoundException extends Exception {

    public PersonNotFoundException() {
        super("Person not found.");
    }

    public PersonNotFoundException(String msg) {
        super(msg);
    }
}
