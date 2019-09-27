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
Determinant det = new Determinant(M); //Initializes Determinant det with Matrix M 
double hasil = det.determinantRowReduction(); // hasil = the determinant of matrix M
```

## determinantSarrus()
determinantSarrus() is a function that returns the determinant of a matrix using Sarrus method. This function only valid for matrix with size of 3x3. If the matrix is not valid, it will return value -99999.

Time complexity : O(1)

### Usage example:
```java
// Inside main
Determinant det = new Determinant(M); //Initializes Determinant det with Matrix M 
double hasil = det.determinantSarrus(); // hasil = the determinant of matrix M
```

## determinantLaplaceExpansion()
determinantLaplaceExpansion() is a function that returns the determinant of a matrix using Laplace Expansion method, or as better known the cofactor expansion. 

Time complexity : O(n!)

### Usage example:
```java
// Inside main
Determinant det = new Determinant(M); //Initializes Determinant det with Matrix M 
double hasil = det.determinantLaplaceExpansion(); // hasil = the determinant of matrix M
```

## getminorEntry(int i, int j)
getminorEntry(int i, int j) is a function that returns a new Matrix object that has its row `i` and column `j` removed. 

### Usage example:
```java
// Inside main
Determinant det = new Determinant(M); //Initializes Determinant det with Matrix M 
Matrix K = det.getminorEntry(i ,j); // K is the minor entry of matrix M without row i and column j
```

## getCofactor(int i, int j)
getCofactor(int i, int j) is a function that returns the cofactor of a Matrix for row `i` and column `j` (in other words, it returns the minor entry with the sign).

### Usage example:
```java
// Inside main
Determinant det = new Determinant(M); //Initializes Determinant det with Matrix M 
double val = det.getCofactor(i, j); // val is the cofactor from row i and column j from matrix m.
```

## getMatrixCofactor()
getMatrixCofactor() is a function that returns cofactor matrix form of Matrix m.

### Usage example:
```java
// Inside main
Determinant det = new Determinant(M); //Initializes Determinant det with Matrix M 
Matrix mCofactor = det.getMatrixCofactor(); // returm cofactor matrix
```

## getAdjoint()
getAdjoint() is a function that returns adjoint matrix form of Matrix m. Adjoint matrix is a transposed cofactor matrix.

### Usage example:
```java
// Inside main
Determinant det = new Determinant(M); //Initializes Determinant det with Matrix M 
Matrix mAdjoint = det.getAdjoint(); // return adjoint of the matrix
```

## inverseAdjoint()
inverseAdjoint() is a function that returns inverse matrix form of Matrix m using Adjoint matrix.

### Usage example:
```java
// Inside main
Determinant det = new Determinant(M); //Initializes Determinant det with Matrix M 
Matrix invAdjoint = det.getAdjoint(); // returns matrix inverse of matrix M
```

## inverseGaussJordan()
inverseGaussJordan() is a function that returns inverse matrix form of Matrix m using GaussJordan Elimination.

### Usage example:
```java
// Inside main
Determinant det = new Determinant(M); //Initializes Determinant det with Matrix M 
Matrix invGauss = det.getAdjoint(); // returns matrix inverse of matrix M
```

## DetToText(double value)
DetToText is a procedure that will output a double from the parameter to an output file

### Usage example:
```java
// Inside main
Matrix det = new Determinant(m);

// After Determinant is initialized...

det.DetToText(value) // Will output the value to an output file.
```