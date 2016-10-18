import groovy.json.JsonSlurper
import org.junit.Before
import org.junit.Test

import java.nio.charset.StandardCharsets

import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertTrue


/**
 * Demonstration of JSON processing in Groovy.
 *
 * @see JsonProcessorTest
 *
 * @author Jonatan Kazmierczak
 */
class GroovyJsonProcessorTest {
    private JsonSlurper jsonSlurper;

    @Before
    void init() {
        jsonSlurper = new JsonSlurper()
    }

    @Test
    void convertJsonObjectToJavaMap() {
        def objectJson = '{ "a": 1, "b": 2, "c": {"n": "name"} }'
        def result = jsonSlurper.parseText objectJson

        assertTrue result instanceof Map
        assertEquals 1, result['a']
        assertEquals 2, result.b
        assertEquals "name", result.c.n
    }

    @Test
    void convertJsonObjectListToJavaStringList() {
        def results = jsonSlurper.parse(
                        getClass().getResourceAsStream("countries.json"), StandardCharsets.UTF_8.toString()
                ).collect {country -> country.name}

        println results
        assertTrue results instanceof List
        assertEquals 247, results.size()
        assertEquals "Afghanistan", results[0]
        assertEquals "Zimbabwe", results[-1]
        assertEquals( ['Zambia', 'Vietnam'], results[-2, -6] )
        assertEquals( ['Australia', 'Austria', 'Azerbaijan'], results[12..14] )
    }
}
