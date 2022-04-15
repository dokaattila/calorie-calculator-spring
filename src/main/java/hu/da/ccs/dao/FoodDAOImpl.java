package hu.da.ccs.dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import hu.da.ccs.model.Food;
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
public class FoodDAOImpl implements FoodDAO{

    @Autowired
    ConnectionData conn;


    @Override
    public List<Food> getAllFood() {
        List<Food> foodList = new ArrayList<>();
        try {
            PreparedStatement prep = conn.getConnection().prepareStatement("SELECT * FROM foodlist ORDER BY food_name");
            ResultSet res = prep.executeQuery();
            while (res.next()) {
                foodList.add(new Food(
                        res.getInt("id"),
                        res.getString("food_name"),
                        res.getDouble("food_fat"),
                        res.getDouble("food_protein"),
                        res.getDouble("food_calories"),
                        res.getDouble("food_carb")
                ));
            }
            return foodList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Food getFoodById(int id) {
        return null;
    }

    @Override
    public Statistic getStatistic(String content) {
        Type listType = new TypeToken<ArrayList<Food>>() {}.getType();
        ArrayList<Food> foodList = new Gson().fromJson(content, listType);
        int listSize = foodList.size();
        double sumFat = foodList.stream().map(Food::getFoodFat).reduce(Double::sum).orElse(0.0);
        double sumCal = foodList.stream().map(Food::getFoodCalories).reduce(Double::sum).orElse(0.0);
        double sumCarb = foodList.stream().map(Food::getFoodCarb).reduce(Double::sum).orElse(0.0);
        double sumProt = foodList.stream().map(Food::getFoodProtein).reduce(Double::sum).orElse(0.0);
        return new Statistic(sumCal, sumCarb, sumFat, sumProt,
                sumCal/listSize, sumCarb/listSize, sumFat/listSize, sumProt/listSize);
    }
}
