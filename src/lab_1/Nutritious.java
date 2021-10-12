package lab_1;

public interface Nutritious {

    int calculateCalories();

    enum Item {
        Chokolate(500),
        Default(350),
        NoFat(25);


        public final int calories;

        Item(int calories) {
            this.calories = calories;
        }
    }
}
