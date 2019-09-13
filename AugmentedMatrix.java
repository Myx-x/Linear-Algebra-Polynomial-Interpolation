public class AugmentedMatrix
{
    Matrix leftMatrix;
    Matrix rightMatrix;

    /*----- CONSTRUCTOR -----*/
    // Creates a new Augmented Matrix
    public void makeAugmentedMatrix(Matrix m1, Matrix m2)
    {
        this.leftMatrix = m1;
        this.rightMatrix = m2;
    }

    /*----- SELECTOR ------*/
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

    /*----- INPUT OUTPUT PROCEDURE ------*/
    
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

}