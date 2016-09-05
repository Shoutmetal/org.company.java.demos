<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form"%>

<div class="row" id="pwd-container">
	<div class="col-md-3"></div>

	<div class="col-md-6">
		<section class="login-form">

			<s:form action="${pageContext.request.contextPath}/account/saveUser" method="post" commandName="User" class="form-horizontal" role="login">

				<img src="${pageContext.request.contextPath}/resources/img/sign-up.png" class="img-responsive" alt="" />

				<s:input path="Username" type="email" name="Username" placeholder="Username" class="form-control input-lg" required="true" />

				<s:input path="Password" type="password" name="password" class="form-control input-lg" id="password" placeholder="Password" required="true" />

				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

				<button type="submit" name="go" class="btn btn-lg btn-primary btn-block">Create</button>

				<a href="${pageContext.request.contextPath}/" class="btn btn-lg btn-warning btn-block">Back</a>

			</s:form>

			<div class="form-links">
				<a href="#">www.company.com</a>
			</div>
		</section>
	</div>

	<div class="col-md-2"></div>
</div>


