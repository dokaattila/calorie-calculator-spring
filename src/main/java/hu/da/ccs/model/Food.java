package hu.da.ccs.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Jacksonized
@Data
public class Food {

    private int foodID;
    private String foodName;
    private double foodFat;
    private double foodCarb;
    private double foodProtein;
    private double foodCalories;

    public int getFoodID() {
        return foodID;
    }

    public void setFoodID(int foodID) {
        this.foodID = foodID;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public double getFoodFat() {
        return foodFat;
    }

    public void setFoodFat(double foodFat) {
        this.foodFat = foodFat;
    }

    public double getFoodCarb() {
        return foodCarb;
    }

    public void setFoodCarb(double foodCarb) {
        this.foodCarb = foodCarb;
    }

    public double getFoodProtein() {
        return foodProtein;
    }

    public void setFoodProtein(double foodProtein) {
        this.foodProtein = foodProtein;
    }


    public void setFoodCalories(double foodCalories) {
        this.foodCalories = foodCalories;
    }
}
