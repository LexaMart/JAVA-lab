package lab_1;

public class Apple extends Food {
    private String size;

    public Apple(String size) {
        super("Apple");
        this.size = size;
    }
    public void consume() {
        System.out.println(this.getFoodName() + " has been eaten");
    }
    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }

    public boolean equals(Object arg0) {
        if (super.equals(arg0)) { // Шаг 1
            if (!(arg0 instanceof Apple)) return false; // Шаг 2
            return size.equals(((Apple)arg0).size); // Шаг 3
        } else
            return false;
    }

    public String toString() {
        return super.toString() + " размера '" + size.toUpperCase() + "'";
    }

    @Override
    public int calculateCalories() {
        if ( this.size.equals("small")) {
            return Item.SmallApple.calories;
        }else {
            return Item.BigApple.calories;
        }
    }
}
