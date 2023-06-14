package de.uulm.sp.oop.ExpressionParser.Excpetions;

public class NotAnArithmeticExpressionException extends Exception {

	public NotAnArithmeticExpressionException(String stringToParse) {
		super("The String \"" + stringToParse + "\" is not parsable to an arithmetic expression");
	}
}
