package controlers;

import database.DBConection;
import database.DataService;
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
        DataService dataService = new DataService();

        List<Mark> marks = dataService.getStudentsMarks();

        req.setAttribute("marks",marks);
        req.setAttribute("currentPage","stProgress.jsp");
        req.getRequestDispatcher("/jsp/template.jsp").forward(req,resp);
    }
}
