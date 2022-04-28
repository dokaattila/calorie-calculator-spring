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

        return null;
    }
}
