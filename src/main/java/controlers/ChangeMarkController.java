package controlers;

import com.google.gson.Gson;
import database.DataService;
import dto.MarkAndID;
import utils.GsonSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(name = "ChangeMarkController", urlPatterns = {"/change-mark"})

public class ChangeMarkController extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataService service = new DataService();

       /* String stringTermId = req.getParameter("termId");
        String stringStudentId = req.getParameter("studentId");

        int termId = Integer.parseInt(stringTermId);
        int studentId = Integer.parseInt(stringStudentId);

        System.out.println("values are: " + termId+ " & " + studentId);*/

        StringBuilder buffer = new StringBuilder();
        BufferedReader reader = req.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            buffer.append(line);
        }
        String data = buffer.toString();

        System.out.println("we want to change mark with next ID : "+data);

        Gson gson = GsonSingleton.INSTANCE.getGson();
        MarkAndID dataFromFrontend = gson.fromJson(data, MarkAndID.class);

        System.out.println("got object from frontend: " + dataFromFrontend);
;

        System.out.println("current id is ");


        resp.sendRedirect("/students-progress?selectedCheckbox=");


    }
}
