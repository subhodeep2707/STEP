import java.util.*;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter operation (+, -, *, /) or exit:");
            String op = sc.next();
            if (op.equalsIgnoreCase("exit")) break;
            System.out.println("Enter two numbers:");
            double a = sc.nextDouble();
            double b = sc.nextDouble();
            double result = 0;
            switch (op) {
                case "+": result = a + b; break;
                case "-": result = a - b; break;
                case "*": result = a * b; break;
                case "/": 
                    if (b != 0) result = a / b;
                    else System.out.println("Division by zero not allowed.");
                    break;
                default: System.out.println("Invalid operation."); continue;
            }
            System.out.println("Result: " + result);
        }
    }
}
