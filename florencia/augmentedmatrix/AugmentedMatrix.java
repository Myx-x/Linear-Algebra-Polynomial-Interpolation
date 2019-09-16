package florencia;

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
    public void swapAugRow(int row1, int row2)
    {
        this.leftMatrix.swapRow(row1, row2);
        this.rightMatrix.swapRow(row1, row2);
    }

    // Does an arithmetic operation on two rows in an augmented matrix
    public void augRowArithmetic(int reducedRow, int reducingRow, double multiplier)
    {
        for(int i=0;i<this.leftMatrix.colCount;i++) this.leftMatrix.arr[reducedRow][i]=this.leftMatrix.arr[reducedRow][i] + multiplier*this.leftMatrix.arr[reducingRow][i];
        for(int i=0;i<this.rightMatrix.colCount;i++) this.rightMatrix.arr[reducedRow][i]=this.rightMatrix.arr[reducedRow][i] + multiplier*this.rightMatrix.arr[reducingRow][i];
    }
    
    // Multiplies one row with a constant
    public void augRowMultiplier(int multipliedRow, double multiplier)
    {
        for(int i=0;i<this.leftMatrix.colCount;i++) this.leftMatrix.arr[multipliedRow][i]*=multiplier;
        for(int i=0;i<this.rightMatrix.colCount;i++) this.rightMatrix.arr[multipliedRow][i]*=multiplier;
    }
    
    /*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= GAUSS ELIMINATION -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
    
    // Partial pivoting
    public int partialPivoting(int col)
    {
        int index=0;
        while(this.leftMatrix.arr[index][col]==0) index++;
        return index;
    }

    // Reduce augmented matrix into echelon form
    public void forwardElimination()
    {
        this.swapAugRow(this.partialPivoting(0),0);
        for(int k=0;k<this.leftMatrix.colCount-1;k++)
        {
            for(int i=k+1;i<this.leftMatrix.rowCount;i++)
            {
                double multiplier = -this.leftMatrix.arr[i][k]/(this.leftMatrix.arr[k][k]);
                this.augRowArithmetic(i, k, multiplier);
                this.printAugmentedMatrix();
                System.out.println();
            }
            this.augRowMultiplier(k, 1/this.leftMatrix.arr[k][k]);
        }
        
    }

    // Reduce augmented matrix into reduced echelon form (if applied after forwardElimintation() method)
    public void backwardElimination()
    {
        for(int k=this.leftMatrix.colCount-1;k>=1;k--)
        {
            for(int i=k-1;i>=0;i--)
            {
                System.out.println(this.leftMatrix.arr[i][k] + " " + this.leftMatrix.arr[k][k]);
                double multiplier = -this.leftMatrix.arr[i][k]/(this.leftMatrix.arr[k][k]);
                this.augRowArithmetic(i, k, multiplier);
                this.printAugmentedMatrix();
                System.out.println();
            }
            this.augRowMultiplier(k, 1/this.leftMatrix.arr[k][k]);
        }
        
    }

	public void gaussElimination(int rowEquation, int colEquation)
	{
		
    }
    
}