import org.junit.Test

import static org.junit.Assert.assertEquals


/**
 * Demonstration of some features of Groovy: mathematical expressions, string interpolation, usage of data holder.
 *
 * @author Jonatan Kazmierczak
 */
class GroovyFeaturesTest {
    @Test
    public void calculate() {
        def x = 11111111111111111.15
        assertEquals(BigDecimal.class, x.class)
        def result = -1 + x * 2
        assertEquals(22222222222222221.30, result)
    }

    @Test
    public void interpolate1() {
        def m = ['a': 1, 'b': 2]
        def result = "a is ${m['a']}\nb is ${m["b"]}"
        assertEquals('a is 1\nb is 2', result.toString())
    }

    @Test
    public void interpolate2() {
        def m = ['a': 1, 'b': 2]
        def result = """\
a is $m.a
b is $m.b
"""
        assertEquals('a is 1\nb is 2\n', result.toString())
    }

    @Test
    public void useHolder1() {
        def gh = new GroovyHolder(name: 'Luke', age: 39)
        println(gh);
        assertEquals('Luke', gh.name);
        assertEquals('Skywalker', gh.surname);
        assertEquals(39, gh.age);
        gh.name = 'Lea'
        println(gh);
        assertEquals('Lea', gh.name);
    }

    @Test
    public void useHolder2() {
        def gh = new GroovyHolder(name: 'Lea')
        println(gh);
        assertEquals('Lea', gh.name);
        assertEquals('Skywalker', gh.surname);
        gh.age = 39
        println(gh);
        assertEquals(39, gh.age);
    }

}
