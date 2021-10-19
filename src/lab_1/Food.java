package lab_1;

import java.util.Objects;

abstract class Food implements Consumable, Nutritious {
    private String name;

    public Food(String name) {
        this.name = name;
    };

    @Override
    public void consume() {
        System.out.println(this.name + " has been drunken");
    }

    @Override
    public boolean equals(Object FoodObj) {
        if (FoodObj instanceof Food) {
            return this.name.equals(((Food) FoodObj).name);
        }else {
            return false;
        }
    }

    public String getFoodName() {
        return this.name;
    }

}
