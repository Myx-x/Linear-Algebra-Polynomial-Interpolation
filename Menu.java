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
                if(navigationStack.peek() == 1){
                    subMenu1();
                    query = s.nextInt();
                    navigationStack.push(query + navigationStack.peek() * 10);
                }else if (navigationStack.peek() == 2){
                    subMenu2();
                    query = s.nextInt();
                    navigationStack.push(query + navigationStack.peek() * 10);
                }else if (navigationStack.peek() == 3){
                    subMenu3();
                    query = s.nextInt();
                    navigationStack.push(query + navigationStack.peek() * 10);
                }else if (navigationStack.peek() == 4){
                    navigationStack.pop();
                }else if (navigationStack.peek() == 5){
                    navigationStack.pop();
                }else if (navigationStack.peek() == 6){
                    navigationStack.pop();
                }else if (navigationStack.peek() == 7){
                    quit = true;
                }
            }else if (stackSize == 3){
                if (navigationStack.peek() == 11){
                    System.out.println("floren");
                    navigationStack.pop();
                }else if (navigationStack.peek() == 12){
                    System.out.println("fritz");
                    navigationStack.pop();
                }else if (navigationStack.peek() == 13){
                    System.out.println("CIBAY");
                    navigationStack.pop();
                }else if (navigationStack.peek() == 14){
                    navigationStack.pop();
                }else if (navigationStack.peek() == 15){
                    navigationStack.pop();
                    navigationStack.pop();
                }else if (navigationStack.peek() == 21){
                    Matrix MT = new Matrix();
                    double hasil;
                    MT.inputMatrix();
                    Determinant det = new Determinant(MT);
                    hasil = det.determinantRowReduction();
                    System.out.println(hasil);
                    navigationStack.pop();
                }else if (navigationStack.peek() == 22){
                    Matrix MT = new Matrix();
                    double hasil;
                    MT.inputMatrix();
                    Determinant det = new Determinant(MT);
                    hasil = det.determinantSarrus();
                    System.out.println(hasil);
                    navigationStack.pop();
                }else if (navigationStack.peek() == 23){
                    Matrix MT = new Matrix();
                    double hasil;
                    MT.inputMatrix();
                    Determinant det = new Determinant(MT);
                    hasil = det.determinantLaplaceExpansion();
                    System.out.println(hasil);
                    navigationStack.pop();
                }else if (navigationStack.peek() == 24){
                    navigationStack.pop();
                    navigationStack.pop();
                }else if (navigationStack.peek() == 31){
                    navigationStack.pop();
                }else if (navigationStack.peek() == 32){
                    navigationStack.pop();
                }else if (navigationStack.peek() == 33){
                    navigationStack.pop();
                    navigationStack.pop();
                }
            }
        }
    }

    private static void printMainMenu()
    {
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
        System.out.println("--- SUBMENU DETERMINAN ---");
        System.out.println("1. Metode OBE");
        System.out.println("2. Metode Sarrus");
        System.out.println("3. Metode Kofaktor");
        System.out.println("4. Kembali");
        System.out.print("Masukkan Pilihan : ");
    }

    private static void subMenu3()
    {
        System.out.println("----- SUBMENU INVERSE -----");
        System.out.println("1. Metode eliminasi Gauss");
        System.out.println("2. Metode Adjoin");
        System.out.println("3. Kembali");
        System.out.print("Masukkan Pilihan : ");
    }

    private static Matrix inputMatrix()
    {
        final Scanner s = new Scanner(System.in);
        if(s.hasNextInt())
		{
			int r=s.nextInt();
			int c=s.nextInt();
            Matrix MT = Matrix(r,c);
			for(int i=0;i<r;i++) for(int j=0;j<c;j++) MT.arr[i][j] = s.nextDouble();
			
			s.nextLine();
		}
		else return MT;
    }
}