package controller;

import model.Product;
import model.service.IProductService;
import model.service.impl.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProductServlet", value = "/Product")
public class ProductServlet extends HttpServlet {
    private static IProductService productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "display":
                display(request, response);
                break;

        }
    }

    private void display(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("product", productService.display());
        request.getRequestDispatcher("displayProduct.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                create(request, response);
                break;
            case "findId":
                findId(request, response);

        }
    }

    private void findId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int findId = Integer.parseInt(request.getParameter("findId"));
        Product product = productService.findId(findId);
        request.setAttribute("product",product);
        request.getRequestDispatcher("displayfindId.jsp").forward(request, response);

    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        String description = request.getParameter("description");
        String producer = request.getParameter("producer");

        Product product = new Product(id,name,price,description,producer);
        productService.create(product);
        display(request,response);

    }

}
