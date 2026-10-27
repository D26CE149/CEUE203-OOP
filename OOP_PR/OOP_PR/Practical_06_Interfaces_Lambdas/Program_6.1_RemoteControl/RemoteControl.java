import java.util.Scanner;

interface Switchable {
    void on();
    void off();

    default void toggle() {
        on();
        off();
    }
}

class Fan implements Switchable {
    public void on()  { System.out.println("Fan : ON"); }
    public void off() { System.out.println("Fan : OFF"); }
}

class Light implements Switchable {
    public void on()  { System.out.println("Light: ON"); }
    public void off() { System.out.println("Light: OFF"); }
}

@FunctionalInterface
interface SwitchPolicy {
    boolean maySwitch(Switchable device, int hour);
}

public class RemoteControl {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Switchable[] devices = { new Fan(), new Light() };

        System.out.println("=== Toggling all devices ===");
        for (Switchable s : devices) {
            s.toggle();
        }

        System.out.print("\nEnter the hour (6-22): ");
        int hour = sc.nextInt();

        System.out.print("Choose device (1 = Fan, 2 = Light): ");
        int choice = sc.nextInt();

        Switchable chosen;
        if (choice == 1) {
            chosen = devices[0];
        } else {
            chosen = devices[1];
        }

        SwitchPolicy policyAnon = new SwitchPolicy() {
            public boolean maySwitch(Switchable device, int h) {
                return h >= 6 && h <= 22;
            }
        };

        SwitchPolicy policyLambda = (device, h) -> h >= 6 && h <= 22;

        System.out.println("\n=== Policy check (anonymous class) ===");
        if (policyAnon.maySwitch(chosen, hour)) {
            System.out.println(chosen.getClass().getSimpleName()
                    + " is ALLOWED to switch on at hour " + hour);
            chosen.on();
        } else {
            System.out.println(chosen.getClass().getSimpleName()
                    + " is DENIED at hour " + hour);
        }

        System.out.println("\n=== Policy check (lambda) ===");
        if (policyLambda.maySwitch(chosen, hour)) {
            System.out.println(chosen.getClass().getSimpleName()
                    + " is ALLOWED to switch on at hour " + hour);
            chosen.on();
        } else {
            System.out.println(chosen.getClass().getSimpleName()
                    + " is DENIED at hour " + hour);
        }

        sc.close();
    }
}
