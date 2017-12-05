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

@WebServlet(name = "TermModifyingControler", urlPatterns = {"/term-modifying"})

public class TermModifyingControler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DataService service = new DataService();
        String idString = req.getParameter("checkboxesModify");
        int id = Integer.parseInt(idString);

        Term termToModify = service.getTermById(id);
        List<Discipline> disciplines = service.getAllDisciplines();
        termToModify.setDisciplines(disciplines);

        req.setAttribute("term", termToModify);
        req.setAttribute("disciplines", disciplines);
        req.setAttribute("currentPage", "termModifying.jsp");
        req.getRequestDispatcher("/jsp/template.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataService service = new DataService();

        String termsName = req.getParameter("termsName");
        int duration = Integer.parseInt(req.getParameter("duration"));
        int id = Integer.parseInt(req.getParameter("id"));
        String[] disciplineIds = req.getParameterValues("disciplineList");

        Term termToModify = service.getTermById(id);
        termToModify.setName(termsName);
        termToModify.setDuration(duration);

        List<Discipline> selectedDisciplines = new ArrayList<>();

        for (String idDiscAsString : disciplineIds) {
            int idDisc = Integer.parseInt(idDiscAsString);
            Discipline discipline = service.getDisciplineById(idDisc);
            System.out.println("disc with id " + idDisc + " has name " + discipline.getName() + " and was added to this list.");
            selectedDisciplines.add(discipline);
        }

        termToModify.setDisciplines(selectedDisciplines);

        service.termUpdating(termToModify);

        resp.sendRedirect("/term?=" + id);
    }
}
