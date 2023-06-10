<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Form</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="container">

	<div id="links">
			<h1><a href="list">Book Store</a></h1>
			<h1><a href="new" class="addNewBook">Add New Book</a></h1>
	</div>
	
	<div class= "form-div">
	
	 <form name="book_form" method="post" action="insert"> 
  
    <hr>
    <p>
	<label> title:</label>
	   <input type="text" placeholder="book title" name="booktitle" /></p>
	     <p>
	     <label> author:</label>
	   <input type="text" placeholder="book author" name="bookauthor" /></p>
		     <p>
	     <label> price:</label>
	   <input type="text" placeholder="book price" name="bookprice" /></p>
	    <br><br>
	    <input type="submit" value="submit"/>

</form>
	
	
	</div>



</div>



</body>
</html>