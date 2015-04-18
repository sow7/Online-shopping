/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author SONGSONG
 */
@WebServlet(name = "GetProductById", urlPatterns = {"/GetProductById"})
public class GetProductById extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            response.setContentType("text/html;charset=UTF-8");
            int id = Integer.parseInt(request.getParameter("id"));
            String size = request.getParameter("size");
            String amount = request.getParameter("amount");
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/ebusiness", "ebusiness", "ebusiness")) {
                Statement st = conn.createStatement();
                String q1 = "SELECT p.product_id, p.product_name, p.price, s.stock from PRODUCT p, PRODUCTSTOCK s where p.product_id=s.product_id and s.product_size='" + size + "' and p.PRODUCT_ID = " + id;
                ResultSet rs = st.executeQuery(q1);
                if (rs.next()) {
                    JSONObject product = new JSONObject();
                    product.put("id", rs.getInt("product_id"));
                    product.put("name", rs.getString("product_name"));
                    product.put("price", String.format("%.2f", rs.getFloat("price") * 0.8));
                    product.put("amount", amount);
                    product.put("stock", rs.getInt("stock"));
                    product.put("size", size);
                    System.out.println("hello");
                    //System.out.println(product.toString());
                    rs.close();
                    st.close();
                    out.println(product.toString());
                } else {
                    q1 = "SELECT * from PRODUCT where PRODUCT_ID = " + id;
                    rs = st.executeQuery(q1);
                    if (rs.next()) {
                        JSONObject product = new JSONObject();
                        product.put("id", rs.getInt("product_id"));
                        product.put("name", rs.getString("product_name"));
                        product.put("price", String.format("%.2f", rs.getFloat("price") * 0.8));
                        product.put("amount", amount);
                        product.put("stock", 0);
                        product.put("size", size);
                        System.out.println("hello");
                        //System.out.println(product.toString());
                        rs.close();
                        st.close();
                        out.println(product.toString());
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException | JSONException e) {
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
