package organization;

// handles creating, printing, adding and removing from the organization
public class OrganizationManager {

    private Group organization;

    public OrganizationManager() {
        this.organization = null;
    }

    // builds the hard coded organization structure
    public void createOrganization() {
        organization = new Group("Top management", "Scrooge McDuck");
        organization.add(new Worker("Grandma Duck", "secretary"));

        // marketing group
        Group marketing = new Group("Marketing", "Donald Duck");
        marketing.add(new Worker("Gus Goose"));

        // sw development group
        Group swDev = new Group("Software Development", "Daisy Duck");
        swDev.add(new Worker("Huey Duck"));
        swDev.add(new Worker("Dewey Duck"));
        swDev.add(new Worker("Louie Duck"));

        // customer support group
        Group custSupport = new Group("Customer Support", "Gladstone Gander");
        custSupport.add(new Worker("Gyro Gearloose"));
        custSupport.add(new Worker("Magica De Spell"));
        custSupport.add(new Worker("Launchpad McQuack"));

        // add all groups under top management
        organization.add(marketing);
        organization.add(swDev);
        organization.add(custSupport);
    }

    public void printOrganization() throws OrganizationNotCreatedException {
        if (organization == null) {
            throw new OrganizationNotCreatedException();
        }
        System.out.println();
        organization.print("");
        System.out.println();
    }

    public boolean isOrganizationCreated() {
        return organization != null;
    }

    // checks that name is in format Firstname Lastname
    public void validateName(String name) throws InvalidNameFormatException {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidNameFormatException();
        }

        String[] parts = name.split(" ");
        if (parts.length != 2) {
            throw new InvalidNameFormatException();
        }

        // both parts must start with uppercase, rest lowercase
        for (String p : parts) {
            if (p.isEmpty()) {
                throw new InvalidNameFormatException();
            }
            if (!Character.isUpperCase(p.charAt(0))) {
                throw new InvalidNameFormatException();
            }
            for (int i = 1; i < p.length(); i++) {
                if (!Character.isLowerCase(p.charAt(i))) {
                    throw new InvalidNameFormatException();
                }
            }
        }
    }

    // add new worker to given unit
    public void addPerson(String unitName, String personName)
            throws OrganizationNotCreatedException, UnitNotFoundException, InvalidNameFormatException {

        if (organization == null) {
            throw new OrganizationNotCreatedException();
        }

        validateName(personName);

        Group target = organization.findGroup(unitName);
        if (target == null) {
            throw new UnitNotFoundException();
        }

        target.add(new Worker(personName));
    }

    // remove worker from organization
    public void removePerson(String personName)
            throws OrganizationNotCreatedException, InvalidNameFormatException, PersonNotFoundException {

        if (organization == null) {
            throw new OrganizationNotCreatedException();
        }

        validateName(personName);

        boolean ok = organization.removeWorker(personName);
        if (!ok) {
            throw new PersonNotFoundException();
        }
    }
}
