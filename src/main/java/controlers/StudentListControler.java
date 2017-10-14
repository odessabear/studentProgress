package controlers;

import database.DBConection;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentListControler", urlPatterns = {"/students-list"})
public class StudentListControler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBConection conection = new DBConection();
        List<Student> students = conection.getAllActiveStudents();

        req.setAttribute("students",students);
        req.setAttribute("currentPage", "studentsList.jsp");
        req.getRequestDispatcher("/jsp/template.jsp").forward(req, resp);
    }
}
