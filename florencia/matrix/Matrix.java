package florencia.matrix;

import java.util.Scanner;

public class Matrix
{
	private Scanner s = new Scanner(System.in);
    public double[][] arr;
    public int rowCount, colCount;

	Matrix(int dimRow, int dimCol) {
		arr = new double[dimRow][dimCol];
		rowCount = dimRow;
		colCount = dimCol;	
	}

	/*----- CONSTRUCTOR -----*/
	// The Matrix Object constructor, creates a matrix with dimension dimRow*dimCol
    public void makeMatrix(int dimRow, int dimCol)
    {
        arr = new double[dimRow][dimCol];
        rowCount = dimRow;
        colCount = dimCol;	
    }
	
	/*----- SELECTOR -----*/
	// Returns the object's rowCount
	public int getRowCount()
	{
		return this.rowCount;
	}
	
	// Returns the object's colCount
    public int getColCount()
    {
        return this.colCount;
    }

	// Sets matrix value at position arr[row][col]
    public void setCell(int row, int col, int value)
    {
		this.arr[row][col] = value;
	}
	
	/*----- INPUT OUTPUT PROCEDURE ------*/
	// Matrix Input Procedure
	public void inputMatrix()
	{
		if(s.hasNextInt())
		{
			int r=s.nextInt();
			int c=s.nextInt();
	
			makeMatrix(r, c);
			for(int i=0;i<r;i++) for(int j=0;j<c;j++) this.arr[i][j] = s.nextDouble();
			
			s.nextLine();
		}
		else return;

	}

	// Matrix Output Procedure
	public void printMatrix()
	{
		for(int i=0;i<this.rowCount;i++)
		{
			for(int j=0;j<this.colCount;j++) System.out.print(this.arr[i][j] + "\t");
			System.out.println();
		}
	}
	
	public void funcA()
	{
		// do blabla1
		// do blabla1
		// do blabla1
		// do blabla1
		// do blabla1
		// do blabla1
		// do blabla1
		// do blabla1
		// do blabla1
		// do blabla1
		// do blabla1
		// do blabla1
		// do blabla1
		// do blabla1
		// do blabla1
		// do blabla1
	}

	/*----- CHECKER -----*/
	public boolean IsSquare(){
		return this.rowCount == this.colCount;
	}


	public void funcB()
	{
		//do blabla2
	}
}
