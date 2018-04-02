public class student
{
    int regno,total;
    int[] mark;
    double average;
    String name,dept;
    String[] grade;
    student(String regno,String name,String dept, String mark1, String mark2, String mark3 )
    {
        this.regno=Integer.parseInt(regno);
        this.name=name;
        this.dept=dept;
        this.mark=new int[3];
        this.mark[0]=Integer.parseInt(mark1);
        this.mark[1]=Integer.parseInt(mark2);
        this.mark[2]=Integer.parseInt(mark3);
        this.total=this.mark[0]+this.mark[1]+this.mark[2];
        this.average=total/3.0;
        String s[]=new String[]{"RA","B","B+","A","A+","O"};
        this.grade=new String[3];
        for(int k=0;k<3;k++)
        {
            int i=(int)Math.floor(mark[k]/10);
            if(i>=9)    i=9;
            if(i<=0)    i=0;
            this.grade[k]=s[i-4];
        }
    }
    String getString()
    {
        String s=name+"  "+total+" "+average+" ";
        for(int i=0;i<3;i++)
            s=s+grade[i]+" ";
        s=s+"\n";
        return s;
    }
}