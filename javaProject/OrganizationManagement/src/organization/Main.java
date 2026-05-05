package organization;

import java.util.Scanner;

// main class - runs the menu loop
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        OrganizationManager mgr = new OrganizationManager();

        while (true) {
            printMenu();
            String choice = sc.nextLine().trim();

            if (choice.equalsIgnoreCase("q")) {
                break;
            }

            try {
                switch (choice) {
                    case "1":
                        handleOption1(mgr);
                        break;
                    case "2":
                        handleOption2(mgr, sc);
                        break;
                    case "3":
                        handleOption3(mgr, sc);
                        break;
                    default:
                        throw new InvalidMenuChoiceException();
                }
            } catch (InvalidMenuChoiceException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (OrganizationNotCreatedException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (UnitNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (InvalidNameFormatException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (PersonNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        sc.close();
    }

    // prints the menu
    private static void printMenu() {
        System.out.println("Organization management system");
        System.out.println("------------------------------");
        System.out.println();
        System.out.println("1. Create and print hard coded organization");
        System.out.println("2. Print organization, add person to it and finally print it");
        System.out.println("3. Print organization, remove person from it and finally print it");
        System.out.println("Q. Quit the application");
        System.out.println();
        System.out.print("Your choice: ");
    }

    // option 1 - create and print
    private static void handleOption1(OrganizationManager mgr)
            throws OrganizationNotCreatedException {
        mgr.createOrganization();
        mgr.printOrganization();
    }

    // option 2 - add person
    private static void handleOption2(OrganizationManager mgr, Scanner sc)
            throws OrganizationNotCreatedException, UnitNotFoundException, InvalidNameFormatException {

        mgr.printOrganization();

        System.out.print("Give unit name: ");
        String unitName = sc.nextLine().trim();

        System.out.print("Give person name: ");
        String personName = sc.nextLine().trim();

        mgr.addPerson(unitName, personName);
        mgr.printOrganization();
    }

    // option 3 - remove person
    private static void handleOption3(OrganizationManager mgr, Scanner sc)
            throws OrganizationNotCreatedException, InvalidNameFormatException, PersonNotFoundException {

        mgr.printOrganization();

        System.out.print("Give person name: ");
        String personName = sc.nextLine().trim();

        mgr.removePerson(personName);
        mgr.printOrganization();
    }
}
