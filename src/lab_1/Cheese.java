package lab_1;

public class Cheese extends Food {
    public Cheese() {
        super("cheese");
    }
    public void consume() {
        System.out.println(this.getFoodName() + " has been eaten");
    }

    @Override
    public int calculateCalories() {
        return Item.Cheese.calories;
    }
}
