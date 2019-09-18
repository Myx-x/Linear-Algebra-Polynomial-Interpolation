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
        
        m1.printMatrix();
        m2.printMatrix();
        
        AugmentedMatrix aug = new AugmentedMatrix(m1, m2);
        aug.printAugmentedMatrix();

        aug.gaussJordanElimination();

        aug.printAugmentedMatrix();
    }
}