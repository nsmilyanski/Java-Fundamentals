package testing;

import java.util.*;

public class Judge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Integer> nameMap = new LinkedHashMap<>();
        Map<String, List<String>> pointMap = new LinkedHashMap<>();
        Map<String, String> dataMap = new LinkedHashMap<>();

        List<String> competitionList = new ArrayList<>();

        while (!input.equals("no more time")){
            String[] commandArr = input.split(" -> ");
            String name = commandArr[0];
            String contest = commandArr[1];
            int points = Integer.parseInt( commandArr[2]);

            nameMap.putIfAbsent(name, 0);
            nameMap.put(name, nameMap.get(name) + points);






            if (!pointMap.containsKey(name)) {
                pointMap.put(contest, new ArrayList<>());
                pointMap.get(contest).add(name);
                pointMap.get(contest).add(points + "");
            }else {

            }


            input = scanner.nextLine();
        }
    }
}
