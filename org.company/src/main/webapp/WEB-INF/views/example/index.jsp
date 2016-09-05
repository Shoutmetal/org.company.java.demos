
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="page-header">
	<h1>Example</h1>
</div>
<div class="container-fluid col-md-12">
	<s:form action="${pageContext.request.contextPath}/example/save" method="post" commandName="PersonViewModel" class="form-horizontal">
		<div class="form-group">
			<label for="id-name" class="col-sm-2 control-label">Name</label>
			<div class="col-sm-10">
				<s:input path="person.name" type="text" class="form-control" id="id-name" placeholder="Name" />
				<s:errors path="person.Name" cssStyle="color:red" />
			</div>
		</div>
		<div class="form-group">
			<label for="id-age" class="col-sm-2 control-label">Age</label>
			<div class="col-sm-10">
				<s:input path="person.age" type="number" class="form-control" id="id-age" placeholder="Age" />
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<div class="checkbox">
					<label> <s:checkbox path="person.status" value="true" /> Status
					</label>
				</div>
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-success">Save</button>
			</div>
		</div>
	</s:form>

	<input type="text" id="term" value="" />
	<button id="btn-showmodal">Modal</button>
	<button id="btn-partial">Partial</button>
	<div class="table-responsive">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Age</th>
					<th>Status</th>
					<th>Addresses</th>
					<th>+ Address</th>
					<th>x Delete</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="item" items="${people}">
					<tr>
						<td>${item.id}</td>
						<td>${item.name}</td>
						<td>${item.age}</td>
						<td>${item.status}</td>
						<td>
							<ul>
								<c:forEach var="subitem" items="${item.addresses}">
									<li>${subitem.name}</li>
								</c:forEach>
							</ul>
						</td>
						<td><a href="${pageContext.request.contextPath}/example/address/${item.id}">Address</a></td>
						<td><a href="${pageContext.request.contextPath}/example/delete/${item.id}">Delete</a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>


</div>

<script>
	$(function() {

		$("#term").autocomplete({
			source : "search",
			minLength : 3
		})

		$("#btn-showmodal").on("click", function() {
			$.ajax({
				url : "ajaxMethod",
				type : "POST",
				data : {
					_csrf: $("#csrf-token").val(),
					data : "hello world"
				},
				success : function(data) {
					console.log(data);

				}

			})
		})
		
		$("#btn-partial").on("click", function() {
			$.ajax({
				url : "partialMethod",
				type : "POST",
				data : {
					_csrf: $("#csrf-token").val()
				},
				success : function(data) {
					console.log(data);

				}

			})
		})

	})
</script>

