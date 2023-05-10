public class KW19 {
    public static void main(String args[]){
        System.out.println(startsOrEndsWithSpace("hello world"));
    }

    public static boolean startsOrEndsWithSpace(final String s){
        // why
        int n = s.length();
        return s.substring(0,1).equals(" ") || s.substring(n-1, n).equals(" ");
    }

    
}
