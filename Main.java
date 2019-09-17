<<<<<<< HEAD
import florencia.augmentedmatrix.*;
import florencia.Matrix;
=======
import florencia.matrix.*;
>>>>>>> origin/matrix

public class Main
{
    public static void main (String args[])
    {
        Matrix mat1=new Matrix();
        Matrix mat2=new Matrix();

        mat1.inputMatrix();
        mat2.inputMatrix();
<<<<<<< HEAD

        AugmentedMatrix aug = new AugmentedMatrix(mat1, mat2);
        AugmentedElimination augEl = new AugmentedElimination(mat1,mat2);
        

        System.out.println(augEl.partialPivoting(0));
        augEl.forwardElimination();
        augEl.backwardElimination();
        aug.fixNegativeZero();
        aug.printAugmentedMatrix();


=======
>>>>>>> origin/matrix
    }
}