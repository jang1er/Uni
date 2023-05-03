import java.util.InputMismatchException;
import java.util.Scanner;

public class Loops {

    //Blackbox
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = readIntFromConsole();

        //TODO: a)

        //TODO: b)
        //i)

        //ii)

        //iii)


        //TODO: c)
        
    }

    /**
     * #BLACKBOX
     * Blackbox-Methode zum Einlesen aus der Konsole. Bei einer fehlerhaften Eingabe wird zu einer
     * erneuten Eingabe aufgefordet,
     *
     * @return Bei korrekter Eingabe, die Eingabe als int
     */
    public static int readIntFromConsole() {

        System.out.print("Please input a natural number: ");
        try {
            int n = scanner.nextInt();

            if (n < 1) {
                System.out.println("[Error] Input is not a natural number!");
                return readIntFromConsole();
            } else {
                return n;
            }
        } catch (InputMismatchException ime) {
            System.out.println("[Error] Input is not a number!");
            scanner.next();
        }

        return readIntFromConsole();
    }
}