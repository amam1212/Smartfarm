package com.smartfarmh2.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Asus on 20/7/2559.
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDao productDao;

    public ProductServiceImpl() {
    }

    //public ProductServiceImpl(ProductDao productDao) {
     //   this.productDao = productDao;
    //}

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public Product create(Product product) {
        return productDao.create(product);
    }

    @Override
    public Product update(Product product) {
        return productDao.update(product);
    }

    @Override
    public void delete(Long id) { Product p = productDao.getProduct(id);productDao.delete(p); }

    @Override
    public Product getProduct(Long id) {
        return productDao.getProduct(id);
    }

    @Override
    public List<Product> list() {
        return productDao.list();
    }

    @Override
    public Product findByName(String name){return productDao.findByName(name); }
}
