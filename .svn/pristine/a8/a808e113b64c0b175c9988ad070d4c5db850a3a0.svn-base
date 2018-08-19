	function getReport(){  	
  		var iniFecha = $("#inicioReporte").val();
  		var finFecha = $("#finReporte").val();
  		var vehiculos = $("#dispReporte").val();
  		var reportType = $("#reportType").val();
  		//Validación de parametros  		
  		if(iniFecha == null || finFecha == null || vehiculos == null ||
  				reportType==null || extension==null){
  				toast("Llene todos los campos");
  			return;
  		}
  		if(iniFecha == "" || finFecha == "" || vehiculos == ""||
  				reportType=="" || extension==""){
  			toast("Llene todos los campos");
  			return;
  		}
  		var items = [];
  		for(var item in vehiculos){      			
  			
  			
  			
  			items.push($("#dispReporte option:contains('"+ vehiculos[item] +"')").attr("id"));
  		}      		     		
  		$("#formato").val(extension);
  		      		
  		$("#reportForm").attr("action", "/reportes" + "/" + reportType );
  		$("#id-coches").val(items);
  		$("#reportForm").submit();
	}
	
	$(document).ready(function() {
		//Inicializacion de datetimepickers
        $.datepicker.regional['es'] = {
                closeText: 'Cerrar',
                prevText: '<Ant.',
                nextText: 'Sig.>',
                currentText: 'Ahora',
                timeText: 'Tiempo',
                hourText: 'Hora',
                minuteText: 'Minuto',
                secondText: 'Segundo',
                monthNames: ['Enero','Febrero','Marzo','Abril','Mayo','Junio',
                'Julio','Agosto','Septiembre','Octubre','Noviembre','Diciembre'],
                monthNamesShort: ['Ene','Feb','Mar','Abr','May','Jun',
                'Jul','Ago','Sep','Oct','Nov','Dic'],
                dayNames: ['Domingo','Lunes','Martes','Miércoles','Jueves','Viernes','Sábado'],
                dayNamesShort: ['Dom','Lun','Mar','Mié','Jue','Vie','Sab'],
                dayNamesMin: ['D','L','Ma','Mi','J','V','S'],
                weekHeader: 'Sem',
                dateFormat: 'dd-mm-yy',
                firstDay: 1,
                isRTL: false,
                showMonthAfterYear: false,
                yearSuffix: ''
            };
    
        $.datepicker.setDefaults($.datepicker.regional['es']);
        $(".hasDatePicker").datetimepicker({
        	dateFormat: "yy-mm-dd",
            timeFormat: "HH:mm:ss",
            timeText: 'Tiempo',
            hourText: 'Hora',
            minuteText: 'Minuto',
            secondText: 'Segundo',
            currentText: 'Actual',
            monthNames: ['Enero','Febrero','Marzo','Abril','Mayo','Junio',
                         'Julio','Agosto','Septiembre','Octubre','Noviembre','Diciembre'],
            monthNamesShort: ['Ene','Feb','Mar','Abr','May','Jun',
                         'Jul','Ago','Sep','Oct','Nov','Dic'],
            dayNames: ['Domingo','Lunes','Martes','Miércoles','Jueves','Viernes','Sábado'],
            dayNamesShort: ['Dom','Lun','Mar','Mié','Jue','Vie','Sab'],
            dayNamesMin: ['D','L','Ma','Mi','J','V','S'],
            weekHeader: 'Sem',
            closeText: 'Cerrar'
        });       
    	     	
	});	
		
