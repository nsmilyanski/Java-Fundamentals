package BasicSyntax.exercise;

import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double georgsMomey = Double.parseDouble(scanner.nextLine());
        int studentsNum = Integer.parseInt(scanner.nextLine());
        double priceSabre = Double.parseDouble(scanner.nextLine());
        double priceRobes = Double.parseDouble(scanner.nextLine());
        double priceBelts = Double.parseDouble(scanner.nextLine());

        double priceAllSabre = priceSabre * Math.ceil(studentsNum * 0.1 + studentsNum);
        double priceAllrobes = priceRobes * studentsNum;
        double priceAllBelts = (studentsNum - studentsNum / 6) * priceBelts;

        double sumAll = priceAllSabre + priceAllrobes + priceAllBelts;

        if (georgsMomey >= sumAll){
            System.out.printf("The money is enough - it would cost %.2flv.", sumAll);
        }else {
            System.out.printf("George Lucas will need %.2flv more.", sumAll - georgsMomey);
        }


    }
}
