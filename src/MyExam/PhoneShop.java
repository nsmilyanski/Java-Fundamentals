package MyExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PhoneShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> phoneList = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("End")){
            List<String> commandList = Arrays.stream(input.split(" - ")).collect(Collectors.toList());
            String command = commandList.get(0);
            switch (command){
                case "Add":
                    String addPhone = commandList.get(1);
                    if (!phoneList.contains(addPhone)){
                        phoneList.add(addPhone);
                    }
                    break;
                case "Remove":
                    String removePhone = commandList.get(1);
                    if (phoneList.contains(removePhone)){
                        phoneList.remove(removePhone);
                    }
                    break;
                case "Bonus phone":
                   String [] bonusArr = commandList.get(1).split(":");
                   String firstPhone = bonusArr[0];
                   String oldPhone = bonusArr[1];
                   if (phoneList.contains(firstPhone)){
                       int index = phoneList.indexOf(firstPhone);
                       phoneList.add(index + 1, oldPhone);
                   }
                    break;
                case "Last":
                    String lastPhone = commandList.get(1);
                    if (phoneList.contains(lastPhone)){
                        phoneList.remove(lastPhone);
                        phoneList.add(lastPhone);
                    }
                    break;
            }


            input = scanner.nextLine();
        }
        System.out.println(phoneList.toString().replaceAll("[\\[\\]]", ""));

    }
}
