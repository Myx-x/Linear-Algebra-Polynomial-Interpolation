# Matrix Class Documentation
This is the documentation for the `Matrix.class` that is available under the package `florencia.matrix`.

## Matrix()
The `Matrix()` object is the fundamental object that supports this program; this object made all the algorithms created here possible with ease.

Here listed the constructors for the Matrix object:
### Matrix()
Initialize an empty array.

### Matrix(int rc, int cc)
Initialize a Matrix of dimension `rc` x `c`.

### Matrix(Matrix M)
Initialize a Matrix with properties linked to `Matrix M` (shallow copy).
---
# Methods
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

## printInverseSPL()
printInverseSPL is a procedure that will output a Matrix object which is the right matrix of an Augmented Matrix.

### Usage example:
```java
// Inside main
Matrix m = new Matrix();

// After Matrix is initialized...

m.printInverseSPL() // Will output the contents of the Matrix object.
```

## isSquare()
isSquare is a function that returns boolean. It will yield a value of `true` when the matrix is square; and `false` otherwise.

### Usage example:
```java
// Inside main
Matrix m = new Matrix();

// After Matrix is initialized...

if(m.isSquare())  // if matrix is square..
{
    // do something
}
```

## rowSwap(int row1, int row2)
rowSwap is a procedure that swaps two rows in a Matrix, which are `row1` and `row2`. It is used in the AugmentedMatrix Object row swap as well. 

*Note that we use zero based indexing in this program.*


### Usage example:
```java
// Inside main
Matrix m = new Matrix();

// After Matrix is initialized...

m.rowSwap(0,2); // Swaps the first row and the second row.
```

## colSwap(int col1, int col2)
colSwap is a procedure that swaps two columns in a Matrix, which are `col1` and `col2`. It is used in the AugmentedMatrix Object col swap as well. 

*Note that we use zero based indexing in this program.*


### Usage example:
```java
// Inside main
Matrix m = new Matrix();

// After Matrix is initialized...

m.colSwap(0,2); // Swaps the first col and the second col.
```

## rowArithmetic(int reducedRow, int reducingRow, double multiplier)
rowArithmetic is a procedure that does an arithmetic procedure on the `reducedRow`, it modifies that row with `multiplier`*`reducingRow`'s value.

*Note that we use zero based indexing in this program.*


### Usage example:
```java
// Inside main
Matrix m = new Matrix();

// After Matrix is initialized...

m.rowArithmetic(0,2,0.5); // Add's up the value of the first row with the third row times 0.5
```
## rowMultiplier(int multipliedRow, double multiplier)
rowMultiplier is a procedure that multiplies the value of the `multipliedRow` with `multiplier`.

*Note that we use zero based indexing in this program.*


### Usage example:
```java
// Inside main
Matrix m = new Matrix();

// After Matrix is initialized...

m.rowMultiplier(0,0.5); // Multiplies the first row with 0.5
```

## normBackwardElimination()
normBackwardElimination is similar to AugmentedMatrix's backwardElimination, but it doesn't reduce it into echelon matrix form. It converts the array into lower triangle matrix in order to be used in the Determinant class.


### Usage example:
```java
// Inside main
Matrix m = new Matrix();

// After Matrix is initialized...

m.normBackwardElimination(); // Does a reduction into lower triangular matrix
```
## fixSignedZero()
fixSignedZero is a procedure that fixed a rounding error relating to signed zero. 

### Usage example:
```java
// Inside main
Matrix m = new Matrix();

// After Matrix is initialized...
/* ---------
Let the matrix be:
1   0   0
-0  1   -0
-0 -0   1
Which may result in a printing error.
-------- */

m.fixedSignedZero(); // Changes the -0 into 0
```

## fixSignedZero()
fixSignedZero is a procedure that fixed a rounding error relating to signed zero. 

### Usage example:
```java
// Inside main
Matrix m = new Matrix();

// After Matrix is initialized...
/* ---------
Let the matrix be:
1   0   0
-0  1   -0
-0 -0   1
Which may result in a printing error.
-------- */

m.fixedSignedZero(); // Changes the -0 into 0
```

## transpose()
tranpose is a function that returns a Matrix object which will be transposed from the matrix.

### Usage example:
```java
// Inside main
Matrix m = new Matrix();

// After Matrix is initialized...
/* ---------
1   2   3
4   5   6
7   8   9
-------- */

Matrix mt = m.transpose(); // Transposes a matrix
/* ---------
1   4   7
2   5   8
3   6   9
-------- */
```

## setIdentityMatrix(int n)
setIdentityMatrix is a procedure that makes an empty square matrix into an identity matrix.

### Usage example:
```java
// Inside main
Matrix m = new Matrix();

m.setIdentityMatrix(3); // Transposes a matrix
/* ---------
1   0   0
0   1   0
0   0   1
-------- */
```
## setIdentityMatrix(int n)
setIdentityMatrix is a procedure that makes an empty square matrix into an identity matrix.

### Usage example:
```java
// Inside main
Matrix m = new Matrix();

m.setIdentityMatrix(3); // Sets m into an identity matrix
/* ---------
1   0   0
0   1   0
0   0   1
-------- */
```

## kaliKons(double X)
kaliKons is a function that returns matrix that all of the elements will be multiplied by `X`.

### Usage example:
```java
// Inside main
Matrix m = new Matrix();

// After matrix is initialized...

Matrix m2 = m.kaliKons(3); // m2 will be equal to Matrix m but the elements are multiplied 3
```
## kaliMatriks(Matrix A, Matrix B)
kaliMatriks is a function to multiply matrix A with matrix B.

### Usage example:
```java
// Inside main
Matrix m = new Matrix();

// After matrix is initialized...

m = m.kaliMatriks(A,B);
```

## isRowZero(int row)
isRowZero is a function that checks whether a Matrix's row is all zero. The `row`-th row will be checked.

### Usage example:
```java
// Inside main
Matrix m = new Matrix();

// After matrix is initialized...

if(m.isRowZero(3)) // if the fourth row is all zero...
{
    //Do something
}
```

## textToMatrix()
textToMatrix is a function to scan a file and input the object as a matrix.

### Usage example:
```java
// Inside main
Matrix m = new Matrix();
// After matrix is initialized...
m.textToMatrix();
```

## deepCopy()
deepCopy is a function to copy a Matrix.

### Usage example:
```java
// Inside main
Matrix m = new Matrix();
// After matrix is initialized...
m.deepCopy(Min);
// Min is a matrix that already have elemen in it
```

## printInverseSPLToText()
printInverseSPLToText is a procedure that will output a Matrix object which is the right matrix of an Augmented Matrix to a file.

### Usage example:
```java
// Inside main
Matrix m = new Matrix();

// After Matrix is initialized...

m.printInverseSPLToText() // Will output the contents of the Matrix object.
```


