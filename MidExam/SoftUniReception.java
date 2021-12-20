package MidExam;

import java.util.Scanner;

public class SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstEmployee = Integer.parseInt(scanner.nextLine());
        int secondEmployee = Integer.parseInt(scanner.nextLine());
        int thirdEmployee = Integer.parseInt(scanner.nextLine());

        int studentsCount = Integer.parseInt(scanner.nextLine());

        int studentsPerHour = firstEmployee + secondEmployee + thirdEmployee;

        int countHours = 0;

        while (studentsCount > 0){
            countHours++;
            studentsCount -= studentsPerHour;
            if (countHours % 4 == 0){
                countHours++;
            }

        }
        System.out.printf("Time needed: %dh.", countHours);
    }
}
