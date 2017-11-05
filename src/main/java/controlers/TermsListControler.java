package controlers;

import database.DBConection;
import entity.Term;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TermsListControler", urlPatterns = {"/terms-list","/terms-list/"})
public class TermsListControler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBConection conection = new DBConection();
        List<Term> terms = conection.getTermsList();

        req.setAttribute("terms",terms);
        req.setAttribute("duration",terms.get(0).getDuration());
        req.setAttribute("disciplineList",terms.get(0).getDisciplines());
        req.setAttribute("currentPage","termsList.jsp");
        req.getRequestDispatcher("/jsp/template.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idTerm = req.getParameter("idTerm");
        DBConection conection = new DBConection();
        List<Term> terms = conection.getTermsList();
    }
}
