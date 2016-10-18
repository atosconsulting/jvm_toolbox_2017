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

## Test cases execution
### Prerequisites
Successful tests executioin requires the following tools:
* JDK 9
* _JDK 8_ (required as long as Gradle crashes on JDK 9)
* Gradle 3.1+

### Execution
The unit tests are supposed to be run with Gradle 3.1+ on JDK 9 with
the following command:
```bash
gradle test
```


Unfortunately, Gradle 3.1 crashes on JDK 9 during downloading
dependencies. As a workaround it should be initially started on JDK 8
to download dependencies and then on JDK 9 to compile and execute tests.

On Unix systems demo can be successfully executed with the following commands:
```bash
export JAVA_HOME=path_to_JDK8
gradle test
export JAVA_HOME=path_to_JDK9
gradle test
```
