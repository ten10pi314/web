import java.rmi.*;
public class myClass implements myInt
{
	public int add(int x,int y){
		return x+y;
	}
	public int sub(int x,int y){
		return x-y;
	}
	public int mul(int x,int y){
		return x*y;
	}
	public int div(int x,int y){
		if(y==0)
			return 0;
		return x/y;
	}
}