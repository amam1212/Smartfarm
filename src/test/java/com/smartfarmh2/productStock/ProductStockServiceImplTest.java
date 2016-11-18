package com.smartfarmh2.productStock;


import com.smartfarmh2.product.Product;
import com.smartfarmh2.product.ProductServiceImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Created by DELL on 7/22/2016.
 */

public class ProductStockServiceImplTest {

    @Test
    public void list(){
        ProductStockServiceImpl productStockService = mock(ProductStockServiceImpl.class);
        Product product1 = new Product("orange","kg");
        Product product2 = new Product("banana","kg");
        Product product3 = new Product("coconut","ea");
        ProductStock productstock1 = new ProductStock(product1,30);
        ProductStock productstock2 = new ProductStock(product2,10);
        ProductStock productstock3 = new ProductStock(product3,40);
        {
            List<ProductStock> returnMock = new ArrayList<>();
            productstock1.setId((long) 101);
            productstock2.setId((long) 102);
            productstock3.setId((long) 103);
            returnMock.add(productstock1);
            returnMock.add(productstock2);
            returnMock.add(productstock3);
            when(productStockService.list()).thenReturn(returnMock);
        }

        List<ProductStock> resultSuccess = productStockService.list();
        assertEquals(productStockService.list(),resultSuccess);
        assertNotNull(resultSuccess);
        System.out.println(resultSuccess);

        System.out.println("=================================================");
        System.out.println("In case of empty database...");
        List<ProductStock> productList = new ArrayList<>();
        when(productList).thenReturn(null);
        List<ProductStock> resultFailed1 = productStockService.list();
        assertNull(resultFailed1);
        System.out.println(resultFailed1);

    }

    @Test
    public void create(){
        ProductStockServiceImpl productStockService = mock(ProductStockServiceImpl.class);
        Product product1 = new Product("orange","kg");
        Product product2 = new Product("banana","kg");
        Product product3 = new Product("coconut","ea");
        Product product4 = new Product("watermelon","kg");
        ProductStock productstock1 = new ProductStock(product1,30);
        ProductStock productstock2 = new ProductStock(product2,10);
        ProductStock productstock3 = new ProductStock(product3,40);
        ProductStock productstock4 = new ProductStock(product4,60);
        {
            product1.setId(1l);
            product2.setId(2l);
            product3.setId(3l);
            product4.setId(4l);
            ProductStock returnMock = new ProductStock(product4,60);
            when(productStockService.create(productstock4)).thenReturn(returnMock);
        }

    ProductStock resultSuccess = productStockService.create(productstock4);
    assertEquals(productstock4.getProduct(),resultSuccess.getProduct());
    assertNotNull(resultSuccess);
    System.out.println(resultSuccess);

        System.out.println("=================================================");
        System.out.println("In case of some of empty data...");
        ProductStock productStock5 = new ProductStock(null,60);
        when(productStockService.create(productStock5)).thenReturn(null);
        ProductStock resultFailed1 = productStockService.create(productStock5);
        assertNull(resultFailed1);
        System.out.println(resultFailed1);

    }

    @Test
    public void getProductStock (){
        ProductStockServiceImpl productStockService = mock(ProductStockServiceImpl.class);
        Product product1 = new Product("orange","kg");
        Product product2 = new Product("banana","kg");
        Product product3 = new Product("coconut","ea");
        ProductStock productstock1 = new ProductStock(product1,30);
        ProductStock productstock2 = new ProductStock(product2,10);
        ProductStock productstock3 = new ProductStock(product3,40);
        {
            product1.setId(1l);
            product2.setId(2l);
            product3.setId(3l);
            ProductStock returnMock = new ProductStock(product3,40);
            when(productStockService.getProductStock(3l)).thenReturn(returnMock);
        }

        ProductStock resultSuccess = productStockService.getProductStock(3l);
        assertEquals(productstock3.getProduct(),resultSuccess.getProduct());
        assertNotNull(resultSuccess);
        System.out.println(resultSuccess);

        System.out.println("=================================================");
        System.out.println("In case of unmatched id...");
        when(productStockService.getProductStock(4l)).thenReturn(null);
        ProductStock resultFailed1 = productStockService.getProductStock(4l);
        assertNull(resultFailed1);
        System.out.println(resultFailed1);

    }

    @Test
    public void delete (){
        ProductStockServiceImpl productStockService = mock(ProductStockServiceImpl.class);
        Product product1 = new Product("orange","kg");
        Product product2 = new Product("banana","kg");
        Product product3 = new Product("coconut","ea");
        ProductStock productstock1 = new ProductStock(product1,30);
        ProductStock productstock2 = new ProductStock(product2,10);
        ProductStock productstock3 = new ProductStock(product3,40);

        List<ProductStock> returnMock = new ArrayList<>();

        product1.setId(1l);
        product2.setId(2l);
        product3.setId(3l);
        returnMock.add(productstock1);
        returnMock.add(productstock2);
        returnMock.add(productstock3);



        productStockService.delete(3l);
        if (!returnMock.contains(3l)) {
            System.out.println("There is no 3l data");
        }

        System.out.println("=================================================");
        System.out.println("In case of unmatched id....");
        productStockService.delete(5l);
        if (!returnMock.contains(3l)) {
            System.out.println("There are all data");
        }

    }

}
