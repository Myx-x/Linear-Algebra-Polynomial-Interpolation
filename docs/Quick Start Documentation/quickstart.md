# A Quick Start Guide.
This is a quick guide on how to use this program. Some information here was already showed in `readme.md` in the root of this repository.

## Prerequisites
1. Java Runtime Environment (JRE), if your intent is to only run the program that we compiled.
2. Java Development Kit (JDK), if your intent is to dig into the source code and wish to compile this program yourself.
3. Any text editor
4. Basic knowledge on using the command line.

## Compiling and Running This Program.
### Using batch file
1. Run `compile.bat` once, it will run the program after you made any changes in the program
2. If you only didn't make any change/made changes only in Menu.java/Main.java, we suggest you to only run the `run.bat` file.

### Manually compile using `javac` and running using `java`
1. Type in into command line : `javac ./florencia/augmentedmatrix/*.java`.
2. Also type in into command line : `javac ./florencia/matrix/*.java`.
3. Type in into command line to compile then run the program : `javac Menu.java` and `java Menu`.

## Common Problems
* Can't run the program - open the terminal in the root directory.
* Java class program version too high - check your JDK and JRE installation again, especially the version of JDK and JRE your installing.
* `javac` or `java` not found in terminal - add the path to JDK and JRE bin to your environment variables.