package com.avior.controller;

import java.math.BigInteger;
import java.security.Principal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.avior.model.routine.RSchipDispositivo;
import com.avior.model.tav.Tavcatdispositivo;
import com.avior.model.tav.Tavusuario;
import com.avior.model.view.DispXUsuarioView;
import com.avior.model.view.RegistroView;
import com.avior.services.ManageDispositivos;
import com.avior.services.ManageUsers;
import com.avior.services.SMSService;

@Controller
@RequestMapping("/ajax")
public class AjaxController {

	private ManageDispositivos deviceService;
	private ManageUsers userService;
	private SMSService smsService;
	private final String text = "t022s003n028467";
	private final String textCorteEnergia = "Powercar123456 1";
	private final String textReinicioEnergia = "Powercar123456 0";
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	public void setUserService(ManageUsers userSvc) {
		this.userService = userSvc;
	}

	@Autowired
	public void setDeviceService(ManageDispositivos deviceService) {
		this.deviceService = deviceService;
	}

	@Autowired
	public void setSmsService(SMSService smsService) {
		this.smsService = smsService;
	}
	
	/**
	 * Se recibe la petici�n para enviar un SMS que va a despertar al
	 * dispositivo
	 * 
	 * �sto solo aplica para personas y mascotas
	 * @param ids
	 * 			Ids numero serial del dispositivo
	 * @param principal
	 *            Objeto de SpringSecurity conteniendo las credenciales de la
	 *            sesi�n
	 * @return Retorna 0 si el mensaje se envi� correctamente, diferente si fall�
	 */
	@RequestMapping(value = "/paroEmergencia", method = RequestMethod.GET)
	public @ResponseBody
	Integer paroEmergencia(String ids, int onOff, Principal principal) {
		//1 --> ON --> Se apaga el auto
		//0 --> OFF --> Se reinicia el auto
		
		// _____________Validaciones
		logger.debug("ID's: " + ids);
		logger.debug("[Controller] Peticion por cantidad");
		if (principal == null)
			return -1; // Usuario no identificado
		logger.debug("Principal not null... OK");
		if (ids == null || ids.length() == 0)
			return -1; // No hay variables
		logger.debug("Params not null... OK");

		Tavusuario loggedUser = this.userService
				.getUsuario(principal.getName());
		List<DispXUsuarioView> dispDeCliente = this.deviceService
				.getDispositivosXUsuario(loggedUser.getFiIdUsuario());
		boolean esDispUsr = false;
		for (DispXUsuarioView disp : dispDeCliente) {
			if (disp.getNroSerie().equals(Long.parseLong(ids))) {
				esDispUsr = true;
				break;
			}
		}
		// El dispositivo no pertenece al usuario
		if (!esDispUsr) {
			return null;
		}

		// Validar el tipo de dispositivo (Persona, mascota, automovil)
		RSchipDispositivo rschip = deviceService.getChipDisp(ids);
		int status = -1;

		// ______________Terminan validaciones___________________

		
		// LLamar servicio de mensajeria
		if(onOff == 0){
			status = smsService.sendMessage(rschip.getFcNumeroTelefonico(), this.textReinicioEnergia);
		}else{
			status = smsService.sendMessage(rschip.getFcNumeroTelefonico(), this.textCorteEnergia);
		}

		return status;
	}
	

	/**
	 * Se recibe la petici�n para enviar un SMS que va a despertar al
	 * dispositivo
	 * 
	 * �sto solo aplica para personas y mascotas
	 * @param ids
	 * 			Ids numero serial del dispositivo
	 * @param principal
	 *            Objeto de SpringSecurity conteniendo las credenciales de la
	 *            sesi�n
	 * @return Retorna 0 si el mensaje se envi� correctamente, diferente si fall�
	 */
	@RequestMapping(value = "/sendMessage", method = RequestMethod.GET)
	public @ResponseBody
	Integer sendMessage(String ids, Principal principal) {
		// _____________Validaciones
		logger.debug("ID's: " + ids);
		logger.debug("[Controller] Peticion por cantidad");
		if (principal == null)
			return -1; // Usuario no identificado
		logger.debug("Principal not null... OK");
		if (ids == null || ids.length() == 0)
			return -1; // No hay variables
		logger.debug("Params not null... OK");

		Tavusuario loggedUser = this.userService
				.getUsuario(principal.getName());
		List<DispXUsuarioView> dispDeCliente = this.deviceService
				.getDispositivosXUsuario(loggedUser.getFiIdUsuario());
		boolean esDispUsr = false;
		for (DispXUsuarioView disp : dispDeCliente) {
			if (disp.getNroSerie().equals(Long.parseLong(ids))) {
				esDispUsr = true;
				break;
			}
		}
		// El dispositivo no pertenece al usuario
		if (!esDispUsr) {
			return null;
		}

		// Validar el tipo de dispositivo (Persona, mascota, automovil)
		RSchipDispositivo rschip = deviceService.getChipDisp(ids);
		int status = -1;

		// ______________Terminan validaciones___________________

		if (rschip.getFiIdTipo() != 1) {
			// LLamar servicio de mensajeria
			status = smsService.sendMessage(rschip.getFcNumeroTelefonico(), this.text);
		}

		return status;
	}

	/**
	 * Obtiene el registro m�s reciente por cada serial indicado como par�metro.
	 * Se limita �nicamente a dispositivos propiedad del usuario que realiza la
	 * petici�n.
	 * 
	 * @param ids
	 *            La cadena de n�meros de serie separados por coma (',')
	 * @param principal
	 *            Objeto de SpringSecurity conteniendo las credenciales de la
	 *            sesi�n
	 * @return Una lista con el �ltimo registro por cada serial v�lido de la
	 *         entrada
	 */
	@RequestMapping(value = "/byLatest", method = RequestMethod.GET)
	public @ResponseBody
	List<RegistroView> getLatest(String ids, Principal principal) {
		// _____________Validaciones

		logger.debug("ID's: " + ids);
		logger.debug("[Controller] Peticion por cantidad");
		if (principal == null)
			return null; // Usuario no identificado
		logger.debug("Principal not null... OK");
		if (ids == null || ids.length() == 0)
			return null; // No hay variables
		logger.debug("Params not null... OK");

		String[] IDS = ids.split(",");
		List<Long> serialesPeticion = new ArrayList<Long>();
		for (int i = 0; i < IDS.length; i++) {
			try {
				serialesPeticion.add(Long.parseLong(IDS[i]));
			} catch (NumberFormatException nfe) {
				logger.debug("Error de formato en numero de serie:" + IDS[i]);
			}
		}

		Tavusuario loggedUser = this.userService
				.getUsuario(principal.getName());
		List<DispXUsuarioView> dispDeCliente = this.deviceService
				.getDispositivosXUsuario(loggedUser.getFiIdUsuario());
		boolean esDispUsr = false;
		for (DispXUsuarioView disp : dispDeCliente) {
			for (Long l : serialesPeticion) {
				if (disp.getNroSerie().equals(l)) {
					esDispUsr = true;
					break;
				}
			}

		}
		// El dispositivo no pertenece al usuario
		if (!esDispUsr) {
			return null;
		}

		// ______________Terminan validaciones___________________

		List<RegistroView> regs = new ArrayList<RegistroView>();
		for (Long serial : serialesPeticion) {

			RSchipDispositivo rschip = deviceService.getChipDisp(serial
					.toString());
			int status = -1;

			if (rschip.getFiIdTipo() != 1) {
				// LLamar servicio de mensajeria
				status = smsService.sendMessage(rschip.getFcNumeroTelefonico(), this.text);
			}

			if (status != 0) {
				logger.error("SMS no enviado al numero: "
						+ rschip.getFcNumeroTelefonico() + " Estatus " + status);
			}

			RegistroView regView = this.deviceService.getUltimoPunto(serial.toString());
			//Se setea la propiedad alias al objeto RegistroView, el dato se obtiene de DispXUsuarioView
			for(DispXUsuarioView disp: dispDeCliente){
				if(disp.getNroSerie().equals(serial)){
					regView.setAlias(disp.getAlias());
					
				}
			}
			
			
			regs.add(regView);

		}
		logger.debug(serialesPeticion.size()
				+ " Seriales en la peticion, se devuelven " + regs.size());
		return regs;
	}

	/**
	 * Obtiene todos los registros que cumplan con la restricci�n de fechas
	 * impuestas como par�metros y que pertenezcan al dispositivo (del usuario
	 * en sesi�n) indicado.
	 * 
	 * @param iniTime
	 *            Tiempo inicial para restringir los registros (fechas en UTC,
	 *            formato de ejemplo: '2015-03-10+06:00:00')
	 * @param finTime
	 *            Tiempo final de la restricci�n
	 * @param nroSerie
	 *            El n�mero de serie del dispositivo (en la URL)
	 * @param principal
	 *            Objeto de SpringSecurity con las credenciales del usuario en
	 *            sesi�n
	 * @return Una lista en JSON con los registros que cumplen con la
	 *         restricci�n.
	 */
	@RequestMapping(value = "/{nroSerie}/byTimeInt", method = RequestMethod.GET)
	public @ResponseBody
	List<RegistroView> getCoords(String iniTime, String finTime,
			@PathVariable("nroSerie") String nroSerie, Principal principal) {

		// _____________Validaciones
		logger.debug("Principal: " + principal);
		if (principal == null)
			return null; // Usuario no identificado
		logger.debug("Vars: [" + iniTime + "][" + finTime + "]");
		if (iniTime == null || finTime == null)
			return null; // No hay variables
		Long serie = Long.parseLong(nroSerie);

		Tavusuario loggedUser = this.userService
				.getUsuario(principal.getName());
		List<DispXUsuarioView> dispDeCliente = this.deviceService
				.getDispositivosXUsuario(loggedUser.getFiIdUsuario());
		boolean esDispUsr = false;
		for (DispXUsuarioView disp : dispDeCliente) {
			if (disp.getNroSerie().equals(serie)) {
				esDispUsr = true;
				break;
			}
		}
		// El dispositivo no pertenece al usuario
		if (!esDispUsr) {
			return null;
		}

		// ______________Terminan validaciones___________________

		List<RegistroView> regs = null;
		try {
			Timestamp its = Timestamp.valueOf(iniTime);
			Timestamp ets = Timestamp.valueOf(finTime);

			regs = this.deviceService.getListaPuntos(serie.toString(), its, ets);

		} catch (IllegalArgumentException e) {
			logger.debug("Error en parametros de peticion.");
			regs = null;
		}

		return regs;
	}

	/**
	 * Regresa la cantidad solicitada de los registros m�s recientes del
	 * dispositivo indicado en el par�metro de la URL.
	 * 
	 * @param qty
	 *            La cantidad de registros a obtener, debe de estar en el rango
	 *            [0,60]
	 * @param nroserie
	 *            el n�mero de serie del dispositivo
	 * @param principal
	 *            Objeto de SpringSecurity conteniendo los datos del usuario de
	 *            la sesi�n
	 * @return La lista de Registros como JSON
	 */
	@RequestMapping(value = "/{nroserie}/byQty", method = RequestMethod.GET)
	public @ResponseBody
	List<RegistroView> getCoordsByQty(String qty,
			@PathVariable("nroserie") String nroserie, Principal principal) {
		// _____________Validaciones
		logger.debug("[Controller] Peticion por cantidad");
		if (principal == null)
			return null; // Usuario no identificado
		if (qty == null)
			return null; // No hay variables
		// User loggedUser = userService.getUser(principal.getName());
		Long serie = Long.parseLong(nroserie);
		Tavusuario loggedUser = this.userService
				.getUsuario(principal.getName());
		List<DispXUsuarioView> dispDeCliente = this.deviceService
				.getDispositivosXUsuario(loggedUser.getFiIdUsuario());
		boolean esDispUsr = false;
		for (DispXUsuarioView disp : dispDeCliente) {
			if (disp.getNroSerie().equals(serie)) {
				esDispUsr = true;
				break;
			}
		}
		// El dispositivo no pertenece al usuario
		if (!esDispUsr) {
			return null;
		}
		logger.debug("Client owns the device ... OK");

		Integer cant = 0;
		try {
			cant = Integer.valueOf(qty);
		} catch (NumberFormatException e) {
			logger.error("Argumentos incorrectos en peticion: " + qty);
		}
		logger.debug("Values: " + serie + "/" + cant);

		if (cant.equals(0) || cant > 60 || cant < 0)
			return null;

		// ______________Terminan validaciones___________________

		return this.deviceService.getListaPuntosByQty("" + serie, cant); // deviceService.listRegistros(serie,
																			// cant);
	}
	
	
	/**
	 * Se buscan los dispositivos asociados al usuario
	 *
	 * @param principal
	 *            Objeto de SpringSecurity conteniendo las credenciales de la
	 *            sesi�n
	 * @return Retorna una lista de dispositivos
	 */
	
	@RequestMapping(value = "/getDevices", method = RequestMethod.GET)
	public @ResponseBody
	List<DispXUsuarioView> getDevices(Principal principal) {
		// _____________Validaciones

		if (principal == null)
			return null; // Usuario no identificado

		// ______________Terminan validaciones___________________

		Tavusuario loggedUser = this.userService
				.getUsuario(principal.getName());
		logger.debug("Usuario loggeado: " + principal.getName() + ", ID: " + loggedUser.getFiIdUsuario());
		List<DispXUsuarioView> dispDeCliente = this.deviceService
				.getDispositivosXUsuario(loggedUser.getFiIdUsuario());

		return dispDeCliente;
	}

	
	@RequestMapping(value = "/{idDispositivo}/setParking", method = RequestMethod.GET)
	public @ResponseBody
	boolean setParking(
			@PathVariable("idDispositivo") String idDispositivo, Principal principal) {

		// _____________Validaciones
		logger.debug("[Controller] Peticion modo estacionamiento");
		if (principal == null)
			return false; // Usuario no identificado
		
		// User loggedUser = userService.getUser(principal.getName());
		Long serie = Long.parseLong(idDispositivo);
		
		Tavusuario loggedUser = this.userService
				.getUsuario(principal.getName());
		List<DispXUsuarioView> dispDeCliente = this.deviceService
				.getDispositivosXUsuario(loggedUser.getFiIdUsuario());
		boolean esDispUsr = false;
		for (DispXUsuarioView disp : dispDeCliente) {
			if (disp.getNroSerie().equals(serie)) {
				esDispUsr = true;
				break;
			}
		}
		// El dispositivo no pertenece al usuario
		if (!esDispUsr) {
			return false;
		}
		logger.debug("Client owns the device ... OK");

		RegistroView reg = this.deviceService.getUltimoPunto(idDispositivo);
		if(reg == null){
			return false;
		}
		Tavcatdispositivo tavCatDispositivo = this.deviceService.getDispositivo(new BigInteger(idDispositivo));
		tavCatDispositivo.setFiLatitud(reg.getLatitud());
		tavCatDispositivo.setFiLongitud(reg.getLongitud());
		tavCatDispositivo.setFiStatus(new Byte("1"));
		
		return this.deviceService.insertaDispositivo(tavCatDispositivo);
		
	}
	
	@RequestMapping(value = "/{idDispositivo}/downParking", method = RequestMethod.GET)
	public @ResponseBody
	boolean downParking(
			@PathVariable("idDispositivo") String idDispositivo, Principal principal) {

		// _____________Validaciones
		logger.debug("[Controller] Baja modo estacionamiento");
		if (principal == null)
			return false; // Usuario no identificado
		
		Long serie = Long.parseLong(idDispositivo);
		
		Tavusuario loggedUser = this.userService
				.getUsuario(principal.getName());
		List<DispXUsuarioView> dispDeCliente = this.deviceService
				.getDispositivosXUsuario(loggedUser.getFiIdUsuario());
		boolean esDispUsr = false;
		for (DispXUsuarioView disp : dispDeCliente) {
			if (disp.getNroSerie().equals(serie)) {
				esDispUsr = true;
				break;
			}
		}
		// El dispositivo no pertenece al usuario
		if (!esDispUsr) {
			return false;
		}
		logger.debug("Client owns the device ... OK");
		
		Tavcatdispositivo tavCatDispositivo = this.deviceService.getDispositivo(new BigInteger(idDispositivo));
		tavCatDispositivo.setFiLatitud(null);
		tavCatDispositivo.setFiLongitud(null);
		tavCatDispositivo.setFiStatus(new Byte("0"));
		
		return this.deviceService.insertaDispositivo(tavCatDispositivo);
		
	}
	
	@RequestMapping(value = "/{idDispositivo}/getStatusPark", method = RequestMethod.GET)
	public @ResponseBody
	boolean getStatusPark(
			@PathVariable("idDispositivo") String idDispositivo, Principal principal) {
		// _____________Validaciones
		
		logger.debug("[Controller] Baja modo estacionamiento");
		if (principal == null)
			return false; // Usuario no identificado
		
		Long serie = Long.parseLong(idDispositivo);
		
		Tavusuario loggedUser = this.userService
				.getUsuario(principal.getName());
		List<DispXUsuarioView> dispDeCliente = this.deviceService
				.getDispositivosXUsuario(loggedUser.getFiIdUsuario());
		boolean esDispUsr = false;
		for (DispXUsuarioView disp : dispDeCliente) {
			if (disp.getNroSerie().equals(serie)) {
				esDispUsr = true;
				break;
			}
		}
		// El dispositivo no pertenece al usuario
		if (!esDispUsr) {
			return false;
		}
		logger.debug("Client owns the device ... OK");

		

		// ______________Terminan validaciones___________________

		return this.deviceService.getStatusParking(new BigInteger(idDispositivo));
	}
	
}
