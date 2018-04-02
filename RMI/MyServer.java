import java.rmi.*;
import java.rmi.registry.*;

public class MyServer{
	public static void main(String[] args) {
		try {
			Adder stub = new AdderRemote();
			Naming.rebind("rmi://localhost:5000/akshay" , stub);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}