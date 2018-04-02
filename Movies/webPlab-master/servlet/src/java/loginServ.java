import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.*;
import javax.servlet.http.*;

public class loginServ extends HttpServlet {
    private static final String dbClassName = "com.mysql.jdbc.Driver";
    private static final String CONNECTION ="jdbc:mysql://localhost:3306/webprog";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>signupServ</title>");    
        out.println("</head>");
        out.println("<body>");
        try{
            Class.forName(dbClassName);
            Connection c = DriverManager.getConnection(CONNECTION,"student","student");
            Statement stmt=c.createStatement();
            ResultSet rs=stmt.executeQuery("select password,id from student where username='"+request.getParameter("username")+"'");
            String pass;
            boolean flag=false;
            int rno=-1;
            while(rs.next())
            {
                pass=rs.getString(1);
                if(pass.equals(request.getParameter("password")))
                {
                    flag=true;
                    rno=rs.getInt(2);
                    break;
                }
            }
            if(flag==true)
            {
                HttpSession s=request.getSession();
                s.setAttribute("id",rno);
                Cookie userName = new Cookie("id", String.valueOf(rno));
                userName.setMaxAge(30*60);
                response.addCookie(userName);
                response.sendRedirect("mainServ");
            }
            else
            {
                response.sendRedirect("index.html");
            }
            c.close();
        }
        catch(Exception e)
        {
            out.println(e);
        }
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
