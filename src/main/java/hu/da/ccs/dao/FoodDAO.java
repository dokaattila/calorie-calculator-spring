package hu.da.ccs.dao;

import hu.da.ccs.model.Food;
import hu.da.ccs.model.Statistic;
import net.minidev.json.JSONObject;

import java.util.List;

public interface FoodDAO {

    List<Food> getAllFood();
    Food getFoodById(int id);
    Statistic getStatistic(String content);

}
