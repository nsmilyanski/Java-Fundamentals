package testing;

import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder(scanner.nextLine());

        String input = scanner.nextLine();

        while (!input.equals("Reveal")){
            String[] commArr = input.split(":\\|:");
            String command = commArr[0];

            switch (command){
                case "InsertSpace":
                    int index = Integer.parseInt(commArr[1]);
                    sb.insert(index, " ");
                    System.out.println(sb);
                    break;
                case "Reverse":
                    String substring = commArr[1];
                    if (sb.toString().contains(substring)) {
                        int strartIndex = sb.indexOf(substring);
                        int lastIndex = strartIndex + substring.length() ;
                        sb = sb.delete(strartIndex, lastIndex);
                        sb.append(new StringBuilder(substring).reverse());
                        System.out.println(sb);

                    }else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    String subS = commArr[1];
                    String replacemant = commArr[2];
                    sb =  new StringBuilder(sb.toString().replaceAll(subS, replacemant));
                    System.out.println(sb);
                    break;
            }


            input = scanner.nextLine();
        }
        System.out.printf("You have a new text message: %s", sb);
    }
}
