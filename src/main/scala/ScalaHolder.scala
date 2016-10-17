import scala.beans.BeanProperty

/**
 * Data holder compatible with Java.
 *
 * @author Jonatan Kazmierczak
 */
case class ScalaHolder(@BeanProperty name: String, @BeanProperty surname: String = "Skywalker", @BeanProperty var age: Int = -1)
