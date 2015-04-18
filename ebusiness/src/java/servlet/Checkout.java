/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SONGSONG
 */
@WebServlet(name = "Checkout", urlPatterns = {"/Checkout"})
public class Checkout extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String line1 = request.getParameter("line1");
        String line2 = request.getParameter("line2");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String postalcode = request.getParameter("postalcode");
        String country = request.getParameter("Country");
        String cardnumber = request.getParameter("cardnumber");
        String cardtype = request.getParameter("cardtype");
        String seccode = request.getParameter("seccode");
        User curr = (User) request.getSession().getAttribute("user");
        int shipid = 1;
        int payid = 1;
        int orderid = 1;
        String total = request.getParameter("total");
        //String eMail = request.getParameter("email1");
        //String password = request.getParameter("password1");
        //Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
        try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/ebusiness", "ebusiness", "ebusiness")) {
            Statement st = conn.createStatement();
            st.execute("insert into SHIPPING(MEMBER_ID, S_LASTNAME, S_FIRSTNAME, LINE1, LINE2, CITY, STATE, POSTALCODE, COUNTRY) VALUES (" + curr.getId() + ",'" + lastname + "','" + firstname + "','" + line1 + "','" + line2 + "','" + city + "','" + state + "'," + postalcode + ",'" + country + "')");
            st.execute("insert into PAYMENT(MEMBER_ID, CARD_NUMBER, CARD_TYPE, SECURITY_CODE) VALUES (" + curr.getId() + "," + cardnumber + ",'" + cardtype + "'," + seccode + ")");
            ResultSet rs = st.executeQuery("SELECT max(SHIP_ID) FROM SHIPPING");
            if (rs.next()) {
                shipid = rs.getInt(1);
            }
            rs = st.executeQuery("SELECT max(PAYMENT_ID) FROM PAYMENT");
            if (rs.next()) {
                payid = rs.getInt(1);
            }
            st.execute("insert into ORDERS(MEMBER_ID, SHIP_ID, PAYMENT_ID, TOTALPRICE) VALUES (" + curr.getId() + "," + shipid + "," + payid + "," + total + ")");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/Personal.jsp");
            rd.forward(request, response);
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
        } catch (SQLException ex) {
            Logger.getLogger(Checkout.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(Checkout.class.getName()).log(Level.SEVERE, null, ex);
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
