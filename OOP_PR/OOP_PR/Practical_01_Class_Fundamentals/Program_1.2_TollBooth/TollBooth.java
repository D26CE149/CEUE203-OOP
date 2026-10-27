import java.util.Scanner;

record Vehicle(String number, String type) {
}

public class TollBooth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int totalToll = 0;
        int bikeCount = 0;
        int carCount = 0;
        int truckCount = 0;

        while (true) {
            System.out.print("Enter vehicle number or done: ");
            String number = sc.next();

            if (number.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Enter type (bike/car/truck): ");
            String type = sc.next().toLowerCase();

            Vehicle vehicle = new Vehicle(number, type);

            int toll = switch (vehicle.type()) {
                case "bike" -> 20;
                case "car" -> 50;
                case "truck" -> 150;
                default -> 0;
            };

            if (toll == 0) {
                System.out.println("Invalid vehicle type");
                continue;
            }

            totalToll = totalToll + toll;

            if (vehicle.type().equals("bike")) {
                bikeCount++;
            } else if (vehicle.type().equals("car")) {
                carCount++;
            } else {
                truckCount++;
            }
        }

        String mostFrequent = "bike";
        int highest = bikeCount;

        if (bikeCount == 0 && carCount == 0 && truckCount == 0) {
            System.out.println("Vehicle Entry :- 0");
            sc.close();
            return;
        }

        if (bikeCount > highest) {
            highest = bikeCount;
            mostFrequent = "bike";
        }

        if (carCount > highest) {
            highest = carCount;
            mostFrequent = "car";
        }

        if (truckCount > highest) {
            mostFrequent = "truck";
        }

        System.out.println("Total toll: " + totalToll);
        System.out.println("Most frequent: " + mostFrequent);

        sc.close();
    }
}
