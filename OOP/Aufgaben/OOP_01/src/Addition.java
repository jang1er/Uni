import java.util.InputMismatchException;
import java.util.Scanner;

public class Addition {

    //Blackbox
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Deklarierung der Variable als int
        int myInteger;

        //Initialisierung der Variable
        myInteger = readIntFromConsole();

        // zweite Variable
        int myOtherInteger = readIntFromConsole();

        int mySum = myInteger + myOtherInteger;

        System.out.println("Eingabe1: " + myInteger);
        System.out.println(" Eingabe2: " + myOtherInteger);
        System.out.println(" Summe: " + mySum);
    }

    /**
     * Blackbox-Methode zum Einlesen aus der Konsole. Bei einer fehlerhaften Eingabe wird zu einer
     * erneuten Eingabe aufgefordet,
     *
     * @return Bei korrekter Eingabe, die Eingabe als int
     */
    public static int readIntFromConsole() {

        System.out.print("Please insert an integer: ");
        try {
            return scanner.nextInt();
        } catch (InputMismatchException ime) {
            System.out.println("[Error] Input is not a whole number!");
            scanner.next();
        }

        return readIntFromConsole();
    }
}
