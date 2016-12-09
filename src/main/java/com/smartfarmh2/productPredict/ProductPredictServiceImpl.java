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
