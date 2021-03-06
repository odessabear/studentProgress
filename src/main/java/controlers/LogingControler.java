package controlers;

import database.DBConection;
import database.DataService;
import entity.Role;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LogingControler", urlPatterns = {"/login", "/logon/"})
public class LogingControler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataService dataService = new DataService();
        List<Role> roles = dataService.getAllRoles();

        req.setAttribute("roles", roles);

        req.setAttribute("currentPage", "login.jsp");
        req.getRequestDispatcher("/jsp/template.jsp").forward(req, resp);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String role = req.getParameter("role");
        int idRole = Integer.parseInt(role);


        DataService dataService = new DataService();
        int idAccount=dataService.isAvailableUser(login, password);
        if (idAccount!=-1) {
            if (dataService.isCorrectRoleFromUser(idAccount,idRole)){
                req.getSession().setAttribute("role", idRole);
                resp.sendRedirect("/home");
            }else {

                List<Role> roles = dataService.getAllRoles();

                req.setAttribute("roles", roles);
                req.setAttribute("errorMessage", 2);

                req.setAttribute("currentPage", "login.jsp");
                req.getRequestDispatcher("/jsp/template.jsp").forward(req, resp);
            }
        }else{

            List<Role> roles = dataService.getAllRoles();

            req.setAttribute("roles", roles);
            req.setAttribute("errorMessage", 1);

            req.setAttribute("currentPage", "login.jsp");
            req.getRequestDispatcher("/jsp/template.jsp").forward(req, resp);
        }

    }
}
