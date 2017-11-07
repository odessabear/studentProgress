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
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

@WebServlet(name = "TermsToDisciplineMappingController",
        urlPatterns = {"/disciplinesForTerm"})
public class TermToDisciplineMappingController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBConection conection = new DBConection();
        int termId = Integer.parseInt(req.getParameter("termId"));
        Term foundTerm = conection.getTermsList().stream()
                .filter(term -> term.getId() == termId)
                .findFirst().get();
        List<String> disciplineNames =
                foundTerm
                        .getDisciplines()
                        .stream()
                        .map(Discipline::getName)
                        .collect(Collectors.toList());
        StringJoiner joiner = new StringJoiner(",");
        disciplineNames.forEach(joiner::add);

        resp.setStatus(200);
        resp.setHeader("Content-Type", "text/plain; charset=UTF-8");

        resp.getWriter().write(joiner.toString());
        resp.getWriter().flush();
        resp.getWriter().close();
    }
}
