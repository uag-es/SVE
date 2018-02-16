
<%@ page import="sistemadevagasdeestacionamento.Car" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'car.label', default: 'Car')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-car" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-car" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<th><g:message code="car.propietario.label" default="Propietario" /></th>
					
						<g:sortableColumn property="placa" title="${message(code: 'car.placa.label', default: 'Placa')}" />
					
						<g:sortableColumn property="marca" title="${message(code: 'car.marca.label', default: 'Marca')}" />
					
						<g:sortableColumn property="modelo" title="${message(code: 'car.modelo.label', default: 'Modelo')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${carInstanceList}" status="i" var="carInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${carInstance.id}">${fieldValue(bean: carInstance, field: "propietario")}</g:link></td>
					
						<td>${fieldValue(bean: carInstance, field: "placa")}</td>
					
						<td>${fieldValue(bean: carInstance, field: "marca")}</td>
					
						<td>${fieldValue(bean: carInstance, field: "modelo")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${carInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
