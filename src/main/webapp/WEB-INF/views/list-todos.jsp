<%@include file="common/header.jspf" %>
<%@include file="common/navigation.jspf" %>

<div class="container">
<table class="table table-striped">
<caption><spring:message code="todo.caption" /></caption>
<thead>
<tr>
<th>Course</th>
<th>Start Date</th>
<th>Is Online</th>
</tr>
</thead>
<tbody>
<c:forEach items="${todos}" var="todo">
<tr>
<td>${todo.desc}</td>
<td><fmt:formatDate pattern="dd/MM/yyyy"
								value="${todo.targetDate}" /></td>
<td>${todo.done}</td>
<td>
<a class="btn btn-success" href="/update-todo?id=${todo.id}">Update</a>
<a class="btn btn-danger" href="/delete-todo?id=${todo.id}">Delete</a>
</td>
</tr>
</tbody>
</c:forEach>
</table>
<div>
<a href="/add-todo" class="btn btn-success" >Add</a>
</div>
</div>
<%@include file="common/footer.jspf" %>