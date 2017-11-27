package controlers;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

@WebServlet(name = "DeleteDesciplineFromTermControler", urlPatterns = {"/deleteDiscFromTerm"})
public class DeleteDesciplineFromTermControler extends HttpServlet{
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
        Gson gson = new Gson();


        Map<String, Integer> termAnId = gson.fromJson(data, Map.class);

        for (Map.Entry<String, Integer> entry : termAnId.entrySet()) {

            System.out.println("k: " + entry.getKey() + "  v: " + entry.getValue());
        }


    }
}
