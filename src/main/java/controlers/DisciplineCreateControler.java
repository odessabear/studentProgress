package controlers;

import database.DBConection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DisciplineCreateControler", urlPatterns = {"/discipline-create.php", "/discipline-create.php/"})
public class DisciplineCreateControler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("currentPage", "discCreating.jsp");
        req.getRequestDispatcher("/jsp/template.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String discipline = req.getParameter("discipline");
        if (discipline.equals("")){
            req.setAttribute("errorMessage",3);
            req.setAttribute("currentPage", "discCreating.jsp");
            req.getRequestDispatcher("/jsp/template.jsp").forward(req, resp);
            return;
        }
        DBConection conection = new DBConection();
        boolean result = conection.insertDiscipline(discipline);
        if (result) {
            resp.sendRedirect("/discipline-list");
        } else {

        }
    }
}
