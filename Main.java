import florencia.augmentedmatrix.AugmentedMatrix;
import florencia.matrix.*;


public class Main
{
    public static void main(String args[])
    {
        Matrix m1 = new Matrix();
        Matrix m2 = new Matrix();
        
        m1.inputMatrix();
        m2.inputMatrix();

        AugmentedMatrix aug = new AugmentedMatrix(m1, m2);

        //aug.gaussElimination();
        aug.gaussJordanElimination();
        aug.convertToSolutionValid();

        
    }
}