import java.rmi.*;
import java.io.*;

public interface myInt extends Remote
{
	public int add(int a,int b) throws RemoteException;
	public String getFile(String fileName) throws RemoteException;
};