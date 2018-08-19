<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:url var="submitComment" value="/about/submit" />

<script type="text/javascript">
	function MM_validateForm() { //v4.0
		if (document.getElementById) {
			var i, p, q, nm, test, num, min, max, errors = '', args = MM_validateForm.arguments;
			for (i = 0; i < (args.length - 2); i += 3) {
				test = args[i + 2];
				val = document.getElementById(args[i]);
				if (val) {
					nm = val.name;
					if ((val = val.value) != "") {
						if (test.indexOf('isEmail') != -1) {
							p = val.indexOf('@');
							if (p < 1 || p == (val.length - 1))
								errors += '- ' + nm
										+ ' must contain an e-mail address.\n';
						} else if (test != 'R') {
							num = parseFloat(val);
							if (isNaN(val))
								errors += '- ' + nm
										+ ' must contain a number.\n';
							if (test.indexOf('inRange') != -1) {
								p = test.indexOf(':');
								min = test.substring(8, p);
								max = test.substring(p + 1);
								if (num < min || max < num)
									errors += '- ' + nm
											+ ' must contain a number between '
											+ min + ' and ' + max + '.\n';
							}
						}
					} else if (test.charAt(0) == 'R')
						errors += '- ' + nm + ' is required.\n';
				}
			}
			if (errors)
				alert('The following error(s) occurred:\n' + errors);
			document.MM_returnValue = (errors == '');
		}
	}
</script>


<td scope="row">
	<p class="p">Si tiene alguna duda o comentario acerca de nuestro
		sistema, le sugerimos completar el siguiente formulario, nuestro
		equipo se pondr&aacute; en contacto con Usted, gracias.</p>
</td>
<td width="45%" rowspan="2"><img src="/image/seguridad.png"
	width="500" height="360" alt="Seguridad Avior"></td>
</tr>
<tr>
	<th width="55%" scope="row">
		<!-- Aqui se pone el mensaje de estado del servidor con respecto al formulario -->
		<form:form method="POST" modelAttribute="commentForm"
			action="${submitComment }">

			<table width="504" height="260" border="0" cellpadding="0"
				cellspacing="0">
				<tr>
					<td class="formulario">
						<p>Email*</p>
					</td>
					<!-- En error debe de cambiar a class="error" -->
					<td colspan="3"><form:input path="email" class="input"
							type="text" cssClass="input campo" id="email" size="55" /></td>
					<td><form:errors cssClass="field_error" path="email" /></td>
				</tr>
				<tr>
					<td class="formulario" scope="col">
						<p>Nombre*</p>
					</td>
					<!-- En error debe de cambiar a class="error" -->
					<td colspan="3" scope="col"><form:input path="nombre"
							type="text" class="input" id="nombre2" value="" size="55" /></td>
					<td><form:errors cssClass="field_error" path="nombre" /></td>
				</tr>
				<%-- Aun no hay soporte para guardar el telefono --%>
				<%--  
        <tr>
          <td class="formulario" scope="col">
            <p>Telefono*</p>
          </td>
          <!-- En error debe de cambiar a class="error" -->
          <td colspan="3" scope="col">
            <input name="telefono" type="text"class="input" id="telefono" value="" size="55" class="campo">
          </td>
        </tr>
    --%>

				<tr>
					<td class="formulario"><p>mensaje*</p></td>
					<!-- En error debe de cambiar a class="com-error" -->
					<td colspan="3"><textarea name="comment" cols="30"
							class="textarea" class="com"> </textarea></td>
				</tr>
				<tr>
					<td width="20%">&nbsp;</td>
					<td width="1%">&nbsp;</td>
					<td width="27%">
						<p>
							<input type="reset" name="limpiar" id="limpiar" value=""
								class="button1">
						</p>
					</td>
					<td width="52%">
						<p>
							<input name="enviar" type="submit" class="button22"
								onclick="MM_validateForm('email','','RisEmail');return document.MM_returnValue"
								value="">
						</p>
					</td>
				</tr>
			</table>
		</form:form>
	</th>