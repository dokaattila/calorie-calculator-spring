package hu.da.ccs.service;

import hu.da.ccs.dao.FoodDAOImpl;
import hu.da.ccs.model.Food;
import hu.da.ccs.model.Statistic;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalorieService {

    @Autowired
    FoodDAOImpl foodDAO;

    public List<Food> getAllFood() {
        return foodDAO.getAllFood();
    }

    public Statistic getStatistic(String content) {
        return foodDAO.getStatistic(content);
    }
}
