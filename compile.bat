@echo off

echo Compiling florencia.augmentedmatrix subpackage...
javac ./florencia/augmentedmatrix/*.java
echo Compiling florencia.matrix subpackage...
javac ./florencia/matrix/*.java
echo Compiling Menu.java...
javac Menu.java

echo --- Menu.java start ---

java Menu