@echo off

echo Compiling florencia.augmentedmatrix subpackage...
javac ./florencia/augmentedmatrix/*.java
echo Compiling florencia.matrix subpackage...
javac ./florencia/matrix/*.java
echo Compiling Main.java...
javac Main.java

echo --- Main.java start ---

java Main in