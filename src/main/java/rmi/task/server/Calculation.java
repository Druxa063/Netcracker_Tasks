package rmi.task.server;

import rmi.task.Tack;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by User on 14.10.2018.
 */
public interface Calculation extends Remote {

    double getCalculation(Tack tack) throws RemoteException;
}
