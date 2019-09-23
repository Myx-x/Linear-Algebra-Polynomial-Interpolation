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

	/*----- UTILITY FUNCTIONS -----*/
	public boolean isSquare(){
		return this.rowCount == this.colCount;
	}

	public void rowSwap(int row1, int row2)
    {
        
        for(int i=0;i<this.colCount;i++)
        {
            System.out.println(this.arr[row1][i]);
            double tmp=this.arr[row1][i];
            this.arr[row1][i]=this.arr[row2][i];
            this.arr[row2][i]=tmp;
        }
        this.printMatrix();
	}
	
	public void colSwap(int col1, int col2)
    {
        for(int i=0;i<this.colCount;i++)
        {
            double tmp=this.arr[i][col1];
            this.arr[col1][i]=this.arr[col2][i];
            this.arr[col2][i]=tmp;
        }
    }

    public void rowArithmetic(int reducedRow, int reducingRow, double multiplier){
        for(int i=0;i<this.colCount;i++) this.arr[reducedRow][i]=this.arr[reducedRow][i] + multiplier*this.arr[reducingRow][i];
    }

    public void rowMultiplier(int multipliedRow, double multiplier){
        for(int i=0;i<this.colCount;i++) this.arr[multipliedRow][i]*=multiplier;
	}

	public void normBackwardElimination(){
		for(int k=this.colCount-1;k>=1;k--)
        {
            for(int i=k-1;i>=0;i--)
            {
                double multiplier = -this.arr[i][k]/(this.arr[k][k]);
                this.rowArithmetic(i, k, multiplier);
            }
            this.rowMultiplier(k, 1/this.arr[k][k]);
        }
	}

	public void fixSignedZero()
	{
		for(int i=0;i<this.rowCount;i++) for(int j=0;j<this.colCount;j++) if(Math.abs(this.arr[i][j])<1e-7) this.arr[i][j]=0.000;
	}

	public Matrix transpose()
	{
		Matrix MT = new Matrix();
		MT.makeMatrix(this.colCount, this.rowCount);

		for(int i=0;i<this.colCount;i++) for(int j=0;j<this.rowCount;j++) MT.arr[i][j] = this.arr[i][j];

		return MT;
	}

	public Matrix setIdentityMatrix()
	{
		if(this.isSquare())
		{
			Matrix I = new Matrix();
			for(int i=0;i<this.rowCount;i++) for(int j=0;j<this.colCount;j++) I.arr[i][j]=i==j?1:0;
			return I;
		}
		else
		{
			System.out.println("Matrix is not square!");
			return this;
		}
	}

	public Matrix kaliKons(Double X)
	{
		Matrix MT = new Matrix();
		for(int i=0;i<this.rowCount;i++){
			 for(int j=0;j<this.colCount;j++) {
				MT.arr[i][j] = MT.arr[i][j] * X;
			}
		}return MT;
	}
}
