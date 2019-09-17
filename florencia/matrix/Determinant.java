package florencia.matrix;

public class Determinant{
    Matrix matrixAcak;

    public double DeterminantSarrus(Matrix matrixAcak){
        double det = 0, sumPlus = 0, sumMin = 0;
        if (matrixAcak.IsSquare() && matrixAcak.getRowCount() == 3){
            sumPlus = (matrixAcak.arr[0][0]*matrixAcak.arr[1][1]*matrixAcak.arr[2][2]) + (matrixAcak.arr[0][1]*matrixAcak.arr[1][2]*matrixAcak.arr[2][0]) + (matrixAcak.arr[0][2]*matrixAcak.arr[1][0]*matrixAcak.arr[2][1]);
            sumMin  = (matrixAcak.arr[2][0]*matrixAcak.arr[1][1]*matrixAcak.arr[0][2]) + (matrixAcak.arr[2][1]*matrixAcak.arr[1][2]*matrixAcak.arr[0][0]) + (matrixAcak.arr[2][2]*matrixAcak.arr[1][0]*matrixAcak.arr[0][2]);
            det = sumPlus + sumMin;
            return det;
        } else {
            System.out.print("Matrix is not valid, therefore the determinant is ");
            return det;
        }
    }

    public double DeterminantRowReduction(Matrix matrixAcak){ //using backwardElimination
        double det = 1;
        boolean checker = true;
        if (matrixAcak.IsSquare()){
            matrixAcak.normBackwardElimination();

            for (int i = 0; i < matrixAcak.colCount && checker; i++){
                if (matrixAcak.arr[i][i] == 0){
                    checker = false;
                    det = 0;
                } else {
                    det *= matrixAcak.arr[i][i];
                }
            }
        }
        return det;
    }
}