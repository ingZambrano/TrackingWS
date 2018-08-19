$(function() {
	
	changeControls(0);
	var cancel = function() {
		$("#nameDialog").dialog("close");
	};
	var getResponse = function() {
		var answer = $("#fenceName").val();
		$("#nameDialog").dialog("close");
		$.getJSON("/cercas/save", {
			id : "0",
			area : "" + lastArea,
			poly : lastFeature,
			name : answer,
			color : "00ff00"
		}, function onReceive(resp) {
			toast(resp.userMessage);
			enableSave(false);
			lastArea = -1;
		});
	};
	var dialogOpts = {
		modal : true,
		draggable: false,
        resizable: false,
        autoOpen : false,
		buttons : {
			"Aceptar" : getResponse,
			"Cancelar" : cancel
		}		
	};
	$("#nameDialog").dialog(dialogOpts);
	enableSave(false);

	$("#borrar").click(function() {

		vectorLayer.removeAllFeatures();
		polygonLayer.removeAllFeatures();

		enableSave(false);
		lastArea = -1;
	});

	$('#nueva').click(function() {
		poly.activate();

		$('#guardar').unbind();
		$('#guardar').click(function() {

			if (typeof lastArea != 'undefined' && lastArea != -1) {
				$('#nameDialog').dialog("open");
			}
		});
		vectorLayer.removeAllFeatures();
		polygonLayer.removeAllFeatures();
		poly.activate();
		modify.deactivate();
	});

	$('#asocCerca').click(function() {
		assocVehicle();
	});

	$('#deleteFence').click(function() {

		var cerca = $("#cercas-edit option:selected").attr("id");
		
		if(cerca != undefined){
			confirmAvior('¿Deseas eliminar la cerca seleccionada?', confirmacion,  function() {
				$.getJSON("/cercas/delete", {
				idCerca : cerca
				}, function onReceive(resp) {
					
					toast(resp.userMessage);
				});
				
				vectorLayer.removeAllFeatures();
				polygonLayer.removeAllFeatures();
				enableSave(false);
				lastArea = -1;
		    },
		    function() {	 
		    	
		    }
		    
		    );
			updateFences();
		}else{
			alertAvior('Selecciona una cerca para eliminar', aviso, aceptar);
		}
		
		
	});
});

var map, poly, lastFeature, lastArea, vectorLayer, polygonLayer, mapLayer;
var modify, idcerca, colorcerca, nombrecerca;

// 0 = nueva cerca, 1 = editar cerca, 2 = asociar vehiculos
var currentControls = 0;
var direction = 0; // 1 = izq, 2 =derecha

function enableSave(action) {
	if (action) {// Habilitar el boton
		$("#guardar").removeClass("boton-deshabilitado");
		$("#guardar").addClass("boton-habilitado");
		$("#borrar").removeClass("boton-deshabilitado");
		$("#borrar").addClass("boton-habilitado");
	} else {// Deshabilitar el boton
		$("#guardar").removeClass("boton-habilitado");
		$("#guardar").addClass("boton-deshabilitado");
		$("#borrar").removeClass("boton-habilitado");
		$("#borrar").addClass("boton-deshabilitado");
	}
}

function changeControls(direction) {
	
	updateFences();
	if (currentControls == 0 && direction == 1) { // Transicion de nuevaCerca
		// a EditarCerca		
		currentControls = 1;
		$('#nuevaCerca').css({
			'display' : 'block',
			'opacity' : '1'
		}).animate({
			'opacity' : '0',
			'left' : '5%'
		}, 1500);
		$('#nuevaCerca').hide();
		$('#editaCerca').css({
			'display' : 'block',
			'opacity' : '0'
		}).animate({
			'opacity' : '1',
			'right' : '5%'
		}, 1500);
	} else if (currentControls == 0 && direction == 2) {// Transicion de
		// nuevaCerca a Asociar
		
		currentControls = 2;
		$('#nuevaCerca').css({
			'display' : 'block',
			'opacity' : '1'
		}).animate({
			'opacity' : '0',
			'left' : '5%'
		}, 1500);
		$('#nuevaCerca').hide();
		$('#asociaCerca').css({
			'display' : 'block',
			'opacity' : '0'
		}).animate({
			'opacity' : '1',
			'right' : '5%'
		}, 1500);
	} else if (currentControls == 1 && direction == 1) {// Transicion de		
		// EditarCerca a Asociar
		
		currentControls = 2;
		$('#editaCerca').css({
			'display' : 'block',
			'opacity' : '1'
		}).animate({
			'opacity' : '0',
			'left' : '5%'
		}, 1500);
		$('#editaCerca').hide();
		$('#asociaCerca').css({
			'display' : 'block',
			'opacity' : '0'
		}).animate({
			'opacity' : '1',
			'right' : '5%'
		}, 1500);
	} else if (currentControls == 1 && direction == 2) {// Transicion de
		// EditarCerca a
		// nuevaCerca
		currentControls = 0;
		$('#editaCerca').css({
			'display' : 'block',
			'opacity' : '1'
		}).animate({
			'opacity' : '0',
			'left' : '5%'
		}, 1500);
		$('#editaCerca').hide();
		$('#nuevaCerca').css({
			'display' : 'block',
			'opacity' : '0'
		}).animate({
			'opacity' : '1',
			'right' : '5%'
		}, 1500);
	} else if (currentControls == 2 && direction == 1) {// Transicion de asocia
		// a nuevaCerca
		currentControls = 0;
		$('#asociaCerca').css({
			'display' : 'block',
			'opacity' : '1'
		}).animate({
			'opacity' : '0',
			'left' : '5%'
		}, 1500);
		$('#asociaCerca').hide();
		$('#nuevaCerca').css({
			'display' : 'block',
			'opacity' : '0'
		}).animate({
			'opacity' : '1',
			'right' : '5%'
		}, 1500);
		
	} else if (currentControls == 2 && direction == 2) {// Transicion de asocia
		// a EditarCerca
		
		currentControls = 1;
		$('#asociaCerca').css({
			'display' : 'block',
			'opacity' : '1'
		}).animate({
			'opacity' : '0',
			'left' : '5%'
		}, 1500);
		$('#asociaCerca').hide();
		$('#editaCerca').css({
			'display' : 'block',
			'opacity' : '0'
		}).animate({
			'opacity' : '1',
			'right' : '5%'
		}, 1500);
	} else if (currentControls == 0 && direction == 0) {// Estado inicial, solo
		// hay que mostrar el
		// default
		$('#nuevaCerca').css({
			'display' : 'block',
			'opacity' : '1'
		});
	}

}

// Se llama cuando se termina de definir un poligono
function featureAddedToMap() {
	var p4326 = poly.handler.polygon.geometry.transform(
			new OpenLayers.Projection("EPSG:900913"),
			new OpenLayers.Projection("EPSG:4326"));
	lastFeature = "" + p4326;
	lastArea = poly.handler.polygon.geometry.getGeodesicArea();
	enableSave(true);

	// Al momento de dar click en guardar abre el dialogo, y espera por el click
	// en guardar(getResponse) o cerrar(cancel)
}

function mapinit() {
	map = new OpenLayers.Map({
		div : "map",
		displayProjection : new OpenLayers.Projection("EPSG:4326"),
		numZoomLevels : 19
	});

	mapLayer = new OpenLayers.Layer.OSM();
	polygonLayer = new OpenLayers.Layer.Vector("Polygon Layer");
	vectorLayer = new OpenLayers.Layer.Vector("Vector Layer");

	map.addLayers([ mapLayer, polygonLayer, vectorLayer ]);
	map.addControl(new OpenLayers.Control.MousePosition());
	poly = new OpenLayers.Control.DrawFeature(polygonLayer,
			OpenLayers.Handler.Polygon);
	map.addControl(poly);
	poly.featureAdded = featureAddedToMap;
	modify = new OpenLayers.Control.ModifyFeature(vectorLayer);
	map.addControl(modify);
	modify.deactivate();

	map.setCenter(new OpenLayers.LonLat(iniLong, iniLat) // Center of the map
	.transform(new OpenLayers.Projection("EPSG:4326"), // transform from WGS
	// 1984
	new OpenLayers.Projection("EPSG:900913") // to Spherical Mercator
	// Projection
	), 15);

	poly.deactivate(); // Crear nueva cerca de default
}

function saveEditedFence() {

	poligono = "" + modify.feature.geometry;

	$.getJSON("/cercas/save", {
		id : idcerca,
		area : "" + modify.feature.geometry.getArea(),
		poly : "" + modify.feature.geometry,
		name : nombrecerca,
		color : colorcerca
	}, function onReceive(id) {
		toast(id);
	});
}
// Dibuja la cerca pol en el mapa
function drawFence(pol) {
	site_style = {
		'strokeWidth' : 2,
		'strokeColor' : "#" + padString(pol.color.toString(16), 6, '0'), // '#0000bb'
		'strokeOpacity' : 0.5,
		'fillColor' : "#" + padString(pol.color.toString(16), 6, '0'), // '#000088'
		'fillOpacity' : 0.4
	};

	idcerca = pol.id;
	nombrecerca = pol.name;
	colorcerca = pol.color;

	vectorLayer.removeAllFeatures();
	polygonLayer.removeAllFeatures();
	var linearRing = new OpenLayers.Geometry.LinearRing(
			strToPointArr(pol.polygon));
	polygonFeature = new OpenLayers.Feature.Vector(
			new OpenLayers.Geometry.Polygon([ linearRing ]), null, site_style);
	vectorLayer.addFeatures([ polygonFeature ]);
	map.zoomToExtent(vectorLayer.getDataExtent());
	poly.deactivate();
	modify.activate();
	modify.mode = OpenLayers.Control.ModifyFeature.RESHAPE;
	modify.createVertices = true;
}

// Agrega el caracter padchar a la cadena string hasta que mida length
function padString(string, length, padchar) {
	var ret = "" + string;
	while (ret.length < length) {
		ret = padchar + ret;
	}
	return ret;
}

function strToPointArr(string) {
	var puntos = [];
	string = string.replace("POLYGON((", "");
	string = string.replace("))", "");
	var fragmentos = string.split(",");
	for (var s = 0; s < fragmentos.length; s++) {
		var aux = fragmentos[s].split(" ");
		var point = new OpenLayers.Geometry.Point(aux[0], aux[1]);
		puntos.push(point.transform(new OpenLayers.Projection("EPSG:4326"), map
				.getProjectionObject()));
	}
	return puntos;
}

function updateFences() {
	
	$.getJSON("/cercas/" + clientId + "/readall", {}, function onReceive(pol) { // pol es un arreglo de cercas

		$("#cercas-assoc").find('option').remove();
		$("#cercas-edit").find('option').remove();
		$('#cercas-assoc').append('<option>---------</option>');
		$('#cercas-edit').append('<option>---------</option>');
		for (var i = 0; i < pol.length; i++) {
			$('#cercas-assoc').append(
					'<option id="' + pol[i].id + '">' + pol[i].name
							+ '</option>');
			
			$('#cercas-edit').append(
					'<option id="' + pol[i].id + '">' + pol[i].name
							+ '</option>');
		}
	});
}

function updateControls(fence) {
	var marcar = false;
	$.getJSON("/ajax/getDevices", function onReceive(devices) {
		for (var j = 0; j < devices.length; j++) {

			for (var i = 0; i < fence.devices.length; i++) {

				if (fence.devices[i] == devices[j].nroSerie) {
					marcar = true;
				}
			}
			if (marcar) {
				$('input[id=' + devices[j].nroSerie + ']')
						.attr('checked', true);
			} else {
				$('input[id=' + devices[j].nroSerie + ']').attr('checked',
						false);
			}
			marcar = false;
		}

	});

}

function getFence(combo) {
	
	if (combo.selectedIndex == 0)
		return;
//	$("#guardar").unbind();
//	$("#guardar").click(saveEditedFence);

	idcerca = $('#cercas-assoc option:selected').attr('id');

	// Obtener todas las cercas y dibujar la seleccionada
	$.getJSON("/cercas/" + clientId + "/readall", {
		idcerca : idcerca
	}, function onReceive(pol) { // pol es un arreglo de cercas
		for (var i = 0; i < pol.length; i++) {
			if (pol[i].id == combo.options[combo.selectedIndex].id) {

				drawFence(pol[i]);
				updateControls(pol[i]);
			}
		}
	});
}

function assocVehicle() {

	var cerca = $("#cercas-assoc option:selected").attr("id");

	if (cerca == null) {
		alertAvior('Selecciona una cerca', aviso, aceptar);
	} else {
		
		var regDesasociados = 0;
		var regAsociados = 0;
		var msjAsociados = null;
		var msjDesAsociados = null;

		$.getJSON("/ajax/getDevices", function onReceive(devices) {

			var noSerie = new Array();
			var noSerieDesasociar = new Array();
			var aux;
			for (var i = 0; i < devices.length; i++) {
				aux = devices[i].nroSerie;
				if ($('#' + aux).attr('checked')) {
					noSerie[noSerie.length] = aux;
				} else if ($('#' + aux).attr('checked') == null) {
					noSerieDesasociar[noSerieDesasociar.length] = aux;
				}
			}

			var vehiculosAsociar = JSON.stringify(noSerie);
			var vehiculosDesasociar = JSON.stringify(noSerieDesasociar);
			
			if (noSerieDesasociar.length != 0) {
				$.getJSON("/cercas/asociarCercas", {
					serialAsoc : vehiculosAsociar,
					serialDesAsoc : vehiculosDesasociar,
					idCerca : cerca
				}, function onReceive(answer) {
					alertAvior(answer.userMessage,aviso, aceptar);
				});
			}
//
//			if (nroSerie.length != 0) {
//				$.getJSON("/cercas/assoc", {
//					serial : nroSerieJson,
//					idCerca : cerca
//				}, function onReceive(answer) {
//					if(answer.status == 0){
//						//El proceso fue correcto
//						regAsociados = answer.regAfectados;
//					}else{
//						msjAsociados = answer.userMessage;
//					}
//				});
//			}

		});
		
	}

}
