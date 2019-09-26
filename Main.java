
import florencia.augmentedmatrix.AugmentedMatrix;
import florencia.matrix.*;


public class Main
{
    public static void main(String args[]) throws Exception
    {
        /*
        AugmentedMatrix aug = new AugmentedMatrix();

        
        aug.inputLinearEquation();
        
        aug.gaussJordanElimination();
        aug.convertToSolutionInfinite();
        System.out.println();
        */

        // aug.printAugmentedMatrix();
        // System.out.println();
        
        // double[][] res = aug.infiniteSolutionMatrix();
        // for(int i=0;i<aug.getLeftMatrix().colCount;i++)
        // {
        //     for(int j=0;j<aug.getLeftMatrix().colCount+1;j++) System.out.print(res[i][j] + " ");
        //     System.out.println();
        // }
        // aug.backwardSubstitution();
        // for(int i=0;i<aug.getLeftMatrix().colCount;i++)
        // {
        //     for(int j=0;j<aug.getLeftMatrix().colCount+1;j++) System.out.print(res[i][j] + " ");
        //     System.out.println();
        // }
        // aug.convertToSolutionInfinite();
        // Determinant d = new Determinant();
        // d.mat.inputMatrix();
        
        // Matrix result = new Matrix();
        
        // result = d.inverseGaussJordan();
        // result.printMatrix();
        
        
        // AugmentedMatrix aug = new AugmentedMatrix();
        // aug.textToAug();
        //aug.printAugmentedMatrix();

        // AugmentedMatrix aug = new AugmentedMatrix();
        // Matrix A = new Matrix();
        // Matrix B = new Matrix();
        // aug.inputLinearEquation();
        // aug.printAugmentedMatrix();
        // Matrix A = new Matrix();
        // Matrix B = new Matrix();
        // A.inputMatrix();
        // B.inputMatrix();
        // Matrix C = new Matrix();
        // C.kaliMatrix(A, B);
        // C.printMatrix();
        AugmentedMatrix aug = new AugmentedMatrix();
        aug.textToAug();
        aug.printAugmentedMatrix();
    }
}