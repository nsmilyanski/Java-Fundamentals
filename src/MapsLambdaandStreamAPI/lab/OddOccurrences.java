package MapsLambdaandStreamAPI.lab;

import java.util.*;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");

        LinkedHashMap<String, Integer> countsMap = new LinkedHashMap<>();

        for (int i = 0; i < words.length ; i++) {
            String key = words[i].toLowerCase();
            if (!countsMap.containsKey(key)){
                countsMap.put(key, 1);
            }else {
                countsMap.put(key, countsMap.get(key) + 1);
            }
        }
        List<String> odd = new ArrayList<>();

        for ( Map.Entry<String, Integer> entry: countsMap.entrySet()) {
            int count = entry.getValue();
            if (count % 2 != 0){
                odd.add(entry.getKey());
            }

        }
        System.out.println(String.join(", ", odd));
    }
}
