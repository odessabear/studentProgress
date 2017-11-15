package controlers;

import database.DBConection;
import entity.Discipline;
import entity.Term;
import sun.security.pkcs11.Secmod;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "TermControler", urlPatterns = {"/term"})
public class TermControler extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBConection conection = new DBConection();
        List<Term> terms = conection.getTermsList();

        Term termToInsertToFrontend;

        if (isEmpty(req.getParameter("id"))) {
            // assume creation
            termToInsertToFrontend = getEmptyTurnForCreation();
        } else {
            int termIdFromFrontend = Integer.parseInt(req.getParameter("id"));
            Optional<Term> currentTerm = terms.stream()
                    .filter(term -> term.getId() == termIdFromFrontend)
                    .findFirst();
            termToInsertToFrontend = currentTerm.get();
        }

        req.setAttribute("term", termToInsertToFrontend);
        req.setAttribute("currentPage", "term.jsp");
        req.getRequestDispatcher("/jsp/template.jsp").forward(req, resp);
    }

    private Term getEmptyTurnForCreation() {
        DBConection conection = new DBConection();
        List<Discipline> disciplineList = conection.getAllDisciplines();
        Term emptyTerm = new Term();
        emptyTerm.setId(0);


        emptyTerm.setName("");
        emptyTerm.setDuration(0);
        emptyTerm.setDisciplines(disciplineList);

        // 1 - create empty term
        return emptyTerm;
    }

    private boolean isEmpty(String id) {
        return (id == null || id.length() == 0);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBConection conection = new DBConection();

        System.out.println("we have new request to create term");
        for (Map.Entry<String, String[]> requestParameter : req.getParameterMap().entrySet()) {
            System.out.println("parameter key: " + requestParameter.getKey());
            System.out.println("parameter values: " + Arrays.deepToString(requestParameter.getValue()));
        }
    }
}
