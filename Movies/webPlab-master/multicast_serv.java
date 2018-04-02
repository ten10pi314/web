import java.net.*;
import java.io.*;
import java.util.*;
public class multicast_serv
{
	public static void main(String[] args) throws Exception
	{
		InetAddress add=InetAddress.getByName("224.0.0.3");
		MulticastSocket s=new MulticastSocket(1234);
		s.joinGroup(add);
		Scanner in=new Scanner(System.in);
		while(true)
		{
			String message=in.next();
			DatagramPacket p=new DatagramPacket(message.getBytes(),message.length(),add,1234);
			s.send(p);
		}
	}
}