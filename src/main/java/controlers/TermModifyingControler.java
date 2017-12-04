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
import java.util.List;

@WebServlet(name = "TermModifyingControler", urlPatterns = {"/term-modifying"})

public class TermModifyingControler extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DataService service = new DataService();
        String idString = req.getParameter("checkboxesModify");
        int id = Integer.parseInt(idString);

        Term termToModify = service.getTermById(id);


        req.setAttribute("term", termToModify);
        req.setAttribute("currentPage", "termModifying.jsp");
        req.getRequestDispatcher("/jsp/template.jsp").forward(req, resp);
    }
}
