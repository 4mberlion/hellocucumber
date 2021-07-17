## Generate jvm report
```shell
clean install
```
It generates an report generated from a cucumber.json file. The json file is generated while running the tests in IDE.git ini

## JShell

1. mvn install
2. mvn jshell:run
3. /env --class-path [path of jar in target dir]
4. import com.amberlion.*
5. Jtest a = new Jtest();
6. a.printTest()  //outputs Success!!!

for more help type /help in jshell mode