package hu.da.ccs.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@AllArgsConstructor
@Jacksonized
@Data
@Getter
public class Meal {

    private int id;
    private String name;
    private double amount;

}
