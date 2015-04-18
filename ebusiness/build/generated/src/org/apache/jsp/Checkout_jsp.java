package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import bean.User;

public final class Checkout_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Strongbility Man</title>\n");
      out.write("        <script src=\"js/jquery-1.11.2.min.js\"></script>\n");
      out.write("        <script src=\"js/jquery.validate.js\"></script>\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/normalize.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/bootstrap.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/check.css\" rel=\"stylesheet\">\n");
      out.write("        <script src='js/checkout.js'></script>\n");
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
      out.write("                                    ");

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
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"row title\">\n");
      out.write("                        <p><h3>Check out</h3></p>\n");
      out.write("                        <div class=\"panel-group\" id=\"accordion\" role=\"tablist\" aria-multiselectable=\"true\">\n");
      out.write("                            <form action=\"Checkout\" method=\"post\">\n");
      out.write("                                <div class=\"panel panel-default\">\n");
      out.write("                                    <div class=\"panel-heading\" role=\"tab\" id=\"headingOne\">\n");
      out.write("                                        <h4 class=\"panel-title\">\n");
      out.write("                                            <a data-toggle=\"collapse\" data-parent=\"#accordion\" href=\"#collapseOne\" aria-expanded=\"false\" arias=\"collapseOne\">\n");
      out.write("                                                Items<br/>\n");
      out.write("                                            </a>\n");
      out.write("                                        </h4>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div id=\"collapseOne\" class=\"panel-collapse collapse in\" role=\"tabpanel\" aria-labelledby=\"headingOne\">\n");
      out.write("                                        <div class=\"panel-body\">\n");
      out.write("                                            <table class=\"table\">\n");
      out.write("                                                <thead>\n");
      out.write("                                                    <tr class=\"info\">\n");
      out.write("                                                        <td>#</td>\n");
      out.write("                                                        <td>Description</td>\n");
      out.write("                                                        <td>Price</td>\n");
      out.write("                                                        <td>Quantity</td>\n");
      out.write("                                                        <td>Total</td>\n");
      out.write("                                                    </tr>\n");
      out.write("                                                </thead>\n");
      out.write("                                                <tbody id=\"product-lists\">\n");
      out.write("                                                </tbody>\n");
      out.write("                                            </table>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div><!--panel-->\n");
      out.write("                                <div class=\"panel panel-default\">\n");
      out.write("                                    <div class=\"panel-heading\" role=\"tab\" id=\"headingTwo\">\n");
      out.write("                                        <h4 class=\"panel-title\">\n");
      out.write("                                            <a data-toggle=\"collapse\" data-parent=\"#accordion\" href=\"#collapseTwo\" aria-expanded=\"false\">\n");
      out.write("                                                Shipping\n");
      out.write("                                            </a>\n");
      out.write("                                        </h4>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div id=\"collapseTwo\" class=\"panel-collapse collapse in\" role=\"tabpanel\" aria-labelledby=\"headingTwo\">\n");
      out.write("                                        <div class=\"form-horizontal\">\n");
      out.write("                                            <div class=\"form-group\">\n");
      out.write("                                                <label class=\"col-sm-2 col-sm-offset-3 control-label\">First name</label>\n");
      out.write("                                                <div class=\"col-sm-3\">\n");
      out.write("                                                    <input type=\"text\" class=\"form\"  name=\"firstname\">\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"form-group\">\n");
      out.write("                                                <label class=\"col-sm-2 col-sm-offset-3 control-label\">Last name</label>\n");
      out.write("                                                <div class=\"col-sm-3\">\n");
      out.write("                                                    <input type=\"text\" class=\"form\"  name=\"lastname\">\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"form-group\">\n");
      out.write("                                                <label class=\"col-sm-2 col-sm-offset-3 control-label\">Line1</label>\n");
      out.write("                                                <div class=\"col-sm-3\">\n");
      out.write("                                                    <input type=\"text\" class=\"form\" id=\"line1\"  name=\"line1\">\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"form-group\">\n");
      out.write("                                                <label class=\"col-sm-2 col-sm-offset-3 control-label\">Line2</label>\n");
      out.write("                                                <div class=\"col-sm-3\">\n");
      out.write("                                                    <input type=\"text\" class=\"form\" name=\"line2\">\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"form-group\">\n");
      out.write("                                                <label class=\"col-sm-2 col-sm-offset-3 control-label\">City</label>\n");
      out.write("                                                <div class=\"col-sm-3\">\n");
      out.write("                                                    <input type=\"text\" class=\"form\" name=\"city\">\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"form-group\">\n");
      out.write("                                                <label class=\"col-sm-2 col-sm-offset-3 control-label\">State</label>\n");
      out.write("                                                <div class=\"col-sm-3\">\n");
      out.write("                                                    <input type=\"text\" class=\"form\" name=\"state\">\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"form-group\">\n");
      out.write("                                                <label class=\"col-sm-2 col-sm-offset-3 control-label\">Postal code</label>\n");
      out.write("                                                <div class=\"col-sm-3\">\n");
      out.write("                                                    <input type=\"text\" class=\"form\" name=\"postalcode\">\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"form-group\">\n");
      out.write("                                                <label class=\"col-sm-2 col-sm-offset-3 control-label\">Country</label>\n");
      out.write("                                                <div class=\"col-sm-3\">\n");
      out.write("                                                    <input type=\"text\" class=\"form\" name=\"Country\">\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div><!--panel-body-->\n");
      out.write("                                    </div><!--panel-collapse-->\n");
      out.write("                                </div><!--panel-->\n");
      out.write("                                <div class=\"panel panel-default\">\n");
      out.write("                                    <div class=\"panel-heading\" role=\"tab\" id=\"headingTwo\">\n");
      out.write("                                        <h4 class=\"panel-title\">\n");
      out.write("                                            <a class=\"collapsed\" data-toggle=\"collapse\" data-parent=\"#accordion\" href=\"#collapseThree\" aria-expanded=\"false\" arias=\"collapseThree\">\n");
      out.write("                                                Payment\n");
      out.write("                                            </a>\n");
      out.write("                                        </h4>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div id=\"collapseThree\" class=\"panel-collapse collapse in\" role=\"tabpanel\" aria-labelledby=\"headingThree\">\n");
      out.write("                                        <div class=\"form-horizontal\">\n");
      out.write("                                            <div class=\"form-group\">\n");
      out.write("                                                <label class=\"col-sm-2 col-sm-offset-3 control-label\">Card Number</label>\n");
      out.write("                                                <div class=\"col-sm-3\">\n");
      out.write("                                                    <input type=\"text\" class=\"form\" name=\"cardnumber\">\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"form-group\">\n");
      out.write("                                                <label class=\"col-sm-2 col-sm-offset-3 control-label\">Type</label>\n");
      out.write("                                                <div class=\"col-sm-3\">\n");
      out.write("\n");
      out.write("                                                    <select class=\"form\">\n");
      out.write("                                                        <option>VISA</option>\n");
      out.write("                                                        <option>American Express</option>\n");
      out.write("                                                        <option>Discover</option>\n");
      out.write("                                                    </select>\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"form-group\">\n");
      out.write("                                                <label class=\"col-sm-2 col-sm-offset-3 control-label\">Expired</label>\n");
      out.write("                                                <div class=\"col-sm-3\">\n");
      out.write("\n");
      out.write("                                                    <select class=\"form-inline half\">\n");
      out.write("                                                        <option>-</option>\n");
      out.write("                                                        <option>1</option>\n");
      out.write("                                                        <option>2</option>\n");
      out.write("                                                        <option>3</option>\n");
      out.write("                                                        <option>4</option>\n");
      out.write("                                                        <option>5</option>\n");
      out.write("                                                        <option>6</option>\n");
      out.write("                                                        <option>7</option>\n");
      out.write("                                                        <option>8</option>\n");
      out.write("                                                        <option>9</option>\n");
      out.write("                                                        <option>10</option>\n");
      out.write("                                                        <option>11</option>\n");
      out.write("                                                        <option>12</option>\n");
      out.write("                                                    </select> / \n");
      out.write("                                                    <select class=\"form-inline half\">\n");
      out.write("                                                        <option>-</opiton>\n");
      out.write("                                                        <option>2015</option>\n");
      out.write("                                                        <option>2016</option>\n");
      out.write("                                                        <option>2017</option>\n");
      out.write("                                                        <option>2018</option>\n");
      out.write("                                                        <option>2019</option>\n");
      out.write("                                                        <option>2020</option>\n");
      out.write("                                                        <option>2021</option>\n");
      out.write("                                                        <option>2022</option>\n");
      out.write("                                                        <option>2023</option>\n");
      out.write("                                                        <option>2024</option>\n");
      out.write("                                                        <option>2025</option>\n");
      out.write("                                                        <option>2026</option>\n");
      out.write("                                                        <option>2027</option>\n");
      out.write("                                                    </select>\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"form-group\">\n");
      out.write("                                                <label class=\"col-sm-2 col-sm-offset-3 control-label\">Security code</label>\n");
      out.write("                                                <div class=\"col-sm-3\">\n");
      out.write("                                                    <input type=\"text\" class=\"form\" name=\"seccode\">\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"form-group\">\n");
      out.write("                                                <div class=\"col-sm-5 col-sm-offset-3\">\n");
      out.write("                                                    <button type=\"submit\" class=\"btn btn-info\">Confirm</button>\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div><!--panel-->\n");
      out.write("                            </form>\n");
      out.write("                        </div><!--panel-group-->\n");
      out.write("                    </div><!--/.row-->\n");
      out.write("                </div><!--/.container-->\n");
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
