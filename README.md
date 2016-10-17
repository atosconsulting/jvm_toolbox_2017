# JVM Toolbox 2017 - Demo
The demo shows how to blend the following JVM languages into
one application:
* Java 9
* ~~Scala 2.12~~ (currently crashes on JRE 9)
* Groovy 2.4
* JavaScript 
  - standard ECMAScript 2015 (ES6)
  - executed by Nashorn engine (included in JRE 9)

Various use cases are demonstrated by unit tests.
Please look into each test file for more information.

The unit tests are supposed to be run with Gradle 3.x on JDK 9 with
the following command:
```bash
gradle test
```

**Note**: Unfortunately, Gradle 3.1 still crashes on JDK 9 during downloading
dependencies. As a workaround it should be initially started on JDK 8
to download dependencies and then on JDK 9 to compile and execute tests -
for example:
```bash
export JAVA_HOME=path_to_JDK8
gradle test
export JAVA_HOME=path_to_JDK9
gradle test
```
