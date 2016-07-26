package com.smartfarmh2.product;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;

import com.smartfarmh2.product.ProductDaoImpl;
import com.smartfarmh2.product.Product;
import static org.junit.Assert.*;


/**
 * Created by DELL on 7/22/2016.
 */

public class ProductServiceImplTest {
//    @Test
//    public void list(){
//        ProductDao productDao = mock(ProductDao.class);
//        ProductServiceImpl productService = new ProductServiceImpl(productDao);
//        List<Product> productList = Arrays.asList(
//                new Product("Mango","kg"),
//                new Product("Banana","kg")
//        );
//        when(productDao.list()).thenReturn(productList);
//        assertThat(productService.list(),is(productList));
//        verify(productDao,times(1)).list();
//    }
//
//    @Test
//    public void create(){
//        ProductDao productDao = mock(ProductDao.class);
//        ProductServiceImpl productService = new ProductServiceImpl(productDao);
//        Product product = new Product("Mango","kg");
//        when(productDao.create(product)).thenReturn(product);
//        assertThat(productService.create(product),is(product));
//        verify(productDao,times(1)).create(product);
//    }
//
//    @Test
//    public void getProduct(){
//        ProductDao productDao = mock(ProductDao.class);
//        ProductServiceImpl productService = new ProductServiceImpl(productDao);
//        List<Product> productList = Arrays.asList(
//                new Product("Mango","kg"),
//                new Product("Banana","kg"),
//                new Product("Apple","kg")
//        );
//        long id = 1;
//        when(productDao.getProduct(id)).thenReturn(productList.get(1));
//        assertThat(productDao.getProduct(id).getName(),is("Banana"));
//        verify(productDao,times(1)).getProduct(id);
//    }
//
//
//    @Test
//    public void createProduct(){
//        Product p = mock(Product.class);
//        when(p.getName()).thenReturn("Mango");
//        when(p.getUnit()).thenReturn("kilogram");
//        ProductDao pDao = mock(ProductDao.class);
//        when(pDao.create(p)).thenReturn(p);
//        ProductService productService = new ProductServiceImpl(pDao);
//        assertThat(productService.create(p).getName(),is("Mango"));
//    }
//
//    @Test
//    public void updateProduct(){
//        Product p = mock(Product.class);
//        when(p.getName()).thenReturn("Mango");
//        when(p.getUnit()).thenReturn("kilogram");
//        ProductDao pDao = mock(ProductDao.class);
//        when(pDao.update(p)).thenReturn(p);
//        ProductService productService = new ProductServiceImpl(pDao);
//        assertThat(productService.update(p).getName(),is("Mango"));
//    }


    @Test
    public void create(){
        ProductDaoImpl productDao = mock(ProductDaoImpl.class);
        Product product = new Product("Apple","kg");
        when(productDao.findByName("Apple")).thenReturn(null);
        {
            Product returnMock = new Product("Apple","kg");
            returnMock.setId((long) 101);
            when(productDao.create(product)).thenReturn(returnMock);
        }
        ProductServiceImpl productService = new ProductServiceImpl();
        productService.setProductDao(productDao);

        Product result =  productService.create(product);
        assertNotNull(result);
        assertEquals("Apple",result.getName());
        assertNotNull(result.getId());
        //verify(productDao).create("aaa@gmail.com");
        verify(productDao).create(product);
    }


    @Test
    public void update(){
        ProductDaoImpl productDao = mock(ProductDaoImpl.class);
        Product product = new Product("Apple","kg");
        when(productDao.findByName("Apple")).thenReturn(null);
        {
            Product returnMock = new Product("Mango","kg");
            returnMock.setId((long) 101);
            when(productDao.update(product)).thenReturn(returnMock);
        }
        ProductServiceImpl productService = new ProductServiceImpl();
        productService.setProductDao(productDao);

        Product result =  productService.update(product);
        assertNotNull(result);
        assertEquals("Mango",result.getName());
        assertNotNull(result.getId());
        //verify(productDao).create("aaa@gmail.com");
        verify(productDao).update(product);
    }

    @Test
    public void getProduct(){
        ProductDaoImpl productDao = mock(ProductDaoImpl.class);
        Product product = new Product("Apple","kg");
        when(productDao.findByName("Apple")).thenReturn(null);
        {
            Product returnMock = new Product("Apple","kg");
            returnMock.setId((long) 101);
            when(productDao.getProduct(101L)).thenReturn(returnMock);
        }
        ProductServiceImpl productService = new ProductServiceImpl();
        productService.setProductDao(productDao);

        Product result =  productService.getProduct(101L);
        assertNotNull(result);
        assertEquals("Apple",result.getName());
        assertNotNull(result.getId());
        //verify(productDao).create("aaa@gmail.com");
        verify(productDao).getProduct(101L);
    }

    public void ListProduct(){
        ProductDaoImpl productDao = mock(ProductDaoImpl.class);
        List<Product> productList = Arrays.asList(
                new Product("Mango","kg"),
                new Product("Banana","kg")
        );
        when(productDao.findByName("Mango")).thenReturn(null);
        {
            Product returnMock = new Product("Apple","kg");
            returnMock.setId((long) 101);
            when(productDao.getProduct(101L)).thenReturn(returnMock);
        }
        ProductServiceImpl productService = new ProductServiceImpl();
        productService.setProductDao(productDao);

        Product result =  productService.getProduct(101L);
        assertNotNull(result);
        assertEquals("Apple",result.getName());
        assertNotNull(result.getId());
        //verify(productDao).create("aaa@gmail.com");
        verify(productDao).getProduct(101L);
    }
}
