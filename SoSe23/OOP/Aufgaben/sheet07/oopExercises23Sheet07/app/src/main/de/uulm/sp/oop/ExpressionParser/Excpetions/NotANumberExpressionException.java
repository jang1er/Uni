package de.uulm.sp.oop.ExpressionParser.Excpetions;

public class NotANumberExpressionException extends Exception {

	public NotANumberExpressionException(String stringToParse) {
		super("The String" + stringToParse + " is not parsable to an arithmetic expression");
	}
}
