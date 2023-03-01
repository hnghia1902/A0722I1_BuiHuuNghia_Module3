package model.service;

import model.product.Product;

import java.util.List;

public interface IProductService {
    List<Product> showListProduct();
    void createProduct(Product product);
    void deleteProduct(int stt);
    Product selectProduct(int id);
}
