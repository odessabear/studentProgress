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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBConection conection = new DBConection();
        List<Term> terms = conection.getTermsList();

        int defaultTermId = 0;
        Optional<Integer> idTerm =
                Optional.ofNullable(req.getParameter("idTerm"))
                        .map(Integer::parseInt)
                        .map(termFromFrontEnd -> termFromFrontEnd - 1);

        req.setAttribute("terms", terms);
        req.setAttribute("duration", terms.get(idTerm.orElse(defaultTermId)).getDuration());
        req.setAttribute("disciplineList", terms.get(idTerm.orElse(defaultTermId)).getDisciplines());
        req.setAttribute("currentPage", "termsList.jsp");
        req.getRequestDispatcher("/jsp/template.jsp").forward(req, resp);

        resp.sendRedirect("/terms-list");
    }
}
