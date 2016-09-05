<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/account/logout" var="logoutUrl" />
<form action="${logoutUrl}" method="post" id="logoutForm">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" id="csrf-token" />
</form>
<c:if test="${user != null}">
	<small style="color: white; position: absolute; right: 5px; top: 5px; padding: 10px"> <strong>Welcome :</strong> ${user} | <a href="javascript:formSubmit()"> Logout</a>
	</small>
</c:if>

<script>
	function formSubmit() {
		document.getElementById("logoutForm").submit();
	}
</script>