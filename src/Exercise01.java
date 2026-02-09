import java.util.Scanner;
public class Exercise01 {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your First name:");
        String fName = scanner.nextLine();
        System.out.println("Enter your second name");

        String sName = scanner.nextLine();
        System.out.println("Hello" + " "+ fName+ " " + sName);

        scanner.close();

    }
}
