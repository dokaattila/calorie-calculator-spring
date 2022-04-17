package hu.da.ccs.dao;

import hu.da.ccs.model.Meal;
import hu.da.ccs.model.Statistic;

import java.util.List;

public interface MealDAO {

    List<Meal> getAllMeal();
    Statistic getMealStatistic(String content);


}
