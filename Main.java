public class Main
{
    public static void main (String args[])
    {
        Matrix mat1=new Matrix();
        Matrix mat2=new Matrix();

        mat1.inputMatrix();
        mat2.inputMatrix();

        AugmentedMatrix aug1 = new AugmentedMatrix();
        aug1.makeAugmentedMatrix(mat1, mat2);

        aug1.leftMatrix.swapRow(0,2);
        aug1.rightMatrix.swapRow(1,2);

        aug1.printAugmentedMatrix();
    }
}