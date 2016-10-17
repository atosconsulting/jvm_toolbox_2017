import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.SimpleBindings;
import java.util.HashMap;
import java.util.Map;


/**
 * Helper class used by tests.
 *
 * @author Jonatan Kazmierczak
 */
class TestHelper {
    static ScriptEngine createJsEngine() {
        // Switch on ES6
        System.setProperty("nashorn.args", "--language=es6");
        return new ScriptEngineManager().getEngineByExtension("js");
        // Alternative form of initialization
        //return new jdk.nashorn.api.scripting.NashornScriptEngineFactory().getScriptEngine( new String[]{"--language=es6"} );
    }

    static Bindings createBindings(String key, Object value) {
        return new SimpleBindings( new HashMap<>( Map.of(key, value) ) );
    }
}
