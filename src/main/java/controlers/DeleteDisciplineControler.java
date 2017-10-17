package controlers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DisciplineCreateControler", urlPatterns = {"/discipline-delete", "/discipline-delete/"})
public class DeleteDisciplineControler extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String checkboxes = req.getParameter("checkboxes");
        System.out.println(checkboxes);

        req.setAttribute("currentPage", "discCreating.jsp");
        req.getRequestDispatcher("/jsp/template.jsp").forward(req, resp);
    }
}
