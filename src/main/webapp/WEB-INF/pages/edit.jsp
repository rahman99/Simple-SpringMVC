<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Being Java Guys | Edit User Details</title>
</head>
<body>
	<center>

		<div style="color: teal; font-size: 30px">Being Java Guys |
			Edit Details</div>



		<c:url var="userRegistration" value="saveUser.html" />
		<form:form id="registerForm" modelAttribute="daftarBuku" method="post"
			action="update">
			<table width="400px" height="150px">
				<tr>
					<td><form:hidden path="id" value="${daftarBukuObject.id}"/></td>
					<%-- <td><form:input path="id" value="${daftarBukuObject.id}" type="hidden"/></td> --%>
				</tr>
				<tr>
					<td><form:label path="judul">Judul </form:label></td>
					<td><form:input path="judul" value="${daftarBukuObject.judul}" /></td>
				</tr>
				<tr>
					<td><form:label path="pengarang">pengarang</form:label></td>
					<td><form:input path="pengarang" value="${daftarBukuObject.pengarang}"/></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Update" />
					</td>
				</tr>
			</table>
		</form:form>


		
	</center>
</body>
</html>
