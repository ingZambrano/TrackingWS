var currentCar = '';
$(document).ready(
		function() {

			// Validar si el modo estacionamiento esta activo
			var url = "/ajax/getDevices";
			var params = "";
			$.getJSON(url, params, function onReceive(devices) { // arreglo de dispositivos

				for (var i = 0; i < devices.length; i++) {
					
					if (devices[i].estacionamiento) {
						$('#' + devices[i].nroSerie + 'Park').attr('value',
								'ACTIVO');
					} else {
						$('#' + devices[i].nroSerie + 'Park').addClass(
								'desactivo-button');
						$('#' + devices[i].nroSerie + 'Park').attr('value',
								'DESACTIVO');
					}

				}

			});

			$(".i-mostrar").hide();
			$(".icono-ultimos").hide();
			$(".i-actualizar").hide();
			$("input[name='autoupdate']").prop("checked", false);

			// Inicializacion de datetimepickers
			$(".hasDatePicker")
					.datetimepicker(
							{
								dateFormat : "yy-mm-dd",
								timeFormat : "HH:mm:ss",
								timeText : 'Tiempo',
								hourText : 'Hora',
								minuteText : 'Minuto',
								secondText : 'Segundo',
								currentText : 'Actual',
								monthNames : [ 'Enero', 'Febrero', 'Marzo',
										'Abril', 'Mayo', 'Junio', 'Julio',
										'Agosto', 'Septiembre', 'Octubre',
										'Noviembre', 'Diciembre' ],
								monthNamesShort : [ 'Ene', 'Feb', 'Mar', 'Abr',
										'May', 'Jun', 'Jul', 'Ago', 'Sep',
										'Oct', 'Nov', 'Dic' ],
								dayNames : [ 'Domingo', 'Lunes', 'Martes',
										'Miercoles', 'Jueves', 'Viernes',
										'Sabado' ],
								dayNamesShort : [ 'Dom', 'Lun', 'Mar', 'Mi\u00e9',
										'Jue', 'Vie', 'Sab' ],
								dayNamesMin : [ 'D', 'L', 'Ma', 'Mi', 'J', 'V',
										'S' ],
								weekHeader : 'Sem',
								closeText : 'Cerrar'
							});

			// Inicializacion de los eventos para los radio button de los coches
			$('#vehiculos input:radio').change(function() {
				carId = $(this).attr('id');
				$('.i-mostrar').fadeOut(200);
				$('.icono-ultimos').fadeOut(200);
				$('.i-actualizar').fadeOut(200);
				$('.i-mostrar').fadeIn();
				$('.icono-ultimos').fadeIn();
				$('.i-actualizar').fadeIn();
			});

			// Evento change de los botones de autoactualizacion
			$('.i-actualizar input:radio')
					.change(
							function() {
								var selectedVal = $(
										'.i-actualizar input:radio:checked')
										.attr('value');
								setAutoUpdate(20 * selectedVal);
							});

		});

var strTiempoRec;
var map;
var mapLayer, markers;
AutoSizeAnchored = OpenLayers.Class(OpenLayers.Popup.Anchored, {
	'autoSize' : true
});
var carId = 0;

function mapinit() {
	map = new OpenLayers.Map("map");
	// var mapLayer = new OpenLayers.Layer.OSM("MapLayer",
	// "http://otile1.mqcdn.com/tiles/1.0.0/osm/\${z}/\${x}/\${y}.png",
	// {numZoomLevels: 19});
	var mapLayer = new OpenLayers.Layer.OSM();
	map.addLayer(mapLayer);
	map.setCenter(new OpenLayers.LonLat(iniLong, iniLat).transform(
			new OpenLayers.Projection("EPSG:4326"), new OpenLayers.Projection(
					"EPSG:900913")), 15);

	markers = new OpenLayers.Layer.Markers("Marcadores");
	map.addLayer(markers);
}

function distance(Coordinates) {
	var points = [];
	var distTotal = 0;
	for (var Point = 0; Point < Coordinates.length; Point++) {
		var p = new OpenLayers.Geometry.Point(Coordinates[Point].lon,
				Coordinates[Point].lat);
		points.push(p);
	}

	if (points.length >= 1) {
		var line = new OpenLayers.Geometry.Curve(points);
		distTotal = line.getGeodesicLength(new OpenLayers.Projection(
				"EPSG:900913"));
		if (distTotal > 1000)
			distTotal = (distTotal / 1000) + " Km";
		else
			distTotal = distTotal + " m";
		var text = "<div class='datos'> La distancia del recorrido es de <br/> "
				+ distTotal + "</div>";
		text += "<div class='datos'> Tiempo del recorrido <br/> "
				+ strTiempoRec + "</div>";
		$("#dists").html(text);
		$("#dists").slideDown(250);
	}
}

function update(CoordVector) {
	var points = [];
	drawPath(CoordVector);
	for (var item = 0; item < CoordVector.length; item++) {
		point = new OpenLayers.LonLat(CoordVector[item].longitud,
				CoordVector[item].latitud);
		point.transform(new OpenLayers.Projection("EPSG:4326"),
				new OpenLayers.Projection("EPSG:900913"));
		var utcDate = new Date(CoordVector[item].ultimaFecha);
		// var theDate = convertFromUTC(utcDate);
		// var theDate = new Date(Date.UTC(CoordVector[item].fecha));
		var theVel = CoordVector[item].velocidad;
		var innerhtml = "<div style='padding: 6px 6px 6px 6px; background-color: #999999;'>Fecha:"
				+ utcDate + "<br/>" + "Vel.: " + theVel + " km/h </div>";
		addMarker(point, innerhtml);
		points.push(point);
	}
	map.raiseLayer(markers, 1);
	map.zoomToExtent(markers.getDataExtent());
	if (CoordVector.length > 0) {
		var dif = Math.abs(CoordVector[CoordVector.length - 1].fecha
				- CoordVector[0].fecha);
		var dDif = Math.floor(dif / 1000 / 60 / 60 / 24);// Dias
		dif -= dDif * 1000 * 60 * 60 * 24;
		var hDif = Math.floor(dif / 1000 / 60 / 60);// Horas
		dif -= hDif * 1000 * 60 * 60;
		var mDif = Math.floor(dif / 1000 / 60);// Minutos
		dif -= mDif * 1000 * 60;
		var sDif = Math.floor(dif / 1000);

		strTiempoRec = "";
		if (dDif > 0)
			strTiempoRec += dDif + " d�a(s) ";
		if (hDif > 0)
			strTiempoRec += hDif + " hora(s) ";
		if (mDif > 0)
			strTiempoRec += mDif + " min. ";
		if (sDif > 0)
			strTiempoRec += sDif + " seg.";
	}
	distance(points);
}

function addMarker(ll, popupHTML) {
	var feature = new OpenLayers.Feature(markers, ll);
	feature.closeBox = false;
	feature.popupClass = AutoSizeAnchored;
	feature.data.popupContentHTML = popupHTML;
	feature.data.overflow = "hidden";

	var marker = feature.createMarker();
	var markerOver = function(evt) {
		if (this.popup == null) {
			this.popup = this.createPopup(this.closeBox);
			this.popup.setBackgroundColor("rgba(0,0,0,0)");
			map.addPopup(this.popup);
		}
		this.popup.show();
		OpenLayers.Event.stop(evt);
	};
	var markerOut = function(evt) {
		if (this.popup != null) {
			this.popup.hide();
		}
	};
	marker.events.register("mouseover", feature, markerOver);
	marker.events.register("mouseout", feature, markerOut);
	markers.addMarker(marker);
}

var lineLayer;
function drawPath(coords) {
	var points = [];
	var line;
	lineLayer = new OpenLayers.Layer.Vector("Line Vector");
	for (var item = 0; item < coords.length; item++) {
		point = new OpenLayers.LonLat(coords[item].longitud,
				coords[item].latitud);
		point.transform(new OpenLayers.Projection("EPSG:4326"),
				new OpenLayers.Projection("EPSG:900913"));
		points.push(new OpenLayers.Geometry.Point(point.lon, point.lat));
	}
	line = new OpenLayers.Geometry.LineString(points);
	var style = {
		strokeColor : "#0000ff",
		strokeOpacity : 0.5,
		strokeWidth : 5
	};
	lineFeature = new OpenLayers.Feature.Vector(line, null, style);
	lineLayer.addFeatures([ lineFeature ]);
	map.addLayer(lineLayer);
	map.addControl(new OpenLayers.Control.DrawFeature(lineLayer,
			OpenLayers.Handler.Path));
}
function clearMap() {
	if (lineLayer != null) {
		lineLayer.removeAllFeatures();
	}
	markers.clearMarkers();
}

function getLatest(urlLatest) {
	var idList = "";

	$("#vehiculos input:checkbox").each(function(index, domEl) {

		if (this.checked)
			idList += $(domEl).attr('id') + ",";
	});
	idList = idList.substring(0, idList.length - 1);
	params = {
		ids : idList
	};

	$
			.getJSON(
					urlLatest,
					params,
					function onRx(coords) {

						clearMap();

						for (var item = 0; item < coords.length; item++) {
							if (coords[item] == null)
								continue;
							point = new OpenLayers.LonLat(
									coords[item].longitud, coords[item].latitud);
							point.transform(new OpenLayers.Projection(
									"EPSG:4326"), new OpenLayers.Projection(
									"EPSG:900913"));

							var utcDate = new Date(coords[item].ultimaFecha);
							// var theDate = convertFromUTC(utcDate);
							var theVel = coords[item].velocidad;
							var alias = coords[item].alias;
							var innerhtml = "<div style='padding: 6px 6px 6px 6px;' class='box_gradient box_round shadow alpha60'>"
									+
									// caralias[item]+"<br/>Fecha:"+
									// utcDate+"<br/>"+"Vel.: " + theVel + "
									// km/h </div>";
									alias
									+ "<br/>Fecha:"
									+ utcDate
									+ "<br/>"
									+ "Vel.: " + theVel + " km/h </div>";
							addMarker(point, innerhtml);

						}
						map.raiseLayer(markers, 1);
						map.zoomToExtent(markers.getDataExtent());
					});
}

function byTimeInterval() {
	$("#dists").slideUp(250);
	var startTime = $('input#tii').datetimepicker('getDate');
	var endTime = $('input#tif').datetimepicker('getDate');

	// var params={
	// iniTime: convertDateToUTC(startTime).format('yyyy-MM-dd hh:mm:ss'),
	// finTime: convertDateToUTC(endTime).format('yyyy-MM-dd hh:mm:ss')};
	var params = {
		iniTime : new Date(startTime).format('yyyy-MM-dd hh:mm:ss'),
		finTime : new Date(endTime).format('yyyy-MM-dd hh:mm:ss')
	};
	var url = "/ajax/" + carId + "/byTimeInt";
	if (carId != 0)
		$.getJSON(url, params, function onReceive(coords) {
			clearMap();
			if (coords.length == 0) {
				alertAvior("No hay registros en este lapso de tiempo", aviso, aceptar);
				return;
			}
			update(coords);
		});
	else
		alertAvior("No se seleccion\u00f3 veh\u00edculo", aviso, aceptar);
}

function byQty(qty) {
	$("#dists").slideUp(250);
	var url = "/ajax/" + carId + "/byQty";
	var params = {
		qty : qty
	};
	if (carId != 0)
		$.getJSON(url, params, function onReceive(coords) {
			clearMap();
			if (coords.length == 0) {
				alertAvior("No se han encontrado registros", aviso, aceptar);
				return;
			}
			update(coords);
		});
	else
		alertAvior("No se seleccion\u00f3 veh\u00edculo", aviso, aceptar);
}

var toID;
function setAutoUpdate(timeInterval) {
	if (toID != null)
		clearInterval(toID);

	if (carId != 0)
		toID = setInterval("autoUpdate();", timeInterval * 1000);
	else
		alertAvior("No se seleccion\u00f3 veh\u00edculo", aviso, aceptar);

}

function convertDateToUTC(date) {
	return new Date(date.getUTCFullYear(), date.getUTCMonth(), date
			.getUTCDate(), date.getUTCHours(), date.getUTCMinutes(), date
			.getUTCSeconds());
}
function convertFromUTC(date) {
	return new Date(Date.UTC(date.getFullYear(), date.getMonth(), date
			.getDate(), date.getHours(), date.getMinutes(), date.getSeconds()));
}

var lastUpdate = convertDateToUTC(new Date());
function autoUpdate() {
	// $("#dists").slideUp(250);
	var mesI = lastUpdate.getMonth() + 1;
	if (mesI < 10)
		mesI = "0" + mesI;
	var stIni = lastUpdate.getFullYear() + "-" + mesI + "-"
			+ lastUpdate.getDate() + " " + lastUpdate.getHours() + ":"
			+ lastUpdate.getMinutes() + ":" + lastUpdate.getSeconds();
	var now = convertDateToUTC(new Date());
	var mesF = now.getMonth() + 1;
	if (mesF < 10)
		mesF = "0" + mesF;
	var stFin = now.getFullYear() + "-" + mesF + "-" + now.getDate() + " "
			+ now.getHours() + ":" + now.getMinutes() + ":" + now.getSeconds();
	var params = {
		iniTime : stIni,
		finTime : stFin
	};
	var url = "/ajax/" + carId + "/byTimeInt";
	$.getJSON(url, params, function onUpdate(newcoords) {

		if (newcoords.length == 0)			
			return;
		else
			update(newcoords);
	});
	lastUpdate = convertDateToUTC(new Date());
}

function toggleButton(serieDispo) {

	var clase = $('#' + serieDispo + 'Park').attr('class');
	if (clase == 'desactivo-button') {

		
		// Llamada JSON para activar modo estacionamiento
		var url = "/ajax/" + serieDispo + "/setParking";
		var params = "";
		$.getJSON(url, params, function onUpdate(resp) {
			if (resp) {
				$('#' + serieDispo + 'Park').removeClass('desactivo-button');
				$('#' + serieDispo + 'Park').attr('value', 'ACTIVO');
				alertAvior('Modo estacionamiento Activo', aviso, cerrar);
			} else {
				$('#' + serieDispo + 'Park').addClass('desactivo-button');
				$('#' + serieDispo + 'Park').attr('value', 'DESACTIVO');
				alertAvior('No fu\u00e9 posible activar el modo estacionamiento', aviso, cerrar);
			}
		});

	} else {

		// Llamada JSON para desactivar modo estacionamiento
		var url = "/ajax/" + serieDispo + "/downParking";
		var params = "";
		$.getJSON(url, params, function onUpdate(resp) {
			if (resp) {

				$('#' + serieDispo + 'Park').addClass('desactivo-button');
				$('#' + serieDispo + 'Park').attr('value', 'DESACTIVO');
				alertAvior('Modo estacionamiento desactivado',aviso, cerrar);
			} else {
				$('#' + serieDispo + 'Park').removeClass('desactivo-button');
				$('#' + serieDispo + 'Park').attr('value', 'ACTIVO');
				alertAvior('No fu\u00e9 posible desactivar el modo estacionamiento', aviso, cerrar);
			}
		});
	}
}