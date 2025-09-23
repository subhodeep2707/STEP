class BasicMath {
    int calculate(int a, int b) { return a + b; }
    double calculate(double a, double b) { return a * b; }
}

class AdvancedMath extends BasicMath {
    int calculate(int a, int b, int c) { return a + b + c; }
    double calculate(double a, double b, double c) { return a * b * c; }
}

public class TestMath {
    public static void main(String[] args) {
        AdvancedMath am = new AdvancedMath();
        System.out.println(am.calculate(2,3));       // 5
        System.out.println(am.calculate(2.0,3.0));   // 6.0
        System.out.println(am.calculate(1,2,3));     // 6
        System.out.println(am.calculate(2.0,3.0,4.0));// 24.0
    }
}
