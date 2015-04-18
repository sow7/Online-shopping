<%-- 
    Document   : Info
    Created on : Apr 16, 2015, 9:25:28 PM
    Author     : SONGSONG
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
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
        <script src='js/items.js'></script>
        <script src='js/cart.js'></script>
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
                            <a href="Cart.jsp"><button class="btn"><span class="glyphicon glyphicon-shopping-cart"></span> <span class="badge badge-info" id="cartamount"></span></button></a>
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
                    <%
                        int product_id = Integer.parseInt(request.getSession().getAttribute("product_id").toString());
                        Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
                        try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/ebusiness", "ebusiness", "ebusiness")) {
                            Statement st = conn.createStatement();
                            ResultSet rs = st.executeQuery("SELECT * FROM PRODUCT WHERE PRODUCT_ID=" + product_id);
                            if (rs.next()) {
                                out.print("<div class=\"col-md-4 col-md-offset-2 product\">\n"
                                        + "              <img class=\"img-rounded pdc-pic\" alt=\"" + rs.getString("product_alt") + "\"src=\"" + rs.getString("product_pic") + "\" width=\"300px\">\n"
                                        + "                    </div>\n"
                                        + "                    <div class=\"col-md-5\"> \n"
                                        + "                        <p  class=\"text-info\"><h3>" + rs.getString("product_name") + "</h3></p>\n"
                                        + "                        <dl class=\"dl-horizontal text-left\">\n"
                                        + "                            <dt>Details</dt>\n"
                                        + "                            <dd>\n"
                                        + "                                " + rs.getString("detail") + "\n"
                                        + "                            </dd>\n"
                                        + "                            <dt>Color:</dt>\n"
                                        + "                            <dd>" + rs.getString("color") + "</dd>\n"
                                        + "                            <dt>Price:</dt>\n"
                                        + "                            <dd><del> $ " + rs.getFloat("price") + "</del></dd>\n"
                                        + "                            <dt>Now:</dt>\n"
                                        + "                            <strong>\n"
                                        + "                                <dd> $ " + String.format("%.2f", rs.getFloat("price") * 0.8) + "</dd>\n"
                                        + "                            </strong>\n"
                                        + "\n"
                                        + "                                <dt>Size:</dt>\n"
                                        + "                                <dd>\n"
                                        + "                                    <select name=\"Size\" id=\"Size\">\n"
                                        + "                                        <option>XS</option>\n"
                                        + "                                        <option>S</option>\n"
                                        + "                                        <option>M</option>\n"
                                        + "                                        <option>L</option>\n"
                                        + "                                        <option>XL</option>\n"
                                        + "                                        <option>XXL</option>\n"
                                        + "                                    </select>\n"
                                        + "                                </dd>\n"
                                        + "                                <dt>Amount:</dt>\n"
                                        + "                                <dd>\n"
                                        + "                                    <input type=\"number\" name=\"Amount\" id=\"Amount\" value=\"1\" ></input>\n"
                                        + "                                </dd>\n"
                                        + "                        </dl>\n"
                                        + "                        <dt></dt>\n"
                                        + "                        <dd>\n"
                                        + "                            <button type=\"submit\" class=\"btn btn-info\" onclick=\"addToCart(" + product_id + ")\" >Add to Cart</button>\n"
                                        + "                        </dd>\n"
                                        + "                    </div>");
                            }
                        }%>
                </div><!--/.container-->
            </div><!--/.content-->
        </div><!--/.warp-->
        <!--footer-->
        <div id="footer">
            <div class="container">
                <p class="text-muted">Copyright 2015</p>
            </div>
        </div><!--/.footer-->
    </body>
</html>
