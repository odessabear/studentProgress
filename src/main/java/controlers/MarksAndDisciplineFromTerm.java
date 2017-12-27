package controlers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MarksAndDisciplineFromTerm", urlPatterns = {"/students-marks"})
public class MarksAndDisciplineFromTerm extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String stringTermId = req.getParameter("termId");
        String stringStudentId = req.getParameter("studendId");

        int termId = Integer.parseInt(stringTermId);
      //  int studentId = Integer.parseInt(stringStudentId);

        System.out.println("our values are: "+ termId+" and ");
    }
}
