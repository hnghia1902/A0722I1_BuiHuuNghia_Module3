package controller;

import model.User;
import model.service.IUserService;
import model.service.impl.UserService;

import javax.jws.soap.SOAPBinding;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserServlet", value = "/User")
public class UserServlet extends HttpServlet {
    IUserService iUserService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }

        switch (action){
            case"showListUser":
                showListUser(request, response);
                break;
            case "createUser":
                createUser(request, response);
                break;
            case "edit":
                editForm(request, response);
                break;
            case "find_by_country":
                find_by_country_form(request, response);
                break;
            case "Sort":
                sort(request, response);
                break;
            case "delete":
                deleteUser(request, response);
                break;
        }
    }

    private void sort(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("listUser",iUserService.sort());
        try {
            request.getRequestDispatcher("listUser.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void find_by_country_form(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect("findCountry.jsp");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private void editForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = iUserService.selectUser(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
        request.setAttribute("user", user);
        dispatcher.forward(request, response);


    }

    private void createUser(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect("createUser.jsp");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        iUserService.deleteUser(id);
        response.sendRedirect("/User?action=showListUser");
    }

    private void showListUser(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("listUser",iUserService.showListUser());
        try {
            request.getRequestDispatcher("listUser.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action= "";
        }
        switch (action){
            case "Create":
                create(request, response);
                break;
            case "Save":
                updateUser(request, response);
                break;
            case "Find":
                find_by_country(request, response);
                break;
        }

    }



    private void updateUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        User user = new User(id, name, email, country);
        iUserService.updateUser(user);
        try {
            response.sendRedirect("/User?action=showListUser");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        User user = new User(name, email, country);
        iUserService.create(user);
        try {
            response.sendRedirect("/User?action=showListUser");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void find_by_country(HttpServletRequest request, HttpServletResponse response) {
        String country = request.getParameter("country");
        request.setAttribute("listUser", iUserService.selectUser_by_country(country));
        try {
            request.getRequestDispatcher("listUser.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
