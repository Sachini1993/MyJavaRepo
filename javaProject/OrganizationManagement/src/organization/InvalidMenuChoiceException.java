package organization;

// thrown when user gives wrong menu choice
public class InvalidMenuChoiceException extends Exception {

    public InvalidMenuChoiceException() {
        super("Invalid menu choice.");
    }

    public InvalidMenuChoiceException(String msg) {
        super(msg);
    }
}
