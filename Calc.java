import java.util.Scanner;

public class Calc {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Calculator ---");
            System.out.println("1. Basic");
            System.out.println("2. Scientific");
            System.out.println("3. Convert");
            System.out.println("4. Exit");
            System.out.print("Option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> basic();
                case 2 -> sci();
                case 3 -> convert();
                case 4 -> {
                    System.out.println("Bye!");
                    return;
                }
                default -> System.out.println("Invalid.");
            }
        }
    }

    static void basic() {
        System.out.print("Num 1: ");
        double a = sc.nextDouble();
        System.out.print("Num 2: ");
        double b = sc.nextDouble();
        System.out.print("Op (+ - * /): ");
        char op = sc.next().charAt(0);

        try {
            double res = switch (op) {
                case '+' -> a + b;
                case '-' -> a - b;
                case '*' -> a * b;
                case '/' -> {
                    if (b == 0) throw new ArithmeticException("Divide by zero");
                    yield a / b;
                }
                default -> throw new IllegalArgumentException("Bad op");
            };
            System.out.println("Result: " + res);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void sci() {
        System.out.println("1. Sqrt");
        System.out.println("2. Pow");
        System.out.print("Pick: ");
        int op = sc.nextInt();

        switch (op) {
            case 1 -> {
                System.out.print("Num: ");
                double x = sc.nextDouble();
                if (x < 0) System.out.println("No sqrt of negative.");
                else System.out.println("Result: " + Math.sqrt(x));
            }
            case 2 -> {
                System.out.print("Base: ");
                double b = sc.nextDouble();
                System.out.print("Exp: ");
                double e = sc.nextDouble();
                System.out.println("Result: " + Math.pow(b, e));
            }
            default -> System.out.println("Invalid.");
        }
    }

    static void convert() {
        System.out.println("1. C to F");
        System.out.println("2. F to C");
        System.out.println("3. INR to USD");
        System.out.println("4. USD to INR");
        System.out.print("Pick: ");
        int op = sc.nextInt();

        switch (op) {
            case 1 -> {
                System.out.print("C: ");
                double c = sc.nextDouble();
                System.out.println("F: " + (c * 9 / 5 + 32));
            }
            case 2 -> {
                System.out.print("F: ");
                double f = sc.nextDouble();
                System.out.println("C: " + ((f - 32) * 5 / 9));
            }
            case 3 -> {
                System.out.print("INR: ");
                double inr = sc.nextDouble();
                System.out.println("USD: " + (inr / 83.0));
            }
            case 4 -> {
                System.out.print("USD: ");
                double usd = sc.nextDouble();
                System.out.println("INR: " + (usd * 83.0));
            }
            default -> System.out.println("Invalid.");
        }
    }
}