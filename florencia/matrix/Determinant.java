package florencia.matrix;

public class Determinant
{
    Matrix mat;
    public Determinant(Matrix m)
    {
        this.mat = m;
    }

    public double determinantRowReduction()
    {
        double result=0;
        return result;
    }
    
    public double determinantSarrus()
    {
        double result=0;
        return result;
    }
    
    public double determinantLaplaceExpansion()
    {
        double result=0;
        return result;
    }

    public Matrix getminorEntry(int i, int j)
    {
        int row, col;
        Matrix MT = new Matrix();
        MT.makeMatrix(this.mat.rowCount-1, this.mat.colCount-1);
        row = 0;
        for(int k=0;k<this.mat.rowCount;k++)
        {
            col = 0; 
            for(int l=0;l<this.mat.colCount;l++)
            { 
                if((k != i)&&(l != j))
                {
                    MT.arr[row][col] = this.mat.arr[k][l];
                    col ++;
                }    
            }
            if(k != i) row ++;
        }
        return MT;
    } 

    public double getCofactor(int i, int j)
    {
        double result, det;
        Matrix MT;
        MT = this.getminorEntry(i,j);
        
        Determinant d = new Determinant(MT);
        det = d.determinantRowReduction();
        result = det * Math.pow(-1,(i+j));
        return result;
    }

    public Matrix getMatrixCofactor()
    {
        Matrix MT = new Matrix();
		MT.makeMatrix(this.mat.colCount, this.mat.rowCount);
        for(int i=0;i<this.mat.rowCount;i++)
        {
            for(int j=0;j<this.mat.colCount;j++)
            {
                MT.arr[i][j] = this.getCofactor(i,j);
            }
        }
        return MT;
    }

    public Matrix getAdjoint()
    {
        Matrix MT;
        MT = this.getMatrixCofactor();
        MT = MT.transpose();
        return MT;
    }
}