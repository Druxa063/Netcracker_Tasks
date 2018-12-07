package sessionBeanTask;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class CalculationServlet extends HttpServlet {

    @EJB
    private Calculation calculation;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("html/text");
        Calculation calculationSession = (Calculation) request.getSession().getAttribute("calculationSession");
        if (calculationSession == null) {
            request.getSession().setAttribute("calculationSession", calculation);
            calculationSession = calculation;
        }
        String action = request.getParameter("action");
        int operand_A = Integer.parseInt(request.getParameter("operand_A"));
        int operand_B = Integer.parseInt(request.getParameter("operand_B"));
        calculationSession.setOperand_A(operand_A);
        calculationSession.setOperand_B(operand_B);
        System.out.println(calculationSession.getOperand_A() + " - " + calculationSession.getOperand_B());
        switch (action) {
            case "addition":
                System.out.println("Servlet addition");
                calculationSession.addition();
                response.getWriter().write(calculationSession.getJSON());
                break;
            case "subtraction":
                calculationSession.subtraction();
                response.getWriter().write(calculationSession.getJSON());
                break;
            case "multiplication":
                calculationSession.multiplication();
                response.getWriter().write(calculationSession.getJSON());
                break;
            case "division":
                calculationSession.division();
                response.getWriter().write(calculationSession.getJSON());
                break;
            case "saveCurrentResultInMemory" :
                calculationSession.saveCurrentResultInMemory();
                response.getWriter().write(calculationSession.getJSON());
                break;
            case "extractMemoryInOperands" :
                calculationSession.extractMemoryInOperands();
                response.getWriter().write(calculationSession.getJSON());
                break;
            case "resetMemory" :
                calculationSession.resetMemory();
                response.getWriter().write(calculationSession.getJSON());
                break;
        }
    }
}
