package MapsLambdaandStreamAPI.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> wordCraftMap = new TreeMap<>();
        wordCraftMap.put("motes", 0);
        wordCraftMap.put("fragments", 0);
        wordCraftMap.put("shards", 0);
        Map<String, Integer> junkMap = new TreeMap<>();

        boolean isDone = false;

        while (!isDone){
        String [] inputArr = scanner.nextLine().split(" ");

            for (int i = 0; i < inputArr.length; i+= 2) {
                int keyValue = Integer.parseInt(inputArr[i]);
                String key = inputArr[i + 1].toLowerCase();

                if (key.equals("motes") || key.equals("fragments") || key.equals("shards")) {

                        wordCraftMap.put(key, wordCraftMap.get(key) + keyValue);

                    if (wordCraftMap.containsKey("motes") && wordCraftMap.get("motes") >= 250){
                        wordCraftMap.put(key, wordCraftMap.get(key) - 250);
                        System.out.println("Dragonwrath obtained!");
                        isDone = true;
                        break;
                    }else if (wordCraftMap.containsKey("fragments") && wordCraftMap.get("fragments") >= 250){
                        int fragValue = wordCraftMap.get(key) - 250;
                        wordCraftMap.put(key, fragValue);
                        System.out.println("Valanyr obtained!");
                        isDone = true;
                        break;
                    }else if (wordCraftMap.containsKey("shards") && wordCraftMap.get("shards") >= 250){
                        wordCraftMap.put(key, wordCraftMap.get(key) - 250);
                        System.out.println("Shadowmourne obtained!");
                        isDone = true;
                        break;
                    }


                }else {
                    if (!junkMap.containsKey(key)){
                        junkMap.put(key, keyValue);
                    }else {
                        junkMap.put(key, junkMap.get(key) + keyValue);
                    }
                }
                if(isDone){
                    break;
                }

            }
                if(isDone){
                    break;
                }


        }
        wordCraftMap.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())).
                forEach(element -> System.out.printf("%s: %d%n", element.getKey(), element.getValue()));
        junkMap.entrySet().forEach(element -> System.out.printf("%s: %d%n", element.getKey(), element.getValue()));


    }
}
