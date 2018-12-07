package jspTask;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CalculationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, RuntimeException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("html/text");
        String action = request.getParameter("action");
        if (action != null) {
            int operand_A = Integer.parseInt(request.getParameter("operand_A"));
            int operand_B = Integer.parseInt(request.getParameter("operand_B"));
            switch (action) {
                case "addition":
                    int addition = operand_A + operand_B;
                    response.getWriter().write(String.valueOf(addition));
                    break;
                case "subtraction":
                    int subtraction = operand_A - operand_B;
                    response.getWriter().write(String.valueOf(subtraction));
                    break;
                case "multiplication":
                    int multiplication = operand_A * operand_B;
                    response.getWriter().write(String.valueOf(multiplication));
                    break;
                case "division":
                    int division = operand_A / operand_B;
                    response.getWriter().write(String.valueOf(division));
                    break;
            }
        } else {
            request.getRequestDispatcher("calculation.jsp").forward(request, response);
        }
    }
}
