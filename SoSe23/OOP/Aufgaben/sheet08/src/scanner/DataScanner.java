package scanner;

import java.io.*;
import java.util.Scanner;

public class DataScanner {

    public static void main (String[] args){
        long start = System.currentTimeMillis();
        System.out.println(sumWithScanner());
        long end = System.currentTimeMillis();
        System.out.println(("\nRuntime with Scanner :" + (end - start) + " ms"));

        start = System.currentTimeMillis();
        System.out.println(sumWithBuffer());
        end = System.currentTimeMillis();
        System.out.println(("\nRuntime with Buffer :" + (end - start) + " ms"));

    }

    public static long sumWithScanner(){
        long sum = 0;
        Scanner read = null;
        try {
            read = new Scanner(new FileInputStream("bigInput.txt"));
        } catch (FileNotFoundException e){}
        while(read.hasNext()){
            sum += read.nextInt();
        }
        return sum;
    }

    public static long sumWithBuffer(){
        long sum = 0;
        BufferedReader read = null;
        try {
            File file = new File("bigInput.txt");
            FileReader reader = new FileReader(file);
            read = new BufferedReader(reader);

            String line;
            while((line = read.readLine()) != null){
                sum += Integer.parseInt(line);
            }
        } catch (Exception e){}

        return sum;
    }
}
