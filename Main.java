
import florencia.augmentedmatrix.AugmentedMatrix;
import florencia.matrix.*;


public class Main
{
    public static void main(String args[]) throws Exception
    {
        Matrix m1 = new Matrix();
        Matrix m2 = new Matrix();

        m1.inputMatrix();
        m2.inputMatrix();

        Matrix m3 = new Matrix();
        m3 = m3.kaliMatrix(m1, m2);

        m3.printMatrix();
    }
}