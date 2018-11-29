package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "BaseFilter")
public class BaseFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session;

        session = request.getSession();
        if (session.getAttribute("userInfoId") == null) {

            String path = request.getRequestURL().toString();
            String[] requests = path.split("/");
            if (requests[requests.length - 1].equals("doLogin")) {
                chain.doFilter(req, resp);
                return;
            }

            if (requests[requests.length - 1].equals("bootstrap.min.css")) {
                chain.doFilter(req, resp);
                return;
            }

            req.getRequestDispatcher("/login").forward(req, resp);
        } else {
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
