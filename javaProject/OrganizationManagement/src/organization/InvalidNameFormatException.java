package organization;

// thrown when name is not in Firstname Lastname format
public class InvalidNameFormatException extends Exception {

    public InvalidNameFormatException() {
        super("Invalid name format.");
    }

    public InvalidNameFormatException(String msg) {
        super(msg);
    }
}
