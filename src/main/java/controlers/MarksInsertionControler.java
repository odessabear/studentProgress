package controlers;

import database.DataService;
import dto.StudentTerm;
import entity.Student;
import entity.Term;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MarksInsertionControler", urlPatterns = {"/insert-marks"})
public class MarksInsertionControler extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataService dataService = new DataService();
        String idAsString = req.getParameter("checkboxForMarks");
        int idStudent = Integer.parseInt(idAsString);
        Student selectedStudent = dataService.getStudentById(idStudent);
        System.out.println("selected id is " + idStudent);

        List<StudentTerm> termsList =dataService.getAllTermsNamesAndIds();


        req.setAttribute("termsList",termsList);
        req.setAttribute("student", selectedStudent);
        req.setAttribute("currentPage", "markInsertion.jsp");
        req.getRequestDispatcher("/jsp/template.jsp").forward(req, resp);
    }
    }

