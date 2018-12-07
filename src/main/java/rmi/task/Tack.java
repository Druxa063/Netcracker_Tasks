package rmi.task;

import java.io.Serializable;
import java.rmi.Remote;

/**
 * Created by User on 14.10.2018.
 */
public class Tack implements Serializable {
    private double a;
    private double b;
    private String action;

    public Tack(double a, double b, String action) {
        this.a = a;
        this.b = b;
        this.action = action;
    }

    public double getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
