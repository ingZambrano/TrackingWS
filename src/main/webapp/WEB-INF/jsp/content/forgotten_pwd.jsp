<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page trimDirectiveWhitespaces="true" %>

<style>
<!--
.campo {
	width: 100%;
}
-->
</style>


<th width="60%" scope="row">
  <img src="/image/mision.png" width="500" height="418"> 
</th>

<td width="40%">
  <div id="wowslider-container1">
      <div class="ws_images">
        <h1>Reestablecer la contrase&ntilde;a</h1>
		<c:url var="resetPwdURL" value="/auth/forgot"/>
		
		<form:form method="POST" modelAttribute="resetForm" action="${resetPwdURL}" accept-charset="utf-8">
			<table>
<!-- 				<tr> -->
<%-- 					<td><form:label path="username">Usuario:</form:label> </td> --%>
<%-- 					<td><form:input path="username" class="campo" id="username" value="" size="55" /></td> --%>
<%-- 					<td><font color="red"> <form:errors path="username"/> </font></td>			 --%>
<!-- 				</tr> -->
				<tr>
					<td><form:label path="email">Correo electr&oacute;nico:</form:label> </td>
					<td><form:input path="email" class="campo" id="email" value="" size="55" /></td>
						<td><font color="red"> <form:errors path="email"/> </font></td>			
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Enviar"/> </td>			
				</tr>		
			</table>
		</form:form>
      </div>
  </div>
</td>