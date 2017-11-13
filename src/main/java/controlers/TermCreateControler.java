package controlers;

import database.DBConection;
import entity.Term;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static utils.Utils.stringIsEmpty;

@WebServlet(name = "TermCreateControler", urlPatterns = {"/term-create"})

public class TermCreateControler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("currentPage", "termCreating.jsp");
        req.getRequestDispatcher("/jsp/template.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String termsName = req.getParameter("termsName");
        String duration = req.getParameter("duration");
        int valueOfDuration = Integer.parseInt(duration);

        DBConection conection = new DBConection();
        if (stringIsEmpty(termsName) || valueOfDuration == 0) {
            req.setAttribute("errorMessage",3);
            req.setAttribute("currentPage", "termCreating.jsp");
            req.getRequestDispatcher("/jsp/template.jsp").forward(req, resp);
            return;
        }
        conection.createNewTerm(termsName,valueOfDuration);
        resp.sendRedirect("/terms-list");
    }

}
