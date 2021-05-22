<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<!DOCTYPE html>
<html>
<head>
    <title>Collections API</title>
    <link rel="stylesheet" type="text/css" href="/css/Stylesheet1.css">
</head>
<body>

<div id="navigation_bar">
    <a href="collections" class="navigation_links" >Home</a>
    <a href="testApi" class="navigation_links" >Test API</a>
    <a href="https://github.com/HarshSharma001/Collections-Framework-Spring-Boot" target="_blank" class="navigation_links" >Get Source Code</a>
    <form id="download_form" action="download" class="navigation_links">
        <input id="download_link" type="submit" class="navigation_links" value="Download">
    </form>
    <a href="mailto:eliteharsh1998@gmail.com" class="navigation_links" >Contact US</a>
    <a href="aboutMe" class="navigation_links" >About Me</a>
</div>

<fieldset>
    <legend>Collections</legend>
    <div>
        <p class="dsa_definetion"><b><u>Data Structures</u></b> : Data structures is a way to organise data in a very efficiet way. It makes humans to play with data with lots of ease i.e. it allows users to
            manipulate and retrive data in the most efficient ways. All available data structures comes under two
            types of abstract parent data structures : </p>

        <ol type="i" class="dsa_definetion">
            <li>) Linear Data Structure : The data structures in which elements are arranged in <b>sequential order</b> or attached with the adjacent elements like arrays, stack etc.</li>
            <li>) Non-Linear Data Structure : The data structures in which elements <b>aren't</b> arranged in sequential order like trees and graphs.</li>
        </ol>

        <p class="dsa_definetion">There are several number of data structures out there, and here we gonna see the most common ones of them :</p>

        <p class="array_definetion"><b>1)<u> Array</u></b> : Arrays are collection of homogenous elements.
            The elements of array data structure used to be stored at contigous memory locations. And in
            programming world, we call such locations as indexes of elements. The indexes values may range from
            0<sup>th</sup> index to any numerical number until a certain constraint isn't crossed. Arrays can be made of any primitive or even non-primitive datatypes like int, float, double, classes etc. </p>

        <p class="array_definetion">Below is the very basic visualization of array data structure : </p>
    </div>

    <div id="array_DSA">
        <img src="DSA - Pictures/Array DS 1.png" alt="">
    </div>

    <div>
        <p class="stack_definetion"><b>2)<u> Stack</u></b> : Stack is a linear data structure which
            uses <b>"Last In First Out"</b> policy with it's elements and it's operations as well. It also uses an index variable named as <b>top</b> which is incremented right before we insert an element into the stack and get decremented right after we remove an element from the stack and initially it's value used to be -1. Stacks can also be made of any primitive or even non-primitive datatypes like int, float, double, classes etc. </p>

        <p class="stack_definetion">Below is the very basic visualization of stack data structure : </p>
    </div>

    <div id="stack_DSA">
        <img src="DSA - Pictures/Stack DS 1.png" alt="">
    </div>

    <div>
        <p class="linkedlist_definetion"><b>3)<u> LinkedList</u></b> : LinkedList is an another type of linear data structure which uses nodes to organise elements and unlike array, linkedlist is a dynamic data structure i.e. we can add or remove elements dynamically. Each of the nodes consists 2 blocks i.e. 1<sup>st</sup> block represents data block and the 2<sup>nd</sup> block represents address block which contains address of the next adjacent element (node). LinkedList can also be made of any primitive or even non-primitive datatypes like int, float, double, classes etc. </p>

        <p class="linkedlist_definetion">Below is the very basic visualization of linkedlist data structure : </p>
    </div>

    <div id="linkedlist_DSA">
        <img src="DSA - Pictures/LinkedList DS 1.png" alt="">
    </div>

    <div>
        <p class="queue_definetion"><b>4)<u> Queue</u></b> : Queue is also a linear data structure which follows the principle of <b>"First In First Out"</b> i.e. the first added element will be the first element to get removed as well. We can assume queue as a real world queue, the one gets first in the queue is the one who gets out of the queue first as well. The first element's index of the queue is denoted as <b>front</b> of the queue and the last element's index of the queue is denoted as <b>rear</b> of the queue.  Queue can also be made of any primitive or even non-primitive datatypes like int, float, double, classes etc. </p>

        <p class="queue_definetion">Below is the very basic visualization of queue data structure : </p>
    </div>

    <div id="queue_DSA">
        <img src="DSA - Pictures/Queue DS 1.png" alt="">
    </div>

    <div>
        <p class="set_definetion"><b>5)<u> Set</u></b> : Set is an unordered data structure which inherits properties of mathematical set i.e. it provides us features like <b>union, intersection</b> etc. And collection itself provides a special functionality to set data structure for it's enhancement, set can't consist duplicate elements in it. Set can also be made of any primitive or even non-primitive datatypes like int, float, double, classes etc. </p>

        <p class="set_definetion">Below is the very basic visualization of set data structure : </p>
    </div>

    <div id="set_DSA">
        <img src="DSA - Pictures/Set DS 1.png" alt="">
    </div>

</fieldset>
</body>
</html>