import groovy.util.Eval;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.math.BigDecimal;

import static java.lang.System.out;
import static org.junit.Assert.assertEquals;


/**
 * Demonstration of dynamic calculation of a mathematical expression in JS and Groovy.
 *
 * @author Jonatan Kazmierczak
 */
public class MathExpressionTest {
    private static final String MATH_EXPR = "-1 + x * 2";

    private static ScriptEngine jse;

    @BeforeClass
    public static void init() {
        jse = TestHelper.createJsEngine();
    }

    @Test
    public void jsCalculate() throws ScriptException {
        Bindings bindings = TestHelper.createBindings("x", 2);
        Double result = (Double) jse.eval(MATH_EXPR, bindings);
        out.printf("x = %d, %s = %.1f%n", bindings.get("x"), MATH_EXPR, result);
        assertEquals( Double.valueOf(3.0), result );
    }

    @Test
    public void groovyCalculate() {
        BigDecimal x = new BigDecimal("11111111111111111.15");
        // Binding local x as x, expression calculation, converting result GString -> String
        String result = Eval.x(x, "\"${" + MATH_EXPR + "}\"").toString();
        out.printf("x = %.2f, %s = %s%n", x, MATH_EXPR, result);
        assertEquals( new BigDecimal("22222222222222221.30"), new BigDecimal(result) );
    }
}
