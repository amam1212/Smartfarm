package com.smartfarmh2.diseaseRecord;

import com.smartfarmh2.product.Product;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;
import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by DELL on 10/18/2016.
 */
@Entity
@Data
@NoArgsConstructor
public class DiseaseRecord implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    private Product product;
    private String name;
    private LocalDate createdDate;

    public DiseaseRecord(Product product, String name) {
        this.product = product;
        this.name = name;
        this.createdDate = LocalDate.now();
    }
}
