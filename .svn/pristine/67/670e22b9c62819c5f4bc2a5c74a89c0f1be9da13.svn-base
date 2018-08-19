<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
<!--
	.popup-calendar{
		z-index: 100;
	}
-->
</style>

<script type="text/javascript">

	var reportType = "";
	var extension = "";
	
	
	function selectFormat(format){		
		$(".filetype").each(function(index){
			if($(this).attr("id") == "span" + format){
				$(this).css("background", "#00A0DD");				
			}else{
				$(this).css("background", "transparent");
			}
				
		});
		extension = format.toLowerCase();
		getReport();
	}

</script>


<form id="reportForm"method="POST" action="javascript:byTimeInterval()">
<div>
<tr>
<th width="40%" scope="row">
	<div id="contenido">
	
		<p class = "formulario"> Seleccione el tipo de reporte</p>
		<select name = "tipoReporte" id = "reportType">
			<option>General</option>
			<option>Detallado</option>
		</select> 
		<!--  
		<input type = "button" value="GENERAL"/><br><br>
		<input type = "button" value="DETALLADO"/>
		-->
	</div>
</th>
<th width="60%" scope="row">
<div id="reportDialog">
	<!--<form id="reportForm"method="POST" action="javascript:byTimeInterval()"> -->
	
		<input type = "hidden" name = "ids" id="id-coches">		
		<p class= "formulario">Proporcione los par&aacute;metros necesarios:</p>
		<label class= "formulario" for="inicioReporte">Fecha inicio:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>		
			<input type="text" size="25" name="inicioReporte" readonly="readonly" class="input campo hasDatePicker" id="inicioReporte"/>
		<br><br>		
		<label class= "formulario" for="finReporte">Fecha fin:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
		    <input type="text" name="finReporte" size="27" readonly="readonly" class="input campo hasDatePicker" id="finReporte"/><br/>
		
		<br><br>
			
		<label class= "formulario" for="dispReporte">Seleccione los dispositivos a reportar:</label><br/>
		<br><br>
		<select name="dispReporte" style="width: 268px;" size="3" id="dispReporte" multiple="multiple">		
		<c:if test="${not empty vehiculos }">
			<c:forEach items="${vehiculos }" var="vehiculo" >
				<option id="${vehiculo.nroSerie }">${vehiculo.alias }</option>				
			</c:forEach>
		</c:if>
		
		</select>
		<input type="hidden" name="formato" id="formato" value=""/>
		<input type="hidden" name="elementos" id="elementos" value=""/>
		 
		<p class= "formulario">Escoja el formato de salida:</p>
		<%--El evento click de estos links, debe ir hacia la funcion javascript que armará el url (action) y hará el submit del form --%>
		<span id="spanPDF" class="filetype" style="background: transparent;"><img id="PDF" onclick="selectFormat(this.id);" src="<c:url value="/image/pdf.png"/>" alt="PDF" width="64" height="64"/></span>
		<span id="spanXLS" class="filetype" style="background: transparent;"><img id="XLS" onclick="selectFormat(this.id);" src="<c:url value="/image/xls.png"/>" alt="Microsoft Excel" width="64" height="64"/></span>
		<!--  <span id="spanHTML" class="filetype" style="background: transparent;"><img id="HTML" onclick="selectFormat(this.id);" src="<c:url value="/image/html.png"/>" alt="P&aacute;gina web" width="64" height="64"/></span> -->
	
</div>
</th>
</tr>
</div>
</form>






	