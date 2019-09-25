import florencia.matrix.*;
import florencia.augmentedmatrix.*;
import java.util.Scanner;
import java.util.Stack;

public class Menu
{  
    public static void main(String args[])
    {
        Stack<Integer> navigationStack = new Stack<Integer>();
        final Scanner s = new Scanner(System.in);
        boolean quit=false;
        Matrix MT = new Matrix();
        double hasil;
        int query;
        
        printMainMenu();
        navigationStack.push(0);

        query = s.nextInt();
        navigationStack.push(navigationStack.peek()*10+query);

        while(!quit)
        {   
            int stackSize = navigationStack.size();
            if (stackSize == 1 ){
                printMainMenu();
                query = s.nextInt();
                navigationStack.push(navigationStack.peek()*10+query);    
            }else if (stackSize == 2){
                if(navigationStack.peek() == 1){// SPL
                    subMenu1();
                    query = s.nextInt();
                    navigationStack.push(query + navigationStack.peek() * 10);
                }else if (navigationStack.peek() == 2){// Determinan
                    subMenu2();
                    query = s.nextInt();
                    navigationStack.push(query + navigationStack.peek() * 10);
                }else if (navigationStack.peek() == 3){ //Matrix Inverse
                    subMenu3();
                    query = s.nextInt();
                    navigationStack.push(query + navigationStack.peek() * 10);
                }else if (navigationStack.peek() == 4){ //Matrix Cofactor
                   optionMenu();
                   query = s.nextInt();
                   navigationStack.push(query + navigationStack.peek() * 10);
                }else if (navigationStack.peek() == 5){ //Matrix Adjoin
                    optionMenu();
                    query = s.nextInt();
                    navigationStack.push(query + navigationStack.peek() * 10);
                }else if (navigationStack.peek() == 6){ //Interpolasi
                    optionMenu();
                    query = s.nextInt();
                    navigationStack.push(query + navigationStack.peek() * 10);
                }else if (navigationStack.peek() == 7){ // Keluar
                    quit = true;
                }
            }else if (stackSize == 3){
                if (navigationStack.peek() == 11){//Gauss
                    optionMenu();
                    query = s.nextInt();
                    navigationStack.push(query + navigationStack.peek() * 10);
                }else if (navigationStack.peek() == 12){//Gauss-Jordan
                    optionMenu();
                    query = s.nextInt();
                    navigationStack.push(query + navigationStack.peek() * 10);
                }else if (navigationStack.peek() == 13){//Matrix balikan
                    optionMenu();
                    query = s.nextInt();
                    navigationStack.push(query + navigationStack.peek() * 10);
                }else if (navigationStack.peek() == 14){//Cramer
                    optionMenu();
                    query = s.nextInt();
                    navigationStack.push(query + navigationStack.peek() * 10);
                }else if (navigationStack.peek() == 15){ // Kembali
                    navigationStack.pop();
                    navigationStack.pop();
                }else if (navigationStack.peek() == 21){//Determinan OBE
                    optionMenu();
                    query = s.nextInt();
                    navigationStack.push(query + navigationStack.peek() * 10);
                }else if (navigationStack.peek() == 22){//Determinan Sarrus
                    optionMenu();
                    query = s.nextInt();
                    navigationStack.push(query + navigationStack.peek() * 10);
                }else if (navigationStack.peek() == 23){//Determinan Kofaktor
                    optionMenu();
                    query = s.nextInt();
                    navigationStack.push(query + navigationStack.peek() * 10);
                }else if (navigationStack.peek() == 24){//Kembali
                    navigationStack.pop();
                    navigationStack.pop();
                }else if (navigationStack.peek() == 31){//Inverse Gauss
                    optionMenu();
                    query = s.nextInt();
                    navigationStack.push(query + navigationStack.peek() * 10);
                }else if (navigationStack.peek() == 32){//Inverse Adjoin
                    optionMenu();
                    query = s.nextInt();
                    navigationStack.push(query + navigationStack.peek() * 10);
                }else if (navigationStack.peek() == 33){ // Kembali
                    navigationStack.pop();
                    navigationStack.pop();
                }else if (navigationStack.peek() == 41){//MC dengan keyboard
                    MT.inputMatrix();
                    Determinant det = new Determinant(MT);
                    MT = det.getMatrixCofactor();
                    optionOutput();
                    query = s.nextInt();
                    navigationStack.push(query + navigationStack.peek() * 10);
                }else if(navigationStack.peek() == 42){//MC dengan file
                    //input file ke matriks
                    Determinant det = new Determinant(MT);
                    MT = det.getMatrixCofactor();
                    optionOutput();
                    query = s.nextInt();
                    navigationStack.push(query + navigationStack.peek() * 10);
                }else if (navigationStack.peek() == 51){//Adjoin dengan keyboard
                    MT.inputMatrix();
                    Determinant det = new Determinant(MT);
                    MT = det.getAdjoint();
                    optionOutput();
                    query = s.nextInt();
                    navigationStack.push(query + navigationStack.peek() * 10);
                }else if(navigationStack.peek() == 52){//Adjoin dengan file
                    //input file ke matriks MT
                    Determinant det = new Determinant(MT);
                    MT = det.getAdjoint();
                    optionOutput();
                    query = s.nextInt();
                    navigationStack.push(query + navigationStack.peek() * 10);
                }else if (navigationStack.peek() == 61){//Interpolasi dengan keyboard
                    //input matriks MT dari keyboard
                    optionOutput();
                    query = s.nextInt();
                    navigationStack.push(query + navigationStack.peek() * 10);
                }else if(navigationStack.peek() == 62){//Interpolasi dengan file
                    //input file ke matriks MT
                    optionOutput();
                    query = s.nextInt();
                    navigationStack.push(query + navigationStack.peek() * 10);    
                }
            }else if (stackSize == 4){
                if (navigationStack.peek() == 111){//Gauss dengan keyboard
                    //input Augmented
                    optionOutput();
                    query = s.nextInt();
                    navigationStack.push(query + navigationStack.peek() * 10);
                }else if (navigationStack.peek() == 112){//Gauss dengan file
                    //input file ke Augmented
                    optionOutput();
                    query = s.nextInt();
                    navigationStack.push(query + navigationStack.peek() * 10);
                }else if (navigationStack.peek() == 121){//Gauss-Jordan dengan keyboard
                    //input Augmented
                    optionOutput();
                    query = s.nextInt();
                    navigationStack.push(query + navigationStack.peek() * 10);
                }else if (navigationStack.peek() == 122){//Gauss-Jordan dengan file
                    //input file ke Augmented
                    optionOutput();
                    query = s.nextInt();
                    navigationStack.push(query + navigationStack.peek() * 10);
                }else if (navigationStack.peek() == 131){//Matrix Balikan dengan keyboard
                    //input Augmented
                    optionOutput();
                    query = s.nextInt();
                    navigationStack.push(query + navigationStack.peek() * 10);
                }else if (navigationStack.peek() == 132){//Matrix Balikan dengan file
                    //input file ke Augmented
                    optionOutput();
                    query = s.nextInt();
                    navigationStack.push(query + navigationStack.peek() * 10);
                }else if (navigationStack.peek() == 141){//Cramer dengan keyboard
                    //input Augmented
                    optionOutput();
                    query = s.nextInt();
                    navigationStack.push(query + navigationStack.peek() * 10);
                }else if (navigationStack.peek() == 142){//Cramer dengan file
                    //input file ke Augmented
                    optionOutput();
                    query = s.nextInt();
                    navigationStack.push(query + navigationStack.peek() * 10);
                }else if (navigationStack.peek() == 211){//Determinan OBE dengan keyboard
                    MT.inputMatrix();
                    Determinant det = new Determinant(MT);
                    hasil = det.determinantRowReduction();
                    optionOutput();
                    query = s.nextInt();
                    navigationStack.push(query + navigationStack.peek() * 10);
                }else if (navigationStack.peek() == 212){//Determinan OBE dengan file
                    //input file ke Matriks MT
                    Determinant det = new Determinant(MT);
                    hasil = det.determinantRowReduction();
                    optionOutput();
                    query = s.nextInt();
                    navigationStack.push(query + navigationStack.peek() * 10);
                }else if (navigationStack.peek() == 221){//Determinan Sarrus dengan keyboard
                    System.out.println("Masukkan hanya dapat Matriks 3 x 3");
                    MT.inputMatrix();
                    Determinant det = new Determinant(MT);
                    hasil = det.determinantSarrus();
                    optionOutput();
                    query = s.nextInt();
                    navigationStack.push(query + navigationStack.peek() * 10);
                }else if (navigationStack.peek() == 222){//Determinan Sarrus dengan file
                    //input file ke Matriks MT
                    Determinant det = new Determinant(MT);
                    hasil = det.determinantSarrus();
                    optionOutput();
                    query = s.nextInt();
                    navigationStack.push(query + navigationStack.peek() * 10);
                }else if (navigationStack.peek() == 231){//Determinan Kofaktor dengan keyboard
                    MT.inputMatrix();
                    Determinant det = new Determinant(MT);
                    hasil = det.determinantLaplaceExpansion();
                    optionOutput();
                    query = s.nextInt();
                    navigationStack.push(query + navigationStack.peek() * 10);
                }else if (navigationStack.peek() == 232){//Determinan Kofaktor dengan file
                    //input file ke Matriks MT
                    Determinant det = new Determinant(MT);
                    hasil = det.determinantLaplaceExpansion();
                    optionOutput();
                    query = s.nextInt();
                    navigationStack.push(query + navigationStack.peek() * 10);
                }else if (navigationStack.peek() == 311){//Inverse Gauss dengan Keyboard
                    MT.inputMatrix();
                    Determinant det = new Determinant(MT);
                    MT = det.inverseGaussJordan();
                    optionOutput();
                    query = s.nextInt();
                    navigationStack.push(query + navigationStack.peek() * 10);
                }else if (navigationStack.peek() == 312){//Inverse Gauss dengan file
                    //input file ke Matriks MT
                    Determinant det = new Determinant(MT);
                    MT = det.inverseGaussJordan();
                    optionOutput();
                    query = s.nextInt();
                    navigationStack.push(query + navigationStack.peek() * 10);
                }else if (navigationStack.peek() == 321){//Inverse Adjoin dengan Keyboard
                    MT.inputMatrix();
                    Determinant det = new Determinant(MT);
                    MT = det.inverseAdjoint();
                    optionOutput();
                    query = s.nextInt();
                    navigationStack.push(query + navigationStack.peek() * 10);
                }else if (navigationStack.peek() == 322){//Inverse Adjoin dengan file
                    //input file ke Matriks MT
                    Determinant det = new Determinant(MT);
                    MT = det.inverseAdjoint();
                    optionOutput();
                    query = s.nextInt();
                    navigationStack.push(query + navigationStack.peek() * 10);
                }else if ((navigationStack.peek() == 411)||(navigationStack.peek() == 421)){//MC output di layar
                    System.out.println("Matriks Kofaktornya :");
                    MT.printMatrix();
                    navigationStack.pop();
                    navigationStack.pop();
                    navigationStack.pop();
                }else if ((navigationStack.peek() == 412)||(navigationStack.peek() == 422)){//MC output di file
                    //output ke file
                    navigationStack.pop();
                    navigationStack.pop();
                    navigationStack.pop();
                }else if ((navigationStack.peek() == 511)||(navigationStack.peek() == 521)){//Adjoin output di layar
                    System.out.println("Adjoinnya :");
                    MT.printMatrix();
                    navigationStack.pop();
                    navigationStack.pop();
                    navigationStack.pop();
                }else if ((navigationStack.peek() == 512)||(navigationStack.peek() == 522)){//Adjoin output di file
                    //output ke file
                    navigationStack.pop();
                    navigationStack.pop();
                    navigationStack.pop();
                }else if ((navigationStack.peek() == 611)||(navigationStack.peek() == 621)){//Interpolasi output di layar
                    navigationStack.pop();
                    navigationStack.pop();
                    navigationStack.pop();
                }else if ((navigationStack.peek() == 612)||(navigationStack.peek() == 622)){//Interpolasi keyboard output di file
                    //output ke file
                    navigationStack.pop();
                    navigationStack.pop();
                    navigationStack.pop();
                }

            }else if (stackSize == 5){
                if ((navigationStack.peek() < 2000)&&(navigationStack.peek() % 2 == 1)){//SPL output di layar
                    navigationStack.pop();
                    navigationStack.pop();
                    navigationStack.pop();
                }else if ((navigationStack.peek() < 2000)&&(navigationStack.peek() % 2 == 0)){//SPL output di file
                    //output ke file
                    navigationStack.pop();
                    navigationStack.pop();
                    navigationStack.pop();
                }else if ((navigationStack.peek() > 2000)&&(navigationStack.peek() < 3000)&&(navigationStack.peek() % 2 == 1)){//Determinant output di layar
                    System.out.println("Determinannya :");
                    System.out.println();
                    navigationStack.pop();
                    navigationStack.pop();
                    navigationStack.pop();
                }else if ((navigationStack.peek() > 2000)&&(navigationStack.peek() < 3000)&&(navigationStack.peek() % 2 == 0)){//Determinant outpur di file
                    //output ke file
                    navigationStack.pop();
                    navigationStack.pop();
                    navigationStack.pop();
                }else if ((navigationStack.peek() > 3000)&&(navigationStack.peek() % 2 == 1)){//Inverse output di layar
                    System.out.println("Matriks Balikannya :");
                    MT.printMatrix();
                    navigationStack.pop();
                    navigationStack.pop();
                    navigationStack.pop();
                }else if ((navigationStack.peek() > 3000)&&(navigationStack.peek() % 2 == 0)){//Inverse output di file
                    //output ke file
                    navigationStack.pop();
                    navigationStack.pop();
                    navigationStack.pop();
                }
            }   
        }
    }

    private static void printMainMenu()
    {
        System.out.println(" ");
        System.out.println("---------- MENU ----------");
        System.out.println("1. Sistem Persamaan Linear");
        System.out.println("2. Determinan");
        System.out.println("3. Matriks balikan");
        System.out.println("4. Matriks kofaktor");
        System.out.println("5. Adjoin");
        System.out.println("6. Interpolasi polinom");
        System.out.println("7. Keluar");
        System.out.print("Masukkan Pilihan : ");
    }

    private static void subMenu1()
    {
        System.out.println(" ");
        System.out.println("--------- SUBMENU SPL ---------"); 
        System.out.println("1. Metode eliminasi Gauss");
        System.out.println("2. Metode eleminasi Gauss-Jordan");
        System.out.println("3. Metode matriks balikan");
        System.out.println("4. Kaidah cramer");
        System.out.println("5. Kembali");
        System.out.print("Masukkan Pilihan : ");
    }

    private static void subMenu2()
    {
        System.out.println(" ");
        System.out.println("--- SUBMENU DETERMINAN ---");
        System.out.println("1. Metode OBE");
        System.out.println("2. Metode Sarrus");
        System.out.println("3. Metode Kofaktor");
        System.out.println("4. Kembali");
        System.out.print("Masukkan Pilihan : ");
    }

    private static void subMenu3()
    {
        System.out.println(" ");
        System.out.println("----- SUBMENU INVERSE -----");
        System.out.println("1. Metode eliminasi Gauss");
        System.out.println("2. Metode Adjoin");
        System.out.println("3. Kembali");
        System.out.print("Masukkan Pilihan : ");
    }

    private static void optionMenu()
    {
        System.out.println("1. Inputan dengan keyboard");
        System.out.println("2. Inputan File");
        System.out.print("Masukkan Pilihan : ");
    }

    private static void optionOutput()
    {
        System.out.println("1. Output di layar");
        System.out.println("2. Output di file");
        System.out.print("Masukkan Pilihan : ");
    }
    
}