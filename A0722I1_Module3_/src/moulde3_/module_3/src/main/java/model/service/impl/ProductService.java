package model.service.impl;

import model.product.Product;
import model.repository.IProductRepository;
import model.repository.impl.ProductRepository;
import model.service.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    IProductRepository iProductRepository = new ProductRepository();

    @Override
    public List<Product> showListProduct() {
        return iProductRepository.showListProduct();
    }

    @Override
    public void createProduct(Product product) {
        iProductRepository.createProduct(product);
    }

    @Override
    public void deleteProduct(int stt) {
        iProductRepository.deleteProduct(stt);
    }

    @Override
    public Product selectProduct(int id) {
        return iProductRepository.selectProduct(id);
    }
}
