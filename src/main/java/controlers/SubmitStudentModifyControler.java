package controlers;

import database.DBConection;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "SubmitStudentModifyControler", urlPatterns = {"/students-modifying-submit"})
public class SubmitStudentModifyControler extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String surname = req.getParameter("surname");
        String name = req.getParameter("name");
        String group = req.getParameter("group");
        String inDate = req.getParameter("inDate");
        String idstr = req.getParameter("id");
        if (surname==null||name==null||group==null||inDate==null){
            req.setAttribute("errorMessage",3);
            req.setAttribute("currentPage", "stModifying.jsp");
            req.getRequestDispatcher("/jsp/template.jsp").forward(req, resp);
            return;
        }
        if (surname.equals("")||name.equals("")||group.equals("")||inDate.equals("")){
            int id = Integer.parseInt(idstr);
            DBConection conection = new DBConection();
            Student student=conection.getStudentById(id);
            req.setAttribute("student",student);
            req.setAttribute("errorMessage",3);
            req.setAttribute("currentPage", "stModifying.jsp");
            req.getRequestDispatcher("/jsp/template.jsp").forward(req, resp);
            return;
        }

        Timestamp timestamp = null;
        try {
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date parsedDate = dateFormat.parse(inDate);
            timestamp = new java.sql.Timestamp(parsedDate.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }

        int id = Integer.parseInt(idstr);
        DBConection conection = new DBConection();
        conection.updateStudent(id,surname, name, group, timestamp);

        resp.sendRedirect("/students-list");
    }
}
