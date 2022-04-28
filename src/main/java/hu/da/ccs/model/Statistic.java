package hu.da.ccs.model;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Jacksonized
@Getter
@Setter
public class Statistic {

    private BigDecimal sumCal;
    private BigDecimal  sumCarb;
    private BigDecimal  sumFat;
    private BigDecimal  sumProt;
    private BigDecimal  avgCal;
    private BigDecimal  avgCarb;
    private BigDecimal  avgFat;
    private BigDecimal  avgProt;



}
