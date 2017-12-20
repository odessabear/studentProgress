package controlers;

import database.DBConection;
import database.DataService;
import dto.TermAndMark;
import entity.Mark;
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

@WebServlet(name = "StudentProgressControler", urlPatterns = {"/students-progress"})
public class StudentProgressControler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataService dataService = new DataService();
        String idAsString = req.getParameter("selectedCheckbox");
        int idStudent = Integer.parseInt(idAsString);
        Student selectedStudent = dataService.getStudentById(idStudent);
        System.out.println("selected id is " + idStudent);



        List<TermAndMark> termAndMarks = dataService.getStudentMarksByStudentId(idStudent);
        String term = null;
        String discipline = null;
        int mark = 0;
        for (TermAndMark result : termAndMarks) {
            term = result.getTermName();
            discipline = result.getDiscipline();
            mark = result.getMark();
        }

        req.setAttribute("term", term);
        req.setAttribute("discipline", discipline);
        req.setAttribute("mark", mark);
        req.setAttribute("student", selectedStudent);
        req.setAttribute("currentPage", "stProgress.jsp");
        req.getRequestDispatcher("/jsp/template.jsp").forward(req, resp);
    }
}
