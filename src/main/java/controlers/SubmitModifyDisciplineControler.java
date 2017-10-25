package controlers;

import database.DBConection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SubmitModifyDisciplineControler", urlPatterns = {"/discipline-modify-submit"})
public class SubmitModifyDisciplineControler extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String disciplineName = req.getParameter("nameDiscipline");
        if(disciplineName.equals("")){
            req.setAttribute("errorMessage",3);
            req.setAttribute("currentPage", "discModifying.jsp");
            req.getRequestDispatcher("/jsp/template.jsp").forward(req, resp);
            return;
        }
        String idDisciplineStr = req.getParameter("idDiscipline");
        int idDisipline = Integer.parseInt(idDisciplineStr);
        DBConection conection = new DBConection();
        conection.modifyingDisciplineById(idDisipline,disciplineName);
        resp.sendRedirect("/discipline-list");


    }
}
