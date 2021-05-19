<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" errorPage="Error.jsp" isErrorPage="false" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Test Collections</title>
    <link rel="stylesheet" type="text/css" href="Layouts/Stylesheet2.css">
</head>
<body>

<p>Choose any of the data structures to test the API</p>
<div id = "dsa_selector">

    <form action="" accept-charset="utf-8">
    <input type="radio" name="dataStructure" value="arraylist" class="ds_rd_buttons" checked>ArrayList
    <input type="radio" name="dataStructure" value="vector" class="ds_rd_buttons">Vector
    <input type="radio" name="dataStructure" value="linkedlist" class="ds_rd_buttons">LinkedList
    <input type="radio" name="dataStructure" value="stack" class="ds_rd_buttons">Stack
    <input type="radio" name="dataStructure" value="queue" class="ds_rd_buttons">Queue
    <input type="radio" name="dataStructure" value="circularQueue" class="ds_rd_buttons">CircularQueue
    <input type="radio" name="dataStructure" value="priorityQueue" class="ds_rd_buttons">PriorityQueue
    <input type="radio" name="dataStructure" value="set" class="ds_rd_buttons">Set

    <fieldset>
        <legend>Enter Details</legend>
            <input type="text" name="add_element" placeholder="Enter element to insert" class="dsa_details" >
            <input type="submit" name="" value="Add Element" class="dsa_details" id="add" formmethod="post" onclick="form.action='add';">
            <input type="text" name="delete_element" placeholder="Enter element to delete" class="dsa_details">
            <input type="submit" name="" value="Remove Element" class="dsa_details" formmethod="post" onclick="form.action='remove';">
            <input type="text" name="" placeholder='${maxElement}' class="dsa_details" id="maxItem" disabled="">
            <input type="submit" name="" value="Max Element" class="dsa_details" formmethod="post" onclick="form.action='max';">

            <input type="text" name="searching_element" placeholder='${elementFound}' class="dsa_details">
            <input type="submit" name="" value="Search Element" class="dsa_details" formmethod="post" onclick="form.action='search';">

            <input type="text" name="" placeholder='${size}' class="dsa_details" id="dsSize" disabled="">
            <input type="submit" name="" value="Size" class="dsa_details" id="sizeButton" formmethod="post" onclick="form.action='size'">
            <input type="submit" name="" value="Sort Elements" class="dsa_details" id="sort" formmethod="post" onclick="form.action='sort';">


        <div>
            <table style="border: 1px solid black;
                          padding: 5px;
                          border-collapse: collapse;
                          margin: 10px;">
                <caption>${dsa_name}</caption>
                <tr>
                    <c:forEach items="${dsa}" var="a">
                        <td style="border: 2px solid black;
                                   font-size: 17px;
                                   padding: 10px">${a}</td>
                    </c:forEach>
                </tr>
            </table>
        </div>
    </fieldset>
    </form>
</div>
</body>
</html>