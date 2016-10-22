package com.smartfarmh2.diseaseRecord;

import java.util.List;

/**
 * Created by DELL on 10/18/2016.
 */
public interface DiseaseRecordService {
    DiseaseRecord create (DiseaseRecord diseaseRecord);
    DiseaseRecord update (DiseaseRecord diseaseRecord);
    void delete (Long id);
    DiseaseRecord getDiseaseRecord (Long id);
    List<DiseaseRecord> list();
}
