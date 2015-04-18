<%-- 
    Document   : Checkout
    Created on : Apr 16, 2015, 9:27:01 PM
    Author     : SONGSONG
--%>

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
        <link href="css/check.css" rel="stylesheet">
        <script src='js/checkout.js'></script>
        <script src="js/ie-emulation-modes-warning.js"></script>
        <script src="js/bootstrap.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    </head>
    <body onload="show_cart()">
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
                    <div class="row title">
                        <p><h3>Check out</h3></p>
                        <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
                            <form action="Checkout" method="post">
                                <div class="panel panel-default">
                                    <div class="panel-heading" role="tab" id="headingOne">
                                        <h4 class="panel-title">
                                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="false" arias="collapseOne">
                                                Items<br/>
                                            </a>
                                        </h4>
                                    </div>
                                    <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
                                        <div class="panel-body">
                                            <table class="table">
                                                <thead>
                                                    <tr class="info">
                                                        <td>Description</td>
                                                        <td>size</td>
                                                        <td>Price</td>
                                                        <td>Quantity</td>
                                                        <td>Total</td>
                                                    </tr>
                                                </thead>
                                                <tbody id="product-lists">
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div><!--panel-->
                                <div class="panel panel-default">
                                    <div class="panel-heading" role="tab" id="headingTwo">
                                        <h4 class="panel-title">
                                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false">
                                                Shipping
                                            </a>
                                        </h4>
                                    </div>
                                    <div id="collapseTwo" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingTwo">
                                        <div class="form-horizontal">
                                            <div class="form-group">
                                                <label class="col-sm-2 col-sm-offset-3 control-label">First name</label>
                                                <div class="col-sm-3">
                                                    <input type="text" class="form"  name="firstname">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-2 col-sm-offset-3 control-label">Last name</label>
                                                <div class="col-sm-3">
                                                    <input type="text" class="form"  name="lastname">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-2 col-sm-offset-3 control-label">Line1</label>
                                                <div class="col-sm-3">
                                                    <input type="text" class="form" id="line1"  name="line1">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-2 col-sm-offset-3 control-label">Line2</label>
                                                <div class="col-sm-3">
                                                    <input type="text" class="form" name="line2">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-2 col-sm-offset-3 control-label">City</label>
                                                <div class="col-sm-3">
                                                    <input type="text" class="form" name="city">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-2 col-sm-offset-3 control-label">State</label>
                                                <div class="col-sm-3">
                                                    <input type="text" class="form" name="state">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-2 col-sm-offset-3 control-label">Postal code</label>
                                                <div class="col-sm-3">
                                                    <input type="text" class="form" name="postalcode">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-2 col-sm-offset-3 control-label">Country</label>
                                                <div class="col-sm-3">
                                                    <input type="text" class="form" name="Country">
                                                </div>
                                            </div>
                                        </div><!--panel-body-->
                                    </div><!--panel-collapse-->
                                </div><!--panel-->
                                <div class="panel panel-default">
                                    <div class="panel-heading" role="tab" id="headingTwo">
                                        <h4 class="panel-title">
                                            <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" arias="collapseThree">
                                                Payment
                                            </a>
                                        </h4>
                                    </div>
                                    <div id="collapseThree" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingThree">
                                        <div class="form-horizontal">
                                            <div class="form-group">
                                                <label class="col-sm-2 col-sm-offset-3 control-label">Card Number</label>
                                                <div class="col-sm-3">
                                                    <input type="text" class="form" name="cardnumber">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-2 col-sm-offset-3 control-label">Type</label>
                                                <div class="col-sm-3">

                                                    <select class="form" name="cardtype">
                                                        <option>VISA</option>
                                                        <option>American Express</option>
                                                        <option>Discover</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-2 col-sm-offset-3 control-label">Expired</label>
                                                <div class="col-sm-3">

                                                    <select class="form-inline half" name="month">
                                                        <option>-</option>
                                                        <option>1</option>
                                                        <option>2</option>
                                                        <option>3</option>
                                                        <option>4</option>
                                                        <option>5</option>
                                                        <option>6</option>
                                                        <option>7</option>
                                                        <option>8</option>
                                                        <option>9</option>
                                                        <option>10</option>
                                                        <option>11</option>
                                                        <option>12</option>
                                                    </select> / 
                                                    <select class="form-inline half" name="year">
                                                        <option>-</opiton>
                                                        <option>2015</option>
                                                        <option>2016</option>
                                                        <option>2017</option>
                                                        <option>2018</option>
                                                        <option>2019</option>
                                                        <option>2020</option>
                                                        <option>2021</option>
                                                        <option>2022</option>
                                                        <option>2023</option>
                                                        <option>2024</option>
                                                        <option>2025</option>
                                                        <option>2026</option>
                                                        <option>2027</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-2 col-sm-offset-3 control-label">Security code</label>
                                                <div class="col-sm-3">
                                                    <input type="text" class="form" name="seccode">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-5 col-sm-offset-3">
                                                    <button type="submit" class="btn btn-info">Confirm</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div><!--panel-->
                            </form>
                        </div><!--panel-group-->
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
