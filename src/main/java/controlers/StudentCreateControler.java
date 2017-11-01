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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@WebServlet(name = "StudentCreateControler", urlPatterns = {"/student-create"})
public class StudentCreateControler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("currentPage", "stCreating.jsp");
        req.getRequestDispatcher("/jsp/template.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String surname = req.getParameter("surname");
        String name = req.getParameter("name");
        String group = req.getParameter("group");
        String intDate = req.getParameter("intDate");
        if (surname==null||name==null||group==null||intDate==null){
            req.setAttribute("errorMessage",3);
            req.setAttribute("currentPage", "stCreating.jsp");
            req.getRequestDispatcher("/jsp/template.jsp").forward(req, resp);
            return;
        }
        if (surname.equals("")||name.equals("")||group.equals("")||intDate.equals("")){
            req.setAttribute("errorMessage",3);
            req.setAttribute("currentPage", "stCreating.jsp");
            req.getRequestDispatcher("/jsp/template.jsp").forward(req, resp);
            return;
        }

        Timestamp timestamp = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date parsedDate = dateFormat.parse(intDate);
            timestamp = new java.sql.Timestamp(parsedDate.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        DBConection conection = new DBConection();
        conection.insertNewStudent(surname, name, group, timestamp);

        resp.sendRedirect("/students-list");


    }
}

