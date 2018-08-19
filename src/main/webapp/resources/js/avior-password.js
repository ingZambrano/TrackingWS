function validarForm() {

	var oldPass = $("#oldPass").val();
	var newPass = $("#newPass").val();
	var newPassConfirm = $("#newPassConfirm").val();

	if (oldPass == "" || oldPass == null) {
		alertAvior("Ingresa tu contrase\u00f1a", aviso, aceptar);
	} else if (newPass == "" || newPass == null) {
		alertAvior("Ingresa tu contrase\u00f1a nueva", aviso, aceptar);
	} else if (newPassConfirm == "" || newPassConfirm == null) {
		alertAvior("Confirma tu contrase\u00f1a", aviso, aceptar);
	} else if (newPass != newPassConfirm) {
		alertAvior("La nueva contrase\u00f1a no es igual a la confirmaci\u00f3n, verifica", aviso, aceptar);
	} else {
		// Llamamos el serivicio para cambiar el password
		$.getJSON(
			"/auth/changepwd",
				{
					oldPass : oldPass,
					newPass : newPass
				},
				function onReceive(answer) {
					if (answer.status == '0') {
						alertAvior("Contrase\u00f1a actualizada", aviso, aceptar);
					} else {
						alertAvior("Ocurri\u00f3 un error, no es posible cambiar tu contrase\u00f1a", aviso, aceptar);
//						alertAvior(answer.message);
					}

				});
	}

}
