package hu.da.ccs.controller;

import hu.da.ccs.model.Food;
import hu.da.ccs.model.Meal;
import hu.da.ccs.model.Statistic;
import hu.da.ccs.service.CalorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CalorieController {

    @Autowired
    CalorieService calorieService;

    @GetMapping("/getallfood")
    public List<Food> getAllFood() {
        return this.calorieService.getAllFood();
    }

    @PostMapping("/getstatistic")
    public Statistic getStatistic(@RequestBody String content) {
        return this.calorieService.getStatistic(content);
    }

    @GetMapping("/getallmeal")
    public List<Meal> getAllMeal() {
        return this.calorieService.getAllMeal();
    }


    @PostMapping("/getmealstatistic")
    public Statistic getMealStatistic(@RequestBody String content) {
        return this.calorieService.getMealStatistic(content);
    }

}
