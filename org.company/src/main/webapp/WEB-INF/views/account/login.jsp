<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row" id="pwd-container">
	<div class="col-md-4"></div>

	<div class="col-md-4">
		<section class="login-form">

			<c:url var="loginUrl" value='../login' />
			<form name="login-form" method="post" action="${loginUrl}" role="login">
				<img src="${pageContext.request.contextPath}/resources/img/enterprise_logo.png" class="img-responsive" alt="" />

				<c:if test="${not empty error}">
					<div class="error">${error}</div>
				</c:if>

				<input type="email" name="username" placeholder="Email" class="form-control input-lg" required /> 
				
				<input type="password" name="password" class="form-control input-lg" id="password" placeholder="Password" required />
				
				 <label><input type="checkbox" name="rememberme" /> Remember me </label> 
				 
				 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

				<button type="submit" name="go" class="btn btn-lg btn-primary btn-block">Sign in</button>
				<div>
					<a href="${pageContext.request.contextPath}/account/createUser">Create account</a> or <a href="#">reset password</a>
				</div>

			</form>

			<div class="form-links">
				<a href="#">www.company.com</a>
			</div>
		</section>
	</div>

</div>


