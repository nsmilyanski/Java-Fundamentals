package ExamPreparation;

import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        StringBuilder sb = new StringBuilder(input);

        String distination = scanner.nextLine();

        while (!distination.equals("Travel")){
            String [] distinationArr = distination.split(":");
            String command = distinationArr[0];

            switch (command){
                case "Add Stop":
                    int index = Integer.parseInt(distinationArr[1]);
                    String addText = distinationArr[2];
                    if (index >= 0 && index <= sb.length() - 1){
                        sb.insert(index, addText);
                    }
                    System.out.println(sb);
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(distinationArr[1]);
                    int endIndex = Integer.parseInt(distinationArr[2]);
                    if (ifIsIndexValid(startIndex, endIndex, sb.length())){
                        sb.delete(startIndex, endIndex + 1 );
                    }
                    System.out.println(sb);
                    break;
                case "Switch":
                    String oldText = distinationArr[1];
                    String newText = distinationArr[2];

                        int indexToRemove = sb.indexOf(oldText);
                        int lastIndex = indexToRemove + oldText.length();
                        if (sb.toString().contains(oldText)) {
                            sb.delete(indexToRemove, lastIndex);
                            sb.insert(indexToRemove, newText);
                        }
                    System.out.println(sb);
                    break;
            }



            distination = scanner.nextLine();
        }
        System.out.printf("Ready for world tour! Planned stops: %s", sb);
    }

    private static boolean ifHasText(String oldText, StringBuilder sb) {
        char a = oldText.charAt(0);
        char b = oldText.charAt(oldText.length() - 1);

        int startIndex = 0;
        int lastIndex = oldText.length();
        if (sb.substring(startIndex, lastIndex).equals(oldText)){
            return true;
        }else {
            return false;
        }
    }

    private static boolean ifIsIndexValid(int startIndex, int endIndex, int length) {
        return startIndex >= 0 && startIndex < endIndex && endIndex <= length - 1;
    }
}
