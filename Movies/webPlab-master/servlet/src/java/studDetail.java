import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class studDetail extends HttpServlet {
    private static final String dbClassName = "com.mysql.jdbc.Driver";
    private static final String CONNECTION ="jdbc:mysql://localhost:3306/webprog";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet studDetail</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"forms.css\">");
            out.println("</head>");
            out.println("<body>");
            
            try{
                Class.forName(dbClassName);
                Connection c = DriverManager.getConnection(CONNECTION,"student","student");
                Statement stmt=c.createStatement();
                ResultSet rs=stmt.executeQuery("select * from studDetail");
                out.println("<h3>Result from Database:</h3>");
                while(rs.next())
                {
                    out.println("<p>"+rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+"</p>");
                }
                rs=stmt.executeQuery("select * from studDetail");
                out.println("<h3>Respective total,average and grades:</h3>");
                while(rs.next())
                {
                    out.println("<p>"+new student(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)).getString()+"</p>");
                }
                c.close();
                
            }
            catch(Exception e)
            {
                out.println(e);
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
