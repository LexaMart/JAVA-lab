package lab_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("How many things you suppose to eat ");
        int arraySize =in.nextInt();
        Food[] breakfast = new Food[arraySize];
        for (int i = 0; i < arraySize;) {
            System.out.println("Food Name:  ");
            String foodName = in.next();
            switch (foodName) {
                case ("milk"):
                    System.out.println("Milk name:  ");
                    String name = in.next();
                    System.out.println("Milk fat:  ");
                    int fat = in.nextInt();
                    breakfast[i] = new Milk(fat, name);
                    i++;
                    break;
                case ("apple"):
                    System.out.println("Apple size:  ");
                    String size = in.next();
                    breakfast[i] = new Apple(size);
                    i++;
                    break;
                case ("cheese"):
                    breakfast[i] = new Cheese();
                    i++;
                    break;
                default:
                    System.out.println("smth wrong, try pass the name again");
                    break;
            }
        }
        for(String arg : args) {
            System.out.println(arg);
            switch (arg) {
                case "-sort":
                  Comparator.sort(breakfast);
                  break;
                case "-calories":
                    getAllCalories(breakfast);
                    break;
                default:
                    break;

            }
        }
        System.out.println("Consuming....");
        for (Food arg: breakfast) {
            arg.consume();
        }
    }
    private static void getAllCalories (Food[] array) {
        int calories = 0;
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i].getFoodName() + " " + array[i].calculateCalories() );
            calories += array[i].calculateCalories();
        }
        System.out.println("This breakfast has: " + calories + " calories");
    }
}
