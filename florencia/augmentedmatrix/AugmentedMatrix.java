package florencia.augmentedmatrix;

import java.util.Scanner;
import florencia.matrix.*;

public class AugmentedMatrix
{
    private Scanner s = new Scanner(System.in);
    Matrix leftMatrix;
    Matrix rightMatrix;

    /*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= CONSTRUCTOR -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
    // Creates a new Augmented Matrix
    public AugmentedMatrix(Matrix m1, Matrix m2)
    {
        leftMatrix = m1;
        rightMatrix = m2;
    }
    
    // Create a copy of an augmented Matrix
    public AugmentedMatrix(AugmentedMatrix augMat)
    {
        leftMatrix = augMat.leftMatrix;
        rightMatrix = augMat.rightMatrix;
    }
    
    /*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= SELECTOR -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-*/
    // Returns left side matrix
    public Matrix getLeftMatrix()
    {
        return this.leftMatrix;
    }

    // Returns right side matrix
    public Matrix getRightMatrix()
    {
        return this.rightMatrix;
    }

    /*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= INPUT OUTPUT PROCEDURE -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-*/
    
    public void inputLinearEquation()
    {
        for(int i=0;i<this.leftMatrix.rowCount;i++)
        {
            for(int j=0;j<this.leftMatrix.colCount;j++) this.leftMatrix.arr[i][j]=s.nextDouble();
            for(int j=0;j<this.rightMatrix.colCount;j++) this.rightMatrix.arr[i][j]=s.nextDouble();
        }
    }

    public void printAugmentedMatrix()
    {
        for(int i=0;i<this.leftMatrix.rowCount;i++)
        {
            for(int j=0;j<this.leftMatrix.colCount;j++) System.out.print(this.getLeftMatrix().arr[i][j]+"\t");
            System.out.print("|\t");
            for(int j=0;j<this.rightMatrix.colCount;j++) System.out.print(this.getRightMatrix().arr[i][j]+"\t");
            System.out.println();
        }
    }

    /*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= ELEMENTARY ROW OPERATIONS (OBE) -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
    // Swaps row1 and row2 in an augmented matrix
    public void augRowSwap(int row1, int row2)
    {
        this.leftMatrix.rowSwap(row1, row2);
        this.rightMatrix.rowSwap(row1, row2);
    }
    
    // Does an arithmetic operation on two rows in an augmented matrix
    public void augRowArithmetic(int reducedRow, int reducingRow, double multiplier)
    {
        this.leftMatrix.rowArithmetic(reducedRow, reducingRow, multiplier);
        this.rightMatrix.rowArithmetic(reducedRow, reducingRow, multiplier);
    }
    
    // Multiplies one row with a constant
    public void augRowMultiplier(int multipliedRow, double multiplier)
    {
        this.leftMatrix.rowMultiplier(multipliedRow, multiplier);
        this.rightMatrix.rowMultiplier(multipliedRow, multiplier);
    }
    
    /*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= GAUSS ELIMINATION -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
    // if consistent, return 1, if inconsistent, return 2, if invalid, return 3
    // Use this function after reducing matrix.
    public int validateAugMat()
    { 
        if(this.leftMatrix.isRowZero(this.leftMatrix.rowCount-1))
        {
            if(this.rightMatrix.arr[this.leftMatrix.rowCount-1][0]==0) return 2;
            else return 3;
        }
        else return 1;
    }

    // Partial pivoting
    public int partialPivoting(int col)
    {
        int index=col;
        double currentPivot=this.leftMatrix.arr[index][col];
        for(int i=index+1;i<this.leftMatrix.rowCount;i++)
        {
            if(Math.abs(this.leftMatrix.arr[i][col])<Math.abs(currentPivot))
            {
                currentPivot=this.leftMatrix.arr[i][col];
                index=i;
            }
        }
        return index;
    }

    // Reduce augmented matrix into echelon form
    public void forwardElimination()
    {
        int rc=this.leftMatrix.rowCount,cc=this.leftMatrix.colCount;

        for(int k=0;k<cc-1;k++)
        {
            this.augRowSwap(this.partialPivoting(k),k);
            for(int i=k+1;i<rc;i++)
            {
                double multiplier = -this.leftMatrix.arr[i][k]/(this.leftMatrix.arr[k][k]);
                this.augRowArithmetic(i, k, multiplier);
                // this.printAugmentedMatrix();
                // System.out.println();
            }
            this.augRowMultiplier(k, 1/this.leftMatrix.arr[k][k]);
        }
        this.augRowMultiplier(cc-1, 1/this.leftMatrix.arr[rc-1][cc-1]);
        
    }

    // Reduce augmented matrix into reduced echelon form (if applied after forwardElimintation() method)
    public void backwardElimination()
    {
        for(int k=this.leftMatrix.colCount-1;k>=1;k--)
        {
            for(int i=k-1;i>=0;i--)
            {
                double multiplier = -this.leftMatrix.arr[i][k]/(this.leftMatrix.arr[k][k]);
                this.augRowArithmetic(i, k, multiplier);
                // this.printAugmentedMatrix();
                // System.out.println();
            }
            this.augRowMultiplier(k, 1/this.leftMatrix.arr[k][k]);
        }
        
    }

	public void gaussElimination()
	{
        this.forwardElimination();
        this.leftMatrix.fixSignedZero();
        this.rightMatrix.fixSignedZero();
    }
    
	public void gaussJordanElimination()
	{
        this.forwardElimination();
        if(this.validateAugMat()==1)
        {
            this.backwardElimination();
            this.leftMatrix.fixSignedZero();
            this.rightMatrix.fixSignedZero();
            this.printAugmentedMatrix();
        }
        else System.out.println("Invalid/Inconsistent Equation");
    
        
    }

    public Matrix inverseMatrix()
    {
        this.leftMatrix.inputMatrix();
        this.rightMatrix.setIdentityMatrix();
        this.gaussJordanElimination();
        return this.rightMatrix;
    }

    public void interpolateGraph()
    {
        int n = s.nextInt();

        Matrix mx=new Matrix(), my=new Matrix();
        mx.makeMatrix(n, n);
        my.makeMatrix(n, 1);
        AugmentedMatrix augGraph = new AugmentedMatrix(mx, my);

        for(int i=0;i<n;i++)
        {
            double x=s.nextDouble(),y=s.nextDouble();
            for(int j=0;j<n;j++)
            {
                augGraph.leftMatrix.arr[i][j] = Math.pow(x,j);
            }
            augGraph.rightMatrix.arr[i][0] = y;
        }


        augGraph.gaussJordanElimination();
        augGraph.printAugmentedMatrix();

        for(int i=0;i<n;i++) augGraph.rightMatrix.arr[i][0]=(double) Math.round(augGraph.rightMatrix.arr[i][0]*10000.0)/10000.0;

        System.out.print("f(x) approximately equal to ");
        for(int i=0;i<n;i++) 
        {
            if(i==0) System.out.print(augGraph.rightMatrix.arr[i][0] + " +");
            else if(i==n-1) System.out.print(augGraph.rightMatrix.arr[i][0] + "X^" + i);
            else System.out.print(augGraph.rightMatrix.arr[i][0] + "X^" + i + " +");
        }
        System.out.println();

        System.out.print("Input x for approximation:");
        double x=s.nextDouble();

        double result=0;
        for(int i=0;i<n;i++) result+=augGraph.rightMatrix.arr[i][0]*Math.pow(x,i);
        System.out.println("Value of f("+x+") is equal to " + result + ".");

    }

    public void convertToSolutionValid()
    {
        System.out.println("The solutions are: ");
        for(int i=0;i<this.leftMatrix.rowCount;i++) System.out.println("x" + (i+1) + " = " + this.rightMatrix.arr[i][0]);
    }
}