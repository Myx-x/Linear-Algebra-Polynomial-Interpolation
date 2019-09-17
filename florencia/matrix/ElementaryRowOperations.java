package florencia.matrix;

public class ElementaryRowOperations extends Matrix
{
    
    public ElementaryRowOperations(double[][] arr, int rowCount, int colCount)
    {
        super(arr, rowCount, colCount);
        System.out.println(super.colCount);
    }

    public void rowSwap(int row1, int row2)
    {
        
        for(int i=0;i<super.colCount;i++)
        {
            System.out.println(super.arr[row1][i]);
            double tmp=super.arr[row1][i];
            super.arr[row1][i]=super.arr[row2][i];
            super.arr[row2][i]=tmp;
        }
        super.printMatrix();
    }

    public void colSwap(int col1, int col2)
    {
        for(int i=0;i<super.colCount;i++)
        {
            double tmp=super.arr[i][col1];
            super.arr[col1][i]=super.arr[col2][i];
            super.arr[col2][i]=tmp;
        }
    }

    public void rowArithmetic(int reducedRow, int reducingRow, double multiplier){
        for(int i=0;i<super.colCount;i++) super.arr[reducedRow][i]=super.arr[reducedRow][i] + multiplier*super.arr[reducingRow][i];
    }

    public void rowMultiplier(int multipliedRow, double multiplier){
        for(int i=0;i<super.colCount;i++) super.arr[multipliedRow][i]*=multiplier;
	}

}