import java.util.Scanner;

enum Coin {
    ONE, TWO, FIVE, TEN
}

public class VendingMachine {
    static void main() {
        final int price = 15;
        int total = 0;
        Scanner sc = new Scanner(System.in);

        while (total < price) {
            try {
                System.out.print("Enter coin (ONE/TWO/FIVE/TEN): ");
                String input = sc.next().toUpperCase();
                Coin coin = Coin.valueOf(input);

                int value = switch (coin) {
                    case ONE -> 1;
                    case TWO -> 2;
                    case FIVE -> 5;
                    case TEN -> 10;
                };

                total = total + value;
                System.out.println("Total so far: " + total);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid coin. Please enter ONE, TWO, FIVE, or TEN.");
            }
        }

        int change = total - price;
        System.out.println("Paid. Change: " + change);

        sc.close();
    }
}
