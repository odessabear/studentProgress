package controlers;

import database.DBConection;
import entity.Discipline;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DisciplineModifyControler", urlPatterns = {"/discipline-modify", "/discipline-modify/"})
public class DisciplineModifyControler extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idstr = req.getParameter("checkboxesModify");
        int id = Integer.parseInt(idstr);
        DBConection conection = new DBConection();
        Discipline discipline = conection.getDisciplineById(id);
        req.setAttribute("discipline",discipline);
        req.setAttribute("currentPage", "discModifying.jsp");
        req.getRequestDispatcher("/jsp/template.jsp").forward(req, resp);
    }
}
