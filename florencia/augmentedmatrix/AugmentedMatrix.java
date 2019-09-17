package florencia.augmentedmatrix;
import florencia.Matrix;
import java.lang.Math;

public class AugmentedMatrix
{
    public Matrix leftMatrix;
    public Matrix rightMatrix;

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

    /*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= UTILITY FUNCITON -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-*/

    public void fixNegativeZero()
    {
        for(int i=0;i<this.leftMatrix.rowCount;i++) for(int j=0;j<this.leftMatrix.colCount;j++) if(this.leftMatrix.arr[i][j]==-0.0) this.leftMatrix.arr[i][j]=0;
        for(int i=0;i<this.rightMatrix.rowCount;i++) for(int j=0;j<this.rightMatrix.colCount;j++) if(this.rightMatrix.arr[i][j]==-0.0) this.rightMatrix.arr[i][j]=0;
    
    }
    
    
}