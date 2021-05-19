<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Error Alert</title>
    <link rel="stylesheet" type="text/css" href="Layouts/Stylesheet3.css">
</head>
    <body>
    <div id="error_message">
        <p>Error : ${errorMessage}</p>
    </div>

    <div>
        <p id="line1">I'm so sorry for the inconvenience you're</p>
        <p id="line2">facing, kindly return to <a href="collections">homepage</a></p>
    </div>
    
    <div id="error_image">
        <img src="DSA - Pictures/Error.png" alt="Error">
    </div>
    </body>
</html>