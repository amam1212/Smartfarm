package com.smartfarmh2.diseaseRecord;

import com.smartfarmh2.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
/**
 * Created by DELL on 10/18/2016.
 */
public interface DiseaseRecordRepository extends JpaRepository<DiseaseRecord,Long>{

        List<DiseaseRecord> findByProduct(Product product);
}
