
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

<<<<<<< HEAD
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
        /*
        AugmentedMatrix aug = new AugmentedMatrix();
        aug.textToAug();
        aug.printAugmentedMatrix();
        */
        Matrix mat = new Matrix();
        mat.textToMatrix();
        mat.MatrixToText();
        System.out.println("<------------------------>");
        AugmentedMatrix aug = new AugmentedMatrix();
        aug.textToAug();
        aug.AugToText();
=======
        m3.printMatrix();
>>>>>>> 838b3be3ed027c1ccc74f74eaf966c929de0c2ea
    }
}