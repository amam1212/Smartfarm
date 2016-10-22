package com.smartfarmh2.diseaseRecord;

import com.smartfarmh2.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * Created by DELL on 10/18/2016.
 */

@Repository
public class DiseaseRecordDaoImpl implements DiseaseRecordDao{
    @Autowired
    DiseaseRecordRepository diseaseRecordRepository;
    @Autowired
    ProductRepository productRepository;
    @Override
    public DiseaseRecord create(DiseaseRecord diseaseRecord) {
        diseaseRecord.setProduct(productRepository.findByName(diseaseRecord.getProduct().getName()));
        return diseaseRecordRepository.save(diseaseRecord);
    }

    @Override
    public DiseaseRecord update(DiseaseRecord diseaseRecord) {
        diseaseRecord.setProduct(productRepository.findByName(diseaseRecord.getProduct().getName()));
        return diseaseRecordRepository.save(diseaseRecord);
    }

    @Override
    public void delete(DiseaseRecord diseaseRecord) {
        diseaseRecordRepository.delete(diseaseRecord);
    }

    @Override
    public DiseaseRecord getDiseaseRecord(Long id) {
        return diseaseRecordRepository.findOne(id);
    }

    @Override
    public List<DiseaseRecord> list() {
        return diseaseRecordRepository.findAll();
    }
}


