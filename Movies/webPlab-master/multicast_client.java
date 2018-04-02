import java.net.*;
import java.io.*;
import java.util.*;
public class multicast_client
{
	public static void main(String[] args) throws Exception
	{
		InetAddress add=InetAddress.getByName("224.0.0.3");
		MulticastSocket s=new MulticastSocket(1234);
		s.joinGroup(add);
		while(true)
		{
			byte[] buff=new byte[1000];
			DatagramPacket p=new DatagramPacket(buff,1000);
			s.receive(p);
			System.out.println(new String(buff));
		}
	}
}