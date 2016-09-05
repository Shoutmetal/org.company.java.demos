<nav class="navbar navbar-inverse navbar-fixed-top container-fluid">
	<div class="container-fluid">

		<div class="navbar-header">
			<a class="navbar-brand" href="#" style="position: relative; top: -8px;"> <img alt="Brand" src="${pageContext.request.contextPath}/resources/img/java8.png">
			</a>
		</div>

		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="${home}"><a href="${pageContext.request.contextPath}/">Home</a></li>
				<li class="${building_blocks}"><a href="${pageContext.request.contextPath}/building_blocks/index">Java Building Blocks</a></li>
				<li class="${operators_and_statements}"><a href="${pageContext.request.contextPath}/operators_and_statements/index">Operators and Statements</a></li>
				<li class="${core_java_api}"><a href="${pageContext.request.contextPath}/core_java_api/index">Core Java API</a></li>
				<li class="${methods_and_encapsulation}"><a href="${pageContext.request.contextPath}/methods_and_encapsulation/index">Methods and Encapsulation</a></li>
				<li class="${class_design}"><a href="${pageContext.request.contextPath}/class_design/index">Class Design</a></li>
				<li class="${exceptions}"><a href="${pageContext.request.contextPath}/exceptions/index">Exceptions</a></li>
			</ul>
		</div>

	</div>
	<jsp:include page="user.jsp" />
</nav>



