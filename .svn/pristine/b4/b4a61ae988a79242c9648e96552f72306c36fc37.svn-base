<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="logo-avior">
	<!-- Start  menu -->
</div>
<c:if test="${empty loggedUser }">
	<nav id="topNav" style="width: 340px;">
		<ul>
			<li <c:if test="${menuItem == 'home' }">class="current"</c:if>><a
				href="/intellitracker" title="">Inicio</a></li>			
			<li <c:if test="${menuItem == 'contact' }">class="current"</c:if>><a
				href="/about/contacto" title="">Contacto</a></li>
			<c:choose>
				<c:when test="${menuItem == 'about' }">
					<li class="current last"><a href="/about" title="">Quienes
							somos</a></li>
				</c:when>
				<c:otherwise>
					<li class="last"><a href="/about" title="">Quienes somos</a></li>
				</c:otherwise>
			</c:choose>


		</ul>
	</nav>
</c:if>
<c:if test="${not empty loggedUser }">

	<nav id="topNav" style="width: 480px;">
<!-- 	<nav id="topNav" style="width: 350px;"> -->
		<ul>
			<li><div class="icono-footer ">
					<div class="i-rastreo" onclick="location.href='/tracking'"
						style="cursor: pointer;">
						<div class="titulo-icono-footer">
							<p>Rastreo</p>
						</div>
					</div>
				</div></li>
			<li>
				<div class="icono-footer ">
					<div class="i-cercas" onclick="location.href='/cercas'"
						style="cursor: pointer;">
						<div class="titulo-icono-footer">
							<p>Geo-cercas</p>
						</div>
					</div>
				</div>
			</li>
			<li>
				<div class="icono-footer ">
					<div class="i-chgpass" onclick="location.href='/auth/resetpass'"
						style="cursor: pointer;">
						<div class="titulo-icono-footer">
							<p>Cambiar contrase&ntilde;a</p>
						</div>
					</div>
				</div>
			</li>
			<li>
				<div id="logout" class="icono-footer ">
					<div class="i-cerrar" onclick="location.href='/auth/logout'"
						style="cursor: pointer;">
						<div class="titulo-icono-footer">
							<p>Cerrar sesi&oacute;n</p>
						</div>
					</div>
				</div>
			</li>
		</ul>
	</nav>

</c:if>
