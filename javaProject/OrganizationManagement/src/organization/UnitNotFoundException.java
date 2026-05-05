package organization;

// thrown when given group name doesnt exist
public class UnitNotFoundException extends Exception {

    public UnitNotFoundException() {
        super("Organization unit not found.");
    }

    public UnitNotFoundException(String msg) {
        super(msg);
    }
}
