package ExamPreparation;

import java.util.*;

public class HeroesofCodeandLogicVII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());;

        Map<String, List<Integer>> heroMap = new TreeMap<>();

        for (int i = 0; i < n ; i++) {
            String[] inputArr = scanner.nextLine().split("\\s+");
            String name = inputArr[0];
            int hitPoints = Integer.parseInt(inputArr[1]);
            int manaPoints = Integer.parseInt(inputArr[2]);
            heroMap.putIfAbsent(name, new ArrayList<>());
            heroMap.get(name).add(hitPoints);
            heroMap.get(name).add(manaPoints);
        }
        String game = scanner.nextLine();
        //heroMap = [Key, List(HP, MP)];

        while (!game.equals("End")){
            String [] gameArr = game.split(" - ");
            String command = gameArr[0];
            String heroName = gameArr[1];
            switch (command){
                case "CastSpell":
                    int mpNeeded = Integer.parseInt(gameArr[2]);
                    String spellName = gameArr[3];
                    if (heroMap.get(heroName).get(1) >= mpNeeded){
                        int mpLeft = heroMap.get(heroName).get(1) - mpNeeded;
                        heroMap.get(heroName).set(1,mpLeft);
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n", heroName,
                                spellName, mpLeft);
                    }else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
                    }

                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(gameArr[2]);
                    String attacker = gameArr[3];
                    int reducedHp = heroMap.get(heroName).get(0) - damage;
                    if (reducedHp > 0){
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", heroName,
                                damage, attacker, reducedHp);
                        heroMap.get(heroName).set(0, reducedHp);
                    }else {
                        System.out.printf("%s has been killed by %s!%n", heroName, attacker);
                        heroMap.remove(heroName);
                    }
                    break;
                case "Recharge":
                    int amount = Integer.parseInt(gameArr[2]);
                    int increasedMp = heroMap.get(heroName).get(1)+ amount;
                    if (increasedMp > 200){
                        increasedMp = 200;
                        amount = 200 - heroMap.get(heroName).get(1);
                    }
                    System.out.printf("%s recharged for %d MP!%n", heroName, amount);
                    heroMap.get(heroName).set(1, increasedMp);
                    break;
                case "Heal":
                    int healAmount = Integer.parseInt(gameArr[2]);
                    int increasedHp = heroMap.get(heroName).get(0) + healAmount;
                    if (increasedHp > 100){
                        increasedHp = 100;
                        healAmount = 100 - heroMap.get(heroName).get(0);
                    }
                    heroMap.get(heroName).set(0, increasedHp);
                    System.out.printf("%s healed for %d HP!%n", heroName, healAmount);
                    break;
            }
            game = scanner.nextLine();
        }
        heroMap.entrySet().stream().sorted((e1, e2) -> e2.getValue().get(0).compareTo(e1.getValue().get(0)))
                .forEach(entry -> {
                    System.out.println(entry.getKey());
                    System.out.printf("  HP: %d%n", entry.getValue().get(0));
                    System.out.printf("  MP: %d%n", entry.getValue().get(1));

                });
    }
}
