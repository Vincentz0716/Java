import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        new Main().menu();
    }

    Scanner input = new Scanner(System.in);

    // Challenge 1: Allowance
    void allowance() {
        double amount = 0.01;
        int days = 0;

        while (amount < 5.00) {
            amount *= 2;
            days++;
        }

        System.out.println("It will take " + days + " days to reach or surpass $5.00");
    }

    // Challenge 2: Addition game
    void addTwoNumbers() {
        int num1 = (int)(Math.random() * 100) + 1;
        int num2 = (int)(Math.random() * 100) + 1;
        int sum = num1 + num2;
        int guess;

        do {
            System.out.print("What is " + num1 + " + " + num2 + "? ");
            guess = input.nextInt();
            if (guess != sum)
                System.out.println("Incorrect. Try again.");
        } while (guess != sum);

        System.out.println("Correct! The sum is " + sum + ".");
    }

    // Challenge 3: Greatest Common Factor
    int GCF(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Challenge 4: Menu
    void menu() {
        int choice;

        do {
            System.out.println("\nWelcome to Looney Tune's System");
            System.out.println("1 - Allowance");
            System.out.println("2 - Addition game");
            System.out.println("3 - Calculate the GCF of two integers");
            System.out.println("4 - Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    allowance();
                    break;
                case 2:
                    addTwoNumbers();
                    break;
                case 3:
                    System.out.print("Enter first integer: ");
                    int a = input.nextInt();
                    System.out.print("Enter second integer: ");
                    int b = input.nextInt();
                    System.out.println("The GCF of " + a + " and " + b + " is " + GCF(a, b) + ".");
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 4);
    }
}
