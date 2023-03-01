package model.repository;

import model.product.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> showListProduct();
    void createProduct(Product product);
    void deleteProduct(int stt);
    Product selectProduct(int id);
}
