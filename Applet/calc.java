import java.applet.*;
import java.awt.*;
import java.awt.event.*;
public class calc extends Applet
{
	TextField op1,op2,res;
	Button add,sub,mul,div;
	public void init()
	{
		op1=new TextField();
		op2=new TextField();
		res=new TextField();
		add=new Button("add");
		sub=new Button("sub");
		mul=new Button("mul");
		div=new Button("div");
		op1.setBounds(100,100,200,20);
		op2.setBounds(100,140,200,20);
		res.setBounds(100,180,200,20);
		add.setBounds(100,220,200,20);
		sub.setBounds(100,260,200,20);
		mul.setBounds(100,300,200,20);
		div.setBounds(100,340,200,20);
		add.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int ans=Integer.parseInt(op1.getText())+Integer.parseInt(op2.getText());
				res.setText(Integer.toString(ans));
			}
		});
		sub.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int ans=Integer.parseInt(op1.getText())-Integer.parseInt(op2.getText());
				res.setText(Integer.toString(ans));
			}
		});
		mul.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int ans=Integer.parseInt(op1.getText())*Integer.parseInt(op2.getText());
				res.setText(Integer.toString(ans));
			}
		});
		div.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int ans=Integer.parseInt(op1.getText())/Integer.parseInt(op2.getText());
				res.setText(Integer.toString(ans));
			}
		});
	}
	public void paint(Graphics g)
	{
		add(op1);
		add(op2);
		add(res);
		add(add);
		add(sub);
		add(mul);
		add(div);
	}
}