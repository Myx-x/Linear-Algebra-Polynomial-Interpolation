
import florencia.augmentedmatrix.AugmentedMatrix;
import florencia.matrix.*;


public class Main
{
    public static void main(String args[])
    {

        AugmentedMatrix aug = new AugmentedMatrix();

        // double[][] res = aug.infiniteSolutionMatrix();
        // for(int i=0;i<aug.getLeftMatrix().colCount;i++)
        // {
        //     for(int j=0;j<aug.getLeftMatrix().colCount+1;j++) System.out.print(res[i][j] + " ");
        //     System.out.println();
        // }
        // aug.convertToSolutionInfinite();
        
        aug.inputLinearEquation();
        aug.printAugmentedMatrix();
        aug.gaussJordanElimination();
        
    }
}