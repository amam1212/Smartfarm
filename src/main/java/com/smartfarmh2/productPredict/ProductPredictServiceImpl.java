package com.smartfarmh2.productPredict;

import com.smartfarmh2.product.Product;
import com.smartfarmh2.product.ProductDao;
import com.smartfarmh2.product.ProductDaoImpl;
import com.smartfarmh2.product.ProductService;
import com.smartfarmh2.productStock.ProductStock;
import com.smartfarmh2.productStock.ProductStockDao;
import com.smartfarmh2.productStock.ProductStockDaoImpl;
import com.smartfarmh2.productStock.ProductStockService;
import org.rosuda.JRI.Rengine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



//@Service("productPredictService")
@Service
public class ProductPredictServiceImpl implements ProductPredictService {

    @Autowired
    ProductStockDao productStockDao;
    @Autowired
    ProductDao productDao;

    //    @Override
//    public ProductPredict getPrediction(ProductPredict  productPredict) {
//        Product product = productService.findByName("name");
//      List<ProductStock> productStockList =  productStockService.findByProduct(product);
//
//        productStockList.get(1).getQuantity();
//
//        // Create an R vector in the form of a string.
//        String javaVector = "c(1,2,3,4,5,6,7,8,9,10)";
//
//        // Start Rengine.
//        Rengine engine = new Rengine(new String[] { "--no-save" }, false, null);
//
//        // The vector that was created in JAVA context is stored in 'rVector' which is a variable in R context.
//        engine.eval("rVector=" + javaVector);
//
//        //Calculate MEAN of vector using R syntax.
//        engine.eval("meanVal=mean(rVector)");
//
//        //Retrieve MEAN value
//        double mean = engine.eval("meanVal").asDouble();
//
//        ProductPredict predict = new ProductPredict(product,mean);
//
//        return predict;
//    }
//    @Override
//    public ArrayList<Double> getPrediction(Long productId, Integer quantity) {
//        String stocks = this.getTotalStock(productId);
//        Rengine engine = new Rengine(new String[]{"--no-save"}, false, null);
////        String preData = "data<-c("+stocks+")";
////        String preQuantity = "result<-predict(fit,"+quantity+")";
//        engine.eval("data<-c("+stocks+")");
//        engine.eval("fit<-arima(data,order=c(1,0,1))");
//        engine.eval("result<-predict(fit,"+quantity+")");
//
//
////        engine.eval("data<-c(88,77,66)");
////        engine.eval("fit<-arima(data,order=c(1,0,1))");
////        engine.eval("result<-predict(fit,1)");
////        double x1 = engine.eval("result$pred[1]").asDouble();
//
//
//        ArrayList<Double> predicts = new ArrayList<>();
//        String preResult = "";
//        double x = 0;
//        for (int i = 1; i <= quantity; i++) {
//            preResult = "result$pred["+i+"]";
//            x = engine.eval(preResult).asDouble();
//            predicts.add(x);
//        }
//        //engine.end();
//        return predicts;
//    }
//

    @Override
    public List<ProductPredict> calculatePrediction(String productName, Integer quantity) {
        Long productId = productDao.findByName(productName).getId();
        String stocks = this.prepareData(productId);


        String newargs1[] = {"--no-save"};
        Rengine engine = Rengine.getMainEngine();
        if (engine == null)
        { engine = new Rengine(newargs1, false, null);
        }


        //Rengine engine = new Rengine(new String[]{"--no-save"}, false, null);


        //engine.start();
        engine.eval("data<-c("+stocks+")");
        engine.eval("fit<-arima(data,order=c(1,0,1))");
        engine.eval("result<-predict(fit,"+quantity+")");


        List<ProductPredict> predicts = new ArrayList<ProductPredict>();
        String preResult = "";
        double x = 0;
        for (int i = 1; i <= quantity; i++) {
            preResult = "result$pred["+i+"]";
            x = engine.eval(preResult).asDouble();
            ProductPredict p = new ProductPredict(i,productDao.getProduct(productId).getName(),x);
            predicts.add(p);
            //predicts.add(x);
        }
        //engine.end();

        if(stocks==null){
            predicts = null;
        }

        return predicts;
    }

    @Override
    public String prepareData(Long productId) {
//        if(productDao  == null){
//            productDao = new ProductDaoImpl();
//        }
//        if(productStockDao  == null){
//            productStockDao = new ProductStockDaoImpl();
//        }
        Product product = productDao.getProduct(productId);
        List<ProductStock> stocks = productStockDao.findByProduct(product);
        String data = null;
        if(stocks.size()>=6) {
            for (ProductStock stock : stocks) {
                data = stocks.stream().map(s -> s.getQuantity() + "").collect(Collectors.joining(","));
                //data += ",";
            }
        }
        return data;
    }
}
