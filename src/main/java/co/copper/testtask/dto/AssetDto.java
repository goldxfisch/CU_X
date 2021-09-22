package co.copper.testtask.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeName("asset")
public class AssetDto implements Collateral {
    private Long id;
    private String name;
    private String currency;
    private Short year;
    private BigDecimal value;

}
