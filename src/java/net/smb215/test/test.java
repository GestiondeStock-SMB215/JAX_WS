package net.smb215.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.smb215.lib.*;
import net.smb215.entities.*;
import java.util.ArrayList;

/**
 *
 * @author jouj
 */
@WebServlet(name = "test", urlPatterns = {"/test"})
public class test extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NamingException, SQLException {
                response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
        
//        HashMap<String,String> values = new HashMap<String, String>();
////        values.put("role_id", "1");
//        values.put("role_name", "test2");
//        values.put("role_desc", "description2");
//        values.put("role_time_stamp", Func.NOW());
//        out.println(values);
//       // r.Create(values);
            
            Role r = new Role();
            r.getClass().getFields();
            
            QueryCriteria Q = new QueryCriteria("role_name", "test2", QueryCriteria.Operand.EQUALS);
            ArrayList<QueryCriteria> Q2 = new ArrayList<QueryCriteria>();
            Q2.add(Q);
            r.Read(Q2, new ArrayList<String>());
            out.println(r.getRole_id());
            out.println(r.getRole_desc());
            out.println(r.getRole_name());
            out.println(r.getRole_time_stamp());
            
//            System.out.println(rs.getFetchSize());
//            while (rs.next()) {
//                out.println("<h1>First Name is " + rs.getString("role_name") + "</h1>");
//            }
            
//        InitialContext ctx = new InitialContext();
//        DataSource ds = (DataSource) ctx.lookup("jdbc/mysql");
//
//        Connection conn = ds.getConnection();
//        Statement stmt = conn.createStatement();
//        //select * from utilisateur
//        
//        ResultSet rs = stmt.executeQuery("select * from role");
//
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet POC on Glassfish</title>");
//
//            while (rs.next()) {
//                out.println("<h1>First Name is " + rs.getString("role_id") + "</h1>");
//            }
//            out.println("</body>");
//            out.println("</html>");
//
//            stmt.close();
//            stmt = null;
//            conn.close();
//            conn = null;
        

            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet test</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet test at " + request.getContextPath() + "</h1>");
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
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
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
