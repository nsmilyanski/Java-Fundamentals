package testing;

import java.util.Scanner;

public class WinningTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] ticketsArr = scanner.nextLine().split("\\s*,\\s* ");


        for (String ticket : ticketsArr) {
        char leftSymbol = ' ';
        char rightSymbol = ' ';
        boolean isValidLength = false;
        int countWinSymbolsFirst = 0;
        int countWinSymbolsSecond = 0;
            if (ticket.length() == 20){
                isValidLength = true;
                for (int i = 0; i < 10; i++) {
                    char symolFirstHalf = ticket.charAt(i);
                   if (ifFirstHalfIsValid(symolFirstHalf)){
                       countWinSymbolsFirst++;
                       if (countWinSymbolsFirst > 1 && symolFirstHalf != leftSymbol){
                           System.out.printf("ticket \"%s\" - no match%n", ticket);
                           continue;
                       }
                       leftSymbol = symolFirstHalf;
                   }
                }

                for (int i = 10; i < ticket.length(); i++) {
                    char symbolSecondHalf = ticket.charAt(i);
                    if (ifFirstHalfIsValid(symbolSecondHalf)){
                        countWinSymbolsSecond++;
                        if (countWinSymbolsSecond > 1 && symbolSecondHalf != rightSymbol){
                            System.out.printf("ticket \"%s\" - no match%n", ticket);
                            continue;
                        }
                        rightSymbol = symbolSecondHalf;
                    }
                }
            }else {
                isValidLength = false;
            }

            if (!isValidLength){
                System.out.println("invalid ticket");
            }else if (countWinSymbolsFirst < 6){
                System.out.printf("ticket \"%s\" - no match%n", ticket);
            } else if ((countWinSymbolsFirst == countWinSymbolsSecond) && countWinSymbolsFirst == 10
                    && leftSymbol == rightSymbol) {
                System.out.printf("ticket \"%s\" - %d%c Jackpot!%n", ticket, countWinSymbolsFirst, leftSymbol);
            }else if ((countWinSymbolsFirst == countWinSymbolsSecond) && countWinSymbolsFirst >= 6 &&
            leftSymbol == rightSymbol){
                System.out.printf("ticket \"%s\" - %d%c%n", ticket, countWinSymbolsFirst, leftSymbol);
            }

        }
    }

    private static boolean ifFirstHalfIsValid(char symolFirstHalf) {

        return symolFirstHalf == '@' || symolFirstHalf == '#' || symolFirstHalf == '$' || symolFirstHalf == '^';
    }
}
