package com.smartfarmh2.diseaseRecord;
import java.util.List;

/**
 * Created by DELL on 10/18/2016.
 */
public interface DiseaseRecordDao {

        DiseaseRecord create (DiseaseRecord diseaseRecord);
        DiseaseRecord update (DiseaseRecord diseaseRecord);
        void delete (DiseaseRecord diseaseRecord);
        DiseaseRecord getDiseaseRecord (Long id);
        List<DiseaseRecord> list();

}
