package controller;

import model.service.IEmployeeService;
import model.service.impl.EmployeeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "FuramaServlet", value = "/Furama")
public class FuramaServlet extends HttpServlet {
    IEmployeeService iEmployeeService = new EmployeeService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "all_employee":
                showListEmployee(request, response);
                break;
        }
    }

    private void showListEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listEmployee", iEmployeeService.showListEmployee());
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
