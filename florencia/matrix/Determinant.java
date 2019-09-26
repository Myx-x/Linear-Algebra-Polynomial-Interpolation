package florencia.matrix;

import java.lang.Math;
import java.io.*;

import florencia.augmentedmatrix.AugmentedMatrix;

public class Determinant
{
    public Matrix mat;

    /*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= CONSTRUCTOR -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
    // Create an empty Determinant Object
    public Determinant(){
        mat = new Matrix();
    }
    
    // Create a determinant object from Matrix m
    public Determinant(Matrix m)
    {
        this.mat = m;
    }
    
    /*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= DETERMINANT CALCULATION -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
    // Calculate determinant using row reduction method
    public double determinantRowReduction()
    {
        double det = 1;
        boolean checker = true;
        if (this.mat.isSquare()){
            this.mat.normBackwardElimination();
            for (int i = 0; i < this.mat.colCount && checker; i++){
                if (this.mat.arr[i][i] == 0){
                    checker = false;
                    det = 0;
                } else {
                    det *= this.mat.arr[i][i];
                }
            }
            return det;
        } else {
            System.out.print("Tolong masukkan matriks yang merupakan matriks persegi.");
            return -99999;
        }
    }
    
    // Calculate the determinant of a 3x3 matrix
    public double determinantSarrus()
    {
        double det = 0, sumPlus = 0, sumMin = 0;
        if (this.mat.isSquare() && this.mat.getRowCount() == 3){
            sumPlus = (this.mat.arr[0][0]*this.mat.arr[1][1]*this.mat.arr[2][2]) + (this.mat.arr[0][1]*this.mat.arr[1][2]*this.mat.arr[2][0]) + (this.mat.arr[0][2]*this.mat.arr[1][0]*this.mat.arr[2][1]);
            sumMin  = (this.mat.arr[2][0]*this.mat.arr[1][1]*this.mat.arr[0][2]) + (this.mat.arr[2][1]*this.mat.arr[1][2]*this.mat.arr[0][0]) + (this.mat.arr[2][2]*this.mat.arr[1][0]*this.mat.arr[0][1]);
            det = sumPlus - sumMin;
            return det;
        } else {
            System.out.println("Tolong masukkan matriks yang berukuran 3x3.");
            return -99999;
        }
    }
    
    // Calculate the determinant of a matrix using Laplace Expansion Method
    public double determinantLaplaceExpansion()
    {
        double det = 0;
        Determinant matCo = new Determinant(this.mat);
        
        if (this.mat.isSquare()){
            for (int j = 0; j < this.mat.colCount; j++){
                det += (this.mat.arr[0][j] * matCo.getCofactor(0, j));
            }
            return det;
        } else {
            System.out.print("Tolong masukkan matriks persegi.");
            return -99999;
        }
    }
    
    /*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= INVERSE RELATED FUNCTIONS -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
    // Get the minor of entry of the matrix
    public Matrix getminorEntry(int i, int j)
    {
        int row, col;
        Matrix MT = new Matrix(this.mat.rowCount-1, this.mat.colCount-1);
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

    // Get the cofactor of the matrix
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

    // Get the cofactor Matrix
    public Matrix getMatrixCofactor()
    {
        Matrix MT = new Matrix(this.mat.colCount, this.mat.rowCount);
        for(int i=0;i<this.mat.rowCount;i++)
        {
            for(int j=0;j<this.mat.colCount;j++)
            {
                MT.arr[i][j] = this.getCofactor(i,j);
            }
        }
        return MT;
    }

    // Get the adjoint of a matrix
    public Matrix getAdjoint()
    {
        Matrix MT = new Matrix(this.mat.colCount, this.mat.rowCount);
        MT = this.getMatrixCofactor();
        MT = MT.transpose();
        return MT;
    }

    // Get the inverse of a matrix using adjoint
    public Matrix inverseAdjoint()
    {
        Matrix MT = new Matrix(this.mat.colCount, this.mat.rowCount);
        MT = this.getAdjoint();
        double x= (double)1/this.determinantRowReduction();
        MT = MT.kaliKons(x);
        return MT;
    }

    // Get the inverse of a matrix using Elementary Row Operations/Gauss Jordan Method
    public Matrix inverseGaussJordan()
    {
        AugmentedMatrix aug = new AugmentedMatrix();
        aug.leftMatrix = mat;
        aug.rightMatrix.setIdentityMatrix(mat.rowCount);
        aug.gaussJordanElimination();
        return aug.rightMatrix;
    }

    // Write augmented matrix to .txt file
    public void DetToText(double value) throws Exception{
        String detFilename = " ";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Masukkan nama file yang akan dijadikan output : ");
        detFilename = reader.readLine();
        StringBuilder builder = new StringBuilder();
        builder.append(value);
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("./output/"+detFilename).getCanonicalPath()));
        writer.write(builder.toString());
		writer.close();
		System.out.println("File "+detFilename+" terletak di folder 'output'");
    }
}