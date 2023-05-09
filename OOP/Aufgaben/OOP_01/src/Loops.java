import java.util.InputMismatchException;
import java.util.Scanner;

public class Loops {

    //Blackbox
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = readIntFromConsole();

        //TODO: a)
        for(int i = 1; i <= n; i++){
            System.out.print(i + " ");
        }
        // make line break
        System.out.println();

        //TODO: b)
        //i)
        int i = 1;
        while(i <= n){
            if(i % 2 == 0)System.out.print(i + " ");
            i++;
        }
        // make line break
        System.out.println();

        //ii)
        int j = 1;
        while(j <= n){
            System.out.print(j*j + " ");
            j++;
        }
        System.out.println();

        //iii)
        int k = n;
        while(k >= -n){
            System.out.print(k + " ");
            k--;
        }
        System.out.println();

        //TODO: c)
        int m = 1;
        while(m <= n){
            if(m % 2 == 0){
                System.out.print("+ ");
            }else {
                System.out.print("* ");
            }
            m++;
        }
        System.out.println();
        
    }

    /**0
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