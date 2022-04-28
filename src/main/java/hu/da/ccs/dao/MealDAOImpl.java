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
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class MealDAOImpl implements MealDAO {

    @Autowired
    ConnectionData conn;
    private final DecimalFormat df = new DecimalFormat("0.00");


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
        BigDecimal sumFatDec = new BigDecimal(sumFat).setScale(2, RoundingMode.HALF_UP);
        double sumCal = foodList.stream().map(Food::getFoodCalories).reduce(Double::sum).orElse(0.0);
        BigDecimal sumCalDec = new BigDecimal(sumCal).setScale(2, RoundingMode.HALF_UP);
        double sumCarb = foodList.stream().map(Food::getFoodCarb).reduce(Double::sum).orElse(0.0);
        BigDecimal sumCarbDec = new BigDecimal(sumCarb).setScale(2, RoundingMode.HALF_UP);
        double sumProt = foodList.stream().map(Food::getFoodProtein).reduce(Double::sum).orElse(0.0);
        BigDecimal sumProtDec = new BigDecimal(sumProt).setScale(2, RoundingMode.HALF_UP);

        double avgCal = sumCal / listSize;
        BigDecimal avgCalDec = new BigDecimal(avgCal).setScale(2, RoundingMode.HALF_UP);
        double avgCarb = sumCarb / listSize;
        BigDecimal avgCarbDec = new BigDecimal(avgCarb).setScale(2, RoundingMode.HALF_UP);
        double avgFat = sumFat / listSize;
        BigDecimal avgFatDec = new BigDecimal(avgFat).setScale(2, RoundingMode.HALF_UP);
        double avgProt = sumProt / listSize;
        BigDecimal avgProtDec = new BigDecimal(avgProt).setScale(2, RoundingMode.HALF_UP);

        return new Statistic(sumCalDec, sumCarbDec, sumFatDec, sumProtDec, avgCalDec, avgCarbDec, avgFatDec, avgProtDec);
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


    public List<Meal> getMealByLetters(String letters) {
        List<Meal> mealList = new ArrayList<>();
        try {
            PreparedStatement prep = conn.getConnection().
                    prepareStatement("SELECT * FROM foodlist WHERE food_name like ? ORDER BY food_name");
            prep.setString(1,letters + "%");
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
    }

