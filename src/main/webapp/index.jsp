<%--
  Created by IntelliJ IDEA.
  User: ffaria
  Date: 5/8/17
  Time: 5:04 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
    <head>
        <title>Rainy Hills by Frederick Faria</title>
    </head>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <style>
        .col-centered{
            float: none;
            margin: 0 auto;
        }
    </style>
    <body>
        <form action="rainyHills" method="post">
            <div class="row" style="padding-top: 200px" >
                <div class="col-lg-6 col-md-6 col-centered">
                    <div style="height: 40px;">
                        <h3>Rainy Hills: <span class="label label-default">Java EE Coding Exercise</span></h3>
                    </div>
                    <div style="height: 43px;">
                        <div class="input-group">
                            <input type="text" name="inputValues" class="form-control" pattern="[0-9]+(\s[0-9]+)*" placeholder="Enter the profile of a surface separated by spaces, e.g: 3 2 4 1 2" required>
                            <span class="input-group-btn">
                                <input type="submit" class="btn btn-default" value="Calculate!">
                            </span>
                        </div><!-- /input-group -->
                    </div>
                    <c:if test="${not empty answer}">
                        <div class="alert alert-success" style="padding: 6px 12px;" role="alert">${answer}</div>
                    </c:if>
                    <c:if test="${not empty error}">
                        <div class="alert alert-danger" style="padding: 6px 12px;" role="alert">${error}</div>
                    </c:if>
                </div><!-- /.col-lg-6 -->
            </div>
            <input type="hidden" name="viewid" value="index.jsp">
        </form>
    </body>
</html>
