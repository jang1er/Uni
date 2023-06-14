package de.uulm.sp.oop.ExpressionParser.Expression;

import de.uulm.sp.oop.ExpressionParser.Excpetions.NotAnArithmeticExpressionException;
import de.uulm.sp.oop.ExpressionParser.Excpetions.NotAnOperatorException;

public class ArithmeticExpression extends Expression{
	private NumberExpression left;
	private Operator operator;
	private Expression right;

	private ArithmeticExpression(NumberExpression left, Operator operator, Expression right) {
		this.left = left;
		this.right = right;
		this.operator = operator;
	}

	public static ArithmeticExpression parse(String stringToParse) throws NotAnArithmeticExpressionException {
		NumberExpression left = null;
		Operator operator = null;
		Expression right = null;

		//TODO

		return new ArithmeticExpression(left, operator, right);
	}

	private static Operator parseOperator(String stringToParse) throws NotAnOperatorException {
		// TODO
		return null;
	}
	
	@Override
	public String toString() {
		return "ArithmeticExpression [left=" + left + ", operator=" + operator + ", right=" + right + "]";
	}
}
