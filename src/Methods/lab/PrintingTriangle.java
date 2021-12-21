package Methods.lab;

import java.util.Scanner;

public class PrintingTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <= num ; i++) {
            Triangles(1, i);
            
        }
        for (int j = num - 1; j >= 1 ; j--) {
            Triangles(1, j);

        }
        

    }
    public static void Triangles(int start, int end){
        for (int i = start; i <= end ; i++) {
            System.out.print(i + " ");

        }
        System.out.println();
    }
}
