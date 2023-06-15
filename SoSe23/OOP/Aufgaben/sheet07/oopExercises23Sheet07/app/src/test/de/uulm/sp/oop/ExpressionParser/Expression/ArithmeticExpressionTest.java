package de.uulm.sp.oop.ExpressionParser.Expression;

import de.uulm.sp.oop.ExpressionParser.Excpetions.NotAnArithmeticExpressionException;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class ArithmeticExpressionTest {

    @Test
    public void testArithmeticExpression1() throws Exception {
        try {
            Field right = ArithmeticExpression.class.getDeclaredField("right");
            right.setAccessible(true);
            Field operator = ArithmeticExpression.class.getDeclaredField("operator");
            operator.setAccessible(true);
            var exp = ArithmeticExpression.parse("3 + 3");
            Assert.assertTrue(right.get(exp) instanceof NumberExpression);
            Assert.assertTrue(operator.get(exp) == Operator.PLUS);
        } catch (NotAnArithmeticExpressionException e) {
            Assert.fail();
        }
    }

    @Test
    public void testArithmeticExpression2() throws Exception {
        try {
            Field right = ArithmeticExpression.class.getDeclaredField("right");
            right.setAccessible(true);
            Field operator = ArithmeticExpression.class.getDeclaredField("operator");
            operator.setAccessible(true);
            var exp = ArithmeticExpression.parse("3 - 3 * 4");
            Assert.assertTrue(right.get(exp) instanceof ArithmeticExpression);
            Assert.assertTrue(operator.get(exp) == Operator.MINUS);
        } catch (NotAnArithmeticExpressionException e) {
            Assert.fail();
        }
    }
}