package controlers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LogingControler",urlPatterns = {"/login","/logon/"})
public class LogingControler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> roles = new ArrayList<String>();
        roles.add("student");
        roles.add("administrator");
        roles.add("teacher");

        req.setAttribute("roles", roles);

        req.getRequestDispatcher("/jsp/login.jsp").forward(req,resp);

    }
}
