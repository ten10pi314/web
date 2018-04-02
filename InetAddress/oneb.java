import java.net.*;

public class oneb{

	public static void main(String[] args) throws Exception {
		InetAddress i = InetAddress.getLocalHost();
		System.out.println("Host Name::: " + i.getHostName());
		System.out.println("Host Address::: " + i.getHostAddress());
		System.out.println("Canonical Host Name::: " + i.getCanonicalHostName());
		System.out.println("Is it reachable?::: " + i.isReachable(1000));
		System.out.println("Local?::: " + i.isSiteLocalAddress());
		System.out.println("Class Name::: " + i.getClass().toString());
	} 
}
