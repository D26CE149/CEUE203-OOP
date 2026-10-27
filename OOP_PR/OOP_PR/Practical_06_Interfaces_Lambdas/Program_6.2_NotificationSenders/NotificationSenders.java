import java.util.Scanner;

@FunctionalInterface
interface Notifier {
    void send(String message);
}

interface Urgent { }

class UrgentEmailSender implements Notifier, Urgent {
    public void send(String message) {
        System.out.println("[EMAIL-URGENT] " + message);
    }
}

public class NotificationSenders {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the message to broadcast: ");
        String message = sc.nextLine();

        Notifier emailSender = (msg) -> System.out.println("[EMAIL] " + msg);
        Notifier smsSender   = (msg) -> System.out.println("[SMS]   " + msg);
        Notifier urgentEmail = new UrgentEmailSender();

        Notifier[] senders = { emailSender, smsSender, urgentEmail };

        System.out.println("\n Broadcasting");
        for (Notifier n : senders) {
            n.send(message);
            if (n instanceof Urgent) {
                n.send(message);
            }
        }

        sc.close();
    }
}
