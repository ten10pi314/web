import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
public class server
{
	public static void main(String[] args) throws Exception
	{
		myClass obj=new myClass();
		myInt stub=(myInt) UnicastRemoteObject.exportObject((myInt)obj,0);
		Registry reg=LocateRegistry.createRegistry(1099);
		reg.rebind("operations",stub);
	}
}