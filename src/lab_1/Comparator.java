package lab_1;

import java.util.Arrays;

public class Comparator {
    public Comparator(){}
    public static Food[] sort (Food[] array) {
        for (int i = 0; i < array.length; i++) {
            Food min = array[i];
            int minId = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j].getFoodName().length() < min.getFoodName().length()) {
                    min = array[j];
                    minId = j;
                }
            }
            // замена
            Food temp = array[i];
            array[i] = min;
            array[minId] = temp;
        }
        System.out.println("Sorted breakfast:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i].getFoodName() + ", ");
        }
        System.out.println("");
        return array;
    }


}
