package rmi.task.client;

import rmi.task.Tack;
import rmi.task.server.Calculation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by User on 15.10.2018.
 */
public class CalculationClient {

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry(null, 12345);
            Calculation calculation = (Calculation) registry.lookup("calculation");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter first operand");
            double a = Double.parseDouble(br.readLine());
            System.out.println("Enter action");
            String action = br.readLine();
            System.out.println("Enter second operand");
            double b = Double.parseDouble(br.readLine());
            Tack tack = new Tack(a, b, action);
            System.out.println(calculation.getCalculation(tack));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
