package florencia.matrix;

import java.util.Scanner;

public class Matrix
{
	private Scanner s = new Scanner(System.in);
    public double[][] arr;
    public int rowCount, colCount;

	/*----- CONSTRUCTOR -----*/
	// The Matrix Object constructor, creates a matrix with dimension dimRow*dimCol

	public Matrix()
	{
		rowCount=0;
		colCount=0;
		arr= new double[1][1];
	}

	public Matrix(Matrix M)
	{
		M.arr = this.arr;
		M.rowCount = this.rowCount;
		M.colCount = this.colCount;
	}

	public Matrix(int rc, int cc)
	{
		rowCount=rc;
		colCount=cc;
		arr=new double[rowCount][colCount];
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
		this.rowCount=s.nextInt();
		this.colCount=s.nextInt();
		this.arr = new double[this.rowCount][this.colCount];

		// System.out.println("pisangggg");
		for(int i=0;i<this.rowCount;i++) for(int j=0;j<this.colCount;j++) this.arr[i][j] = s.nextDouble();	
	}

	// Matrix Output Procedure
	public void printMatrix()
	{
		this.fixSignedZero();
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
            double tmp=this.arr[row1][i];
            this.arr[row1][i]=this.arr[row2][i];
            this.arr[row2][i]=tmp;
        }
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
        }
	}

	public void fixSignedZero()
	{
		for(int i=0;i<this.rowCount;i++) for(int j=0;j<this.colCount;j++) if(Math.abs(this.arr[i][j])<1e-7) this.arr[i][j]=0.000;
	}

	public Matrix transpose()
	{
		Matrix MT = new Matrix(this.colCount, this.rowCount);

		for(int i=0;i<this.colCount;i++) for(int j=0;j<this.rowCount;j++) MT.arr[i][j] = this.arr[j][i];

		return MT;
	}

	public void setIdentityMatrix(int n)
	{
		if(this.isSquare())
		{
			this.rowCount=n;
			this.colCount=n;
			this.arr = new double[n][n];
			for(int i=0;i<this.rowCount;i++) for(int j=0;j<this.colCount;j++) this.arr[i][j]=(i==j)?1:0;
			this.printMatrix();
		}
		else
		{
			System.out.println("Matrix is not square!");
		}
	}

	public Matrix kaliKons(Double X)
	{
		Matrix MT = new Matrix(this);
		for(int i=0;i<this.rowCount;i++){
			 for(int j=0;j<this.colCount;j++) {
				MT.arr[i][j] = MT.arr[i][j] * X;
			}
		}return MT;
	}
	
	public boolean isRowZero(int row)
	{
		boolean result=true;
		int i=0;

		while(result && i<this.colCount)
		{
			if(this.arr[row][i]!=0) result=false;
			else i++;
		}
		return result;
	}
}
