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
    private String TICKER;
    private String PER;
    private Integer DATE;
    private Integer TIME;
    private Double OPEN;
    private Double HIGH;
    private Double LOW;
    private Double CLOSE;
    private Long VOL;

    public EntityExample(String[] row) {
        this.TICKER = row[0];
        this.PER = row[1];
        this.DATE = Integer.parseInt(row[2]);
        this.TIME = Integer.parseInt(row[3]);
        this.OPEN = Double.parseDouble(row[4]);
        this.HIGH = Double.parseDouble(row[5]);
        this.LOW = Double.parseDouble(row[6]);
        this.CLOSE = Double.parseDouble(row[7]);
        this.VOL = Long.parseLong(row[8]);
    }
}

