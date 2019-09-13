import java.util.Scanner;

public class Matrix
{
    public double[][] arr;
    public int rowCount, colCount;

	/*----- CONSTRUCTOR -----*/
	// The Matrix Object constructor, creates a matrix with dimension dimRow*dimCol
    public void makeMatrix(int dimRow, int dimCol)
    {
        this.arr = new double[dimRow][dimCol];
        this.rowCount = dimRow;
        this.colCount = dimCol;
    }
	
	/*----- SELECTOR -----*/
	// Returns the object's rowCount
	public int getMatrixRow()
	{
		return this.rowCount;
	}
	
	// Returns the object's colCount
    public int getMatrixCol()
    {
        return this.colCount;
    }

	// Sets matrix value at position arr[row][col]
    public void setCell(int row, int col, int value)
    {
		this.arr[row][col] = value;
	}
	
	// Matrix Input Procedure
	public void inputMatrix()
	{
		Scanner s = new Scanner(System.in);
		int r=s.nextInt(), c=s.nextInt();

		makeMatrix(r, c);
		for(int i=0;i<r;i++) for(int j=0;j<c;j++) this.arr[i][j] = s.nextInt();

		s.close();
	}

	// Matrix Output Procedure
	public void printMatrix()
	{
		for(int i=0;i<this.rowCount;i++)
		{
			for(int j=0;j<this.colCount;j++)
			{
				System.out.print(this.arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	private void swap(double a, double b)
	{
		double tmp=a;
		a=b;
		b=tmp;
	}

	public void swapRow(int row1, int row2)
	{
		for(int i=0;i<this.colCount;i++) swap(arr[row1][i], arr[row2][i]);
	}

	public void swapCol(int col1, int col2)
	{
		for(int i=0;i<this.rowCount;i++) swap(arr[i][col1], arr[i][col2]);
	}

	
}