package de.uulm.sp.oop.ExpressionParser;

import de.uulm.sp.oop.ExpressionParser.Expression.ArithmeticExpression;

public class App {
	public static void main(String[] args) {
		String str = "0 + 1 - 3";

		try {
			var arExp = ArithmeticExpression.parse(str);
			System.out.println(arExp);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
