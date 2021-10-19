package lab_1;

public class Milk extends Food {
    private int fat;
    static private int glassesOfMilk = 0;

    public Milk (int fat, String milkName) {
        super(milkName + " Milk");
        this.fat = fat;
        this.glassesOfMilk += 1;
    }

    public Milk (int fat) {
        super( "Unknown Milk");
        this.fat = fat;
        this.glassesOfMilk += 1;
    }

    public String getStringFat () {
        return this.fat + "%";
    }

    static void glasses () {
        System.out.println(glassesOfMilk);
    }

    @Override
    public int calculateCalories() {
        int colories = 0;
       if (this.fat >= 6) {
           colories += Item.Chokolate.calories;
       }
       else if (this.fat < 6 && this.fat >= 2) {
           colories += Item.Default.calories;
       }else {
           colories += Item.NoFat.calories;
       }
       return colories;
    }
}
