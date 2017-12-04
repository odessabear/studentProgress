package controlers;

import entity.Term;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TermModifyingControler", urlPatterns = {"/term-modifying"})

public class TermModifyingControler extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Term termToModify = new Term();
        req.setAttribute("term",termToModify);
        req.setAttribute("currentPage", "termModifying.jsp");
        req.getRequestDispatcher("/jsp/template.jsp").forward(req, resp);
    }
}
