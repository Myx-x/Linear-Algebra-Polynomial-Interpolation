
import florencia.augmentedmatrix.AugmentedMatrix;
import florencia.matrix.*;


public class Main
{
    public static void main(String args[]) throws Exception
    {
        AugmentedMatrix aug = new AugmentedMatrix();
        Matrix m3 = new Matrix();
        aug.inputLinearEquation();
        m3 = aug.makeInverseSPL();
        // Determinant det = new Determinant(aug.leftMatrix);
        // m3 = det.inverseAdjoint();

        // // m3 = m3.kaliMatrix(m3, aug.rightMatrix);
        m3.printMatrix();
        // Matrix a = new Matrix();
        // Matrix b = new Matrix();
        // Determinant c = new Determinant(a);
        // a.inputMatrix();
        // b.inputMatrix();
        // a.printMatrix();
        // a = a.kaliMatrix(a, b);
        // a.printMatrix();

    }
}