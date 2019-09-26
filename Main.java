
import florencia.augmentedmatrix.AugmentedMatrix;
import florencia.matrix.*;

import java.io.*;


public class Main
{
    public static void main(String args[]) throws Exception
    {
        PrintStream file = new PrintStream(new File("./output/output.txt").getCanonicalPath());
        PrintStream console = System.out;

        System.setOut(file);
        System.out.println("ini file1");
        System.out.println("ini file2");

        System.setOut(console);
        System.out.println("ini console1");
        System.out.println("ini console2");

        System.setOut(file);
        System.out.println("ini file lanjutan 3");
        System.out.println("ini file lanjutan 4");

        System.setOut(console);
        System.out.println("ini console lanjutan 3");
        System.out.println("ini console lanjutan 4");

        // AugmentedMatrix aug = new AugmentedMatrix();
        // Matrix m3 = new Matrix();
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
        /*
        Matrix mat = new Matrix();
        mat.textToMatrix();
        mat.MatrixToText();
        System.out.println("<------------------------>");
        AugmentedMatrix aug = new AugmentedMatrix();
        aug.textToAug();
        aug.AugToText();
        */
        /*
        Matrix mat = new Matrix();
        Determinant det = new Determinant(mat);
        System.out.println(det.determinantRowReduction());
        System.out.println(det.determinantSarrus());
        System.out.println(det.determinantLaplaceExpansion());
        System.out.println("----------------------------");
        det.DetToText(det.determinantRowReduction());
        det.DetToText(det.determinantSarrus());
        det.DetToText(det.determinantLaplaceExpansion());
        */
        // m3 = aug.makeInverseSPL();
        // // Determinant det = new Determinant(aug.leftMatrix);
        // // m3 = det.inverseAdjoint();
    }
}