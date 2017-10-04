import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HomeServlet", urlPatterns = {"/home","/home/"})
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.getWriter().print("<!DOCTYPE html>");
        resp.getWriter().print("<html>");
        resp.getWriter().print("<head>");
        resp.getWriter().print("<meta charset=\"utf-8\">");
        resp.getWriter().print("<title>title</title>");
        resp.getWriter().print(" <link rel = \"stylesheet\" href=\"c://www//1-stCSS.css\">");
        resp.getWriter().print("</head><body><h1>Title Page</h1><div class=\"sub-header-wrapper\">");
        resp.getWriter().print("<h2 class=\"sub-header\"><em>Система управления студентами и их успеваемостью</em></h2>");
        resp.getWriter().print("<a class=\"logout-link\" href=\"#\">Logout</a>");
        resp.getWriter().print("</div><br><center>");
        resp.getWriter().print(" <div class = \"links\">");
        resp.getWriter().print("<div><a href=\"back.html\">Студенты</a></div>");
        resp.getWriter().print("<div><a href=\"main.html\">Дисциплины</a></div>");
        resp.getWriter().print("<div><a href=\"main.html\">Семестры</a></div>");
        resp.getWriter().print("</div>");
        resp.getWriter().print("</body></html>");
    }
}
