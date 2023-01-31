package run;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CalcuratorServlet", value = "/CalcuratorServlet")
public class CalcuratorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "calculator":
                calculator(request,response);
                break;
            case "reset":
                reset(request,response);
                break;
        }
    }
    protected void calculator(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        String description = request.getParameter("description");
        Double price = Double.parseDouble(request.getParameter("price"));
        Double amount = Double.parseDouble(request.getParameter("amount"));
        Double discountamount = price * amount * 0.01;
        String DescriptionAmount = ("Product Description: "+description+", Discount Amount : " + discountamount);
        request.setAttribute("DescriptionAmount", DescriptionAmount);
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
    protected void reset(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
