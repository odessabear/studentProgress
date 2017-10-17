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

@WebServlet(name = "StudentCreateControler", urlPatterns = {"/student-create", "/student-create/"})
public class StudentCreateControler extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBConection conection = new DBConection();

        req.setAttribute("currentPage", "stCreating.jsp");
        req.getRequestDispatcher("/jsp/template.jsp").forward(req, resp);
    }
}
