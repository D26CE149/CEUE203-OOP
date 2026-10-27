public class CinemaShow {
    private String title;
    private int seatsAvailable;
    private final int capacity;
    private static int totalBooked = 0;

    public CinemaShow(String title, int capacity) {
        this.title = title;
        this.capacity = capacity;
        seatsAvailable = capacity;
    }

    public CinemaShow(String title) {
        this(title, 100);
    }

    public boolean book(int n) {
        if (n <= seatsAvailable) {
            seatsAvailable = seatsAvailable - n;
            totalBooked = totalBooked + n;
            return true;
        }
        return false;
    }

    public void cancel(int n) {
        seatsAvailable = seatsAvailable + n;

        if (seatsAvailable > capacity) {
            seatsAvailable = capacity;
        }
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public static int getTotalBooked() {
        return totalBooked;
    }

    public static void main(String[] args) {
        CinemaShow show = new CinemaShow("Java Movie", 50);

        System.out.println("Show: " + show.title);

        boolean result1 = show.book(20);
        System.out.println("Book 20: " + result1);
        System.out.println("Seats left: " + show.getSeatsAvailable());

        boolean result2 = show.book(40);
        System.out.println("Book 40: " + result2);
        System.out.println("Seats left: " + show.getSeatsAvailable());

        show.cancel(10);
        System.out.println("After cancel 10");
        System.out.println("Seats left: " + show.getSeatsAvailable());

        boolean result3 = show.book(15);
        System.out.println("Book 15: " + result3);
        System.out.println("Seats left: " + show.getSeatsAvailable());

        System.out.println("Total booked: " + CinemaShow.getTotalBooked());
    }
}
