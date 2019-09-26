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
		this.arr = M.arr;
		this.rowCount = M.rowCount;
		this.colCount = M.colCount;
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

	// Inverse SPL Output Procedure
	public void printInverseSPL()
	{
		System.out.println("\nThe Solution is/are : ");
		for(int i=0; i<this.rowCount;i++)
		{	 
			System.out.println("X"+(i+1)+" = "+ this.arr[i][0]);
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
		else System.out.println("Matriks tidak berbentuk persegi.");
	}

	// Multiply each element of matrix by x
	public Matrix kaliKons(double X)
	{
		Matrix MT = new Matrix(this.rowCount, this.colCount);

		for(int i=0;i<this.colCount;i++) for(int j=0;j<this.rowCount;j++) MT.arr[i][j] = this.arr[i][j] * X;

		return MT;
	}

	// Multiply Matrix A with Matrix B
	public Matrix kaliMatrix(Matrix A, Matrix B)
	{
		int i,j, k=1;
		double count;
		Matrix C = new Matrix(A.rowCount, B.colCount);

		if(B.rowCount==A.colCount)
		{
			for(i=0; i<C.rowCount; i++)
			{
				for(j=0; j<C.colCount; j++)
				{
					count = 0;
					for(k=0; k<A.colCount; k++) count += A.arr[i][k] * B.arr[k][j];
					C.arr[i][j] = count;
				}
			}
		}

		return C;

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
	// Read .txt file into matrix
	public void textToMatrix() throws Exception {
        Matrix matrixFile = new Matrix(101, 101);
		int x = 0, y = 0;
		String filenameMatrix = " ";

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Input file name for matrix : ");
		filenameMatrix = reader.readLine();
		File file = new File(new File("./tests/"+filenameMatrix).getCanonicalPath());
		BufferedReader br = null;

		try{
			br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null){
				y = 0;
                String[] values = line.split(" ");
                for (String str : values){
                    double str_double = Double.parseDouble(str);
                    matrixFile.arr[x][y] = str_double;
                    y++;
				}
                x++;
			}
			matrixFile.rowCount = x;
			matrixFile.colCount = y;
			System.out.println("Matrix has been made!");
        }
		catch(Exception Exception){
			System.out.println("File not found!");
		}
		
		this.rowCount = matrixFile.rowCount;
		this.colCount = matrixFile.colCount;
		this.arr = new double[this.rowCount][this.colCount];
		for (int i = 0; i < matrixFile.rowCount; i++){
			for (int j = 0; j < matrixFile.colCount; j++){
				this.arr[i][j] = matrixFile.arr[i][j];
			}
		}
		//taken and modified from https://www.daniweb.com/programming/software-development/threads/324267/reading-file-and-store-it-into-2d-array-and-parse-it
	}
	
	// Deepcopy procedure for matrix
	public void deepCopy(Matrix matIn){
		this.rowCount = matIn.rowCount;
		this.colCount = matIn.colCount;
		this.arr = new double[this.rowCount][this.colCount];
		for (int i = 0; i < matIn.rowCount; i++){
			for (int j = 0; j < matIn.colCount; j++){
				this.arr[i][j] = matIn.arr[i][j];
			}
		}
	}
}
