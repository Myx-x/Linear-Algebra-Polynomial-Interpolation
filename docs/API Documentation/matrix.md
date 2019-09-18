# Matrix Class Documentation
This is the documentation for the `Matrix.class` that is available under the package `florencia.matrix`.

## Matrix()
The `Matrix()` object is the fundamental object that supports this program; this object made all the algorithms created here possible with ease.

## makeMatrix(int dimRow, int dimCol)
makeMatrix works as a constructor for the Matrix object, and it takes two parameters, `dimRow` and `dimCol`. This procedure sets the Matrix object so that it is initialized with size of `dimRow` x `dimCol`.

### Usage example:
```java
// Inside main
Matrix m = new Matrix();
m.makeMatrix(3, 5); // Initializes an array with size 3x5
```

## getRowCount()
getRowCount works as a selector to get Matrix's object `rowCount` variable.

### Usage example:
```java
// Inside main
Matrix m = new Matrix();
m.makeMatrix(3, 5); // Initializes an array with size 3x5
int r = m.getRowCount(); // r = 3
```

## getColCount()
getColCount works as a selector to get Matrix's object `colCount` variable.

### Usage example:
```java
// Inside main
Matrix m = new Matrix();
m.makeMatrix(3, 5); // Initializes an array with size 3x5
int c = m.getColCount(); // c = 5
```

## setCell(int row, int col, int value)
setCell works as a setter to set Matrix's object `arr[row][col]` to be assigned a value of `value`.

### Usage example:
```java
// Inside main
Matrix m = new Matrix();
m.makeMatrix(3, 5); // Initializes an array with size 3x5
m.setCell(0, 1, 99) // m.arr[0][1] = 99
```

## inputMatrix()
inputMatrix is a default procedure provided to input something into a Matrix object. This procecure will prompt the user to input row and column amount. This procedure makes use of the `makeMatrix()` procedure. In other words, there's **no need** in using `makeMatrix()` procedure before using this procedure.

### Usage example:
```java
// Inside main
Matrix m = new Matrix();

// Instead of
m.makeMatrix(3,5);

// ..when you're having user input, use:
m.inputMatrix() // Input 3 & 5 when prompted.

```

## printMatrix()
printMatrix is a procedure that will output a Matrix object. The object will be printed in a grid style way, with tabs separating each number. The dimension will always be `rowCount` x `colCount` when printing.

### Usage example:
```java
// Inside main
Matrix m = new Matrix();

// After Matrix is initialized...

m.printMatrix() // Will output the contents of the Matrix object.
```

