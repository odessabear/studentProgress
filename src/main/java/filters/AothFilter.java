package filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AothFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String url = request.getRequestURI();

        if (url.equals("/login") || url.equals("/") || url.endsWith(".js") || url.endsWith(".css")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            Object idRole = request.getSession().getAttribute("role");
            if (idRole == null) {
                ((HttpServletResponse) servletResponse).sendRedirect("/login");
                return;
            }

            if (idRole.equals("")) {
                ((HttpServletResponse) servletResponse).sendRedirect("/login");
                return;
            }
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }

    @Override
    public void destroy() {

    }
}
