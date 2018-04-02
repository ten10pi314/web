import java.rmi.*;
import java.io.*;
public class myIntImpl implements myInt
{
	public int add(int a,int b)
	{
		return a+b;
	}
	public String getFile(String fileName)
	{
		String s="";
		try{
			FileInputStream f=new FileInputStream(fileName);
			int x;
			while((x=f.read())!=-1)
			{
				s=s+(char)x;
			}
			f.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return s;
	}
}