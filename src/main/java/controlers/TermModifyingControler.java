package controlers;

import database.DataService;
import entity.Discipline;
import entity.Term;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "TermModifyingControler", urlPatterns = {"/term-modifying"})

public class TermModifyingControler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DataService service = new DataService();

        String idString = req.getParameter("checkboxesModify");
        int id = Integer.parseInt(idString);

        List<Term> alTerms = service.getTermsList();

        Term termToModify;

        Optional<Term> currentTerm = alTerms.stream()
                .filter(term -> term.getId() == id)
                .findFirst();
        termToModify = currentTerm.get();

        List<Discipline> disciplineList = service.getAllDisciplines();

        req.setAttribute("term", termToModify);
        req.setAttribute("disciplineList", disciplineList);
        req.setAttribute("currentPage", "termModifying.jsp");
        req.getRequestDispatcher("/jsp/template.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataService service = new DataService();

        String termsName = req.getParameter("termsName");
        String stringDuration = req.getParameter("duration");

        if (termsName.equals("") || stringDuration.equals("")) {
            req.setAttribute("errorMessage", 3);
            req.setAttribute("currentPage", "termModifying.jsp");
            req.getRequestDispatcher("/jsp/template.jsp").forward(req, resp);
            return;
        }
        int duration = Integer.parseInt(stringDuration);
        int id = Integer.parseInt(req.getParameter("id"));
        String[] disciplineIds = req.getParameterValues("disciplineList");

        Term termToModify = service.getTermById(id);
        termToModify.setName(termsName);
        termToModify.setDuration(duration);

        List<Discipline> selectedDisciplines = new ArrayList<>();
        try {

            if (disciplineIds != null) {
                for (String idDiscAsString : disciplineIds) {
                    int idDisc = Integer.parseInt(idDiscAsString);
                    Discipline discipline = service.getActiveDisciplineById(idDisc);
                    System.out.println("disc with id " + idDisc + " has name " + discipline.getName() + " and was added to this list.");
                    selectedDisciplines.add(discipline);
                }
            } else {
                // then this is aftershock of removing disc from term
            }
        }catch (Exception e){
            e.printStackTrace();
        }

            termToModify.setDisciplines(selectedDisciplines);

            service.termUpdating(termToModify);

            resp.sendRedirect("/terms-list");
        }
    }
