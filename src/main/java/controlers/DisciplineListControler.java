package controlers;

import database.DBConection;
import entity.Discipline;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DisciplineListControler", urlPatterns = {"/discipline-list","/discipline-list/"})
public class DisciplineListControler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBConection conection = new DBConection();
        List<Discipline> disciplines = conection.getAllDisciplines();

        req.setAttribute("disciplines",disciplines);
        req.setAttribute("currentPage","discList.jsp");
        req.getRequestDispatcher("/jsp/template.jsp").forward(req, resp);
    }
}
