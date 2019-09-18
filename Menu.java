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

        navigationStack.push(0);
        while(!quit)
        {   
            int query;
            int stackSize = navigationStack.size();

            printMainMenu();
            query = s.nextInt();
            
            switch(query)
            {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    System.exit(0);
                    break;
            }
        }
    }

    private static void printMainMenu()
    {
        System.out.println("MENU");
        System.out.println("1. Sistem Persamaan Linear");
        System.out.println("2. Determinan");
        System.out.println("3. Matriks balikan");
        System.out.println("4. Matriks kofaktor");
        System.out.println("5. Adjoin");
        System.out.println("6. Interpolasi polinom");
        System.out.println("7. Keluar");
    }
}