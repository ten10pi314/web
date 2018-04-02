import java.io.*;
import java.net.*;
import java.util.*;

public class server
{
	public static void main(String[] args) throws Exception
	{
		ServerSocket ss=new ServerSocket(1234);
		Socket s=ss.accept();
		DataInputStream in=new DataInputStream(s.getInputStream());
		DataOutputStream out=new DataOutputStream(s.getOutputStream());
		System.out.println("To send files, type 'file <filename>'");
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			System.out.println("wait for Client:");
			String recv=in.readUTF();
			String[] arr=recv.split(" ");
			if(arr[0].equals("file"))
			{
				FileOutputStream f=new FileOutputStream(arr[1]);
				int x=Integer.parseInt(in.readUTF());
				while(x!=0)
				{
					f.write(in.read());
					x--;
				}
				recv="received "+recv;
			}
			System.out.println(recv);
			System.out.println("Server:");
			recv=sc.nextLine();
			arr=recv.split(" ");
			out.writeUTF(recv);
			if(arr[0].equals("file"))
			{
				FileInputStream f=new FileInputStream(arr[1]);
				int x=0;
				while(f.read()!=-1)
				{
					x++;
				}
				out.writeUTF(Integer.toString(x));
				f=new FileInputStream(arr[1]);
				while((x=f.read())!=-1)
				{
					out.write(x);
				}
				System.out.println("sent "+recv);
			}
		}
	}
}
