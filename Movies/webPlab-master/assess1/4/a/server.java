import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
public class server
{
	public static void main(String[] args) throws Exception
	{
		myIntImpl serv=new myIntImpl();
		myInt stub=(myInt) UnicastRemoteObject.exportObject((myInt)serv,0);
		Registry reg=LocateRegistry.createRegistry(1099);
		reg.rebind("rmi",stub);
	}
}