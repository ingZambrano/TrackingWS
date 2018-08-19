<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<th scope="row">
	<div id="c-wrapper">
		<div class="c-item">
			<div class="i-vehiculo">
				<div class="t-vehiculo">
					<p>mis veh&iacute;culos</p>
					<div class="cont-vehiculos" id="vehiculos">

						<c:forEach items="${autos }" var="auto" varStatus="cont">
							<c:url var="urlIntervalo"
								value="/ajax/${auto.nroSerie}/byTimeInt" />
							<c:url var="urlLatest" value="/ajax/byLatest" />

							<%--onclick="setVehicle(this.id)" el id es el nroSerie --%>
							<input type="radio" id="${auto.nroSerie }" name="myradio"
								value="1">
							<span style="text-align: left;"> ${auto.alias } </span>
							<input type="checkbox" onchange="getLatest('${urlLatest }')"
								id="${auto.nroSerie}">
							<br />
							<br />

						</c:forEach>
					</div>
				</div>
			</div>
		</div>
		<div class="c-item">
			<div class="i-estacionamiento">
				<div class="t-vehiculo">
					<p>modo estaci&oacute;namiento/paseo</p>
					<div class="cont-vehiculos" id="vehiculos">

						<c:forEach items="${autos }" var="auto" varStatus="cont">

							<input type="button" id="${auto.nroSerie}Park" name="mybutton"								
								value="ACTIVO"
								style="cursor: pointer; width: 8em; color: #0093bc; font-weight: bold; text-align: center;"
								onclick="toggleButton('${auto.nroSerie}');">

							<br />
							<br />

						</c:forEach>
					</div>

				</div>
			</div>
		</div>
		<div class="c-item">
			<div class="i-mostrar">
				<div class="t-mostrar">
					<p>mostrar intervalo</p>
				</div>
				<form method="post" action="javascript:byTimeInterval()">
					<table id="tabla-intervalo">
						<tr>
							<td height="30" class="formulario">
								<p>
									<strong>INICIO&nbsp;&nbsp;&nbsp;&nbsp;</strong>
								</p>
							</td>
							<td><input type="text" class="input campo hasDatePicker"
								id="tii" size="16" /></td>
						</tr>
						<tr>
							<td height="30" class="formulario">
								<p>
									<strong>FIN&nbsp;&nbsp;&nbsp;&nbsp;</strong>
								</p>
							</td>
							<td><input type="text" class="input campo hasDatePicker"
								id="tif" size="16" /></td>
						</tr>
						<tr>
							<td width="20%" height="40">&nbsp;</td>
							<td>
								<p>
									<input name="enviar" type="submit" class="button-mostrar"
										value="">
								</p>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>

		<div class="c-item">
			<div class=" icono-ultimos">

				<p>
					<input class="botonUltimo" onclick="byQty(20)" type="submit"
						value="&Uacute;LTIMOS 20" /><br> <input class="botonUltimo"
						onclick="byQty(40)" type="submit" value="&Uacute;LTIMOS 40" /><br>
					<input class="botonUltimo" onclick="byQty(60)" type="submit"
						value="&Uacute;LTIMOS 60" />
				</p>

			</div>
		</div>
		<!--  
		<div class="c-item">
			<div class="i-actualizar">
				<div class="t-actualizar">
					<p>auto-aCtualizar</p>
						<form name=myform>
						<p>
							<input type="radio" name="autoupdate" value="1"> actualizar en 20 seg.
						</p>
						<p>
							<input type="radio" name="autoupdate" value="2"> actualizar en 40 seg.
						</p>
						<p>
							<input type="radio" name="autoupdate" value="3"> actualizar en 60 seg.
						</p>
					</form>
				</div>
				
			</div>
		</div>
		-->

	</div>



</th>


<tr>
	<td colspan="2">
		<div id="map" class="mapa"></div>
	</td>

</tr>

