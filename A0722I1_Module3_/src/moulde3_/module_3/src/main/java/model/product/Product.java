package model.product;

public class Product {
    private int stt;
    private String name;
    private double price;
    private int quantity;
    private String color;
    private String description;
    private String category;
//    private String business;


    public Product() {
    }


    public Product(String name, double price, int quantity, String color, String category) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.category = category;
    }

    public Product(int stt, String name, double price, int quantity, String color, String category) {
        this.stt = stt;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.category = category;
    }

    public Product(String name, double price, int quantity, String color, String description, String category) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.description = description;
        this.category = category;
    }

    public Product(int id, String name, double price, int quantity, String color, String description, String category) {
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
