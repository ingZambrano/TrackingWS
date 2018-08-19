<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<td align="center">
<div id="wowslider-container1">
	<div class="ws_images">
		<h1>Cambiar contrase&ntilde;a</h1>
		<table>
			<tr>
				<td>Contrase&ntilde;a anterior:</td>
				<td><input id="oldPass" type="password" size="10"></td>
			</tr>
			<tr>
				<td>Contrase&ntilde;a nueva:</td>
				<td><input id="newPass" type="password" size="10"></td>

			</tr>

			<tr>
				<td>Confirmar contrase&ntilde;a:</td>
				<td><input id="newPassConfirm" type="password" size="10"></td>

			</tr>

			<tr>
				<td colspan="2" align="center"><input type="button" value="Enviar"
					onclick="validarForm();" style="cursor: pointer;" /></td>
			</tr>
		</table>

	</div>
</div>
</td>