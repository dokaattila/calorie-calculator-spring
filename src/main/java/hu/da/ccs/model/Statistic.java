package hu.da.ccs.model;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Jacksonized
@Getter
@Setter
public class Statistic {

    private double sumCal;
    private double sumCarb;
    private double sumFat;
    private double sumProt;
    private double avgCal;
    private double avgCarb;
    private double avgFat;
    private double avgProt;



}
