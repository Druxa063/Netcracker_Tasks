package rmi.test.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by User on 11.10.2018.
 */
public class ProductServer {
    public static void main(String args[]) {
        try {
            System.out.println("Constructing server implementations...");
            ProductImpl p1 = new ProductImpl("Blackwell Toaster");
            ProductImpl p2 = new ProductImpl("ZapXpress Microwave Oven");
            System.out.println("Binding server implementations to registry...");
            Product product1 = (Product) UnicastRemoteObject.exportObject(p1, 0);
            Product product2 = (Product) UnicastRemoteObject.exportObject(p2, 0);
            Registry registry = LocateRegistry.createRegistry(12345);
            registry.bind("toaster", product1);
            registry.bind("microwave", product2);
            System.out.println ("Waiting for invocations from clients...");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

}
