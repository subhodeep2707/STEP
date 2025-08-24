import java.util.Scanner;

public class BMIProgram {
    public static String getStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 25) return "Normal";
        else if (bmi < 30) return "Overweight";
        else return "Obese";
    }

    public static String[][] calculateBMI(double[][] data) {
        String[][] result = new String[data.length][4];
        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double heightM = data[i][1] / 100; // cm → m
            double bmi = weight / (heightM * heightM);
            result[i][0] = String.format("%.1f", heightM * 100);
            result[i][1] = String.format("%.1f", weight);
            result[i][2] = String.format("%.2f", bmi);
            result[i][3] = getStatus(bmi);
        }
        return result;
    }

    public static void display(String[][] result) {
        System.out.println("Height(cm)\tWeight(kg)\tBMI\tStatus");
        for (String[] row : result) {
            System.out.println(row[0] + "\t\t" + row[1] + "\t\t" + row[2] + "\t" + row[3]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] data = new double[10][2];
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight(kg) of person " + (i+1) + ": ");
            data[i][0] = sc.nextDouble();
            System.out.print("Enter height(cm) of person " + (i+1) + ": ");
            data[i][1] = sc.nextDouble();
        }
        String[][] result = calculateBMI(data);
        display(result);
        sc.close();
    }
}
