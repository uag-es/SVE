<%@ page import="sistemadevagasdeestacionamento.Car" %>



<div class="fieldcontain ${hasErrors(bean: carInstance, field: 'propietario', 'error')} required">
	<label for="propietario">
		<g:message code="car.propietario.label" default="Propietario" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="propietario" name="propietario.id" from="${sistemadevagasdeestacionamento.User.list()}" optionKey="id" required="" value="${carInstance?.propietario?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: carInstance, field: 'placa', 'error')} required">
	<label for="placa">
		<g:message code="car.placa.label" default="Placa" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="placa" required="" value="${carInstance?.placa}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: carInstance, field: 'marca', 'error')} required">
	<label for="marca">
		<g:message code="car.marca.label" default="Marca" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="marca" required="" value="${carInstance?.marca}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: carInstance, field: 'modelo', 'error')} required">
	<label for="modelo">
		<g:message code="car.modelo.label" default="Modelo" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="modelo" required="" value="${carInstance?.modelo}"/>

</div>

