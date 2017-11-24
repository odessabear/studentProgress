package controlers;

import database.DBConection;
import database.DataService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@WebServlet(name = "DeleteStudentControler", urlPatterns = {"/students-deleting"})
public class DeleteStudentControler extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String checkboxes = req.getParameter("checkboxes");
        StringTokenizer stringTokenizer = new StringTokenizer(checkboxes,"|");
        List<String> ids = new ArrayList<>();
        while (stringTokenizer.hasMoreTokens()){
            ids.add(stringTokenizer.nextToken());
        }

        DataService dataService = new DataService();
        for (String idStr:ids){
            int id=Integer.parseInt(idStr);
            dataService.deleteStudent(id);
        }
        resp.sendRedirect("/students-list");

    }
}
