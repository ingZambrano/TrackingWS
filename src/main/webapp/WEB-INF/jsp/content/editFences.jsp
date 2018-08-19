<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<style>

#controles-cercas{
	overflow: hidden;
	height: 120px;
	float: left;
	width: 89%;
}
.cc-item{
	float:left;
	margin: 0;
	padding: 0 40px 0 40px;
    width: 90%;
	height: 100px;
	display: none;
}
.control-carrusel{
	cursor: pointer;	
	font-family: Arial, Helvetica, sans-serif; 
	color: #fff; 
	background: #22A9DD;
	font-size: 30px; 
	width: 5%; 
	height: 100px; 
	margin-left: 0px;
	margin-bottom: 0px;	
	text-shadow: 0 1px 1px rgba(0, 0, 0, 0.5);
	-webkit-border-radius: 3px;
	   -moz-border-radius: 3px;
	        border-radius: 3px;	
	-webkit-box-shadow: 0px 1px 6px 4px rgba(0, 0, 0, 0.07) inset,
	        0px 0px 0px 3px rgb(254, 254, 254),
	        0px 5px 3px 3px rgb(210, 210, 210);
	   -moz-box-shadow:0px 1px 6px 4px rgba(0, 0, 0, 0.07) inset,
	        0px 0px 0px 3px rgb(254, 254, 254),
	        0px 5px 3px 3px rgb(210, 210, 210);
	        box-shadow:0px 1px 6px 4px rgba(0, 0, 0, 0.07) inset,
	        0px 0px 0px 3px rgb(254, 254, 254),
	        0px 5px 3px 3px rgb(210, 210, 210);
	-webkit-transition: all 0.2s linear;
	   -moz-transition: all 0.2s linear;
	     -o-transition: all 0.2s linear;
	        transition: all 0.2s linear;
}
.botonCercas{
	width: 30%;
	cursor: pointer;	
	padding: 8px 5px;
	font-family: Arial, Helvetica, sans-serif;
	color: #fff;
	font-size: 12px;	
	border: 1px solid rgb(28, 108, 122);	
	margin-left: 0px;
	margin-bottom: 10px;	
	text-shadow: 0 1px 1px rgba(0, 0, 0, 0.5);
	-webkit-border-radius: 3px;
	   -moz-border-radius: 3px;
	        border-radius: 3px;	
	-webkit-box-shadow: 0px 1px 6px 4px rgba(0, 0, 0, 0.07) inset,
	        0px 0px 0px 3px rgb(254, 254, 254),
	        0px 5px 3px 3px rgb(210, 210, 210);
	   -moz-box-shadow:0px 1px 6px 4px rgba(0, 0, 0, 0.07) inset,
	        0px 0px 0px 3px rgb(254, 254, 254),
	        0px 5px 3px 3px rgb(210, 210, 210);
	        box-shadow:0px 1px 6px 4px rgba(0, 0, 0, 0.07) inset,
	        0px 0px 0px 3px rgb(254, 254, 254),
	        0px 5px 3px 3px rgb(210, 210, 210);
	-webkit-transition: all 0.2s linear;
	   -moz-transition: all 0.2s linear;
	     -o-transition: all 0.2s linear;
	        transition: all 0.2s linear;
}
.boton-deshabilitado{
	background: #CCCCCC;
}
.boton-habilitado{
	background: #22A9DD;
}

.boton-habilitado:hover{
	background:#0093bc;
}

.boton-deshabilitado:hover{
	background: #DDDDDD;
}

.boton-habilitado:active{
	background:#0093bc;
	position: relative;
	top: 1px;
	border: 1px solid #0093bc;	
	-webkit-box-shadow: 0px 1px 6px 4px rgba(0, 0, 0, 0.2) inset;
	   -moz-box-shadow: 0px 1px 6px 4px rgba(0, 0, 0, 0.2) inset;
	        box-shadow: 0px 1px 6px 4px rgba(0, 0, 0, 0.2) inset;
}

.boton-deshabilitado:active{
	background:#DDDDDD;
	position: relative;
	top: 1px;
	border: 1px solid #0093bc;	
	-webkit-box-shadow: 0px 1px 6px 4px rgba(0, 0, 0, 0.2) inset;
	   -moz-box-shadow: 0px 1px 6px 4px rgba(0, 0, 0, 0.2) inset;
	        box-shadow: 0px 1px 6px 4px rgba(0, 0, 0, 0.2) inset;
}


</style>




<div id="nameDialog" title="Nombre de cerca">
	<p>Proporcione un nombre para la cerca que reci&eacute;n cre&oacute;</p>
	<input type="text" id="fenceName">
</div>


<tr>
<th scope="row">
	<a id="control-left" class="control-carrusel"  onclick="changeControls(1);" style="float: left;"> <br> &lt;	</a>
	<div id="controles-cercas">	
		<div class="cc-item" id="nuevaCerca">
			<p>
				<input class="botonCercas boton-deshabilitado" id="borrar" type="submit" value="BORRAR" /> 
				<input class="botonCercas boton-habilitado" id="nueva" type="submit" value="NUEVA" /> 
				<input class="botonCercas boton-deshabilitado" id="guardar" type="submit" value="GUARDAR" />
				<br/>
			</p>			
		</div>		
		<div class="cc-item" id="asociaCerca">		
			<div style="float: left;">
			Asociar veh&iacute;culos a la cerca:
				<select id="cercas-assoc" onchange="getFence(this);">
				</select><br><br><br>			
				<input id="asocCerca" type="submit" value="Asociar/Desasociar" style="cursor:pointer;">
			</div>
			<div style="float:left;border: 1px solid gray;text-align: left; overflow: auto; width: 50%; height: 100px;">
				<c:forEach items="${devices }" var="auto" varStatus="cont">
				<input type="checkbox"
        		       id="${auto.nroSerie}"> 
        			<span style="text-align:left;"> 
        				${auto.alias }
        			</span> 
        			<br/>        					
    			</c:forEach>
			</div>
		</div>
		<div class="cc-item" id="editaCerca">
			Seleccione una cerca para eliminar
			<select id="cercas-edit" onchange="getFence(this);">
			</select><br><br><br>				
			<input id="deleteFence" type="submit" value="Eliminar" style="cursor:pointer;" onclick="">
		</div>	
	</div>	
	<a id="control-right" class="control-carrusel" onclick="changeControls(2);" style="float: right;"> <br> &gt;	</a>
</th>

</tr>
<tr>
	<td colspan="2">
		<div id="map" class="mapa">
		</div>
	</td>
</tr>