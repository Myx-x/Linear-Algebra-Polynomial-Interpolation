package florencia.matrix;

import java.util.Scanner;
import java.io.*;

public class Matrix
{
	private Scanner s = new Scanner(System.in);
    public double[][] arr;
    public int rowCount, colCount;

    /*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= CONSTRUCTOR -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
	// Creates an empty matrix
	public Matrix()
	{
		rowCount=0;
		colCount=0;
		arr= new double[1][1];
	}
	
	// Creates a Matrix with dimension rc x cc
	public Matrix(int rc, int cc)
	{
		rowCount=rc;
		colCount=cc;
		arr=new double[rowCount][colCount];
	}
	
	// Creates a copy of Matrix M
	public Matrix(Matrix M)
	{
		M.arr = this.arr;
		M.rowCount = this.rowCount;
		M.colCount = this.colCount;
	}


    /*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= SELECTOR -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
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
	
	/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= INPUT OUTPUT PROCEDURE -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
	// Matrix Input Procedure
	public void inputMatrix()
	{
		System.out.print("Masukkan Baris :");
		this.rowCount=s.nextInt();
		System.out.print("Masukkan Kolom :");
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

    /*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= UTILITY FUNCTIONS -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
	// Test wheter matrix is square or not
	public boolean isSquare(){
		return this.rowCount == this.colCount;
	}

	// Swap a row1 and row2 in a matrix. row1 & row2 must be valid.
	public void rowSwap(int row1, int row2)
    {
        for(int i=0;i<this.colCount;i++)
        {
            double tmp=this.arr[row1][i];
            this.arr[row1][i]=this.arr[row2][i];
            this.arr[row2][i]=tmp;
        }
	}
	
	// Swap a col1 and col2 in a matrix. col1 & col2 must be valid.
	public void colSwap(int col1, int col2)
    {
        for(int i=0;i<this.colCount;i++)
        {
            double tmp=this.arr[i][col1];
            this.arr[col1][i]=this.arr[col2][i];
            this.arr[col2][i]=tmp;
        }
    }

	// reducedRow[i] -= multiplier * reducingrow[i]
    public void rowArithmetic(int reducedRow, int reducingRow, double multiplier){
		for(int i=0;i<this.colCount;i++) this.arr[reducedRow][i]=this.arr[reducedRow][i] + multiplier*this.arr[reducingRow][i];
    }
	
	// multipliedRow[i] *= multiplier
    public void rowMultiplier(int multipliedRow, double multiplier){
        for(int i=0;i<this.colCount;i++) this.arr[multipliedRow][i]*=multiplier;
	}

	// Does a backward elimination to a matrix (used for determinant)
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

	// Use to fix an issue relating doubles having signed zero
	public void fixSignedZero()
	{
		for(int i=0;i<this.rowCount;i++) for(int j=0;j<this.colCount;j++) if(Math.abs(this.arr[i][j])<1e-7) this.arr[i][j]=0.000;
	}

	// Transposes matrix
	public Matrix transpose()
	{
		Matrix MT = new Matrix(this.colCount, this.rowCount);

		for(int i=0;i<this.colCount;i++) for(int j=0;j<this.rowCount;j++) MT.arr[i][j] = this.arr[j][i];

		return MT;
	}

	// Set the matrix into its identity form
	public void setIdentityMatrix(int n)
	{
		if(this.isSquare())
		{
			this.rowCount=n;
			this.colCount=n;
			this.arr = new double[n][n];
			for(int i=0;i<this.rowCount;i++) for(int j=0;j<this.colCount;j++) this.arr[i][j]=(i==j)?1:0;
		}
		else System.out.println("Matrix is not square!");
	}

	// Multiply each element of matrix by x
	public Matrix kaliKons(double X)
	{
		Matrix MT = new Matrix(this.colCount, this.rowCount);

		for(int i=0;i<this.colCount;i++) for(int j=0;j<this.rowCount;j++) MT.arr[i][j] = this.arr[i][j] * X;

		return MT;
	}
	
	// Test wheter a row consists of all zero or not
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

	/*-----------Text Input------------*/
	public void textToMatrix(){
        Matrix matrixFile = new Matrix(101, 101);
		int x = 0, y = 0; 

		Scanner inputFile = new Scanner(System.in);
		System.out.print("Input file name for matrix : ");
		String filename = inputFile.nextLine();
		File file = new File("D:/#code/java/Linear-Algebra-Polynomial-Interpolation/input/"+filename);

		try{
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null){
				y = 0;
                String[] values = line.split(" ");
                for (String str : values){
                    double str_double = Double.parseDouble(str);
                    matrixFile.arr[x][y] = str_double;
                    //System.out.println(matrix[x][y] + " ");
                    y++;
				}
                x++;
                //System.out.println("");
			}
			matrixFile.rowCount = x;
			matrixFile.colCount = y;
            in.close();
        }
		catch(IOException ioException){};
		inputFile.close();
		//matrix.printMatrix();		
		System.out.print("Matrix have been made!");

		//taken and modified from https://www.daniweb.com/programming/software-development/threads/324267/reading-file-and-store-it-into-2d-array-and-parse-it
    }
}
