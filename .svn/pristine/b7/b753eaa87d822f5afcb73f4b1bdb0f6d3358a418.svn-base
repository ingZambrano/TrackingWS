//Variables para los visos de alert y confirm
var aviso = 'Aviso';
var aceptar = 'Aceptar';
var cancelar = 'Cancelar';
var confirmacion = 'Confirmación';
var cerrar = 'Cerrar';

function alertAvior(message, title, buttonText) {

    buttonText = (buttonText == undefined) ? 'Ok' : buttonText;
    title = (title == undefined) ? 'The page says:' : title;

    var div = $('<div>');
    div.html(message);
    div.attr('title', title);
    div.dialog({        
        modal: true,
        draggable: false,
        resizable: false,
        autoOpen: false,
        buttons: [{
            text: buttonText,
            click: function () {
                $(this).dialog("close");
                div.remove();
            }
        }]        
    });
    div.dialog("open");
}



function confirmAvior(message, title, yesCallback, noCallback) {	
	
	var div = $('<div>');
    div.html(message);
    div.attr('title', title);
    div.dialog({
        autoOpen: true,
        modal: true,
        draggable: false,
        resizable: false,
        buttons: [{
            text: 'SI',
            click: function () {
                $(this).dialog("close");
                div.remove();
                yesCallback();
            }            
        },
        {
            text: 'NO',
            click: function () {
                $(this).dialog("close");
                div.remove();
                noCallback();
            }            
        }
        ]
    });
	
}

