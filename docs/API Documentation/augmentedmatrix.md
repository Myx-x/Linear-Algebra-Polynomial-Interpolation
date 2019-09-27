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

## printAugmentedMatrix()
printAugmentedMatrix is an output procedure with an augmented matrix form.

### Usage example:
```java
// Inside main
AugmentedMatrix aug = new AugmentedMatrix(leftMat, rightMat); // Creates a new AugmentedMatrix()
aug.printAugmentedMatrix();
```

## augRowSwap(int i, int j)
augRowSwap is a procedure to swap row in the Augmented form.

### Usage example:
```java
// Inside main
AugmentedMatrix aug = new AugmentedMatrix(leftMat, rightMat); // Creates a new AugmentedMatrix()
aug.augRowSwap(i,j); // swap row i and row j
```

## augRowArithmetic(int reducedRow, int reducingRow, double multiplier)
augRowArithmetic is a procedure to do arithmetic operation on two rows in an augmented matrix

### Usage example:
```java
// Inside main
AugmentedMatrix aug = new AugmentedMatrix(leftMat, rightMat); // Creates a new AugmentedMatrix()
aug.augRowArithmetic(i,j, X); // reduce row i, reduce row j, and multiply with an X
```

## augRowMultiplier(int multipliedRow, double multiplier)
augRowMultiplier is a procedure to multiples one rows with a constant

### Usage example:
```java
// Inside main
AugmentedMatrix aug = new AugmentedMatrix(leftMat, rightMat); // Creates a new AugmentedMatrix()
aug.augRowArithmetic(i, X); // reduce row i and multiply with an X
```

## validateAugMat()
validateAugMat is a procedure to validate an augmented matrix.

### Usage example:
```java
// Inside main
AugmentedMatrix aug = new AugmentedMatrix(leftMat, rightMat); // Creates a new AugmentedMatrix()
aug.validateAugMat(); 
```

## forwardElimination()
forwardElimination is a procedure to reduce front of the augmented matrix into an echelon form.

### Usage example:
```java
// Inside main
AugmentedMatrix aug = new AugmentedMatrix(leftMat, rightMat); // Creates a new AugmentedMatrix()
aug.forwardElimination(); 
```


## backwardElimination()
backwardElimination is a procedure to reduce back of the augmented matrix into an echelon form.

### Usage example:
```java
// Inside main
AugmentedMatrix aug = new AugmentedMatrix(leftMat, rightMat); // Creates a new AugmentedMatrix()
aug.backwardElimination(); 
```

## GaussElimination()
gaussElimination is a procedure to use a gauss elimination for the augmented matrix.

### Usage example:
```java
// Inside main
AugmentedMatrix aug = new AugmentedMatrix(leftMat, rightMat); // Creates a new AugmentedMatrix()
aug = aug.gaussElimination(); 
```


## gaussJordanElimination()
gaussJordanElimination is a procedure to use a gauss-jordan elimination for the augmented matrix.

### Usage example:
```java
// Inside main
AugmentedMatrix aug = new AugmentedMatrix(leftMat, rightMat); // Creates a new AugmentedMatrix()
aug = aug.gaussJordanElimination(); 
```

## makeInverseSPL()
makeInverseSPL is a procedure to use a inverse method to make a solution from the augmented matrix.

### Usage example:
```java
// Inside main
AugmentedMatrix aug = new AugmentedMatrix(leftMat, rightMat); // Creates a new AugmentedMatrix()
Matrix M = aug.makeInverseSPL(); // The solution for the aug is initialized in matrix M 
```


## makeInterpolationMatrix()
makeInterpolationMatrix is an input procedure to use interpolation for the augmented matrix.

### Usage example:
```java
// Inside main
AugmentedMatrix aug = new AugmentedMatrix(leftMat, rightMat); // Creates a new AugmentedMatrix()
aug = aug.makeInterpolationMatrix(); 
```


## convertToInterpolation(AugmentedMatrix aug)
convertToInterpolation is an output procedure to output the solution for interpolation.

### Usage example:
```java
// Inside main
AugmentedMatrix aug = new AugmentedMatrix(leftMat, rightMat); // Creates a new AugmentedMatrix()
aug = aug.makeInterpolationMatrix();
aug.convertToInterpolation(aug); // Will make an output to the screen 
```

## Cramer()
Cramer is an output procedure to make the solution from the augmented matrix.

### Usage example:
```java
// Inside main
AugmentedMatrix aug = new AugmentedMatrix(leftMat, rightMat); // Creates a new AugmentedMatrix()
aug.Cramer(); 
```

## infiniteSolutionMatrix()
infiniteSolutionMatrix is a procedure to make the solution matrix from the augmented matrix.

### Usage example:
```java
// Inside main
AugmentedMatrix aug = new AugmentedMatrix(leftMat, rightMat); // Creates a new AugmentedMatrix()
double cc[][] = aug.infiniteSolutionMatrix(); 
```

## backwardSubstitution()
backwardSubstitution is a procedure to substitute the bacward from the augmented matrix.

### Usage example:
```java
// Inside main
AugmentedMatrix aug = new AugmentedMatrix(leftMat, rightMat); // Creates a new AugmentedMatrix()
aug.backwardSubstitution(); 
```

## convertToSolutionInfinite()
convertToSolutionInfinite is an output procedure to make the solution matrix from the augmented matrix.

### Usage example:
```java
// Inside main
AugmentedMatrix aug = new AugmentedMatrix(leftMat, rightMat); // Creates a new AugmentedMatrix()
aug.convertToSolutionInfinite(); 
```

## textToAug()
textToAug is an input procedure to make the augmented matrix from a file.

### Usage example:
```java
// Inside main
AugmentedMatrix aug = new AugmentedMatrix(leftMat, rightMat); // Creates a new AugmentedMatrix()
aug.textToAug(); 
```

## AugToText()
AugToText() is an output procedure to make the augmented matrix into a file.

### Usage example:
```java
// Inside main
AugmentedMatrix aug = new AugmentedMatrix(leftMat, rightMat); // Creates a new AugmentedMatrix()
aug.AugToText(); 
```

## convertToInterpolationToText(AugmentedMatrix aug)
convertToInterpolation is an output procedure to output the solution for interpolation into a file.

### Usage example:
```java
// Inside main
AugmentedMatrix aug = new AugmentedMatrix(leftMat, rightMat); // Creates a new AugmentedMatrix()
aug.convertToInterpolationToText(aug); 
```

## CramerToText()
CramerToText is an output procedure to make the solution from the augmented matrix into a file.

### Usage example:
```java
// Inside main
AugmentedMatrix aug = new AugmentedMatrix(leftMat, rightMat); // Creates a new AugmentedMatrix()
aug.CramerToText(); 
```


## convertToSolutionInfiniteToText()
convertToSolutionInfiniteToText is an output procedure to make the solution matrix from the augmented matrix into a file.

### Usage example:
```java
// Inside main
AugmentedMatrix aug = new AugmentedMatrix(leftMat, rightMat); // Creates a new AugmentedMatrix()
aug.convertToSolutionInfiniteToText(); 
```

