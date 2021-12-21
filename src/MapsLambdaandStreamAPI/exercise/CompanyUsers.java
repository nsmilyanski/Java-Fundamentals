package MapsLambdaandStreamAPI.exercise;

import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, List<String>> idKeeper = new LinkedHashMap<>();

        while (!input.equals("End")){
            String [] inputArr = input.split(" -> ");
            String companyName = inputArr[0];
            String id = inputArr[1];

            if (!idKeeper.containsKey(companyName)){
                idKeeper.put(companyName, new ArrayList<>());
                idKeeper.get(companyName).add(id);
            }else {
                if (!idKeeper.get(companyName).contains(id)){
                    idKeeper.get(companyName).add(id);
                }
            }


            input = scanner.nextLine();
        }
        idKeeper.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .forEach(entry ->{
                    System.out.println(entry.getKey());
                    entry.getValue().forEach(ids -> System.out.printf("-- %s%n", ids));
                });
    }
}
