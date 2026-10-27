import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of cards: ");
        int totalCards = scanner.nextInt();
        scanner.nextLine();

        Card[] cards = new Card[totalCards];
        int count = 0;

        for (int i = 0; i < totalCards; i++) {
            System.out.print("Enter rank for card " + (i + 1) + ": ");
            String rank = scanner.nextLine();

            System.out.print("Enter suit for card " + (i + 1) + ": ");
            String suit = scanner.nextLine();

            Card newCard = new Card(rank, suit);
            boolean duplicate = false;

            for (int j = 0; j < count; j++) {
                if (newCard.equals(cards[j])) {
                    duplicate = true;
                    break;
                }
            }

            if (duplicate) {
                System.out.println("Duplicate found: " + newCard);
                break;
            } else {
                cards[count] = newCard;
                count++;
            }
        }
    }
}
