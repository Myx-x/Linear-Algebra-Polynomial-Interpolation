# AugmentedMatrix Class Documentation
This is the documentation for the `AugmentedMatrix.class` that is available under the package `florencia.augmentedmatrix`.

## AugmentedMatrix()
The `AugmentedMatrix()` object is an object that its purpose is specifically to solve linear equations. It simply consists of two Matrix object.

### Components:
* `Matrix leftMatrix` - as the left side matrix; usually being the coefficients of the linear equation.
* `Matrix rightMatrix` - as the right side matrix; it can be the constant in the linear equation or an identity matrix.

## AugmentedMatrix(Matrix m1, Matrix m2)
This is one of the constructor of AugmentedMatrix object. It create a new AugmentedMatrix object using two parameters, which is for the left matrix and the right matrix.

### Usage example:
```java
// Inside main
Matrix leftMat = new Matrix();
Matrix righttMat = new Matrix();
// Both matrix initialized
AugmentedMatrix aug = new AugmentedMatrix(leftMat, rightMat); // Creates a new AugmentedMatrix()
```

## AugmentedMatrix(Matrix m1, Matrix m2)
This is one of the constructor of AugmentedMatrix object. It create a new AugmentedMatrix object using one parameter, which is the augmented matrix itself. It may be used to copy an AugmentedMatrix into another.

### Usage example:
```java
// Inside main
// A valid AugmentedMatrix available
AugmentedMatrix aug2 = new AugmentedMatrix(aug1); // Creates a new AugmentedMatrix() which contents equal to aug1
```

## getLeftMatrix()
getLeftMatrix works as a selector to get AugmentedMatrix's object `leftMatrix` variable.

### Usage example:
```java
// Inside main
AugmentedMatrix aug = new AugmentedMatrix(leftMat, rightMat); // Creates a new AugmentedMatrix()
Matrix m = AugmentedMatrix.getLeftMatrix();
```

## getRightMatrix()
getRightMatrix works as a selector to get AugmentedMatrix's object `rightMatrix` variable.

### Usage example:
```java
// Inside main
AugmentedMatrix aug = new AugmentedMatrix(leftMat, rightMat); // Creates a new AugmentedMatrix()
Matrix m = AugmentedMatrix.getLeftMatrix();
```

## inputLinearEquation()
inputLinearEquation is an input procedure with an augmented matrix form, especially for inputting to solve a linear equation.

### Usage example:
```java
// Inside main
AugmentedMatrix aug = new AugmentedMatrix(leftMat, rightMat); // Creates a new AugmentedMatrix()
aug.inputLinearEquation();
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


