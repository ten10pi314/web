import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
public class client
{
	public static void main(String[] args) throws Exception
	{
		Registry reg=LocateRegistry.getRegistry(1099);
		myInt skeleton= (myInt) reg.lookup("operations");
		System.out.println(skeleton.add(10,5)+"\n"+
							skeleton.sub(10,5)+"\n"+
							skeleton.mul(10,5)+"\n"+
							skeleton.div(10,5));
	}
}