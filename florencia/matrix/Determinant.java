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
}