public class Loops {
    public static int IndexOf(int ele, int[] array){
        for (int i = 0; i < array.length; i++) {
            if (array[i] == ele) return i;
        }
        return -1;
    }

    public static void main( String[] args){
        int n = 13;
        int[] array = {1,5,12,77,100};
        System.out.println(n + " is located at index " + IndexOf(n, array));
    }
}
