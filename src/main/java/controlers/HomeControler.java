package controlers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "HomeControler", urlPatterns = {"/home", "/home/"})
public class HomeControler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie avtor = new Cookie("avtor", "Alexander");
        resp.addCookie(avtor);

        HttpSession httpSession = req.getSession();


        req.setAttribute("currentPage", "title.jsp");
        req.getRequestDispatcher("/jsp/template.jsp").forward(req, resp);
    }
}
