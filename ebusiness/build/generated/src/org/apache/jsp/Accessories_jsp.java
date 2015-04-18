package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Connection;
import bean.User;

public final class Accessories_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Strongbility Man</title>\n");
      out.write("        <script src=\"js/jquery-1.11.2.min.js\"></script>\n");
      out.write("        <script src=\"js/jquery.validate.js\"></script>\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/normalize.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/bootstrap.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/category.css\" rel=\"stylesheet\">\n");
      out.write("        <script src=\"js/ie-emulation-modes-warning.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"wrap\">\n");
      out.write("            <!--header-->\n");
      out.write("            <div class=\"navbar navbar-fixed-top\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\" navbar-fixed-top navbar-inverse\">\n");
      out.write("                        <div class=\"navbar-inner\">\n");
      out.write("                            <a class=\"btn btn-navbar\" data-toggle=\"collapse\" data-target=\".nav-collapse\">\n");
      out.write("                                <span class=\"icon-bar\"></span>\n");
      out.write("                                <span class=\"icon-bar\"></span>\n");
      out.write("                                <span class=\"icon-bar\"></span>\n");
      out.write("                            </a>\n");
      out.write("                            <div class=\"nav-collapse\">\n");
      out.write("                                <ul class=\"nav\">\n");
      out.write("                                    <li class=\"active down\"><a href=\"Looks.jsp\">LOOKS</a></li>\n");
      out.write("                                    <li ><a class=\"logo\" href=\"index.jsp\" ><img src=\"pic/icon/Logo.png\" alt=\"Strongbility\" height=65></a></li>\n");
      out.write("                                    <li class=\"down\"><a href=\"Top.jsp\" >CATEGORY</a></li>\n");
      out.write("                                </ul>\n");
      out.write("                            </div><!--/.nav-collapse -->\n");
      out.write("                        </div><!-- /.navbar-inner -->\n");
      out.write("                    </div><!-- /.navbar-inverse-->\n");
      out.write("                </div><!-- /.container -->   \n");
      out.write("            </div><!--  navbar navbar-fixed-top -->\n");
      out.write("            <div class=\"sidnav\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"btn-group pull-right subnav\">\n");
      out.write("                        <div class=\"dropdown\">\n");
      out.write("                            <a href=\"Cart.jsp\"><button class=\"btn\"><span class=\"glyphicon glyphicon-shopping-cart\"></span> <span class=\"badge badge-info\" id=\"shoppingcart\"></span></button></a>\n");
      out.write("                            ");

                                User current = (User) request.getSession().getAttribute("user");
                                if (current == null) {
                            
      out.write(" \n");
      out.write("                            <a href=\"Signin.html\"><button class=\"btn\">Sign in</button></a>\n");
      out.write("                            ");
 } else {
      out.write("\n");
      out.write("                            <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">\n");
      out.write("                                <button class=\"btn\">Hi, ");
      out.print(current.getFirstname());
      out.write(" <b class=\"caret\"></b></button>\n");
      out.write("                            </a>\n");
      out.write("                            <ul class=\"dropdown-menu\" role=\"menu\" aria-labelledby=\"dLabel\">\n");
      out.write("                                <li><a href=\"Personal.jsp\"><button class=\"btn1\">Account</button></a></li>\n");
      out.write("                                <li><form action=\"Signout\" method=\"post\" name=\"signout\"><button class=\"btn1\">Sign out</button></form></li>\n");
      out.write("                            </ul>\n");
      out.write("                            ");
}
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div><!--  btn-group -->\n");
      out.write("                </div><!--/.row-->\n");
      out.write("            </div><!--/.sidnav-->\n");
      out.write("            <!--content-->\n");
      out.write("            <div class=\"content\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"container-fluid\">\n");
      out.write("                        <div class=\"col-md-2\">\n");
      out.write("                            <ul class=\"nav sidebar-nav\">\n");
      out.write("                                <li><a tabindex=\"-1\" href=\"Top.jsp\">TOP</a></li>\n");
      out.write("                                <li><a tabindex=\"-1\" href=\"Bottom.jsp\">BOTTOM</a></li>\n");
      out.write("                                <li><a tabindex=\"-1\" href=\"Outware.jsp\">OUTWARE</a></li>\n");
      out.write("                                <li><a tabindex=\"-1\" href=\"Shoes.jsp\">SHOES</a></li>\n");
      out.write("                                <li><a tabindex=\"-1\" href=\"Accessories.jsp\"><span  class=\"select\">ACCESSORIES</span></a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </div><!--/.col-md-2-->\n");
      out.write("                        <div class=\"col-md-8\">\n");
      out.write("                            <div class=\"container\">\n");
      out.write("                                <div class=\"product-list\">\n");
      out.write("                                    <div class=\"row\">\n");
      out.write("                                        ");

                                            Class.forName("org.apache.derby.jdbc.ClientDriver");
                                            try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/ebusiness", "ebusiness", "ebusiness")) {
                                                Statement st = conn.createStatement();
                                                ResultSet rs = st.executeQuery("SELECT * from PRODUCT WHERE PRODUCT_TYPE='Accessories'");
                                                while (rs.next()) {
                                                    out.print("<div class=\"col-md-3 product\">\n"
                                                            + "                  <img class=\"img-rounded pdc-pic\" alt=\"" + rs.getString("product_alt") + "\"src=\"" + rs.getString("product_pic") + "\" height=\"150px\">\n"
                                                            + "                            <p  class=\"text-info\">" + rs.getString("product_name") + "</p>\n"
                                                            + "                            <div class=\"text-center\">\n"
                                                            + "                            <dl class=\"dl-horizontal text-left\">\n"
                                                            + "                              <small>  \n"
                                                            + "                                  <dt>Price:</dt>\n"
                                                            + "                                  <dd><del> $ " + rs.getFloat("price") + "</del></dd>\n"
                                                            + "                                  <dt>Now:</dt>\n"
                                                            + "                                  <strong>\n"
                                                            + "                                         <dd> $ " + String.format("%.2f", rs.getFloat("price") * 0.8) + "</dd>\n"
                                                            + "                                   </strong>\n"
                                                            + "                                    <dt>Color:</dt>\n"
                                                            + "                                    <dd>" + rs.getString("color") + "</dd>\n"
                                                            + "                                </small>\n"
                                                            + "                             </dl>\n"
                                                            + "                 <form action=\"Showdetail\" method=\"post\"><input type=\"hidden\" name=\"product_id\" value=\"" + rs.getInt("product_id") + "\"/><button class=\"btn\" onclick=\"detail\">Detail</button></form><br/><br/>\n"
                                                            + "              </div><!--/.text-info-->\n"
                                                            + "       </div><!--/.col-md-2-->");
                                                }
                                                rs.close();
                                                conn.close();
                                            }
                                        
      out.write("\n");
      out.write("                                    </div><!--/.row-->\n");
      out.write("                                </div><!--/.product-list-->\n");
      out.write("                            </div><!--/.container-->\n");
      out.write("                        </div><!--/.col-md-10-->\n");
      out.write("                    </div><!--container-fluid-->\n");
      out.write("                </div><!--/.row-->\n");
      out.write("            </div><!--/.content-->\n");
      out.write("            <!--footer-->\n");
      out.write("            <div id=\"footer\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <p class=\"text-muted\">Copyright 2015</p>\n");
      out.write("                </div>\n");
      out.write("            </div><!--/.footer-->\n");
      out.write("        </div><!--/.warp-->\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
