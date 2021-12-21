package MapsLambdaandStreamAPI.exercise;

import java.util.*;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, List<Double> > productMap = new LinkedHashMap<>();
        Map<String, Double> resultMap = new LinkedHashMap<>();

        while (!input.equals("buy")){
            String [] inputArr = input.split(" ");
            String product = inputArr[0];
            double price = Double.parseDouble(inputArr[1]);
            double quantity = Double.parseDouble(inputArr[2]);

            if (!productMap.containsKey(product)){
                productMap.put(product, new ArrayList<>());
                productMap.get(product).add(price);
                productMap.get(product).add(quantity);
            }else {
                //int index = productMap.get(product).indexOf(price);
                double OldQuantity = productMap.get(product).get(1);
                productMap.get(product).set(0, price);
                productMap.get(product).set(1, OldQuantity + quantity);

            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<Double>> entry: productMap.entrySet()) {
            double currentQuantity = entry.getValue().get(0);
            double currentPrice = entry.getValue().get(1);
            double result = currentPrice * currentQuantity;

            resultMap.put(entry.getKey(), result);

        }

        resultMap.entrySet().forEach(entry -> System.out.printf("%s -> %.2f%n", entry.getKey(), entry.getValue()));

    }
}
