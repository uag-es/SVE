<%@ page import="sistemadevagasdeestacionamento.Tarifa" %>



<div class="fieldcontain ${hasErrors(bean: tarifaInstance, field: 'tarifa', 'error')} required">
	<label for="tarifa">
		<g:message code="tarifa.tarifa.label" default="Tarifa" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="tarifa" from="${tarifaInstance.constraints.tarifa.inList}" required="" value="${tarifaInstance?.tarifa}" valueMessagePrefix="tarifa.tarifa"/>

</div>

<div class="fieldcontain ${hasErrors(bean: tarifaInstance, field: 'use', 'error')} required">
	<label for="use">
		<g:message code="tarifa.use.label" default="Use" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="use" name="use.id" from="${sistemadevagasdeestacionamento.User.list()}" optionKey="id" required="" value="${tarifaInstance?.use?.id}" class="many-to-one"/>

</div>

