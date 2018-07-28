
<%@ page import="sistemadevagasdeestacionamento.Tarifa" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'tarifa.label', default: 'Tarifa')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-tarifa" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-tarifa" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="tarifa" title="${message(code: 'tarifa.tarifa.label', default: 'Tarifa')}" />
					
						<th><g:message code="tarifa.use.label" default="Use" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${tarifaInstanceList}" status="i" var="tarifaInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${tarifaInstance.id}">${fieldValue(bean: tarifaInstance, field: "tarifa")}</g:link></td>
					
						<td>${fieldValue(bean: tarifaInstance, field: "use")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${tarifaInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
