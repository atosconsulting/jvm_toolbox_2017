/*
 * ES6 code with Nashorn extension - Java object.
 *
 * @author Jonatan Kazmierczak
 */
Java.to( JSON.parse( countriesJson ).map( country => country.name ), 'java.lang.String[]' )
