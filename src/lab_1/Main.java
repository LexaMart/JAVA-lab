package lab_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("How many glasses of Milk you suppose to drink ");
        int arraySize =in.nextInt();
        Food[] brekfast = new Food[arraySize];
        for (int i = 0; i < arraySize; i++ ) {
            System.out.println("Milk name ");
            String milkName = in.next();
            System.out.println("Milk fat ");
            int fat =  in.nextInt();
            brekfast[i] = new Milk(fat, milkName);
        }
    }
}
