<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<td height="168" colspan="2" scope="row">
	

	<div id="f-wrapper" >
		<%-- 
		<div class="logo-avior-chico">
			<div class=" titulo-logo-chico">
				<p>Copyright &copy; Sistemas Avior&reg;&#8482; 2013<br/>
					Powered by<a href="http://www.posicionamientoweb-licorne.com">
						Licorne</a>
				</p>
			</div>
		</div>
		--%>
		<sec:authorize	access="hasRole('ROLE_ADMIN')">		
		
		<div class="icono-footer " >
			<div class="i-agregar-cliente" onclick="location.href='/clients/add'" style="cursor:pointer;">
				<div class="titulo-icono-footer">
					<p>Agregar Cliente</p>
				</div>
			</div>
		</div>
		<div class="icono-footer " >
			<div class="i-vincular" onclick="location.href='/clients/link'" style="cursor:pointer;">
				<div class="titulo-icono-footer">
					<p>Vincular dispositivo</p>
				</div>
			</div>
		</div>
		<div class="icono-footer " >
			<div class="i-agregar-usuario" onclick="location.href='/users/add'" style="cursor:pointer;">
				<div class="titulo-icono-footer">
					<p>Agregar usuario</p>
				</div>
			</div>
		</div>
		<div class="icono-footer " >
			<div class="i-quitar" onclick="location.href='/clients/remdevice'" style="cursor:pointer;">
				<div class="titulo-icono-footer">
					<p>Quitar dispositivo</p>
				</div>
			</div>
		</div>
		</sec:authorize>
		
		<c:if test="${not empty loggedUser }">
		
		<div class="icono-footer " >
			<div class="i-rastreo" onclick="location.href='/tracking'" style="cursor:pointer;">
				<div class="titulo-icono-footer">
					<p>Rastreo</p>
				</div>
			</div>
		</div>
		<div class="icono-footer " >
			<div class="i-cercas" onclick="location.href='/cercas'" style="cursor:pointer;">
				<div class="titulo-icono-footer">
					<p>Geo-cercas</p>
				</div>
			</div>
		</div>
		
		
<!-- 		<div class="icono-footer " >			 -->
<!-- 			<div class="i-reportes" onclick="location.href='/reportes'" style="cursor:pointer;">							 -->
<!-- 				<div class="titulo-icono-footer">				 -->
<!-- 					<p>Reportes</p> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->
		
		<div id="logout" class="icono-footer " >			
			<div class="i-cerrar" onclick="location.href='/auth/logout'" style="cursor:pointer;">							
				<div class="titulo-icono-footer">				
					<p>Cerrar sesi&oacute;n</p>
				</div>
			</div>
		</div>
		
		</c:if>
	</div>
</td>

