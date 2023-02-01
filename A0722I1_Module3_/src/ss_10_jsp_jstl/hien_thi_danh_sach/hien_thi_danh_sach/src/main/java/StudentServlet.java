import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/StudentServlet")
public class StudentServlet extends HttpServlet {

    private static List<Student> studentList;

    static {
        studentList = new ArrayList<>();
        studentList.add(new Student("thu","09/01/2090","23ksjd-asdfd","D:\\codegym_module 3\\A0722I1_BuiHuuNghia_Module3\\A0722I1_Module3_\\src\\ss_10_jsp_jstl\\hien_thi_danh_sach\\hien_thi_danh_sach\\img\\avt1.jfif"));
        studentList.add(new Student("thua","09/01/2200","23ksjd-assded","D:\\codegym_module 3\\A0722I1_BuiHuuNghia_Module3\\A0722I1_Module3_\\src\\ss_10_jsp_jstl\\hien_thi_danh_sach\\hien_thi_danh_sach\\img\\avt2.jfif"));
        studentList.add(new Student("thuw","09/01/2400","23ksjd-asgsdfd","D:\\codegym_module 3\\A0722I1_BuiHuuNghia_Module3\\A0722I1_Module3_\\src\\ss_10_jsp_jstl\\hien_thi_danh_sach\\hien_thi_danh_sach\\img\\avt3.jfif"));
        studentList.add(new Student("thud","09/01/2100","23ksjd-assdfed","D:\\codegym_module 3\\A0722I1_BuiHuuNghia_Module3\\A0722I1_Module3_\\src\\ss_10_jsp_jstl\\hien_thi_danh_sach\\hien_thi_danh_sach\\img\\avt4.jfif"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("student", studentList);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
