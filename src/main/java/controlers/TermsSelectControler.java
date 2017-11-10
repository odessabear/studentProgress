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
import java.util.Optional;

@WebServlet(name = "TermsSelectControler", urlPatterns = {"/terms-select"})
public class TermsSelectControler extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBConection conection = new DBConection();
        List<Term> terms = conection.getTermsList();


        Optional<String> termName =
                Optional.ofNullable(req.getParameter("termName"));
        Term maybeTerm = terms.stream()
                .filter(term -> term.getName().toLowerCase().equals(termName.get().toLowerCase()))
                .findFirst().get();

        req.setAttribute("terms",  maybeTerm);
        req.setAttribute("duration", maybeTerm.getDuration());
        req.setAttribute("idSelectedTerm",maybeTerm.getId());
        req.setAttribute("disciplineList", maybeTerm.getDisciplines());
        req.setAttribute("currentPage", "termsList.jsp");
        req.getRequestDispatcher("/jsp/template.jsp").forward(req, resp);

        resp.sendRedirect("/terms-list");
    }
}
