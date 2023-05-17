package sheet03;

import java.util.ArrayList;
import java.util.List;

public class ArrayMixed{

	public static void main(String[] args) {
		//: Testen!
		//Beispiel:
		System.out.println("[Test join]");
		System.out.printf("\"%s\" (erwartet: \"%s\")%n%n", join(";", new String[]{"A", "B", "Horst"}), "A;B;Horst");
		System.out.println(join("-", split(";", "A;B;C;Horst")));

		String[] array = new String[]{"AAAbc","AEf","cAAAA","aa","A"};
		//sortByLength(array);
		for (String s : array){
			System.out.println(s);
		}
		System.out.println();
		sortByOcc('A', array);
		for (String s : array){
			System.out.println(s);
		}

		System.out.println(joinReverse(" ", "Das Wetter ist heute sehr schön."));

	}

	public static String join(String delim, String[] array){
		//: a)
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
		//: b)
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
		return result.toArray(new String[0]);

	}

	public static void sortByLength(String[] array){
		//: c)

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
		// ich weiß nicht warum ich das so machen will
		ArrayList<Integer> OccList = new ArrayList<Integer>();
		ArrayList<String> list = new ArrayList<String>(List.of(array));
		for (String str : array){
			int n = 0;
			for (int i = 0; i < str.length(); i++){
				if(c == str.charAt(i)) {
					n++;
				}
			}
			OccList.add(n);
		}
		int index = 0;
		while(index < array.length){
			int[] max = new int[]{0,0};
			for( int i = 0; i < OccList.size(); i++) {
				if(max[0] < OccList.get(i)){
					max[0] = OccList.get(i); max[1] = i;
				}
			}
			array[index] = list.get(max[1]);
			list.remove(max[1]);
			OccList.remove(max[1]);
			index++;
		}
	}

	public static String joinReverse(String c, String str){
		String[] array = split(c, str);
		String[] reversed = new String[array.length];
		for(int i = 0; i < array.length; i++){
			reversed[i] = array[array.length -i -1];
		}
		return join(c, reversed);
	}

}