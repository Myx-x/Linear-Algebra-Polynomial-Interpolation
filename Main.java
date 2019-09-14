public class Main
{
    public static void main (String args[])
    {
        Matrix mat1=new Matrix();
        Matrix mat2=new Matrix();

        mat1.inputMatrix();
        mat2.inputMatrix();

        AugmentedMatrix aug = new AugmentedMatrix(mat1, mat2);

        System.out.println(aug.partialPivoting(0));

        aug.forwardElimination();
        aug.backwardElimination();

        aug.printAugmentedMatrix();
    }
}