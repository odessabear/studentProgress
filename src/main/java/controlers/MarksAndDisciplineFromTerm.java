package controlers;

import com.google.gson.Gson;
import database.DataService;
import dto.TermAndMark;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MarksAndDisciplineFromTerm", urlPatterns = {"/students-marks"})
public class MarksAndDisciplineFromTerm extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DataService service = new DataService();
        String stringTermId = req.getParameter("termId");
        String stringStudentId = req.getParameter("studentId");

        int termId = Integer.parseInt(stringTermId);
        int studentId = Integer.parseInt(stringStudentId);

        System.out.println("our values are: " + termId + " and " + studentId);


        List<TermAndMark> progress = service.getStudentProgressByStudentAndTermIds(studentId, termId);

        Gson gson = new Gson();
        String jsonS = gson.toJson(progress);

        System.out.println("gson = " + jsonS);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(jsonS);
        out.flush();
    }
}
