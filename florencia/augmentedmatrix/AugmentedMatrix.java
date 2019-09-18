package florencia.augmentedmatrix;

import florencia.matrix.*;

public class AugmentedMatrix
{
    Matrix leftMatrix;
    Matrix rightMatrix;

    /*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= CONSTRUCTOR -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
    // Creates a new Augmented Matrix
    public AugmentedMatrix(Matrix m1, Matrix m2)
    {
        leftMatrix = m1;
        rightMatrix = m2;
    }
    
    // Create a copy of an augmented Matrix
    public AugmentedMatrix(AugmentedMatrix augMat)
    {
        leftMatrix = augMat.leftMatrix;
        rightMatrix = augMat.rightMatrix;
    }
    
    /*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= SELECTOR -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-*/
    // Returns left side matrix
    public Matrix getLeftMatrix()
    {
        return this.leftMatrix;
    }

    // Returns right side matrix
    public Matrix getRightMatrix()
    {
        return this.rightMatrix;
    }

    /*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= INPUT OUTPUT PROCEDURE -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-*/
    
    public void printAugmentedMatrix()
    {
        for(int i=0;i<this.leftMatrix.rowCount;i++)
        {
            for(int j=0;j<this.leftMatrix.colCount;j++) System.out.print(this.getLeftMatrix().arr[i][j]+"\t");
            System.out.print("|\t");
            for(int j=0;j<this.rightMatrix.colCount;j++) System.out.print(this.getRightMatrix().arr[i][j]+"\t");
            System.out.println();
        }
    }

    /*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= ELEMENTARY ROW OPERATIONS (OBE) -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
    // Swaps row1 and row2 in an augmented matrix
    public void augRowSwap(int row1, int row2)
    {
        this.leftMatrix.rowSwap(row1, row2);
        this.rightMatrix.rowSwap(row1, row2);
    }
    
    // Does an arithmetic operation on two rows in an augmented matrix
    public void augRowArithmetic(int reducedRow, int reducingRow, double multiplier)
    {
        this.leftMatrix.rowArithmetic(reducedRow, reducingRow, multiplier);
        this.rightMatrix.rowArithmetic(reducedRow, reducingRow, multiplier);
    }
    
    // Multiplies one row with a constant
    public void augRowMultiplier(int multipliedRow, double multiplier)
    {
        this.leftMatrix.rowMultiplier(multipliedRow, multiplier);
        this.rightMatrix.rowMultiplier(multipliedRow, multiplier);
    }
    
    /*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= GAUSS ELIMINATION -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
    
    // Partial pivoting
    public int partialPivoting(int col)
    {
        int index=col;
        double currentPivot=this.leftMatrix.arr[index][col];
        for(int i=index+1;i<this.leftMatrix.rowCount;i++)
        {
            if(Math.abs(this.leftMatrix.arr[i][col])<Math.abs(currentPivot))
            {
                currentPivot=this.leftMatrix.arr[i][col];
                index=i;
            }
        }
        return index;
    }

    // Reduce augmented matrix into echelon form
    public void forwardElimination()
    {
        int rc=this.leftMatrix.rowCount,cc=this.leftMatrix.colCount;

        for(int k=0;k<cc-1;k++)
        {
            this.augRowSwap(this.partialPivoting(k),k);
            for(int i=k+1;i<rc;i++)
            {
                double multiplier = -this.leftMatrix.arr[i][k]/(this.leftMatrix.arr[k][k]);
                this.augRowArithmetic(i, k, multiplier);
                this.printAugmentedMatrix();
                System.out.println();
            }
            this.augRowMultiplier(k, 1/this.leftMatrix.arr[k][k]);
        }
        this.augRowMultiplier(cc-1, 1/this.leftMatrix.arr[rc-1][cc-1]);
        
    }

    // Reduce augmented matrix into reduced echelon form (if applied after forwardElimintation() method)
    public void backwardElimination()
    {
        for(int k=this.leftMatrix.colCount-1;k>=1;k--)
        {
            for(int i=k-1;i>=0;i--)
            {
                double multiplier = -this.leftMatrix.arr[i][k]/(this.leftMatrix.arr[k][k]);
                this.augRowArithmetic(i, k, multiplier);
                this.printAugmentedMatrix();
                System.out.println();
            }
            this.augRowMultiplier(k, 1/this.leftMatrix.arr[k][k]);
        }
        
    }

	public void gaussElimination()
	{
        this.forwardElimination();
        this.leftMatrix.fixSignedZero();
        this.rightMatrix.fixSignedZero();
    }
    
	public void gaussJordanElimination()
	{
        this.forwardElimination();
        this.backwardElimination();
        this.leftMatrix.fixSignedZero();
        this.rightMatrix.fixSignedZero();
    }

    public void inverseMatrix()
    {
        this.leftMatrix.inputMatrix();
        
    }
}