package main.java.de.uulm.sp.oop.exercises.e05;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Main {

	/*

	Aufgabe 2:
	a)
		Listen lassen sich über Collections.sort( List<T> l) (Natural Ordering von Comparable) oder mit
		Collections.sort(List<T> l, Comparator<T> comp) (eigene definierte Ordnung) sortieren.
		Eine Collection enthält keine eigene sort-Methode, da sie keine definierte Ordnung besitzt.


	 */
	public static void main(String[] args) {
		// Implement Task 2
		ArrayList<Pair<Integer, String>> list = new ArrayList<>();
		list.add(new Pair<>(4, "hallo"));
		list.add(new Pair<>(2, "dasistwirklichsehrtoll"));
		list.add(new Pair<>(23, "lol"));
		list.add(new Pair<>(11, "lool"));
		list.add(new Pair<>(99, "neunundneunzigluftballons"));
		list.add(new Pair<>(98, "kaputt_:("));
		list.add(new Pair<>(99, "lol"));
		list.add(new Pair<>(23, "lol"));

		Collections.sort(list);
		System.out.println(list.toString());


		// Implement Task 3
		HashSet<Pair<Integer,String>> set = new HashSet<>();
		for (Pair<Integer,String> x : list ){
			if(!set.add(x))System.out.println(x.toString() + " is a duplicate");
		}
		
		// Implement Task 4
		LocalDate now = LocalDate.now();
		LocalDate fourweeksprior = now.minusWeeks(4);
		LocalDate onemonthprior = now.minusMonths(1);
		System.out.println("\nAufgabe 3");
		System.out.println(now + " : " + now.getDayOfWeek());
		System.out.println(fourweeksprior + " : " + fourweeksprior.getDayOfWeek());
		System.out.println(onemonthprior + " : " + onemonthprior.getDayOfWeek());


		char[][] sokoban = new char[7][];
		sokoban[0] = "#######".toCharArray();
		sokoban[1] = "#.....#".toCharArray();
		sokoban[2] = "#..$..#".toCharArray();
		sokoban[3] = "#.$@$.#".toCharArray();
		sokoban[4] = "#..$..#".toCharArray();
		sokoban[5] = "#.....#".toCharArray();
		sokoban[6] = "#######".toCharArray();

		Sokoban game = new Sokoban();
		System.out.println(game.sokobanToString(sokoban));
		game.moveNorth(sokoban);
		game.moveEast(sokoban);
		game.moveSouth(sokoban);
		System.out.println(game.sokobanToString(sokoban));


	}

}
