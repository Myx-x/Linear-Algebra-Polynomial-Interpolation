package florencia;

public class AugmentedElimination extends AugmentedMatrix
{
    public AugmentedElimination(Matrix leftMatrix, Matrix rightMatrix){
        super(leftMatrix,rightMatrix);
    }
    /*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= ELEMENTARY ROW OPERATIONS (OBE) -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
    // Swaps row1 and row2 in an augmented matrix
    public void swapAugRow(int row1, int row2)
    {
        super.leftMatrix.swapRow(row1, row2);
        super.rightMatrix.swapRow(row1, row2);
    }

    // Does an arithmetic operation on two rows in an augmented matrix
    public void augRowArithmetic(int reducedRow, int reducingRow, double multiplier)
    {
        for(int i=0;i<super.leftMatrix.colCount;i++) super.leftMatrix.arr[reducedRow][i]=super.leftMatrix.arr[reducedRow][i] + multiplier*super.leftMatrix.arr[reducingRow][i];
        for(int i=0;i<super.rightMatrix.colCount;i++) super.rightMatrix.arr[reducedRow][i]=super.rightMatrix.arr[reducedRow][i] + multiplier*super.rightMatrix.arr[reducingRow][i];
    }
    
    // Multiplies one row with a constant
    public void augRowMultiplier(int multipliedRow, double multiplier)
    {
        for(int i=0;i<super.leftMatrix.colCount;i++) super.leftMatrix.arr[multipliedRow][i]*=multiplier;
        for(int i=0;i<super.rightMatrix.colCount;i++) super.rightMatrix.arr[multipliedRow][i]*=multiplier;
    }
    
    /*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= GAUSS ELIMINATION -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
    
    // Partial pivoting
    public int partialPivoting(int col)
    {
        int index=0;
        while(super.leftMatrix.arr[index][col]==0) index++;
        return index;
    }

    // Reduce augmented matrix into echelon form
    public void forwardElimination()
    {
        this.swapAugRow(this.partialPivoting(0),0);
        for(int k=0;k<super.leftMatrix.colCount-1;k++)
        {
            for(int i=k+1;i<super.leftMatrix.rowCount;i++)
            {
                double multiplier = -super.leftMatrix.arr[i][k]/(super.leftMatrix.arr[k][k]);
                this.augRowArithmetic(i, k, multiplier);
                super.printAugmentedMatrix();
                System.out.println();
            }
            this.augRowMultiplier(k, 1/super.leftMatrix.arr[k][k]);
        }
        
    }

    // Reduce augmented matrix into reduced echelon form (if applied after forwardElimintation() method)
    public void backwardElimination()
    {
        for(int k=super.leftMatrix.colCount-1;k>=1;k--)
        {
            for(int i=k-1;i>=0;i--)
            {
                double multiplier = -super.leftMatrix.arr[i][k]/(super.leftMatrix.arr[k][k]);
                this.augRowArithmetic(i, k, multiplier);
                super.printAugmentedMatrix();
                System.out.println();
            }
            this.augRowMultiplier(k, 1/this.leftMatrix.arr[k][k]);
        }
        
    }

    public void gaussElimination(int rowEquation, int colEquation)
    {
        
    }

}