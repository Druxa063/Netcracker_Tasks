package rmi.test.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by User on 11.10.2018.
 */
public interface Product extends Remote {
    /**
     * Gets the description of this product.
     * @return the product description
     */
    String getDescription() throws RemoteException;
}

