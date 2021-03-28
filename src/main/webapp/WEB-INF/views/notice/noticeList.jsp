<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<%@ taglib
	prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"
%>
<!DOCTYPE html>
<html>
<head>
<c:import url="../template/bootStrap.jsp"></c:import>
<title>noticeList</title>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<div class="container">
		<h2>Notice</h2>
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">NO</th>
					<th scope="col">SUBJECT</th>
					<th scope="col">NAME</th>
					<th scope="col">DATE</th>
					<th scope="col">HIT</th>
				</tr>
			</thead>
			<tbody>
				<!-- 반복문 시작 -->
				<c:forEach
					items="${list }"
					var="DTO"
				>
					<tr>
						<td>${DTO.num }</td>
						<td><a href="./noticeSelect?num=${DTO.num }">${DTO.title }</a></td>
						<td>${DTO.writer }</td>
						<td>${DTO.regdate }</td>
						<td>${DTO.hit }</td>
					</tr>
				</c:forEach>
				<!-- 반복문 끝 -->
			</tbody>
		</table>
		<c:if test="${not empty member and member.id eq 'admin' }">
		<a href="./noticeInsert" class="btn btn-dark" role="button">Insert</a>
		</c:if>
	</div>
</body>
</html>