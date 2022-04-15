package hu.da.ccs.model;

import lombok.Data;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Data
@Jacksonized
@Getter
public class FoodList {

    private List<Food> foodList;


}
