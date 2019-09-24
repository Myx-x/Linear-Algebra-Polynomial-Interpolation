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
                    Matrix MT = new Matrix();
                    MT.inputMatrix();
                    Determinant det = new Determinant(MT);
                    MT = det.getMatrixCofactor();
                    System.out.println("Matriks Kofaktornya :");
                    MT.printMatrix();
                    navigationStack.pop();
                    navigationStack.pop();
                }else if(navigationStack.peek() == 42){//MC dengan file
                    navigationStack.pop();
                    navigationStack.pop();
                }else if (navigationStack.peek() == 51){//Adjoin dengan keyboard
                    Matrix MT = new Matrix();
                    MT.inputMatrix();
                    Determinant det = new Determinant(MT);
                    MT = det.getAdjoint();
                    System.out.println("Adjoinnya :");
                    MT.printMatrix();
                    navigationStack.pop();
                    navigationStack.pop();
                }else if(navigationStack.peek() == 52){//Adjoin dengan file
                    navigationStack.pop();
                    navigationStack.pop();
                }else if (navigationStack.peek() == 61){//Interpolasi dengan keyboard
                    navigationStack.pop();
                    navigationStack.pop();
                }else if(navigationStack.peek() == 62){//Interpolasi dengan file
                    navigationStack.pop();
                    navigationStack.pop();    
                }
            }else if (stackSize == 4){
                if (navigationStack.peek() == 111){//Gauss dengan keyboard
                    navigationStack.pop();
                    navigationStack.pop();
                }else if (navigationStack.peek() == 112){//Gauss dengan file
                    navigationStack.pop();
                    navigationStack.pop();
                }else if (navigationStack.peek() == 121){//Gauss-Jordan dengan keyboard
                    navigationStack.pop();
                    navigationStack.pop();
                }else if (navigationStack.peek() == 122){//Gauss-Jordan dengan file
                    navigationStack.pop();
                    navigationStack.pop();
                }else if (navigationStack.peek() == 131){//Matrix Balikan dengan keyboard
                    navigationStack.pop();
                    navigationStack.pop();
                }else if (navigationStack.peek() == 132){//Matrix Balikan dengan file
                    navigationStack.pop();
                    navigationStack.pop();
                }else if (navigationStack.peek() == 141){//Cramer dengan keyboard
                    navigationStack.pop();
                    navigationStack.pop();
                }else if (navigationStack.peek() == 142){//Cramer dengan file
                    navigationStack.pop();
                    navigationStack.pop();
                }else if (navigationStack.peek() == 211){//Determinan OBE dengan keyboard
                    Matrix MT = new Matrix();
                    MT.inputMatrix();
                    double hasil;
                    Determinant det = new Determinant(MT);
                    hasil = det.determinantRowReduction();
                    System.out.println("Determinannya :");
                    System.out.println(hasil);
                    navigationStack.pop();
                    navigationStack.pop();
                }else if (navigationStack.peek() == 212){//Determinan OBE dengan file
                    navigationStack.pop();
                    navigationStack.pop();
                }else if (navigationStack.peek() == 221){//Determinan Sarrus dengan keyboard
                    System.out.println("Masukkan hanya dapat Matriks 3 x 3");
                    Matrix MT = new Matrix();
                    MT.inputMatrix();
                    double hasil;
                    Determinant det = new Determinant(MT);
                    hasil = det.determinantSarrus();
                    System.out.println("Determinannya :");
                    System.out.println(hasil);
                    navigationStack.pop();
                    navigationStack.pop();
                }else if (navigationStack.peek() == 222){//Determinan Sarrus dengan file
                    navigationStack.pop();
                    navigationStack.pop();
                }else if (navigationStack.peek() == 231){//Determinan Kofaktor dengan keyboard
                    Matrix MT = new Matrix();
                    MT.inputMatrix();
                    double hasil;
                    Determinant det = new Determinant(MT);
                    hasil = det.determinantLaplaceExpansion();
                    System.out.println("Determinannya :");
                    System.out.println(hasil);
                    navigationStack.pop();
                    navigationStack.pop();
                }else if (navigationStack.peek() == 232){//Determinan Kofaktor dengan file
                    navigationStack.pop();
                    navigationStack.pop();
                }else if (navigationStack.peek() == 311){//Inverse Gauss dengan Keyboard
                    Matrix MT = new Matrix();
                    MT.inputMatrix();
                    Determinant det = new Determinant(MT);
                    MT = det.inverseGaussJordan();
                    System.out.println("Matriks Balikannya :");
                    MT.printMatrix();
                    navigationStack.pop();
                    navigationStack.pop();
                }else if (navigationStack.peek() == 312){//Inverse Gauss dengan file
                    navigationStack.pop();
                    navigationStack.pop();
                }else if (navigationStack.peek() == 321){//Inverse Adjoin dengan Keyboard
                    Matrix MT = new Matrix();
                    MT.inputMatrix();
                    Determinant det = new Determinant(MT);
                    MT = det.inverseAdjoint();
                    System.out.println("Matriks Balikannya :");
                    MT.printMatrix();
                    navigationStack.pop();
                    navigationStack.pop();
                }else if (navigationStack.peek() == 322){//Inverse Adjoin dengan file
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
    
}