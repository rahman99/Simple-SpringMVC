<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springform"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Being Java Guys | Book Details</title>
</head>
<body>
	<center>

		<div style="color: teal; font-size: 30px">Being Java Guys | Book
			Details</div>
		
		
		<c:if test="${!empty resultSearch.daftarBukuList}">
			
			<table border="1" bgcolor="black" width="600px">
				<tr
					style="background-color: teal; color: white; text-align: center;"
					height="40px">
					
					<td>Judul</td>
					<td>Pengarang</td>
					<td></td>
				</tr>
				<c:forEach items="${resultSearch.daftarBukuList}" var="daftarbuku">
					<tr
						style="background-color: white; color: black; text-align: center;"
						height="30px">
						
						<td><c:out value="${daftarbuku.judul}" />
						</td>
						<td><c:out value="${daftarbuku.pengarang}" />
						</td>
						<td><a href="editlink?id=${daftarbuku.id}">Edit</a>
							<a>|</a>
							<a href="delete?id=${daftarbuku.id}">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>

		<a href="form">add new User</a>
		
		
		
		<div >
			<springform:form method="get" action="searching" modelAttribute="resultSearch">
				<fieldset>
					<label>Search : </label>
					
					<springform:input path="searchKey" value="${resultSearch.searchKey}"/>				
					<input type="submit" id="searchingForm" value="GO" />
				</fieldset>
			</springform:form>
		</div>
	</center>
</body>
</html>
