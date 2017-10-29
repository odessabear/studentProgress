package controlers;

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

        req.setAttribute("currentPage", "discModifying.jsp");
        req.getRequestDispatcher("/jsp/template.jsp").forward(req, resp);
    }
}
