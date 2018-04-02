import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.util.*;

public class client
{
	public static void main(String[] args) throws Exception
	{
		Registry reg=LocateRegistry.getRegistry("localhost",1099);
		myInt skeleton = (myInt) reg.lookup("rmi");
		Scanner in=new Scanner(System.in);
		System.out.println("Enter 2 numbers:");
		System.out.println(skeleton.add(in.nextInt(),in.nextInt()));
		System.out.println("Enter file name:");
		System.out.println(skeleton.getFile(in.next()));
	}
}