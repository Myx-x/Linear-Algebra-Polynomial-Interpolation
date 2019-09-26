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
        AugmentedMatrix Aug = new AugmentedMatrix();
        Matrix MT = new Matrix();
        int query;
        double hasil= -999;
        
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
                }else if (navigationStack.peek() == 7){ // Keluar
                    quit = true;
                }else if ((navigationStack.peek() >= 4)&&(navigationStack.peek() <= 6)){ //Matrix Cofactor, Matrix Adjoin, Interpolasi
                    optionInput();
                    query = s.nextInt();
                    navigationStack.push(query + navigationStack.peek() * 10);
                }else{//inputan untuk pilihan salah
                    System.out.println(navigationStack.peek() + " bukan merupakan pilihan");
                    navigationStack.pop();
                }
            }else if (stackSize == 3){
                if ((navigationStack.peek() == 15)||(navigationStack.peek() == 24)||(navigationStack.peek() == 33)){//Kembali
                    navigationStack.pop();
                    navigationStack.pop();
                }else if(navigationStack.peek() > 40){
                    if(navigationStack.peek() < 60){//input matriks for MC and Adjoin
                        if(navigationStack.peek() % 2 == 1){//input matriks dengan keyboard
                            MT.inputMatrix();    
                        }else{//input file ke matriks MT
                            //input file ke matriks MT
                        }   
                    }
                    if (navigationStack.peek() / 10 == 4){//MC 
                        Determinant det = new Determinant(MT);
                        MT = det.getMatrixCofactor();
                    }else if (navigationStack.peek() /10 == 5){//Adjoin dengan keyboard
                        Determinant det = new Determinant(MT);
                        MT = det.getAdjoint();
                    }else if (navigationStack.peek() / 10 == 6){//Interpolasi dengan keyboard
                        Aug = Aug.makeInterpolationMatrix();
                    }
                    optionOutput();
                    query = s.nextInt();
                    navigationStack.push(query + navigationStack.peek() * 10); 
                }else{//All submenu for SPL, Inverse, Determinant except kembali
                    optionInput();
                    query = s.nextInt();
                    navigationStack.push(query + navigationStack.peek() * 10);
                }

            }else if (stackSize == 4){
                if(navigationStack.peek() < 400){//Input for SPL, Inverse, Determinant
                    if(navigationStack.peek() > 200){//input matriks for Determinant and Inverse
                        if(navigationStack.peek() % 2 == 1){//input matriks dengan keyboard
                            MT.inputMatrix();    
                        }else{//input file ke matriks MT
                            //input file ke matriks MT
                        }   
                    }else{//input Augmentedmatriks for SPL
                        if(navigationStack.peek() % 2 == 1){//input augmented matriks dengan keyboard
                            Aug.inputLinearEquation();   
                        }else{//input dari file
                            //input file ke augmented matriks Aug
                        }
                    }
                    if(navigationStack.peek() / 10 == 11){//Gauss
                        Aug.gaussElimination();
                    }else if (navigationStack.peek() / 10 == 12){//Gauss-Jordan
                        Aug.gaussJordanElimination();
                    }else if (navigationStack.peek() / 10 == 13){//Matrix Balikan
                        //rumus Matriks balikan
                    }else if (navigationStack.peek() / 10 == 14){//Cramer
                       //rumus cramer
                    }else if (navigationStack.peek() / 10 == 21){//Determinan OBE 
                        Determinant det = new Determinant(MT);
                        hasil = det.determinantRowReduction();
                    }else if (navigationStack.peek() / 10 == 22){//Determinan Sarrus
                        Determinant det = new Determinant(MT);
                        hasil = det.determinantSarrus();
                    }else if (navigationStack.peek() / 10 == 23){//Determinan Kofaktor 
                        Determinant det = new Determinant(MT);
                        hasil = det.determinantLaplaceExpansion();
                    }else if (navigationStack.peek() / 10 == 31){//Inverse Gauss 
                        Determinant det = new Determinant(MT);
                        MT = det.inverseGaussJordan();
                    }else if (navigationStack.peek() / 10 == 32){//Inverse Adjoin 
                        Determinant det = new Determinant(MT);
                        MT = det.inverseAdjoint();
                    }
                    optionOutput();
                    query = s.nextInt();
                    navigationStack.push(query + navigationStack.peek() * 10); 
                }else{//output navigationStack.peek() > 400 
                    if (navigationStack.peek() < 600){//MC dan Adjoin
                        if(navigationStack.peek() % 2 == 1){//ke layar
                            MT.printMatrix();
                        }else{//ke file
                            //output matriks ke file
                        }
                    }else{//interpolasi
                        if(navigationStack.peek() % 2 == 1){//ke layar
                            Aug.convertToInterpolation(Aug);
                        }else{//ke file
                            //output persamaan interpolasi ke file
                        }
                    }
                    navigationStack.pop();
                    navigationStack.pop();
                    navigationStack.pop();
                }

            }else if (stackSize == 5){
                if (navigationStack.peek() < 2000){//SPL
                    if(navigationStack.peek() % 2 == 1){//output ke layar
                        Aug.printAugmentedMatrix();
                        Aug.gaussJordanElimination();
                        Aug.convertToSolutionInfinite();
                    }else{//output ke file 
                        //SPL ke file
                    }
                }else if((navigationStack.peek() < 3000)&&(navigationStack.peek() > 2000)){//Determinan
                    if(navigationStack.peek() % 2 == 1){//output ke layar
                        System.out.println(hasil);
                    }else{//output ke file 
                        //Determinan ke file
                    }
                }else{//Inverse
                    if(navigationStack.peek() % 2 == 1){//output ke layar
                        MT.printMatrix();
                    }else{//output ke file 
                        //Inverse ke file
                    }
                }
                navigationStack.pop();
                navigationStack.pop();
                navigationStack.pop();
            }   
        }s.close();
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

    private static void optionInput()
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