<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytags"%>
<html>
<head>
<mytags:jquery />
<mytags:style />
</head>
<body>
<mytags:menu/>
<h3>Carts</h3>
<c:choose>
	<c:when test="${fn:length(persons) gt 0}">
		<table border=1>
			<tr>
				<th>Id</th>
				<th>User</th>
				
			</tr>
			<c:forEach var="Cart" items="${carts}">
				<tr class="${person.age gt 70 ? 'senior' : 'junior'}">
					<td><c:out value="${Cart.id}"/></td>
					<td>${Cart.User}</td>
					
				</tr>
			</c:forEach>
		</table>
	</c:when>
	<c:otherwise>No carts</c:otherwise>
</c:choose>
<mytags:footer/>

</body>
</html>
