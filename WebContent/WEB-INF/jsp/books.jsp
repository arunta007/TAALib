<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<table border="1" height="100%" width="100%">
<tr>
<td width="5%">Order No</td>
<td width="5%">Book Id</td>
<td align="center" width="30%">Title</td>
<td align="center" width="30%">Description</td>

</tr>
<c:forEach begin="1" items="${listOfBooks}" var="book" varStatus="i">
<tr>
<td>${i.index}</td>
<td>${book.id}</td>
<td align="center">${book.title}</td>
<td align="center">${book.description}</td>
</tr>
</c:forEach></table>
