package controlers;

import database.DBConection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@WebServlet(name = "DeleteDisciplineControler", urlPatterns = {"/discipline-delete", "/discipline-delete/"})
public class DeleteDisciplineControler extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String checkboxes = req.getParameter("checkboxes");
        StringTokenizer stringTokenizer = new StringTokenizer(checkboxes, "|");
        List<String> ids = new ArrayList<String>();
        while (stringTokenizer.hasMoreTokens()){
            ids.add(stringTokenizer.nextToken());
        }

        DBConection conection = new DBConection();
        for (String idstr:ids){
            int id=Integer.parseInt(idstr);
            conection.deleteDiscipline(id);
        }
        resp.sendRedirect("/discipline-list");


    }
}
