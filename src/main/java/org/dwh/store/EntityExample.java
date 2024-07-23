package org.dwh.store;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.dwh.store.entity.AbstractBaseEntity;

@Entity
@Table(name = "example")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EntityExample extends AbstractBaseEntity {
    private Integer AGE;
    private Integer GENDER;
    private Integer HEIGHT;
    private Double WEIGHT;
    private Integer AP_HI;
    private Integer AP_LO;
    private Integer CHOLESTEROL;
    private Integer GLUC;
    private Integer SMOKE;
    private Integer ALCO;
    private Integer ACTIVE;
    private Integer CARDIO;

    public EntityExample(String[] row) {
        this.id = Long.valueOf(row[0]);
        this.AGE = Integer.valueOf(row[1]);
        this.GENDER = Integer.valueOf(row[2]);
        this.HEIGHT = Integer.parseInt(row[3]);
        this.WEIGHT = Double.parseDouble(row[4]);
        this.AP_HI = Integer.parseInt(row[5]);
        this.AP_LO = Integer.parseInt(row[6]);
        this.CHOLESTEROL = Integer.parseInt(row[7]);
        this.GLUC = Integer.parseInt(row[8]);
        this.SMOKE = Integer.parseInt(row[9]);
        this.ALCO = Integer.parseInt(row[10]);
    }
}

