
import florencia.augmentedmatrix.AugmentedMatrix;
import florencia.matrix.*;


public class Main
{
    public static void main(String args[])
    {
        Matrix m1 = new Matrix();
        Matrix m2 = new Matrix();
        
        // m1.inputMatrix();
        // m2.inputMatrix();

        AugmentedMatrix aug = new AugmentedMatrix(m1, m2);

        // aug.gaussJordanElimination();
        // double[][] res = aug.infiniteSolutionMatrix();
        // for(int i=0;i<aug.getLeftMatrix().colCount;i++)
        // {
        //     for(int j=0;j<aug.getLeftMatrix().colCount+1;j++) System.out.print(res[i][j] + " ");
        //     System.out.println();
        // }
        // aug.convertToSolutionInfinite();

        aug.inputLinearEquation();
        aug.printAugmentedMatrix();
        
    }
}