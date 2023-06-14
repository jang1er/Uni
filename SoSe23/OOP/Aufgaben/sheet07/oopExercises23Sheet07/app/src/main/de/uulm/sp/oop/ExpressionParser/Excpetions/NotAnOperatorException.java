package de.uulm.sp.oop.ExpressionParser.Excpetions;

public class NotAnOperatorException extends Exception {

	public NotAnOperatorException(String stringToParse) {
		super("The String \"" + stringToParse + "\" is not a parsable operator");
	}
}
