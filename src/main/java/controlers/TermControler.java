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
import java.util.*;
import java.util.stream.Collectors;

@WebServlet(name = "TermControler", urlPatterns = {"/term"})
public class TermControler extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBConection conection = new DBConection();
        List<Term> terms = conection.getTermsList();

        Term termToInsertToFrontend;

        if (isEmpty(req.getParameter("id"))) {
            // assume creation
            termToInsertToFrontend = getEmptyTermForCreation();
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

    private Term getEmptyTermForCreation() {
        DBConection conection = new DBConection();
        List<Discipline> disciplineList = conection.getAllDisciplines();
        Term emptyTerm = new Term();
        emptyTerm.setId(0);


        emptyTerm.setName("");
        emptyTerm.setDuration(0);
        emptyTerm.setDisciplines(disciplineList);

        System.out.println(emptyTerm);

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

        Term termToCreate = new Term();
        termToCreate.setDuration((Integer.parseInt(req.getParameter("durationLength"))));
        termToCreate.setName(req.getParameter("name"));

        String[] disciplineIds = req.getParameterValues("disciplineList");
        System.out.println("DISC ID is " + Arrays.deepToString(disciplineIds));

        List<Discipline> chosenDisciplines = new ArrayList<>();
        for (String discIdAsString : disciplineIds) {
            int discId = Integer.parseInt(discIdAsString);
            Discipline discipline = conection.getDisciplineById(discId);
            System.out.println("disc with id " + discId + " has name " + discipline.getName() + " and was added to this list.");
            chosenDisciplines.add(discipline);
        }

        termToCreate.setDisciplines(chosenDisciplines);

        int addedTermId = conection.createNewTerm(termToCreate);


        // TODO: add redirect to term with the ID above.


        resp.sendRedirect("/term?id=" + addedTermId);
    }
}
