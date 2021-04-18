<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	Welcome ${name}. You are now authenticated. </br>
	Manage your todo's using this link: <a href="list-todos">Manage Todos</a></br>
	<spring:message code="welcome.caption" />
</div>

<%@ include file="common/footer.jspf"%>