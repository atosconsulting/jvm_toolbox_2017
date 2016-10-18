import org.junit.Test;

import static java.lang.System.out;
import static org.junit.Assert.assertEquals;


/**
 * Demonstration of usage of a Groovy data holder in Java.
 *
 * @author Jonatan Kazmierczak
 */
public class HolderTest {
    @Test
    public void useGroovyHolder() {
        GroovyHolder gh = new GroovyHolder();
        out.println(gh);
        assertEquals("Skywalker", gh.getSurname());
        gh.setName("Leia");
        out.println(gh);
        assertEquals("Leia", gh.getName());
    }
}
