package controlers;

import database.DBConection;
import entity.Mark;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentProgressControler", urlPatterns = {"/students-progress"})
public class StudentProgressControler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBConection conection = new DBConection();

        List<Mark> marks = conection.getStudentsMarks();

        req.setAttribute("marks",marks);
        req.setAttribute("currentPage","stProgress.jsp");
        req.getRequestDispatcher("/jsp/template.jsp").forward(req,resp);
    }
}
