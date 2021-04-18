<%@include file="common/header.jspf" %>
<%@include file="common/navigation.jspf" %>
<div class="container">
<h1>Add a Course</h1>
<form:form method="post" commandName="todo">
<fieldset class="form-group">
<form:hidden path="id"/>
<form:hidden path="user"/>
<form:label path="desc">Description </form:label>
<form:input path="desc" type="text" class="form-control" required="required"></form:input>
<form:errors path="desc" cssClass="text-warning"></form:errors>
</fieldset>

<fieldset class="form-group">
<form:label path="targetDate">TargetDate </form:label>
<form:input path="targetDate" type="text" class="form-control" required="required"></form:input>
<form:errors path="targetDate" cssClass="text-warning"></form:errors>
</fieldset>

<input class="btn btn-success" type="submit" value="Submit" align="center">
</form:form>
</div>
<%@include file="common/footer.jspf" %>