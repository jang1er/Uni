import java.util.InputMismatchException;
import java.util.Scanner;

public class LoopsNested {

    //Blackbox
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = readIntFromConsole();

        //TODO: a)
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();

        //TODO: b)
        for(int x = 0; x < n; x++){
            for (int y = 0; y <= x; y++){
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();

        //TODO: c)
        for (int a = 1; a <= n; a++){
            for (int b = 1; b <= n; b++){
                if(a == 1 || a == n || b == 1 || b == n){
                    System.out.print("* ");
                }else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println();

        //TODO: d)
        for (int o = 1; o <= n; o++){
            for (int p = 1; p <= n; p++){
                if(o == 1 || o == n || p == 1 || p == n|| p > (n/2)+1){
                    System.out.print("* ");
                }else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println();
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