import florencia.augmentedmatrix.AugmentedMatrix;
import florencia.matrix.*;


public class Main
{
    public static void main(String args[])
    {
        Matrix m1 = new Matrix();

        m1.inputMatrix();
        Determinant d1 = new Determinant(m1);

        Matrix m2 = d1.getminorEntry(1, 1);

        m2.printMatrix();
        
        /*AugmentedMatrix aug = new AugmentedMatrix(m1, m2);
        aug.printAugmentedMatrix();

        aug.gaussJordanElimination();

        aug.printAugmentedMatrix();*/
    }
}