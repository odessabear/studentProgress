package controlers;

import com.google.gson.Gson;
import database.DataService;
import dto.SelectedTermAndDiscipline;
import utils.GsonSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(name = "DeleteDesciplineFromTermControler", urlPatterns = {"/deleteDiscFromTerm"})
public class DeleteDesciplineFromTermControler extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        StringBuilder buffer = new StringBuilder();
        BufferedReader reader = req.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            buffer.append(line);
        }
        String data = buffer.toString();

        System.out.println("we have new request to delete discipline from  term ::: " + data);

        Gson gson = GsonSingleton.INSTANCE.getGson();
        SelectedTermAndDiscipline fromFrontend = gson.fromJson(data, SelectedTermAndDiscipline.class);

        System.out.println("got object from frontend: " + fromFrontend);

        DataService service = new DataService();
        service.deleteDisciplineFromTerm(fromFrontend);


        System.out.println("current id is " + fromFrontend.getTermId());


        resp.sendRedirect("/term-modifying");
    }

}

