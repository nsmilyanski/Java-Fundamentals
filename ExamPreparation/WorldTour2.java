package ExamPreparation;

import java.util.Scanner;

public class WorldTour2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String travelStops = scanner.nextLine();

        String distination = scanner.nextLine();

        while (!distination.equals("Travel")){
            String [] distinationArr = distination.split(":");
            String command = distinationArr[0];

            switch (command){
                case "Add Stop":
                    int index = Integer.parseInt(distinationArr[1]);
                    String addText = distinationArr[2];
                    if (index >= 0 && index < travelStops.length()){
                        String firstPart = travelStops.substring(0, index);
                        String secondPart = travelStops.substring(index);
                        travelStops = firstPart + addText + secondPart;

                    }
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(distinationArr[1]);
                    int endIndex = Integer.parseInt(distinationArr[2]);
                    if (ifIsIndexValid(startIndex, endIndex, travelStops.length())){
                        String firstPiece = travelStops.substring(0, startIndex);
                        String secondPiece = travelStops.substring(endIndex + 1);
                        travelStops = firstPiece + secondPiece;

                    }

                    break;
                case "Switch":
                    String oldText = distinationArr[1];
                    String newText = distinationArr[2];

                    if (travelStops.contains(oldText)) {
                       travelStops = travelStops.replace(oldText, newText);
                    }

                    break;
            }

            System.out.println(travelStops);
            distination = scanner.nextLine();
    }
        System.out.printf("Ready for world tour! Planned stops: %s", travelStops);
}

    private static boolean ifIsIndexValid(int startIndex, int endIndex, int length) {

        return startIndex >= 0 &&  endIndex < length;
    }
    }
