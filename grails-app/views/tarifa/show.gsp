
<%@ page import="sistemadevagasdeestacionamento.Tarifa" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'tarifa.label', default: 'Tarifa')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-tarifa" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-tarifa" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list tarifa">
			
				<g:if test="${tarifaInstance?.tarifa}">
				<li class="fieldcontain">
					<span id="tarifa-label" class="property-label"><g:message code="tarifa.tarifa.label" default="Tarifa" /></span>
					
						<span class="property-value" aria-labelledby="tarifa"><g:fieldValue bean="${tarifaInstance}" field="tarifa"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${tarifaInstance?.use}">
				<li class="fieldcontain">
					<span id="use-label" class="property-label"><g:message code="tarifa.use.label" default="Use" /></span>
					
						<span class="property-value" aria-labelledby="use-label"><g:link controller="user" action="show" id="${tarifaInstance?.use?.id}">${tarifaInstance?.use?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:tarifaInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${tarifaInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
