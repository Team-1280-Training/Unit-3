import java.util.Scanner;

public class UserInput {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string:");
        String string = input.nextLine();
        System.out.println("Kewl: Xx_" + string + "_xX");
        System.out.println("Enter an integer:");
        int integer = input.nextInt();
        System.out.println("Squared: " + integer * integer);
    }
}