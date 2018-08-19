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

<link rel="stylesheet" href="/css/skel.css" />
<link rel="stylesheet" href="/css/style.css" />
<link rel="stylesheet" href="/css/style-wide.css" />
</head>


<body>

	<!-- Header -->
	<div id="header" class="skel-layers-fixed">

		<div class="top">

			<!-- Logo -->
			<div id="logo">
				<span class=""><img src="/image/logoAvior.png" alt=""
					style="width: 250px;" /></span>
				<h1 id="title">Sistemas Avior</h1>
				<p>avior.com.mx</p>
			</div>
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
			style="background-image: url('/image/fondo_home.jpg'); padding-left: 30px; padding-right: 30px; width: 100%; height: 100%;">
			<div>
				<header>
					<div>
						<img alt="" src="/image/logoAviorBig.png"
							style="width: 450px; height: 180px;">
					</div>
					<div style="color: #000; padding-bottom: 300px;">
						<h2>Sistemas Avior</h2>
						<h3>
							Lo sentimos ocurri&oacute; un error al enviar tu mensaje<br>
							Por favor intentalo mas tarde.
						</h3>
						<a
							href="/" class="button scrolly"
							style="width: 100px; height: 40px; padding: 2px; align: center; font-size: 15px;">Regresar
							</a>
					</div>

				</header>

			</div>
		</section>
	</div>
</body>
</html>