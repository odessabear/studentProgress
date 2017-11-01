package controlers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StudentProgressControler", urlPatterns = {"/students-progress"})
public class StudentProgressControler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("currentPage","stProgress.jsp");
        req.getRequestDispatcher("/jsp/template.jsp").forward(req,resp);
    }
}
