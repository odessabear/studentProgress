package controlers;

import com.google.gson.Gson;
import database.DataService;
import dto.IdTermDisciplineAndDiscipline;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "MarkInsertionController", urlPatterns = {"/mark-insertion"})

public class MarkInsertionController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataService dataService = new DataService();

        String stringTermId = req.getParameter("termId");
        int termId = Integer.parseInt(stringTermId);

        System.out.println("our value is: " + termId);

        List<IdTermDisciplineAndDiscipline> idsAndDisciplines = dataService.getIdTermDisciplineAndDisciplineByTermId(termId);

        Gson gson = new Gson();
        String jsons = gson.toJson(idsAndDisciplines);

        System.out.println("our gsons is " + jsons);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter output = resp.getWriter();
        output.print(jsons);
        output.flush();
    }
}
