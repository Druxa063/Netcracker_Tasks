package rmi.test.client;

import rmi.test.server.Product;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by User on 11.10.2018.
 */
public class ProductClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry(null, 12345);
            Product c1 = (Product) registry.lookup("toaster");
            Product c2 = (Product) registry.lookup("microwave");
            System.out.println(c1.getDescription());
            System.out.println(c2.getDescription());
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

}
