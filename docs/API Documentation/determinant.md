# Determinant Class Documentation
This is the documentation for the `Determinant.class` that is available under the package `florencia.matrix`.

## Determinant()
`Determinant()` is an object created specifically for determinant related algorithms.
Components:
1. `Matrix m` - the Matrix object itslef with its components.

<!-- ## Determinant(Matrix M)
The `Determinant(Matrix M)` object is the fundamental object that supports this program; this object made all the algorithms created here possible with ease.

### Usage example:
```java
// Inside main
Matrix m = new Matrix();
m.makeMatrix(3, 5); // Initializes an array with size 3x5 
```-->

## determinantRowReduction()
determinantRowReduction is a function that returns the determinant of a matrix using Row Reduction method. It applies the use of the elementary row operations.

Time complexity : O(n^2)

### Usage example:
```java
// Inside main
Matrix m = new Matrix();
m.makeMatrix(3, 5); // Initializes an array with size 3x5
double det = m.determinantRowReduction(); // det = the determinant of matrix m
```

## determinantSarrus()
determinantSarrus() is a function that returns the determinant of a matrix using Sarrus method. This function only valid for matrix with size of 3x3. If the matrix is not valid, it will return value -99999.

Time complexity : O(1)

### Usage example:
```java
// Inside main
Matrix m = new Matrix();
m.makeMatrix(3, 5); // Initializes an array with size 3x5
double det = m.determinantSarrus(); // det = the determinant of matrix m
```

## determinantLaplaceExpansion()
determinantLaplaceExpansion() is a function that returns the determinant of a matrix using Laplace Expansion method, or as better known the cofactor expansion. 

Time complexity : O(n!)

### Usage example:
```java
// Inside main
Matrix m = new Matrix();
m.makeMatrix(3, 5); // Initializes an array with size 3x5
double det = m.determinantLaplaceExpansion(); // det = the determinant of matrix m
```

## getminorEntry(int i, int j)
getminorEntry(int i, int j) is a function that returns a new Matrix object that has its row `i` and column `j` removed. 

### Usage example:
```java
// Inside main
Preview matrix M
M.getminorEntry(i ,j);
Show the reduced form
```

## getCofactor(int i, int j)
getCofactor(int i, int j) is a function that returns the cofactor of a Matrix for row `i` and column `j` (in other words, it returns the minor entry with the sign).

### Usage example:
```java
// Inside main
Matrix m = new Matrix();
double val = m.getCofactor(i, j); // val is the cofactor from row i and column j from matrix m.
```

## getMatrixCofactor()
getMatrixCofactor() is a function that returns cofactor matrix form of Matrix m.

### Usage example:
```java
// Inside main
Matrix m = new Matrix();
Matrix mCofactor = m.getMatrixCofactor(); // returm cofactor matrix
```

## getAdjoint()
getAdjoint() is a function that returns adjoint matrix form of Matrix m. Adjoint matrix is a transposed cofactor matrix.

### Usage example:
```java
// Inside main
Matrix m = new Matrix();
Matrix mAdjoint = m.getAdjoint(); // return adjoint of the matrix
```