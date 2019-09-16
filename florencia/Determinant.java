package florencia;

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

    public void normRowArithmetic(int reducedRow, int reducingRow, double multiplier){
        for(int i=0;i<matrixAcak.colCount;i++) matrixAcak.arr[reducedRow][i]=matrixAcak.arr[reducedRow][i] + multiplier*matrixAcak.arr[reducingRow][i];
    }

    public void normRowMultiplier(int multipliedRow, double multiplier){
        for(int i=0;i<matrixAcak.colCount;i++) matrixAcak.arr[multipliedRow][i]*=multiplier;
    }

    public void normBackwardElimination(){
        for (int k = matrixAcak.colCount - 1; k >= 1; k--){
            for (int i = k - 1; i >= 0; i--){
                System.out.println(matrixAcak.arr[i][k] + " " + matrixAcak.arr[k][k]);
                double multiplier = -matrixAcak.arr[i][k]/(matrixAcak.arr[k][k]);
                matrixAcak.normRowArithmetic(i, k, multiplier);
                matrixAcak.printAugmentedMatrix();
                System.out.println();
            }
            matrixAcak.normRowMultiplier(k, 1/matrixAcak.arr[k][k]);
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

    public double DeterminantCofactor(Matrix matrixAcak){
        double det;
        if (matrixAcak.colCount == 2){
            
        }


        for (int x = 0; x < matrixAcak.colCount; x++){

        }
    }
}