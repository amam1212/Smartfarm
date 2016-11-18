package com.smartfarmh2.diseaseRecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by DELL on 10/18/2016.
 */

@Service
public class DiseaseRecordServiceImpl implements DiseaseRecordService{

    @Autowired
    DiseaseRecordDao diseaseRecordDao;

    @Override
    public DiseaseRecord create(DiseaseRecord diseaseRecord) {
        LocalDate create = null;
        diseaseRecord.setCreatedDate(create.now());
        return diseaseRecordDao.create(diseaseRecord);
    }

    @Override
    public DiseaseRecord update(DiseaseRecord diseaseRecord) {
        //LocalDate update = null;
        diseaseRecord.setCreatedDate(getDiseaseRecord(diseaseRecord.getId()).getCreatedDate());
        return diseaseRecordDao.update(diseaseRecord);
    }

    @Override
    public boolean delete(Long id) {
        DiseaseRecord dr = diseaseRecordDao.getDiseaseRecord(id);
        diseaseRecordDao.delete(dr);
        diseaseRecordDao.getDiseaseRecord(id);
        if(getDiseaseRecord(id)!=null){
            return false;
        }
        return true;
    }

    @Override
    public DiseaseRecord getDiseaseRecord(Long id) {
        return diseaseRecordDao.getDiseaseRecord(id);
    }

    @Override
    public List<DiseaseRecord> list() {
        return diseaseRecordDao.list();
    }
}