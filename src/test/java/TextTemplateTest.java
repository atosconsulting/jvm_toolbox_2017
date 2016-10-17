import groovy.util.Eval;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;
import static org.junit.Assert.assertEquals;


/**
 * Demonstration of dynamic processing of a text template in JS and Groovy.
 *
 * @author Jonatan Kazmierczak
 */
public class TextTemplateTest {
    private static final String TEMPLATE = "a is ${m.a}\nb is ${m.b}";
    private static final String EXPECTED_RESULT = "a is 1\nb is 2";

    private static ScriptEngine jse;

    @BeforeClass
    public static void init() {
        jse = TestHelper.createJsEngine();
    }

    @Test
    public void jsProcess() throws ScriptException {
        Bindings bindings = TestHelper.createBindings("m", createValuesMap());
        String result = (String) jse.eval("`" + TEMPLATE + "`", bindings);
        out.println(result);
        assertEquals(EXPECTED_RESULT, result);
    }

    @Test
    public void groovyProcess() throws ScriptException {
        // Binding map as m, expression calculation, converting result GString to String
        String result = Eval.me("m", createValuesMap(), "\"\"\"" + TEMPLATE + "\"\"\"").toString();
        out.println(result);
        assertEquals(EXPECTED_RESULT, result);
    }

    private static Map<String, Integer> createValuesMap() {
        HashMap<String, Integer> m = new HashMap<>();
        m.put("a", 1);
        m.put("b", 2);
        return m;
    }
}
