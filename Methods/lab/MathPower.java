package Methods.lab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num = Double.parseDouble(scanner.nextLine());
        double raised = Double.parseDouble(scanner.nextLine());

        double output = MathPower(num, raised);
        DecimalFormat df = new DecimalFormat("0.####");

        System.out.println(df.format(output));




    }
    public static double MathPower (double num, double raised){
        double output = 1;
        for (int i = 1; i <= raised ; i++) {
            output *=  num ;

        }
        return output;
    }
}
