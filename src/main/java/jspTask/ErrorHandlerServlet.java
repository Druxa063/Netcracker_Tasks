package jspTask;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ErrorHandlerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");
        if (servletName == null) {
            servletName = "Unknown";
        }
        request.setAttribute("statusCode", statusCode != null ? statusCode : "");
        request.setAttribute("servletName", servletName);
        request.setAttribute("exceptionType", throwable != null ? throwable.getClass().getName() : "");
        request.setAttribute("ExceptionMessage", throwable != null ? throwable.getMessage() : "");
        request.getRequestDispatcher("exception.jsp").forward(request, response);
    }
}
