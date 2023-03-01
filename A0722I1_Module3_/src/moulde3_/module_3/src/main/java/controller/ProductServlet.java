package controller;

import model.product.Product;
import model.service.IProductService;
import model.service.impl.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProductServlet", value = "/Product")
public class ProductServlet extends HttpServlet {
    IProductService iProductService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null){
            action = "";
        }
        switch (action){
            case "showListProduct":
                listProduct(request, response);
                    break;
            case "create":
                create_Product(request,response);
                    break;
            case "delete":
                deleteProduct(request,response);
                break;
            case "edit":
                editFrom(request, response);
                break;
        }
    }

    private void editFrom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int stt = Integer.parseInt(request.getParameter("stt"));
        Product product = iProductService.selectProduct(stt);
        request.setAttribute("Product", product);
        request.getRequestDispatcher("edit.jsp").forward(request,response);
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int stt =Integer.parseInt(request.getParameter("stt"));
        iProductService.deleteProduct(stt);
        response.sendRedirect("/Product?action=showListProduct");
    }

    private void create_Product(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("create.jsp");
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listProduct", iProductService.showListProduct());
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                createProduct(request, response);
                break;
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        double price = Integer.parseInt(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String category = request.getParameter("category");
        String description = request.getParameter("description");

        Product product = new Product(name,price,quantity,color,category,description);
        iProductService.createProduct(product);
        response.sendRedirect("/Product?action=showListProduct");
    }
}
