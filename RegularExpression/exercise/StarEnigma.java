package RegularExpression.exercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String regex = "@(?<planet>[A-Za-z]+)([^@!:>-])*:(?<population>[0-9]+)([^@!:>-])*!(?<attack>[AD])!([^@!:>-])*->([^@!:>-])*(?<soldierCount>[0-9]+)";
        Pattern pattern = Pattern.compile(regex);
        List<String> attackedPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int counter = 0;
        String encryptedMessage = scanner.nextLine();
        String workMessage = encryptedMessage.toLowerCase();
            for (int j = 0; j < workMessage.length(); j++) {
                char symbol = workMessage.charAt(j);
                if (symbol == 's' || symbol == 't' || symbol == 'r' || symbol == 'a'){
                    counter++;
                }
            }

            for (int k = 0; k < encryptedMessage.length(); k++) {
                char current = encryptedMessage.charAt(k);
                char decryptChar = (char) (current - counter);
                sb.append(decryptChar);
            }
            String decryptedMessage = sb.toString();
            Matcher matcher = pattern.matcher(decryptedMessage);
            if (matcher.find()){
                String planetName = matcher.group("planet");
                int population = Integer.parseInt(matcher.group("population"));
                char attack = matcher.group("attack").charAt(0);
                int soldierCount  = Integer.parseInt(matcher.group("soldierCount"));

                if (attack == 'A'){
                    attackedPlanets.add(planetName);
                }else if (attack == 'D'){
                    destroyedPlanets.add(planetName);
                }
            }

        }
        System.out.printf("Attacked planets: %d%n", attackedPlanets.size());
        Collections.sort(attackedPlanets);
        attackedPlanets.forEach(planets -> System.out.printf("-> %s%n", planets));
        System.out.printf("Destroyed planets: %d%n", destroyedPlanets.size());
        Collections.sort(destroyedPlanets);
        destroyedPlanets.forEach(planets -> System.out.printf("-> %s%n", planets));

    }
}
