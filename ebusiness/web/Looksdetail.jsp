<%-- 
    Document   : Looksdetail
    Created on : Apr 16, 2015, 9:23:37 PM
    Author     : SONGSONG
--%>

<%@page import="bean.Look"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="bean.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Strongbility Man</title>       
        <script src="js/jquery-1.11.2.min.js"></script>
        <script src="js/jquery.validate.js"></script>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/normalize.css" rel="stylesheet">
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/looksdetail.css" rel="stylesheet">
        <script src="js/ie-emulation-modes-warning.js"></script>
        <script src="js/bootstrap.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="wrap">
            <!--header-->
            <div class="navbar navbar-fixed-top">
                <div class="container">
                    <div class=" navbar-fixed-top navbar-inverse">
                        <div class="navbar-inner">
                            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </a>
                            <div class="nav-collapse">
                                <ul class="nav">
                                    <li class="active down"><a href="Looks.jsp">LOOKS</a></li>
                                    <li ><a class="logo" href="index.jsp" ><img src="pic/icon/Logo.png" alt="Strongbility" height=65></a></li>
                                    <li class="down"><a href="Top.jsp" >CATEGORY</a></li>
                                </ul>
                            </div><!--/.nav-collapse -->
                        </div><!-- /.navbar-inner -->
                    </div><!-- /.navbar-inverse-->
                </div><!-- /.container -->   
            </div><!--  navbar navbar-fixed-top -->
            <div class="sidnav">
                <div class="row">
                    <div class="btn-group pull-right subnav">
                        <div class="dropdown">
                            <a href="Cart.jsp"><button class="btn"><span class="glyphicon glyphicon-shopping-cart"></span> <span class="badge badge-info" id="shoppingcart"></span></button></a>
                            <%
                                User current = (User) request.getSession().getAttribute("user");
                                if (current == null) {
                            %> 
                            <a href="Signin.html"><button class="btn">Sign in</button></a>
                            <% } else {%>
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                <button class="btn">Hi, <%=current.getFirstname()%> <b class="caret"></b></button>
                            </a>
                            <ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
                                <li><a href="Personal.jsp"><button class="btn1">Account</button></a></li>
                                <li><form action="Signout" method="post" name="signout"><button class="btn1">Sign out</button></form></li>
                            </ul>
                            <%}%>
                        </div>
                    </div><!--  btn-group -->
                </div><!--/.row-->
            </div><!--/.sidnav-->
            <!--content-->
            <div class="content">
                <div class="container">
                    <div class="row">
                        <%
                            Look curr = (Look) request.getSession().getAttribute("look");
                            out.print("<div class=\"col-md-2 col-md-offset-1 product\">\n"
                                    + "            <div class=\"off\"><img src=\"pic/icon/off-0" + curr.getLooksid() + ".png\" alt=\"20%off\" > </div>\n"
                                    + "            <form action=\"viewlookdetail\" method=\"post\"><input type=\"hidden\" name=\"look_id\" value=\"" + curr.getLooksid() + "\"/><button onclick=\"Lookdetail\"><img src=\"" + curr.getLookspic() + "\" alt=\"" + curr.getLooksalt() + "\" height=\"260px\" > </button></form>\n"
                                    + "   </div><!--/.col-md-2-->");
                            Class.forName("org.apache.derby.jdbc.ClientDriver");
                            try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/ebusiness", "ebusiness", "ebusiness")) {
                                Statement st = conn.createStatement();
                                ResultSet rs = st.executeQuery("SELECT p.product_id, p.product_name, p.color, p.price, p.product_pic, p.product_alt from LOOKS l, PRODUCT p, LOOKSDETAIL ld where p.product_id=ld.product_id and ld.looks_id=l.looks_id and l.looks_id=" + curr.getLooksid());
                                out.print("<div class=\"col-md-9\">\n"
                                        + "                            <div class=\"container\">\n"
                                        + "                                <div class=\"product-list\">\n"
                                        + "                                    <div class=\"row\">");
                                while (rs.next()) {
                                    out.print("<div class=\"col-md-2 product\">\n"
                                            + "                        <img class=\"img-rounded pdc-pic\" alt=\"" + rs.getString("product_alt") + "\"src=\"" + rs.getString("product_pic") + "\" height=120 >\n"
                                            + "                                            <p  class=\"text-info\">" + rs.getString("product_name") + "</p>\n"
                                            + "                                            <div class=\"text-center\">\n"
                                            + "                                                <dl class=\"dl-horizontal text-left\">\n"
                                            + "                                                    <small>  \n"
                                            + "                                                        <dt>Price:</dt>\n"
                                            + "                                                        <dd><del> $ " + rs.getFloat("price") + "</del></dd>\n"
                                            + "                                                        <dt>Now:</dt>\n"
                                            + "                                                        <strong>\n"
                                            + "                                                            <dd> $ " + String.format("%.2f", rs.getFloat("price") * 0.8) + "</dd>\n"
                                            + "                                                        </strong>\n"
                                            + "                                                        <dt>Color:</dt>\n"
                                            + "                                                        <dd>" + rs.getString("color") + "</dd>\n"
                                            + "                                                    </small>\n"
                                            + "                                                </dl>\n"
                                            + "                                                <form action=\"Showdetail\" method=\"post\"><input type=\"hidden\" name=\"product_id\" value=\"" + rs.getInt("product_id") + "\"/><button class=\"btn\" onclick=\"detail\">Detail</button></form>\n"
                                            + "                                                <br/><br/>\n"
                                            + "                                            </div><!--/.text-center-->\n"
                                            + "                                        </div><!--/.col-md-2-->");
                                }
                                rs.close();
                                conn.close();
                            }
                        %>
                    </div><!--/.row-->
                </div><!--/.product-list-->
            </div><!--/.container-->
        </div><!--/.col-md-10-->
    </div><!--container-fluid-->
</div><!--/.row-->
</div><!--/.content-->
<!--footer-->
<div id="footer">
    <div class="container">
        <p class="text-muted">Copyright 2015</p>
    </div>
</div><!--/.footer-->
</div><!--/.warp-->
</body>
</html>