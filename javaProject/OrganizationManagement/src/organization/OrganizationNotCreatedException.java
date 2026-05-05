package organization;

// thrown when trying to use organization before creating it
public class OrganizationNotCreatedException extends Exception {

    public OrganizationNotCreatedException() {
        super("Create the organization first.");
    }

    public OrganizationNotCreatedException(String msg) {
        super(msg);
    }
}
