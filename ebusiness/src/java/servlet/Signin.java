/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
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
@WebServlet(name = "Signin", urlPatterns = {"/Signin"})
public class Signin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     */
    @SuppressWarnings("empty-statement")
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        String eMail = request.getParameter("email1");
        String password = request.getParameter("password1");
        PrintWriter out = response.getWriter();
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
        try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/ebusiness", "ebusiness", "ebusiness")) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM MEMBERS WHERE EMAIL='" + eMail + "'");
            if (rs.next()) {
                if (rs.getString("password").equals(password)) {
                    User u = new User(rs.getString("firstname"), eMail, rs.getInt("member_id"));
                    request.getSession().setAttribute("user", u);
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
                    rd.forward(request, response);
                } else {
                    out.println("<html lang=\"en\">\n"
                            + "    <head>\n"
                            + "        <title>Strongbility Man-Login</title>\n"
                            + "        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n"
                            + "        <link href=\"css/normalize.css\" rel=\"stylesheet\">\n"
                            + "        <link href=\"css/bootstrap.css\" rel=\"stylesheet\">\n"
                            + "        <link href=\"css/login.css\" rel=\"stylesheet\">\n"
                            + "        <script src=\"js/jquery-1.11.2.min.js\"></script>\n"
                            + "        <script src=\"js/jquery.validate.js\"></script>\n"
                            + "        <script src=\"js/ie-emulation-modes-warning.js\"></script>\n"
                            + "        <script type=\"text/javascript\">\n"
                            + "            $().ready(function () {\n"
                            + "                $(\"#form1\").validate({\n"
                            + "                    rules: {\n"
                            + "                        email: {\n"
                            + "                            required: true,\n"
                            + "                            email: true\n"
                            + "                        },\n"
                            + "                        password: {\n"
                            + "                            required: true,\n"
                            + "                            minlength: 5\n"
                            + "                        },\n"
                            + "                        confirmPassword: {\n"
                            + "                            required: true,\n"
                            + "                            minlength: 5,\n"
                            + "                            equalTo: \"#password\"\n"
                            + "                        }\n"
                            + "                    }\n"
                            + "                });\n"
                            + "                $(\"#form2\").validate({\n"
                            + "                    rules: {\n"
                            + "                        email1: {\n"
                            + "                            required: true,\n"
                            + "                            email: true\n"
                            + "                        },\n"
                            + "                        password1: {\n"
                            + "                            required: true\n"
                            + "                        }\n"
                            + "                    }\n"
                            + "                });\n"
                            + "            });\n"
                            + "        </script>\n"
                            + "<script type=\"text/javascript\">alert(\"Your password is wrong.\")</script>"
                            + "    </head>\n"
                            + "\n"
                            + "    <body>\n"
                            + "        <div class=\"wrap\">\n"
                            + "            <!--header-->\n"
                            + "            <div class=\"navbar navbar-fixed-top\">\n"
                            + "                <div class=\"container\">\n"
                            + "                    <div class=\" navbar-fixed-top navbar-inverse\">\n"
                            + "                        <div class=\"navbar-inner\">\n"
                            + "                            <a class=\"btn btn-navbar\" data-toggle=\"collapse\" data-target=\".nav-collapse\">\n"
                            + "                                <span class=\"icon-bar\"></span>\n"
                            + "                                <span class=\"icon-bar\"></span>\n"
                            + "                                <span class=\"icon-bar\"></span>\n"
                            + "                            </a>\n"
                            + "                            <div class=\"nav-collapse\">\n"
                            + "                                <ul class=\"nav\">\n"
                            + "                                    <li class=\"active down\"><a href=\"Looks.jsp\">LOOKS</a></li>\n"
                            + "                                    <li ><a class=\"logo\" href=\"index.jsp\" ><img src=\"pic/icon/Logo.png\" alt=\"Strongbility\" height=65 ></a></li>\n"
                            + "                                    <li class=\"down\"><a href=\"Top.jsp\" >CATEGORY</a></li>\n"
                            + "                                </ul>\n"
                            + "                            </div><!--/.nav-collapse -->\n"
                            + "                        </div><!-- /.navbar-inner -->\n"
                            + "                    </div><!-- /.navbar-inverse-->\n"
                            + "                </div><!-- /.container -->   \n"
                            + "\n"
                            + "            </div><!--  navbar navbar-fixed-top -->\n"
                            + "            <div class=\"sidnav\">\n"
                            + "                <div class=\"row\">\n"
                            + "                    <div class=\"btn-group pull-right subnav\">\n"
                            + "                        <a href=\"Cart.jsp\"><button class=\"btn\"><span class=\"glyphicon glyphicon-shopping-cart\"></span> <span class=\"badge badge-info\">8</span></button></a>\n"
                            + "                        <a href=\"Signin.html\"><button class=\"btn\">Sign in</button></a>\n"
                            + "                    </div><!--  btn-group -->\n"
                            + "                </div><!--/.row-->\n"
                            + "            </div><!--/.sidnav-->\n"
                            + "\n"
                            + "            <!--content-->\n"
                            + "            <div class=\"content\">\n"
                            + "                <div class=\"container\">\n"
                            + "                    <div class=\"area\">\n"
                            + "                        <div class=\"row \">\n"
                            + "                            <div class=\"col-md-5 col-md-offset-1  signup text-left\">\n"
                            + "                                <h3 class=\"text-info\">Not a member?</h3>\n"
                            + "                                <h6 class=\"text-default\">Sign up now</h6>\n"
                            + "                                <form id='form1' class=\"form\" action=\"Register\" method=\"post\">\n"
                            + "                                    <div>\n"
                            + "                                        <label for=\"inputEmail\" class=\"text-left\">Email</label>\n"
                            + "                                        <div>\n"
                            + "                                            <input type=\"email\" name=\"email\" id='email' placeholder=\"Email\">\n"
                            + "                                        </div>\n"
                            + "                                    </div>\n"
                            + "                                    <div>\n"
                            + "                                        <label for=\"inputPassword\" class=\"text-left\">Password</label>\n"
                            + "                                        <div>\n"
                            + "                                            <input type=\"password\" name=\"password\" id='password' placeholder=\"Password\">\n"
                            + "                                        </div>\n"
                            + "                                    </div>\n"
                            + "                                    <div>\n"
                            + "                                        <label for=\"inputPassword\" class=\"text-left\">Confirm Password</label>\n"
                            + "                                        <div>\n"
                            + "                                            <input type=\"password\" name=\"confirmPassword\" id='confirmPassword' placeholder=\"Password\">\n"
                            + "                                        </div>\n"
                            + "                                    </div>\n"
                            + "                                    <div>\n"
                            + "                                        <button type=\"submit\" class=\"btn\">Sign up</button>\n"
                            + "                                    </div>\n"
                            + "                                </form>\n"
                            + "                            </div><!--/.col-sm-3-->\n"
                            + "                            <div class=\"col-md-5 col-md-offset-1 singin text-left\">\n"
                            + "                                <h3 class=\"text-info\" class=\"text-left\">Already a Member?</h3>\n"
                            + "                                <h6 class=\"info\">Sign in here</h6>\n"
                            + "                                <form id='form2' class=\"form\" action=\"Signin\" method='post'>\n"
                            + "                                    <div>\n"
                            + "                                        <label for=\"inputEmail\" class=\"text-left\">Email</label>\n"
                            + "                                        <div>\n"
                            + "                                            <input type=\"text\" name=\"email1\" id='email1' placeholder=\"Email\">\n"
                            + "                                        </div>\n"
                            + "                                    </div>\n"
                            + "                                    <div>\n"
                            + "                                        <label for=\"inputPassword\" class=\"text-left\">Password</label>\n"
                            + "                                        <div>\n"
                            + "                                            <input type=\"password\" name=\"password1\" id='password1' placeholder=\"Password\">\n"
                            + "                                        </div>\n"
                            + "                                    </div>\n"
                            + "                                    <p></p>\n"
                            + "                                    <div>\n"
                            + "                                        <button type=\"submit\" class=\"btn\">Sign in</button>\n"
                            + "                                    </div>\n"
                            + "                                </form>\n"
                            + "                            </div><!--/.col-sm-3-->\n"
                            + "                        </div><!--/.row-->\n"
                            + "                    </div><!--/.area-->\n"
                            + "                </div><!--/.container-->\n"
                            + "            </div><!--/.content-->\n"
                            + "        </div><!--/.warp-->\n"
                            + "        <!--footer-->\n"
                            + "        <div id=\"footer\">\n"
                            + "            <div class=\"container\">\n"
                            + "                <p class=\"text-muted\">Copyright 2015</p>\n"
                            + "            </div>\n"
                            + "        </div><!--/.footer-->\n"
                            + "    </body>\n"
                            + "</html>");
                }
            } else {
                out.println("<html lang=\"en\">\n"
                        + "    <head>\n"
                        + "        <title>Strongbility Man-Login</title>\n"
                        + "        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n"
                        + "        <link href=\"css/normalize.css\" rel=\"stylesheet\">\n"
                        + "        <link href=\"css/bootstrap.css\" rel=\"stylesheet\">\n"
                        + "        <link href=\"css/login.css\" rel=\"stylesheet\">\n"
                        + "        <script src=\"js/jquery-1.11.2.min.js\"></script>\n"
                        + "        <script src=\"js/jquery.validate.js\"></script>\n"
                        + "        <script src=\"js/ie-emulation-modes-warning.js\"></script>\n"
                        + "        <script type=\"text/javascript\">\n"
                        + "            $().ready(function () {\n"
                        + "                $(\"#form1\").validate({\n"
                        + "                    rules: {\n"
                        + "                        email: {\n"
                        + "                            required: true,\n"
                        + "                            email: true\n"
                        + "                        },\n"
                        + "                        password: {\n"
                        + "                            required: true,\n"
                        + "                            minlength: 5\n"
                        + "                        },\n"
                        + "                        confirmPassword: {\n"
                        + "                            required: true,\n"
                        + "                            minlength: 5,\n"
                        + "                            equalTo: \"#password\"\n"
                        + "                        }\n"
                        + "                    }\n"
                        + "                });\n"
                        + "                $(\"#form2\").validate({\n"
                        + "                    rules: {\n"
                        + "                        email1: {\n"
                        + "                            required: true,\n"
                        + "                            email: true\n"
                        + "                        },\n"
                        + "                        password1: {\n"
                        + "                            required: true\n"
                        + "                        }\n"
                        + "                    }\n"
                        + "                });\n"
                        + "            });\n"
                        + "        </script>\n"
                        + "<script type=\"text/javascript\">alert(\"Your e-mail is not registered. Please sign up first.\")</script>"
                        + "    </head>\n"
                        + "\n"
                        + "    <body>\n"
                        + "        <div class=\"wrap\">\n"
                        + "            <!--header-->\n"
                        + "            <div class=\"navbar navbar-fixed-top\">\n"
                        + "                <div class=\"container\">\n"
                        + "                    <div class=\" navbar-fixed-top navbar-inverse\">\n"
                        + "                        <div class=\"navbar-inner\">\n"
                        + "                            <a class=\"btn btn-navbar\" data-toggle=\"collapse\" data-target=\".nav-collapse\">\n"
                        + "                                <span class=\"icon-bar\"></span>\n"
                        + "                                <span class=\"icon-bar\"></span>\n"
                        + "                                <span class=\"icon-bar\"></span>\n"
                        + "                            </a>\n"
                        + "                            <div class=\"nav-collapse\">\n"
                        + "                                <ul class=\"nav\">\n"
                        + "                                    <li class=\"active down\"><a href=\"Looks.jsp\">LOOKS</a></li>\n"
                        + "                                    <li ><a class=\"logo\" href=\"index.jsp\" ><img src=\"pic/icon/Logo.png\" alt=\"Strongbility\" height=65 ></a></li>\n"
                        + "                                    <li class=\"down\"><a href=\"Top.jsp\" >CATEGORY</a></li>\n"
                        + "                                </ul>\n"
                        + "                            </div><!--/.nav-collapse -->\n"
                        + "                        </div><!-- /.navbar-inner -->\n"
                        + "                    </div><!-- /.navbar-inverse-->\n"
                        + "                </div><!-- /.container -->   \n"
                        + "\n"
                        + "            </div><!--  navbar navbar-fixed-top -->\n"
                        + "            <div class=\"sidnav\">\n"
                        + "                <div class=\"row\">\n"
                        + "                    <div class=\"btn-group pull-right subnav\">\n"
                        + "                        <a href=\"Cart.jsp\"><button class=\"btn\"><span class=\"glyphicon glyphicon-shopping-cart\"></span> <span class=\"badge badge-info\">8</span></button></a>\n"
                        + "                        <a href=\"Signin.html\"><button class=\"btn\">Sign in</button></a>\n"
                        + "                    </div><!--  btn-group -->\n"
                        + "                </div><!--/.row-->\n"
                        + "            </div><!--/.sidnav-->\n"
                        + "\n"
                        + "            <!--content-->\n"
                        + "            <div class=\"content\">\n"
                        + "                <div class=\"container\">\n"
                        + "                    <div class=\"area\">\n"
                        + "                        <div class=\"row \">\n"
                        + "                            <div class=\"col-md-5 col-md-offset-1  signup text-left\">\n"
                        + "                                <h3 class=\"text-info\">Not a member?</h3>\n"
                        + "                                <h6 class=\"text-default\">Sign up now</h6>\n"
                        + "                                <form id='form1' class=\"form\" action=\"Register\" method=\"post\">\n"
                        + "                                    <div>\n"
                        + "                                        <label for=\"inputEmail\" class=\"text-left\">Email</label>\n"
                        + "                                        <div>\n"
                        + "                                            <input type=\"email\" name=\"email\" id='email' placeholder=\"Email\">\n"
                        + "                                        </div>\n"
                        + "                                    </div>\n"
                        + "                                    <div>\n"
                        + "                                        <label for=\"inputPassword\" class=\"text-left\">Password</label>\n"
                        + "                                        <div>\n"
                        + "                                            <input type=\"password\" name=\"password\" id='password' placeholder=\"Password\">\n"
                        + "                                        </div>\n"
                        + "                                    </div>\n"
                        + "                                    <div>\n"
                        + "                                        <label for=\"inputPassword\" class=\"text-left\">Confirm Password</label>\n"
                        + "                                        <div>\n"
                        + "                                            <input type=\"password\" name=\"confirmPassword\" id='confirmPassword' placeholder=\"Password\">\n"
                        + "                                        </div>\n"
                        + "                                    </div>\n"
                        + "                                    <div>\n"
                        + "                                        <button type=\"submit\" class=\"btn\">Sign up</button>\n"
                        + "                                    </div>\n"
                        + "                                </form>\n"
                        + "                            </div><!--/.col-sm-3-->\n"
                        + "                            <div class=\"col-md-5 col-md-offset-1 singin text-left\">\n"
                        + "                                <h3 class=\"text-info\" class=\"text-left\">Already a Member?</h3>\n"
                        + "                                <h6 class=\"info\">Sign in here</h6>\n"
                        + "                                <form id='form2' class=\"form\" action=\"Signin\" method='post'>\n"
                        + "                                    <div>\n"
                        + "                                        <label for=\"inputEmail\" class=\"text-left\">Email</label>\n"
                        + "                                        <div>\n"
                        + "                                            <input type=\"text\" name=\"email1\" id='email1' placeholder=\"Email\">\n"
                        + "                                        </div>\n"
                        + "                                    </div>\n"
                        + "                                    <div>\n"
                        + "                                        <label for=\"inputPassword\" class=\"text-left\">Password</label>\n"
                        + "                                        <div>\n"
                        + "                                            <input type=\"password\" name=\"password1\" id='password1' placeholder=\"Password\">\n"
                        + "                                        </div>\n"
                        + "                                    </div>\n"
                        + "                                    <p></p>\n"
                        + "                                    <div>\n"
                        + "                                        <button type=\"submit\" class=\"btn\">Sign in</button>\n"
                        + "                                    </div>\n"
                        + "                                </form>\n"
                        + "                            </div><!--/.col-sm-3-->\n"
                        + "                        </div><!--/.row-->\n"
                        + "                    </div><!--/.area-->\n"
                        + "                </div><!--/.container-->\n"
                        + "            </div><!--/.content-->\n"
                        + "        </div><!--/.warp-->\n"
                        + "        <!--footer-->\n"
                        + "        <div id=\"footer\">\n"
                        + "            <div class=\"container\">\n"
                        + "                <p class=\"text-muted\">Copyright 2015</p>\n"
                        + "            </div>\n"
                        + "        </div><!--/.footer-->\n"
                        + "    </body>\n"
                        + "</html>");
            }
        } catch (SQLException e) {
            //e.printStackTrace();
            System.out.println("connect fail");
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
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Signin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Signin.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Signin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Signin.class.getName()).log(Level.SEVERE, null, ex);
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
