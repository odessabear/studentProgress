package controlers;

import database.DBConection;
import entity.Discipline;
import entity.Term;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "TermsListControler", urlPatterns = {"/terms-list"})
public class TermsListControler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBConection conection = new DBConection();

        List<Term> terms = conection.getTermsList();

        Term currentTerm;

        if (terms.size() == 0) {
            Term emptyTerm = new Term();
            emptyTerm.setId(0);
            emptyTerm.setDisciplines(Collections.singletonList(new Discipline()));
            emptyTerm.setName("");
            emptyTerm.setDuration(0);
            currentTerm = emptyTerm;
        } else {
            currentTerm = terms.get(0);
        }

        req.setAttribute("terms",terms);
        req.setAttribute("duration",currentTerm.getDuration());
        req.setAttribute("idSelectedTerm",currentTerm.getId());
        req.setAttribute("disciplineList",currentTerm.getDisciplines());
        req.setAttribute("currentPage","termsList.jsp");
        req.getRequestDispatcher("/jsp/template.jsp").forward(req, resp);
    }

}
