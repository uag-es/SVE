<%@ page import="sistemadevagasdeestacionamento.Automovel" %>



<div class="fieldcontain ${hasErrors(bean: automovelInstance, field: 'proprietario', 'error')} required">
	<label for="proprietario">
		<g:message code="automovel.proprietario.label" default="Proprietario" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="proprietario" name="proprietario.id" from="${sistemadevagasdeestacionamento.User.list()}" optionKey="id" required="" value="${automovelInstance?.proprietario?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: automovelInstance, field: 'placa', 'error')} required">
	<label for="placa">
		<g:message code="automovel.placa.label" default="Placa" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="placa" required="" value="${automovelInstance?.placa}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: automovelInstance, field: 'marca', 'error')} required">
	<label for="marca">
		<g:message code="automovel.marca.label" default="Marca" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="marca" required="" value="${automovelInstance?.marca}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: automovelInstance, field: 'modelo', 'error')} required">
	<label for="modelo">
		<g:message code="automovel.modelo.label" default="Modelo" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="modelo" required="" value="${automovelInstance?.modelo}"/>

</div>

