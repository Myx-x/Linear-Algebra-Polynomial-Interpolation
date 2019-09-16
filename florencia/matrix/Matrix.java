package florencia.matrix;

import java.util.Scanner;

public class Matrix
{
	private Scanner s = new Scanner(System.in);
    public double[][] arr;
    public int rowCount, colCount;

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
	
	/*----- UTILITY FUNCTIONS ------*/
	// Swaps row1 with row2
	public void swapRow(int row1, int row2)
	{
		for(int i=0;i<this.colCount;i++) 
		{
			double tmp = this.arr[row1][i];
			this.arr[row1][i]=this.arr[row2][i];
			this.arr[row2][i]=tmp;
		}
	}
	// Swaps col1 with col2
	public void swapCol(int col1, int col2)
	{
		for(int i=0;i<this.rowCount;i++) 
		{
			double tmp = this.arr[i][col1];
			this.arr[i][col1]=this.arr[i][col2];
			this.arr[i][col2]=tmp;
		}	
	}

	/*----- CHECKER -----*/
	public boolean IsSquare(){
		return this.rowCount == this.colCount;
	}

	/*--------------*/
	public void normRowArithmetic(int reducedRow, int reducingRow, double multiplier){
        for(int i=0;i<this.colCount;i++) this.arr[reducedRow][i]=this.arr[reducedRow][i] + multiplier*this.arr[reducingRow][i];
    }

    public void normRowMultiplier(int multipliedRow, double multiplier){
        for(int i=0;i<this.colCount;i++) this.arr[multipliedRow][i]*=multiplier;
	}
	
	public void normBackwardElimination(){
        for (int k = this.colCount - 1; k >= 1; k--){
            for (int i = k - 1; i >= 0; i--){
                System.out.println(this.arr[i][k] + " " + this.arr[k][k]);
                double multiplier = -this.arr[i][k]/(this.arr[k][k]);
                this.normRowArithmetic(i, k, multiplier);
                this.printMatrix();
                System.out.println();
            }
            this.normRowMultiplier(k, 1/this.arr[k][k]);
        }
    }
}
