package com.wissem.ecommerce.service;


import com.wissem.ecommerce.dao.ProductDao;
import com.wissem.ecommerce.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductDao productDao;


    public Product addNewProduct(Product product) {
        return productDao.save(product);
    }

    public List<Product> getAllProducts() {
        return productDao.findAll();
    }


    public void deleteProduct(int productId) {
        productDao.deleteById(productId);
    }

    public Product getProductById(int productId) {
        return productDao.findById(productId).get();
    }

    public List<Product> getProductDetails(boolean isSingleProductCheckout, int productId) {
        if (isSingleProductCheckout) {
            List<Product> list = new ArrayList<>();
            Product product = productDao.findById(productId).get();
            list.add(product);
            return list;
        } else {
            return new ArrayList<>();
        }
    }
}


