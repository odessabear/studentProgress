package controlers;

import database.DBConection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "TermDeleteControler", urlPatterns = {"/term-delete"})
public class TermDeleteControler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("currentPage","termsList.jsp");
        req.getRequestDispatcher("/jsp/template.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional<Integer> maybeIdTerm =
                Optional.ofNullable(req.getParameter("idTerm"))
                        .map(Integer::parseInt);
        DBConection conection = new DBConection();

        if (maybeIdTerm.isPresent()) {
            System.err.println("term is present. removing one with id " + maybeIdTerm.get());
            int idTerm = maybeIdTerm.get();
            conection.disableTerm(idTerm);

            // do your stuff with it
        } else {
            System.err.println("no term with such id");
            // return "no term with such id"
        }
        resp.sendRedirect("/terms-list");

    }
}
