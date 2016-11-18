package com.smartfarmh2.productPredict;
import com.smartfarmh2.product.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by DELL on 10/23/2016.
 */

@Entity
@Data
@NoArgsConstructor
public class ProductPredict {
    @Id
    @GeneratedValue
    private int id;
    private String product;
    private double quantity;


    public ProductPredict(int id, String product, double quantity) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
    }
}
