package hu.da.ccs.dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import hu.da.ccs.model.Food;
import hu.da.ccs.model.Meal;
import hu.da.ccs.model.Statistic;
import hu.da.ccs.service.ConnectionData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.lang.reflect.Type;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class MealDAOImpl implements MealDAO {

    @Autowired
    ConnectionData conn;


    @Override
    public List<Meal> getAllMeal() {
        List<Meal> mealList = new ArrayList<>();
        try {
            PreparedStatement prep = conn.getConnection().prepareStatement("SELECT * FROM foodlist ORDER BY food_name");
            ResultSet res = prep.executeQuery();
            while (res.next()) {
                mealList.add(new Meal(
                        res.getInt("id"),
                        res.getString("food_name"),
                        0
                ));
            }
            return mealList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Statistic getMealStatistic(String content) {
        List<Food> foodList = new ArrayList<>();
        Type listType = new TypeToken<ArrayList<Meal>>() {
        }.getType();
        ArrayList<Meal> mealArrayList = new Gson().fromJson(content, listType);
        int listSize = mealArrayList.size();
        for (Meal meal : mealArrayList) {
            foodList.add(getFoodFromMeal(meal.getId(), meal.getAmount()));
        }
        double sumFat = foodList.stream().map(Food::getFoodFat).reduce(Double::sum).orElse(0.0);
        double sumCal = foodList.stream().map(Food::getFoodCalories).reduce(Double::sum).orElse(0.0);
        double sumCarb = foodList.stream().map(Food::getFoodCarb).reduce(Double::sum).orElse(0.0);
        double sumProt = foodList.stream().map(Food::getFoodProtein).reduce(Double::sum).orElse(0.0);
        return new Statistic(sumCal, sumCarb, sumFat, sumProt,
                sumCal/listSize, sumCarb/listSize, sumFat/listSize, sumProt/listSize);
    }

    private Food getFoodFromMeal(int id, double amount) {
        try {
            Food myFood = new Food();
            PreparedStatement prep = conn.getConnection().prepareStatement("SELECT * FROM foodlist WHERE id = ?");
            prep.setInt(1, id);
            ResultSet res = prep.executeQuery();
            while (res.next()) {
                myFood.setFoodID(res.getInt("id"));
                myFood.setFoodName(res.getString("food_name"));
                myFood.setFoodFat((res.getDouble("food_fat") / 100) * amount);
                myFood.setFoodProtein((res.getDouble("food_protein") / 100) * amount);
                myFood.setFoodCalories((res.getDouble("food_calories") / 100) * amount);
                myFood.setFoodCarb((res.getDouble("food_carb") / 100) * amount);
            }
            return myFood;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
