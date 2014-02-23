<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
	<title>Book Details</title>
</head>
<body>
<h2>Book Details</h2>
<form:form method="post" action="addBook">

	<table>
	<tr>
		<td><form:label path="title">Title</form:label></td>
		<td><form:input path="title" /></td> 
	</tr>
	<tr>
		<td><form:label path="description">Description</form:label></td>
		<td><form:input path="description" /></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="Add Book"/>
		</td>
	</tr>
</table>	
	
</form:form>
</body>
</html>
