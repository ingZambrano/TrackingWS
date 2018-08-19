<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="shortcut icon" type="image/vnd.microsoft.icon"
	href="<c:url value="/favicon.ico" />" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta charset="UTF-8" />
<!-- Always force latest IE rendering engine (even in intranet) & Chrome Frame-->
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<%--Generic script --%>
<script type="text/javascript"
		src="<c:url value="/js/avior-generic.js" />"></script>

<%-- Google Analytics scripts --%>
<script>
  		(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  		(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  		m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  		})(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  		ga('create', 'UA-50370228-1', 'avior.com.mx');
  		ga('send', 'pageview');
  		
  		<%--Extender la funcionalidad del objeto Date de JavaScript para proveer la función format --%>
  	    Date.prototype.format = function(format) //author: meizz
  	    {
  	      var o = {
  	        "M+" : this.getMonth()+1, //month
  	        "d+" : this.getDate(),    //day
  	        "h+" : this.getHours(),   //hour
  	        "m+" : this.getMinutes(), //minute
  	        "s+" : this.getSeconds(), //second
  	        "q+" : Math.floor((this.getMonth()+3)/3),  //quarter
  	        "S" : this.getMilliseconds() //millisecond
  	      }

  	      if(/(y+)/.test(format)) format=format.replace(RegExp.$1,
  	        (this.getFullYear()+"").substr(4 - RegExp.$1.length));
  	      for(var k in o)if(new RegExp("("+ k +")").test(format))
  	        format = format.replace(RegExp.$1,
  	          RegExp.$1.length==1 ? o[k] :
  	            ("00"+ o[k]).substr((""+ o[k]).length));
  	      return format;
  	    }
  	    
</script>

<title><tiles:insertAttribute name="title" /></title>

<link rel="stylesheet" type="text/css" href="/css/footer.css">

<c:choose>
	<c:when test="${not empty lastPosition}">
		<c:set var="longitud" value="${lastPosition.longitud }" scope="page" />
		<c:set var="latitud" value="${lastPosition.latitud }" scope="page" />
	</c:when>
	<c:otherwise>
		<%--El centro de la Cd. de México como default --%>
		<c:set var="longitud" value="-99.133214" scope="page" />
		<c:set var="latitud" value="19.432535" scope="page" />
	</c:otherwise>
</c:choose>



<link rel="stylesheet" type="text/css" href="/css/nav.css">

<c:choose>
	<c:when test="${pageType == 'principal'}">
		<link rel="stylesheet" type="text/css" href="/css/demo.css" />
		<link rel="stylesheet" type="text/css" href="/css/style-login.css" />
		<link rel="stylesheet" type="text/css" href="/css/animate-custom.css" />
		<link rel="stylesheet" type="text/css" href="/engine1/style.css" />
		<style type="text/css">
a#vlb {
	display: none
}
</style>
	</c:when>


	<c:when test="${pageType == 'map'}">
		<%-- <link rel="stylesheet" href="css/nav.css"> --%>

		<script type="text/javascript">
    			var caralias=[<c:forEach items="${autos }" var="auto" varStatus="cont">
    		              		'<c:out value="${auto.alias}"/> ',
    			              </c:forEach>
    		    	          	0];
    			var iniLong = <c:out value="${longitud}"/>;
    			var iniLat = <c:out value="${latitud}"/>;
    			var clientId=${autos[0].idCliente};
      		</script>
	</c:when>

	<%-- template, reports y contacts no incluyen mas CSS --%>

</c:choose>


<script type="text/javascript"
	src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.js" />"> </script>

<script src="/js/modernizr.js"></script>

<c:if test="${not empty maps or not empty reportDialogs }">
	<style type="text/css">
.ui-timepicker-div .ui-widget-header {
	margin-bottom: 8px;
}

.ui-timepicker-div dl {
	text-align: left;
}

.ui-timepicker-div dl dt {
	height: 25px;
	margin-bottom: -25px;
}

.ui-timepicker-div dl dd {
	margin: 0 10px 10px 65px;
}

.ui-timepicker-div td {
	font-size: 90%;
}

.ui-tpicker-grid-label {
	background: none;
	border: none;
	margin: 0;
	padding: 0;
}

.ui-timepicker-rtl {
	direction: rtl;
}

.ui-timepicker-rtl dl {
	text-align: right;
}

.ui-timepicker-rtl dl dd {
	margin: 0 65px 10px 10px;
}
/*Hack to keep fully visible the Datepicker*/
.ui-datepicker {
	z-index: 2000 !important;
}
</style>

</c:if>

<c:if test="${not empty maps}">
	<script type="text/javascript"
		src="<c:url value="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.16/jquery-ui.js" />"> </script>
	<link
		href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.16/themes/flick/jquery-ui.css"
		type="text/css" rel="Stylesheet" />
	<script type="text/javascript"
		src="<c:url value="/js/jquery-ui-timepicker-addon.js"/>"></script>

	<script type="text/javascript" src="/js/ol/OpenLayers.js"></script>
	<script type="text/javascript"
		src="<c:url value="/js/avior-rastreo.js" />"></script>
</c:if>

<c:if test="${not empty fenceDialogs }">
	<script type="text/javascript">
    	var iniLong = ${longitud};
    	var iniLat  = ${latitud};
    	var clientId = ${clientId};
    </script>
	<script type="text/javascript" src="/js/avior-cercas.js"></script>
</c:if>

<c:if test="${not empty reportDialogs }">
	<script type="text/javascript"
		src="<c:url value="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.16/jquery-ui.js" />"> </script>
	<link
		href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.16/themes/flick/jquery-ui.css"
		type="text/css" rel="Stylesheet" />
	<script type="text/javascript"
		src="<c:url value="/js/jquery-ui-timepicker-addon.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/js/avior-reportes.js" />"></script>
</c:if>
<c:if test="${not empty chgPassword }">
	<script type="text/javascript"
		src="<c:url value="/js/avior-password.js" />"></script>
</c:if>

<script type="text/javascript">
	    function toast(sMessage){
  	    	var container = $(document.createElement("div"));
  	    	container.addClass("toast");
  	    	var message = $(document.createElement("div"));
  	    	message.addClass("message");
  	    	message.text(sMessage);
  	    	message.appendTo(container);
  	    	container.appendTo(document.body);
  	    	container.delay(100).fadeIn("slow", function(){
  	    		$(this).delay(2000).fadeOut("slow", function(){
  	    			$(this).remove();
  	    		});
  	    	});
  	    }

  	</script>
</head>









<body class="no-js"
	<c:if test="${not empty maps }">onload="mapinit();"</c:if>>

	<script>
      var el = document.getElementsByTagName("body")[0];
      el.className = "";
    </script>

	<%-- En reportes cambia a la clase container-reportes --%>
	<div class="content">
		<noscript>Necesita habilitar el uso de JavaScript en el
			navegador para poder usar las funciones de la p&aacute;gina.</noscript>

		<tiles:insertAttribute name="menu" />

		<table width="100%" height="592" border="0" cellpadding="0"
			cellspacing="0">
			<tr>
				<tiles:insertAttribute name="content" />
			</tr>
			<tr>
				<tiles:insertAttribute name="footer" />
			</tr>
		</table>
	</div>

	<script>
      (function($){
        
        //cache nav
        var nav = $("#topNav");
        
        //add indicator and hovers to submenu parents
        nav.find("li").each(function() {
          if ($(this).find("ul").length > 0) {
            $("<span>").text("^").appendTo($(this).children(":first"));

            //show subnav on hover
            $(this).mouseenter(function() {
              $(this).find("ul").stop(true, true).slideDown();
            });
            
            //hide submenus on exit
            $(this).mouseleave(function() {
              $(this).find("ul").stop(true, true).slideUp();
            });
          }
        });
      })(jQuery);
    </script>
</html>