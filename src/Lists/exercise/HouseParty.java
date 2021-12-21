package Lists.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<String> namesList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<String> guests = Arrays.stream(scanner.nextLine().
                    split(" ")).collect(Collectors.toList());
            String name = guests.get(0);
            if (guests.size() == 3){
               if (namesList.isEmpty() || !namesList.contains(name)){
                   namesList.add(name);
               }else {
                   System.out.printf("%s is already in the list!%n", name);
               }

            }else if (guests.size() == 4){
                if (namesList.contains(name)){
                    namesList.remove(name);
                }else {
                    System.out.printf("%s is not in the list!%n", name);
                }

            }

        }
        for (int i = 0; i < namesList.size() ; i++) {
            System.out.println(namesList.get(i));
        }
        }
    }
