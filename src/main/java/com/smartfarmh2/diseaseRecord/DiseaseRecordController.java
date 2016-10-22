package com.smartfarmh2.diseaseRecord;

import com.smartfarmh2.diseaseRecord.DiseaseRecord;
import com.smartfarmh2.diseaseRecord.DiseaseRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * Created by DELL on 10/18/2016.
 */
@CrossOrigin
@RestController
public class DiseaseRecordController {
    @Autowired
    DiseaseRecordService diseaseRecordService;

    @RequestMapping(value = "/diseaseRecord",method = RequestMethod.GET)
    public List<DiseaseRecord> list(){
        return diseaseRecordService.list();
    }

    @RequestMapping(value = "/diseaseRecord",method = RequestMethod.POST)
    public DiseaseRecord create(@RequestBody DiseaseRecord diseaseRecord){
        return diseaseRecordService.create(diseaseRecord);
    }

    @RequestMapping(value = "/diseaseRecord/{id}",method = RequestMethod.GET)
    public  DiseaseRecord getProduct(@PathVariable("id") Long id){
        return diseaseRecordService.getDiseaseRecord(id);
    }

    @RequestMapping(value = "/diseaseRecord/{id}",method = RequestMethod.PUT)
    public  DiseaseRecord edit(@PathVariable("id") Long id,@RequestBody DiseaseRecord diseaseRecord){
        return diseaseRecordService.update(diseaseRecord);
    }

    @RequestMapping(value = "/diseaseRecord/{id}",method = RequestMethod.DELETE)
    public  void delete(@PathVariable("id") Long id){
        diseaseRecordService.delete(id);
    }
}
