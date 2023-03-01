package model.repository.impl;

import model.product.Product;
import model.repository.IProductRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static final String ALL_PRODUCT = "select stt,`name`,price,quantity,color,category from quan_li_san_pham.product;";
    private static final String CREATE_PRODUCT = "insert into quan_li_san_pham.product(`name`, price,quantity,color, description, category) value(?,?,?,?,?,?)";
    private static final String DELETE_PRODUCT = "delete from quan_li_san_pham.product where STT = ?;";
    private static final String SELECT_PRODUCT_BY_ID = "select STT,`name`, price,quantity,color, description, category from quan_li_san_pham.product where stt = ?";



    @Override
    public List<Product> showListProduct() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        List<Product> productList = new ArrayList<>();
        if (connection != null){
            try {
                statement = connection.prepareStatement(ALL_PRODUCT);
                resultSet = statement.executeQuery();
                Product product = null;
                while (resultSet.next()){
                    int id =resultSet.getInt("STT");
                    String name = resultSet.getString("name");
                    int price = resultSet.getInt("price");
                    int quantity = resultSet.getInt("quantity");
                    String color = resultSet.getString("color");
                    String category = resultSet.getString("category");

                    product = new Product(id,name,price,quantity,color,category);
                    productList.add(product);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnection.close();
            }
        }
        return productList;

    }

    @Override
    public void createProduct(Product product) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null){
            try {
                statement = connection.prepareStatement(CREATE_PRODUCT);
                statement.setString(1,product.getName());
                statement.setDouble(2,product.getPrice());
                statement.setInt(3,product.getQuantity());
                statement.setString(4,product.getColor());
                statement.setString(5,product.getDescription());
                statement.setString(6,product.getCategory());

                statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnection.close();
            }
        }
    }

    @Override
    public void deleteProduct(int stt) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(DELETE_PRODUCT);
                statement.setInt(1,stt);
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnection.close();
            }
        }
    }

    @Override
    public Product selectProduct(int id) {

        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Product product = null;
        if (connection != null){
            try {
                statement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);
                statement.setInt(1,id);
                resultSet = statement.executeQuery();
                while (resultSet.next()){
                    int stt =resultSet.getInt("STT");
                    String name = resultSet.getString("name");
                    double price = resultSet.getInt("price");
                    int quantity = resultSet.getInt("quantity");
                    String color = resultSet.getString("color");
                    String description = resultSet.getString("description");
                    String category = resultSet.getString("category");

                    product = new Product(stt,name,price,quantity,color,description,category);

                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnection.close();
            }
        }
        return product;
    }

}

