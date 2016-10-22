//package com.smartfarmh2.product;
//
//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import static org.hamcrest.CoreMatchers.nullValue;
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.CoreMatchers.*;
//import static org.mockito.Mockito.*;
//
//import com.smartfarmh2.product.ProductDaoImpl;
//import com.smartfarmh2.product.Product;
//import static org.junit.Assert.*;
//
//
///**
// * Created by DELL on 7/22/2016.
// */
//
//public class ProductServiceImplTest {
//
//    @Test
//    public void list(){
//        ProductServiceImpl productService = mock(ProductServiceImpl.class);
//        Product product1 = new Product(1l,"orange","kg");
//        Product product2 = new Product(2l,"banana","kg");
//        Product product3 = new Product(3l,"coconut","ea");
//        {
//            List<Product> returnMock = new ArrayList<>();
//            returnMock.add(product1);
//            returnMock.add(product2);
//            returnMock.add(product3);
//            when(productService.list()).thenReturn(returnMock);
//        }
//
//        List<Product> resultSuccess = productService.list();
//        assertEquals(productService.list(),resultSuccess);
//        assertNotNull(resultSuccess);
//        System.out.println(resultSuccess);
//
//        System.out.println("=================================================");
//        System.out.println("In case of empty database...");
//        List<Product> productList = new ArrayList<>();
//        when(productList).thenReturn(null);
//        List<Product> resultFailed1 = productService.list();
//        assertNull(resultFailed1);
//        System.out.println(resultFailed1);
//
//    }
//
//    @Test
//    public void create(){
//        ProductServiceImpl productService = mock(ProductServiceImpl.class);
//        Product product = new Product(2l,"banana","kg");
//        {
//            Product returnMock = new Product(2l,"banana","kg");
//            when(productService.create(product)).thenReturn(returnMock);
//        }
//
//    Product resultSuccess = productService.create(product);
//    assertEquals(product.getName(),resultSuccess.getName());
//    assertNotNull(resultSuccess);
//    System.out.println(resultSuccess);
//
//        System.out.println("=================================================");
//        System.out.println("In case of some of empty data...");
//        Product product1 = new Product("orange",null);
//        when(productService.create(product1)).thenReturn(null);
//        Product resultFailed1 = productService.create(product1);
//        assertNull(resultFailed1);
//        System.out.println(resultFailed1);
//
//    }
//
//    @Test
//    public void getProduct (){
//        ProductServiceImpl productService = mock(ProductServiceImpl.class);
//        Product product1 = new Product(1l,"orange","kg");
//        Product product2 = new Product(2l,"banana","kg");
//        Product product3 = new Product(3l,"coconut","ea");
//        {
//            Product returnMock = new Product(2l,"banana","kg");
//            when(productService.getProduct(2l)).thenReturn(returnMock);
//        }
//
//        Product resultSuccess = productService.getProduct(2l);
//        assertEquals(product2.getName(),resultSuccess.getName());
//        assertNotNull(resultSuccess);
//        System.out.println(resultSuccess);
//
//        System.out.println("=================================================");
//        System.out.println("In case of unmatched id...");
//        when(productService.getProduct(4l)).thenReturn(null);
//        Product resultFailed1 = productService.getProduct(4l);
//        assertNull(resultFailed1);
//        System.out.println(resultFailed1);
//
//    }
//
//    @Test
//    public void delete (){
//        ProductServiceImpl productService = mock(ProductServiceImpl.class);
//        Product product1 = new Product(1l,"orange","kg");
//        Product product2 = new Product(2l,"banana","kg");
//        Product product3 = new Product(3l,"coconut","ea");
//
//        List<Product> returnMock = new ArrayList<>();
//        returnMock.add(product1);
//        returnMock.add(product2);
//        returnMock.add(product3);
//
//
//
//        productService.delete(3l);
//        if (!returnMock.contains(3l)) {
//            System.out.println("There is no 3l data");
//        }
//
//        System.out.println("=================================================");
//        System.out.println("In case of unmatched id....");
//        productService.delete(5l);
//        if (!returnMock.contains(3l)) {
//            System.out.println("There are all data");
//        }
//
//    }
//
//}
