import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of points: ");
        int n = input.nextInt();

        Point[] points = new Point[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter x coordinate for point " + (i + 1) + ": ");
            int x = input.nextInt();

            System.out.print("Enter y coordinate for point " + (i + 1) + ": ");
            int y = input.nextInt();

            points[i] = new Point(x, y);
        }

        int distinctCount = 0;

        for (int i = 0; i < points.length; i++) {
            boolean alreadyFound = false;

            for (int j = 0; j < i; j++) {
                if (points[i].equals(points[j])) {
                    alreadyFound = true;
                    break;
                }
            }

            if (!alreadyFound) {
                distinctCount++;
            }
        }

        System.out.println("Distinct: " + distinctCount);
    }
}
