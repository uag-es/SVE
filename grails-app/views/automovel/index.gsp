
<%@ page import="sistemadevagasdeestacionamento.Automovel" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'automovel.label', default: 'Automovel')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-automovel" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-automovel" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<th><g:message code="automovel.proprietario.label" default="Proprietario" /></th>
					
						<g:sortableColumn property="placa" title="${message(code: 'automovel.placa.label', default: 'Placa')}" />
					
						<g:sortableColumn property="marca" title="${message(code: 'automovel.marca.label', default: 'Marca')}" />
					
						<g:sortableColumn property="modelo" title="${message(code: 'automovel.modelo.label', default: 'Modelo')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${automovelInstanceList}" status="i" var="automovelInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${automovelInstance.id}">${fieldValue(bean: automovelInstance, field: "proprietario")}</g:link></td>
					
						<td>${fieldValue(bean: automovelInstance, field: "placa")}</td>
					
						<td>${fieldValue(bean: automovelInstance, field: "marca")}</td>
					
						<td>${fieldValue(bean: automovelInstance, field: "modelo")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${automovelInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
