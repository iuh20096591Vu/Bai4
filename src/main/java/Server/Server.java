package Server;

import dao.DoctorDAO;
import dao.impl.DoctorImpl;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {
    private static final String URL = "rmi://DESKTOP-RB92ON5:7878/";

    public static void main(String[] args) throws NamingException, Exception {
        Context context = new InitialContext();

        DoctorDAO doctorDAO = new DoctorImpl(); //java remote object

        LocateRegistry.createRegistry(7878);
        context.bind(URL + "doctorDAO", doctorDAO);

        System.out.println("Server is running...");
    }
}
