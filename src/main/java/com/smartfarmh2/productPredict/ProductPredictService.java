package com.smartfarmh2.productPredict;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 10/23/2016.
 */

public interface ProductPredictService {
//    ProductPredict getPrediction(ProductPredict productPredict);
    //ArrayList<Double> getPrediction(Long productId, Integer quantity);
    List<ProductPredict> calculatePrediction(String productName, Integer quantity);
    String prepareData(Long productId);
}
