import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.*;
import javax.servlet.http.*;

public class mainServ extends HttpServlet {
    private static final String dbClassName = "com.mysql.jdbc.Driver";
    private static final String CONNECTION ="jdbc:mysql://localhost:3306/webprog";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet mainServ</title>");            
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"forms.css\">");
            out.println("</head>");
            out.println("<body>");
            try{
                int id=-1;
                id=Integer.parseInt(request.getSession().getAttribute("id").toString());
                if(id!=-1)
                {
                    Class.forName(dbClassName);
                    Connection c = DriverManager.getConnection(CONNECTION,"student","student");
                    Statement stmt=c.createStatement();
                    ResultSet rs=stmt.executeQuery("select name from student where id='"+id+"'");
                    while(rs.next())
                    {
                        out.println("<h3>Welcome, "+rs.getString(1)+"</h3>");
                    }
                    out.println("<form action='logoutServ'>");
                    out.println("<p align='center'><input type='submit' value='Log Out' /></p>");
                    out.println("</form>");
                    c.close();
                }
            }
            catch(Exception e)
            {
                response.sendRedirect("index.html");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
