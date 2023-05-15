package sheet03;

import java.util.ArrayList;
import java.util.List;

public class ArrayMixed{

	public static void main(String[] args) {
		//TODO: Testen!
		//Beispiel:
		System.out.println("[Test join]");
		System.out.printf("\"%s\" (erwartet: \"%s\")%n%n", join(";", new String[]{"A", "B", "Horst"}), "A;B;Horst");
		System.out.println(join("-", split(";", "A;B;C;Horst")));
		String[] array = new String[]{"Abc","Ef","c"};
		sortByLength(array);
		for (String s : array){
			System.out.println(s);
		}

	}

	public static String join(String delim, String[] array){
		//TODO: a)
		String result = "";
		boolean first = true;
		for( String s : array){
			if(first){
				result += s;
				first = false;
			}else{
				result += delim + s;
			}

		}
		return result;
	}

	public static String[] split(String delim, String str){
		//TODO: b)
		ArrayList<String> result = new ArrayList<String>();
		String temp = "";
		for (int i = 0; i < str.length(); i++){
			String s = str.substring(i, i+1);
			if(s.equals(delim)){
				result.add(temp);
				temp = "";
			}else {
				temp += s;
			}
		}
		result.add(temp);
		String[] StringArray = result.toArray(new String[0]);
		return StringArray;
	}

	public static void sortByLength(String[] array){
		//TODO: c)

		// bubble sort
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - (i+1); j++) {
				if (array[j].length() > array[j + 1].length()) {
					String temp = array[j + 1];
					array[j + 1] = array[j];
					array[j] = temp;
				}
			}
		}
	}

	public static void sortByOcc(char c, String[] array){
		//TODO: d)

	}

	public static String joinReverse(String c, String str){
		//TODO: e)
		return null;
	}

}