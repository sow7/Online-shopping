<%-- 
    Document   : Looks
    Created on : Apr 16, 2015, 9:24:51 PM
    Author     : SONGSONG
--%>

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
        <link href="css/looks.css" rel="stylesheet">
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
                            Class.forName("org.apache.derby.jdbc.ClientDriver");
                            try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/ebusiness", "ebusiness", "ebusiness")) {
                                Statement st = conn.createStatement();
                                ResultSet rs = st.executeQuery("SELECT * from LOOKS");
                                int i = 2;
                                if (rs.next()) {
                                    out.print("<div class=\"col-md-2 product\">\n"
                                            + "            <div class=\"off\"><img src=\"pic/icon/off-01.png\" alt=\"20%off\" > </div>\n"
                                            + "            <form action=\"viewlookdetail\" method=\"post\"><input type=\"hidden\" name=\"look_id\" value=\"" + rs.getInt("LOOKS_ID") + "\"/><input type=\"hidden\" name=\"look_pic\" value=\"" + rs.getString("LOOKS_PIC") + "\"/><input type=\"hidden\" name=\"look_alt\" value=\"" + rs.getString("LOOKS_ALT") + "\"/><button onclick=\"Lookdetail\"><img src=\"" + rs.getString("LOOKS_PIC") + "\" alt=\"" + rs.getString("LOOKS_ALT") + "\" height=\"350px\" > </button></form>\n"
                                            + "   </div><!--/.col-md-2-->");
                                }
                                while (rs.next()) {
                                    out.print("<div class=\"col-md-2 col-md-offset-1 product\">\n"
                                            + "            <div class=\"off\"><img src=\"pic/icon/off-0" + i + ".png\" alt=\"20%off\" > </div>\n"
                                            + "            <form action=\"viewlookdetail\" method=\"post\"><input type=\"hidden\" name=\"look_id\" value=\"" + rs.getInt("LOOKS_ID") + "\"/><input type=\"hidden\" name=\"look_pic\" value=\"" + rs.getString("LOOKS_PIC") + "\"/><input type=\"hidden\" name=\"look_alt\" value=\"" + rs.getString("LOOKS_ALT") + "\"/><button onclick=\"Lookdetail\"><img src=\"" + rs.getString("LOOKS_PIC") + "\" alt=\"" + rs.getString("LOOKS_ALT") + "\" height=\"350px\" > </button></form>\n"
                                            + "   </div><!--/.col-md-2-->");
                                    i++;
                                }
                                rs.close();
                                conn.close();
                            }
                        %>
                    </div><!--/.row-->
                </div><!--/.container-->
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
