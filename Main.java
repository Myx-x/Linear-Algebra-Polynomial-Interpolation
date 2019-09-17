import florencia.matrix.*;


public class Main
{
    public static void main(String args[])
    {
        Matrix m1 = new Matrix();
        m1.inputMatrix();
        
        ElementaryRowOperations me1 = new ElementaryRowOperations();

        me1.rowSwap(0,1);

        m1.printMatrix();
    }
}