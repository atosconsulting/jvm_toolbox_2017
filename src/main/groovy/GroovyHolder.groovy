/**
 * Data holder.
 *
 * @author Jonatan Kazmierczak
 */
class GroovyHolder {
    String name
    String surname = 'Skywalker'
    Integer age = -1

    String toString() { "GroovyHolder(name=$name, surname=$surname, age=$age)" }
}
