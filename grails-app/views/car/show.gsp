
<%@ page import="sistemadevagasdeestacionamento.Car" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'car.label', default: 'Car')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-car" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-car" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list car">
			
				<g:if test="${carInstance?.propietario}">
				<li class="fieldcontain">
					<span id="propietario-label" class="property-label"><g:message code="car.propietario.label" default="Propietario" /></span>
					
						<span class="property-value" aria-labelledby="propietario-label"><g:link controller="user" action="show" id="${carInstance?.propietario?.id}">${carInstance?.propietario?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${carInstance?.placa}">
				<li class="fieldcontain">
					<span id="placa-label" class="property-label"><g:message code="car.placa.label" default="Placa" /></span>
					
						<span class="property-value" aria-labelledby="placa-label"><g:fieldValue bean="${carInstance}" field="placa"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${carInstance?.marca}">
				<li class="fieldcontain">
					<span id="marca-label" class="property-label"><g:message code="car.marca.label" default="Marca" /></span>
					
						<span class="property-value" aria-labelledby="marca-label"><g:fieldValue bean="${carInstance}" field="marca"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${carInstance?.modelo}">
				<li class="fieldcontain">
					<span id="modelo-label" class="property-label"><g:message code="car.modelo.label" default="Modelo" /></span>
					
						<span class="property-value" aria-labelledby="modelo-label"><g:fieldValue bean="${carInstance}" field="modelo"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:carInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${carInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
