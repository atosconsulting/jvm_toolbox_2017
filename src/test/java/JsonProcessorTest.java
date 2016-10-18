import org.junit.BeforeClass;
import org.junit.Test;

import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Map;

import static java.lang.System.out;
import static org.junit.Assert.assertEquals;


/**
 * Demonstration of JSON processing in JS.
 *
 * @see GroovyJsonProcessorTest
 *
 * @author Jonatan Kazmierczak
 */
public class JsonProcessorTest {
    private static ScriptEngine jse;

    @BeforeClass
    public static void init() {
        jse = TestHelper.createJsEngine();
    }

    @Test
    public void convertJsonObjectToJavaMap() throws ScriptException {
        // sample JSON (after replacing single quotes with double quotes)
        String objectJson = "{ 'a': 1, 'b': 2, 'c': {'n': 'name'} }"
                .replace('\'', '"');
        String jsCode = "JSON.parse( objectJson )";
        Map result = (Map) jse.eval(jsCode, TestHelper.createBindings("objectJson", objectJson));

        assertEquals(1, result.get("a"));
        assertEquals(2, result.get("b"));
        assertEquals( "name", ((Map) result.get("c")).get("n") );
    }

    @Test
    public void convertJsonObjectListToJavaStringArray() throws IOException, ScriptException {
        String countriesJson = new BufferedReader(
                new InputStreamReader(getClass().getResourceAsStream("countries.json"), StandardCharsets.UTF_8)
        ).readLine();
        out.println("JSON size (B): " + countriesJson.length());

        Reader jsCodeReader = new InputStreamReader(
                getClass().getResourceAsStream("countries_processor.js"), StandardCharsets.UTF_8);

        String[] results = (String[])
                jse.eval(jsCodeReader, TestHelper.createBindings("countriesJson", countriesJson));

        out.println( Arrays.toString(results) );
        assertEquals(247, results.length);
        assertEquals( "Afghanistan", results[0] );
        assertEquals( "Zimbabwe", results[ results.length - 1 ] );
    }
}
