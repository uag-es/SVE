
<%@ page import="sistemadevagasdeestacionamento.Automovel" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'automovel.label', default: 'Automovel')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-automovel" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-automovel" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list automovel">
			
				<g:if test="${automovelInstance?.proprietario}">
				<li class="fieldcontain">
					<span id="proprietario-label" class="property-label"><g:message code="automovel.proprietario.label" default="Proprietario" /></span>
					
						<span class="property-value" aria-labelledby="proprietario-label"><g:link controller="user" action="show" id="${automovelInstance?.proprietario?.id}">${automovelInstance?.proprietario?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${automovelInstance?.placa}">
				<li class="fieldcontain">
					<span id="placa-label" class="property-label"><g:message code="automovel.placa.label" default="Placa" /></span>
					
						<span class="property-value" aria-labelledby="placa-label"><g:fieldValue bean="${automovelInstance}" field="placa"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${automovelInstance?.marca}">
				<li class="fieldcontain">
					<span id="marca-label" class="property-label"><g:message code="automovel.marca.label" default="Marca" /></span>
					
						<span class="property-value" aria-labelledby="marca-label"><g:fieldValue bean="${automovelInstance}" field="marca"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${automovelInstance?.modelo}">
				<li class="fieldcontain">
					<span id="modelo-label" class="property-label"><g:message code="automovel.modelo.label" default="Modelo" /></span>
					
						<span class="property-value" aria-labelledby="modelo-label"><g:fieldValue bean="${automovelInstance}" field="modelo"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:automovelInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${automovelInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
