package com.smartfarmh2.productPredict;


import com.fasterxml.jackson.databind.util.JSONPObject;
import com.smartfarmh2.productStock.ProductStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 10/23/2016.
 */
@CrossOrigin
@RestController
public class ProductPredictController {
    @Autowired
    ProductPredictService productPredictService;

//    @RequestMapping(value = "/productPredict",method = RequestMethod.GET)
//    public String predict(@RequestParam(value="productId", required=false) Long productId,
//                        @RequestParam(value="quantity", required=false) Integer quantity){
////        if(productPredictService == null){
////            productPredictService = new ProductPredictServiceImpl();
////        }
////        String predictData = "[";
////        ArrayList<Double> predicts = productPredictService.getPrediction(productId, quantity);
////        for (double predict:predicts) {
////            predictData += predict + ",";
////        }
////        predictData += "]";
////        return predictData;
//    }


    @RequestMapping(value = "/getPrediction/{productName}/{quantity}",method = RequestMethod.GET)
    public List<ProductPredict> getPrediction(@PathVariable("productName") String productName, @PathVariable("quantity") Integer quantity){
        return productPredictService.calculatePrediction(productName,quantity);
    }
}
