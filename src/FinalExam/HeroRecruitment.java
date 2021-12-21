package FinalExam;

import java.util.*;

public class HeroRecruitment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, List<String>> heroesMap = new TreeMap<>();

        while (!input.equals("End")){
            String[] inputArr = input.split(" ");

            String command = inputArr[0];
            String heroName = inputArr[1];

            switch (command){
                case "Enroll":
                    if (!heroesMap.containsKey(heroName)){
                        heroesMap.put(heroName, new ArrayList<>());
                    }else {
                        System.out.printf("%s is already enrolled.%n", heroName);
                    }
                    break;
                case "Learn":
                    String spellName = inputArr[2];
                    if (!heroesMap.containsKey(heroName)){
                        System.out.printf("%s doesn't exist.%n", heroName);
                    }else {
                        if (heroesMap.get(heroName).contains(spellName)){
                            System.out.printf("%s has already learnt %s.%n", heroName, spellName);
                        }else {
                            heroesMap.get(heroName).add(spellName);
                        }
                    }
                    break;
                case "Unlearn":
                    String spell2 = inputArr[2];

                    if (!heroesMap.containsKey(heroName)){
                        System.out.printf("%s doesn't exist.%n", heroName);
                    }else {
                        if (!heroesMap.get(heroName).contains(spell2)){
                            System.out.printf("%s doesn't know %s.%n", heroName, spell2);
                        }else {
                            heroesMap.get(heroName).remove(spell2);
                        }
                    }
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.println("Heroes:");

        heroesMap.entrySet().stream().sorted((e1, e2) -> {
            int result = e2.getValue().size() - e1.getValue().size();
            return result;
        }).forEach(entry -> {
            System.out.printf("== %s: ", entry.getKey());
            System.out.print(String.join(", ", entry.getValue()));
            System.out.println();
        });
    }
}
