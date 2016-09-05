<%@taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<div class="page-header">
	<h1>${Address.person.name}</h1>
</div>
<div class="container-fluid col-md-12">
	<s:form action="${pageContext.request.contextPath}/example/addressSave"
		method="post" commandName="Address" class="form-horizontal">
		<s:hidden path="person.id" />
		<div class="form-group">
			<label for="id-name" class="col-sm-2 control-label">Address
				Name</label>
			<div class="col-sm-10">
				<s:input path="name" type="text" class="form-control" id="id-name"
					placeholder="Address Name" />
			</div>
		</div>
		<div class="form-group">
			<label for="id-name" class="col-sm-2 control-label">Address
				Number</label>
			<div class="col-sm-10">
				<s:input path="number" type="text" class="form-control" id="id-name"
					placeholder="Address Number" />
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-success">Save</button>
			</div>
		</div>
	</s:form>
</div>