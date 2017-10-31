package controlers;

import database.DBConection;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StudentModifyControler", urlPatterns = {"/students-modifying"})
public class StudentModifyControler extends HttpServlet{


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idstr = req.getParameter("checkboxesModify");
        int id = Integer.parseInt(idstr);
        DBConection conection = new DBConection();
        Student student= conection.getStudentById(id);
        req.setAttribute("student",student);
        req.setAttribute("currentPage", "stModifying.jsp");
        req.getRequestDispatcher("/jsp/template.jsp").forward(req, resp);

    }
}
