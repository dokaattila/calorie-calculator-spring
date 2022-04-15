package hu.da.ccs.controller;

import hu.da.ccs.model.Food;
import hu.da.ccs.model.Statistic;
import hu.da.ccs.service.CalorieService;
import net.minidev.json.JSONObject;
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

}
