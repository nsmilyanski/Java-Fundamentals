package MidExam;

import java.math.BigDecimal;
import java.util.Scanner;

public class GuineaPig {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double foodKg = Double.parseDouble(scanner.nextLine());
        double hayKg = Double.parseDouble(scanner.nextLine());
        double coverKg = Double.parseDouble(scanner.nextLine());
        double pigKg = Double.parseDouble(scanner.nextLine());
        boolean goToPetStore = false;

        for (int i = 1; i <= 30 ; i++) {
            foodKg -= 0.300;
            if (i % 2 == 0){
                hayKg -= foodKg * 0.05;
            }
            if (i % 3 == 0){
                coverKg -= pigKg/3;
            }
            if (Math.ceil(foodKg) <= 0 ||Math.ceil(hayKg) <= 0 || Math.ceil(coverKg) <= 0){
                goToPetStore = true;
                break;
            }

        }
        if (goToPetStore){
            System.out.printf("Merry must go to the pet store!");
        }else {
            System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.", foodKg
            , hayKg, coverKg);
        }


    }
}
