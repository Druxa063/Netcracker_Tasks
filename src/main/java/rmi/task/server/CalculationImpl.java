package rmi.task.server;

import rmi.task.Tack;

/**
 * Created by User on 14.10.2018.
 */
public class CalculationImpl implements Calculation {

    @Override
    public double getCalculation(Tack tack) {
        double a = tack.getA();
        double b = tack.getB();
        switch (tack.getAction()) {
            case "+" :
                return a + b;
            case "-" :
                return a - b;
            case "*" :
                return a * b;
            case "/" :
                return a / b;
            default:
                throw new RuntimeException("Выбрано не верное математическое действие");
        }
    }
}
