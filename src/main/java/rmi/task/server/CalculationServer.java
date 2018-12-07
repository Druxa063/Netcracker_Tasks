package rmi.task.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by User on 14.10.2018.
 */
public class CalculationServer {

    public static void main(String[] args) {
        try {
            System.out.println("Constructing server implementations...");
            CalculationImpl calculation = new CalculationImpl();
            System.out.println("Binding server implementations to registry...");
            UnicastRemoteObject.exportObject(calculation, 0);
            Registry registry = LocateRegistry.createRegistry(12345);
            registry.bind("calculation", calculation);
            System.out.println ("Waiting for invocations from clients...");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
