<%-- 
    Document   : index
    Created on : Apr 16, 2015, 8:58:51 PM
    Author     : SONGSONG
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="bean.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Strongbility Man-Check Out</title>        
        <script src="js/jquery-1.11.2.min.js"></script>
        <script src="js/jquery.validate.js"></script>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/normalize.css" rel="stylesheet">
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/personal.css" rel="stylesheet">
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
                                    <li ><a class="logo" href="index.jsp" ><img src="pic/icon/Logo.png" alt="Strongbility" height="65px" ></a></li>
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
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                Profile
                            </h4>
                        </div><!--/.panel-heading-->
                        <% Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
                            Statement st;
                            try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/ebusiness", "ebusiness", "ebusiness")) {
                                st = conn.createStatement();
                                ResultSet rs = st.executeQuery("SELECT * FROM MEMBERS WHERE EMAIL='" + current.getEmail() + "'");
                                if (rs.next()) {%>
                        <div class="panel-collapse collapse in">
                            <table class="table">
                                <tr>
                                    <td class="title">First Name</td>
                                    <td class="text"><%= rs.getString("firstname")%></td>
                                </tr>
                                <tr>
                                    <td class="title">Last Name</td>
                                    <td class="text"><%= rs.getString("lastname")%></td>
                                </tr>
                                <tr>
                                    <td class="title">Email</td>
                                    <td class="text"><%= rs.getString("email")%></td>
                                </tr>
                                <tr>
                                    <td class="title">Gender</td>
                                    <td class="text"><%= rs.getString("gender")%></td>
                                </tr>
                                <tr>
                                    <td class="title">Birthday</td>
                                    <td class="text"><%= rs.getString("b_month")%> <%= rs.getString("b_day")%> <%= rs.getString("b_year")%></td>
                                </tr>
                                <tr>
                                    <td class="title">Phone</td>
                                    <td class="text"><%= rs.getString("phone")%></td>
                                </tr>
                                <tr></tr>
                            </table>
                        </div><!--panel-collapse-->
                        <%
                                    conn.close();
                                    rs.close();
                                    st.close();
                                }
                            }%>
                    </div><!--/.panel-->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                Order History
                            </h4>
                        </div><!--/.panel-heading-->
                        <div class="panel-collapse collapse in">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <td>Order_ID</td>
                                        <td>Ship_ID</td>
                                        <td>expense</td>
                                        <td>Date</td>
                                    </tr>
                                </thead>
                                <%
                                    try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/ebusiness", "ebusiness", "ebusiness")) {
                                        st = conn.createStatement();
                                        ResultSet rs = st.executeQuery("SELECT ORDER_ID, SHIP_ID, TOTALPRICE, ORDER_TIME  FROM ORDERS WHERE MEMBER_ID= " + current.getId());
                                        while (rs.next()) {
                                %>
                                <tr>
                                    <td><%= rs.getInt(1)%></td>
                                    <td><%= rs.getInt(2)%></td>
                                    <td>$ <%= rs.getInt(3)%></td>
                                    <td><%= rs.getString(4)%></td>
                                </tr>
                                <%}
                                        conn.close();
                                        st.close();
                                        rs.close();
                                    }
                                %>
                            </table>
                        </div><!--panel-collapse-->
                    </div><!--/.panel-->
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
