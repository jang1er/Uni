package de.uulm.sp.oop.ExpressionParser.Expression;

import de.uulm.sp.oop.ExpressionParser.Excpetions.NotANumberExpressionException;
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

		if(stringToParse == null)throw new NotAnArithmeticExpressionException(null);

		// split at spaces
		String[] toParse = stringToParse.split(" ");
		String restExpression = "";
		for (int i = 2; i < toParse.length; i++){
			restExpression += toParse[i] + " ";
		}
		restExpression.trim();


		try {
			left = NumberExpression.parse(toParse[0]);
			operator = parseOperator((toParse[1]));
		} catch (Exception e){
			throw new NotAnArithmeticExpressionException(stringToParse);
		}

		try{
			right = NumberExpression.parse(restExpression);
		}catch (NotANumberExpressionException why){
			right = ArithmeticExpression.parse(restExpression);
		}


		return new ArithmeticExpression(left, operator, right);
	}

	private static Operator parseOperator(String stringToParse) throws NotAnOperatorException {
		switch (stringToParse){
			case "+":
				return Operator.PLUS;
			case "-":
				return Operator.MINUS;
			case "*":
				return Operator.MUL;
			case "/":
				return Operator.DIV;
			default:
				throw new NotAnOperatorException(stringToParse);
		}
	}
	
	@Override
	public String toString() {
		return "ArithmeticExpression [left=" + left + ", operator=" + operator + ", right=" + right + "]";
	}
}
