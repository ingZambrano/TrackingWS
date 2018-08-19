<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<th width="39%" scope="row">
	<!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
	<a class="hiddenanchor" id="toregister"></a> <a class="hiddenanchor"
	id="tologin"></a>
	<div id="wrapper"><c:if test="${empty loggedUser }">

			<c:url var="securityCheck" value="/j_spring_security_check" />

			<div id="login" class="animate form">
				<form action="${securityCheck }" method="post" autocomplete="on">
					<h1>INICIAR SESI&Oacute;N</h1>
					<p><label for="j_username" class="uname" data-icon="">
							USUARIO&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> <input
						id="username" name="j_username" required="required" type="text"
						placeholder="" /></p>
					<p><label for="j_password" class="youpasswd" data-icon="">
							CONTRASE&Ntilde;A </label> <input id="password" name="j_password"
						required="required" type="password" placeholder="" /></p>

					<p class="login button"><label
						style="color: red; align: center;"> ${msj_error}</label> <input
						type="submit" value="ACCEDER" /></p>

					<p class="change_link"><a href="/auth/forgot"
						class="to_register">¿OLVID&Oacute; SU CONTRASE&Ntilde;A?</a></p>

			</form>
			</div>
		</c:if></div>
</th>
<td width="61%">
	<div>

		<ul id="carruselAvior" style="list-style-type: none;">
			<li><a data-image="/image/logoAvior.png" title="descripcion1"
				data-a="b"></a></li>
			<li><a data-image="/image/seguridad-avior.png"
				title="descripcion4" data-a="a"></a></li>
			<li><a data-image="/image/avior-persona2.png"
				title="descripcion1" data-a="b"></a></li>
			<li><a data-image="/image/avior-mascota2.png"
				title="descripcion2" data-a="a"></a></li>
			<li><a data-image="/image/ubicacion-avior.png"
				title="descripcion4" data-a="a"></a></li>
			<li><a data-image="/image/avior-persona1.png"
				title="descripcion3" data-a="a"></a></li>
			<li><a data-image="/image/avior-mascota1.png"
				title="descripcion3" data-a="a"></a></li>
	</ul>


</div>


</td>
<script type="text/javascript" src="engine1/jquery.js"></script>
<script type="text/javascript" src="engine1/wowslider.js"></script>
<script type="text/javascript" src="engine1/script.js"></script>
<script type="text/javascript" src="/js/common_behaviour.js"></script>
<script src="https://code.jquery.com/jquery-1.7.2.min.js"
	type="text/javascript"></script>
<script src="/js/dev/jquery.jsCarousel-1.1.1.js" type="text/javascript"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#carruselAvior').jsCarousel({
			autostart : true,
			effect : 'fade' //slide, simple
			,
			width : 626,
			height : 499,
			interval : 3000,
			effectDuration : 500

		});

		$('#carruselAvior').jsCarousel('addCallback', 'onLoad', function() {
			if (console) {
				console.log('loaded');
			}
		});

		$('#start-button').click(function(e) {
			$('#carrusel').jsCarousel('start');
		});

		$('#stop-button').click(function(e) {
			$('#carrusel').jsCarousel('stop');
		});

		$('#apply').click(function(e) {
			$('#carrusel').jsCarousel('options', {
				effect : $('#effect').eq(0).val(),
				effectDuration : parseInt($('#effectDuration').eq(0).val()),
				interval : parseInt($('#interval').eq(0).val())
			});
		});

		$('#next').click(function(e) {
			$('#carrusel').jsCarousel('next');
		});

		$('#previous').click(function(e) {
			$('#carrusel').jsCarousel('previous');
		});
	});
</script>
