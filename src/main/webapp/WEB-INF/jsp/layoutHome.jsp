<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page trimDirectiveWhitespaces="true"%>
<!DOCTYPE HTML>
<html>
<head>
<link rel="shortcut icon" type="/image/vnd.microsoft.icon"
	href="<c:url value="../image/favicon.ico" />" />
<title>Sistemas Avior</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />

<script src="/js/jquery.min.js"></script>
<script src="/js/jquery.scrolly.min.js"></script>
<script src="/js/jquery.scrollzer.min.js"></script>
<script src="/js/skel.min.js"></script>
<script src="/js/skel-layers.min.js"></script>
<script src="/js/init.js"></script>
<noscript>
	<link rel="stylesheet" href="/css/skel.css" />
	<link rel="stylesheet" href="/css/style.css" />
	<link rel="stylesheet" href="/css/style-wide.css" />
</noscript>
<c:url var="submitComment" value="/submit" />

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


</head>
<body>

	<!-- Header -->
	<div id="header" class="skel-layers-fixed">

		<div class="top">

			<!-- Logo -->
			<h1 id="title" align="right"
				style="position: relative; color: #fff; font-weight: 600; font-size: 1em; line-height: 1em; margin-right: 1.5em; margin-top: 2em;">Sistemas
				Avior</h1>
			<div id="logo">

				<span class="image avatar48" style="width: 100%; height: 100%;"><img
					src="/image/logoAviorLitle.png" alt="" /></span>

				<p>avior.com.mx</p>
			</div>
			<!-- Nav -->
			<nav id="nav">
				<ul>
					<li><a href="#home" id="top-link"
						class="skel-layers-ignoreHref"><span class="icon fa-home">Principal</span></a></li>
					<li><a href="#top" id="top-link"
						class="skel-layers-ignoreHref"><span class="icon fa-users">Misi&oacute;n
								y Visi&oacute;n</span></a></li>
					<li><a href="#video_comercial" id="portfolio-link"
						class="skel-layers-ignoreHref"><span
							class="icon fa-video-camera">Video Comercial</span></a></li>
					<li><a href="#about" id="about-link"
						class="skel-layers-ignoreHref"><span
							class="icon fa-map-marker">Intellitracker</span></a></li>
					<li><a href="#contact" id="contact-link"
						class="skel-layers-ignoreHref"><span class="icon fa-envelope">Contacto</span></a></li>
				</ul>
			</nav>

		</div>

		<div class="bottom">

			<!-- Social Icons -->
			<ul class="icons">
				<li><a href="https://twitter.com/AviorMx"
					class="icon fa-twitter"><span class="label">Twitter</span></a></li>
				<li><a href="https://www.facebook.com/aviormx"
					class="icon fa-facebook"><span class="label">Facebook</span></a></li>
				<li><a href="https://plus.google.com/+AviorMx"
					class="icon fa-google-plus"><span class="label">GPlus</span></a></li>

			</ul>

		</div>

	</div>

	<!-- Main -->
	<div id="main">


		<!-- Home -->
		<section id="home" class="one dark cover"
			style="background-image: url('/image/fondo_home.jpg'); width: 100%; height: 100%;">
			<div>
				<header>
					<div>
						<img alt="" src="/image/logoAviorBig.png"
							style="width: 70%; height: 60%;">
					</div>
					<div style="color: #000; padding-bottom: 30%;">
						<h2>Sistemas Avior</h2>
						<h3>Desarrollamos tecnolog&iacute;a como tu la necesitas.</h3>
					</div>

				</header>

			</div>
		</section>


		<!-- Mision Vision -->
		<section id="top" class="three"
			style="padding-left: 30px; padding-right: 30px;">
			<div>
				<header>
					<h2 class="alt"
						style="color: #000; font-size: 35px; text-align: justify; font-weight: lighter;">
						Somos una empresa mexicana dedicada a ofrecer soluciones
						tecnol&oacute;gicas a problemas reales de manera accesible y eficiente.</h2>

					<p style="color: #000; font-size: 25px; font-weight: lighter;">
						Misi&oacute;n:<br>Crear productos y servicios que satisfagan
						las necesidades de nuestros clientes, utilizando modernas
						herramientas tecnol&oacute;gicas de software y hardware.
					</p>
					<br> <br> <br>
					<p style="color: #000; font-size: 25px; font-weight: lighter;">
						Visi&oacute;n:<br>Ser la empresa n&uacute;mero uno en soluciones y
						desarrollo de tecnol&oacute;gico, orient&aacute;ndonos siempre a la satisfacción
						completa de nuestros clientes, comprometi&eacute;ndonos a tomar en cuenta
						sus necesidades en Tecnolog&iacute;as de la Información para cubrirlas de
						manera eficaz y eficiente.
					</p>
					<br> <br> <br>
				</header>

			</div>
		</section>

		<!-- Video Comercial -->
		<section id="video_comercial" class="two"
			style="padding-left: 30px; padding-right: 30px;">
			<div style="padding-bottom: 200px;">
				<header>
					<h2>Video Comercial</h2>
				</header>

				<p class="alt" style="text-align: justify;">En Sistemas Avior
					contamos con una gama de soluciones tecnológicas que se adaptan a
					sus necesidades. Lo invitamos a ver nuestro video comercial</p>

				<div>
					<div>
						<article class="item">
							<div>
								<iframe width="560" height="315"
									src="https://www.youtube.com/embed/PCX1K1-oSjM?rel=0&amp;showinfo=0"
									frameborder="0" allowfullscreen></iframe>
							</div>

						</article>

					</div>

				</div>

			</div>
		</section>

		<!-- About Me -->
		<section id="about" class="three" style="padding: 5px;">
			<div style="padding: 30px;">
				<header>
					<h2>Intellitracker</h2>
				</header>

				<a href="#" class="image featured" style="height: 250px;"><img
					src="/image/fondoIntellitracker.png" alt="" /></a>

				<p style="font-weight: bold;">Intellitracker es un sistema de
					geolocalización satelital.</p>
				<p style="text-align: justify;">Consta de un dispositivo de
					rastreo, una base de datos para almacenar el historial de
					ubicaciones, una p&aacute;gina web donde se consulta la posición
					actual y aplicacion móvil compatible con iphone y android, adem&aacute;s
					de obtener reportes y cercas virtuales con alarma SMS</p>
				<img alt="" src="/image/localiza.png"><br> <a
					href="/intellitracker" class="button scrolly"
					style="width: 100px; height: 40px; padding: 2px; align: center; font-size: 15px;">Iniciar
					Sesi&oacute;n</a>
			</div>

		</section>

		<!-- Contact -->
		<section id="contact" class="four">
			<div>

				<header>
					<h2>Contacto</h2>
				</header>

				<p>Si tienes alguna duda acerca de nuestros servicios env&iacute;anos
					un mensaje y con gusto nos pondremos en contacto contigo.</p>
				<form:form method="POST" modelAttribute="commentForm"
					action="${submitComment }">

					<table class="row 50%">
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

						<tr>
							<td class="formulario"><p>Mensaje*</p></td>
							<!-- En error debe de cambiar a class="com-error" -->
							<td colspan="3"><textarea name="comment" cols="30"
									class="textarea" class="com"> </textarea></td>
						</tr>
						<tr>
							<td width="20%">&nbsp;</td>
							<td width="1%">&nbsp;</td>

							<td width="52%">
								<p>


									<input type="submit" value="Enviar mensaje"
										onclick="MM_validateForm('email','','RisEmail');return document.MM_returnValue" />

								</p>
							</td>
						</tr>
					</table>
				</form:form>

			</div>
		</section>

	</div>

	<!-- Footer -->
	<div id="footer">

		<!-- Copyright -->
		<ul class="copyright">
			<li>&copy; Untitled. All rights reserved.</li>
			<li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
		</ul>

	</div>

</body>
</html>