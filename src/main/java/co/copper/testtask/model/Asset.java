package co.copper.testtask.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.math.BigDecimal;

@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ASSET")
public class    Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String currency;

    @Column(name = "year_of_issue")
    private Short year;

    @Column(name = "assessed_value")
    private BigDecimal value;
}
