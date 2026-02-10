import java.util.Scanner;

public class Exercise01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your first name:");
        String fName = scanner.nextLine();

        System.out.println("Enter your second name:");
        String sName = scanner.nextLine();

        System.out.println("Enter your age:");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.println("What is your GPA:");
        double gpa = Double.parseDouble(scanner.nextLine());

        System.out.println("Are you a student (true/false):");
        boolean isStudent = Boolean.parseBoolean(scanner.nextLine());

        System.out.println("Hello " + fName + " " + sName);
        System.out.println("You are " + age + " years old");
        System.out.println("Your GPA is " + gpa);

        if (isStudent) {
            System.out.println("You are a student, so you are permitted to access our library.");
        } else {
            System.out.println("You are not a student, so access is denied.");
        }

        scanner.close();
    }
}
