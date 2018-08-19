package com.avior.controller;

import java.math.BigInteger;
import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.avior.model.notifications.AjaxNotification;
import com.avior.model.tav.Tavcatcerca;
import com.avior.model.tav.Tavcercadisp;
import com.avior.model.tav.Tavusuario;
import com.avior.model.view.FenceIdView;
import com.avior.model.view.FenceView;
import com.avior.services.FenceService;
import com.avior.services.ManageDispositivos;
import com.avior.services.ManageUsers;

@Controller
@RequestMapping("/cercas")
public class FencesController {

	private ManageDispositivos devSvc;
	private FenceService fenceSvc;
	private ManageUsers usrSvc;
	private Logger logger = LoggerFactory.getLogger(getClass());

	DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	@Autowired
	public void setFenceSvc(FenceService fenceSvc) {
		this.fenceSvc = fenceSvc;
	}

	@Autowired
	public void setDevSvc(ManageDispositivos devSvc) {
		this.devSvc = devSvc;
	}

	@Autowired
	public void setUsrSvc(ManageUsers usrSvc) {
		this.usrSvc = usrSvc;
	}

	@RequestMapping
	public String editFences(Model model, Principal principal) {
		logger.info("Atendiendo petición para generar página principal de cercas");
		String maps = "include";

		Tavusuario theUserLogged = usrSvc.getUsuario(principal.getName());
		model.addAttribute("cercas", fenceSvc.listCercas(Long.parseLong(theUserLogged.getFiIdUsuario())));
		model.addAttribute("maps", maps);
		model.addAttribute("loggedUser", theUserLogged);
		model.addAttribute("fenceDialogs", true);
		model.addAttribute("devices",devSvc.getDispositivosXUsuario(theUserLogged.getFiIdUsuario()));
		model.addAttribute("pageType", "map");
		model.addAttribute("clientId", theUserLogged.getFiIdUsuario());
		return "fences";
	}
	
	
	@RequestMapping(value = "/asociarCercas", method = RequestMethod.GET)
	public @ResponseBody
	AjaxNotification asociar(String[] serialAsoc, String[] serialDesAsoc, String idCerca,  
			Principal principal) {
		
		int lenghtAsoc = lenghtOfArray(serialAsoc);
		int lenghtDesasoc = lenghtOfArray(serialDesAsoc);
		
		AjaxNotification ret = new AjaxNotification();
		Tavcatcerca tavCatCerca = (Tavcatcerca) fenceSvc.consulta(Tavcatcerca.class, idCerca);	
		String nombreCerca = tavCatCerca.getFcNombre();
		if(desasociarVehiculos(serialDesAsoc, idCerca, principal).getStatus() == 0){				
			ret.setUserMessage("Se desasociaron "+lenghtDesasoc+" vehículos de la cerca "+nombreCerca+".\n");

		}else{
			ret.setUserMessage("Error al desasociar los vehículos de la cerca "+nombreCerca+".\n");
		}
		
		if(asociarVehiculos(serialAsoc, idCerca, principal).getStatus() == 0){			
			ret.setUserMessage(ret.getUserMessage().concat("Se asociaron "+lenghtAsoc+" vehículos a la cerca "+nombreCerca));			
		}else{
			ret.setUserMessage(ret.getUserMessage().concat("Error al asociar los vehículos de la cerca "+nombreCerca));
		}
		return ret;
	}

	private int lenghtOfArray(String[] arreglo){
		if(arreglo != null){
			if(arreglo[0] == null || arreglo[0].equals("") || arreglo[0].equals("0") || arreglo[0].equals("[]")){
				return 0;
			}else{
				return arreglo.length;
			}
		}
		return 0;
	}
	
	public AjaxNotification desasociarVehiculos(String[] serial, String idCerca,
			Principal principal) {
		AjaxNotification msg = new AjaxNotification();
		msg.setStatus(1);
		msg.setUserMessage("Error al procesar petición (V2F0001)");
		logger.debug(serial + ";" + idCerca);
		try {

			Tavusuario theUserLogged = usrSvc.getUsuario(principal.getName());
			Long idCliente = Long.parseLong(theUserLogged.getFiIdUsuario());

			for (String s : serial) {

				if (s.contains("[")) {
					s = s.replace("[", "");
				}
				if (s.contains("]")) {
					s = s.replace("]", "");
				}
				Tavcercadisp tavCercaDisp = fenceSvc.obtenercercaDisp(
						new BigInteger(idCerca), BigInteger.valueOf(idCliente),
						s);
				if (tavCercaDisp != null) {
					fenceSvc.borrarTavCerca(tavCercaDisp);
				}

			}
			msg.setStatus(0);
			msg.setRegAfectados(serial.length);
			msg.setUserMessage("");
			return msg;
		} catch (NullPointerException e) {
			logger.error(e.getMessage());
			msg.setUserMessage("Error al procesar petición (V2F0002)");
		} catch (Exception e) {
			logger.error(e.getMessage());
			msg.setUserMessage("Error al procesar petición (V2F0003)");
		}
		return msg;
	}

	
	public AjaxNotification asociarVehiculos(String[] serial, String idCerca,
			Principal principal) {
		AjaxNotification msg = new AjaxNotification();
		msg.setStatus(1);
		msg.setUserMessage("Error al procesar petición (V2F0001)");
		logger.debug(serial + ";" + idCerca);
		String idCercaDisp = "-1";
		try {

			// Buscar las cercas asociadas que tiene el usuario
			Tavusuario theUserLogged = usrSvc.getUsuario(principal.getName());
			Long idCliente = Long.parseLong(theUserLogged.getFiIdUsuario());

			for (String s : serial) {
				if (s.contains("[")) {
					s = s.replace("[", "");
				}
				if (s.contains("]")) {
					s = s.replace("]", "");
				}

				List<Tavcercadisp> listCercasUsuario = fenceSvc.listCercasUsuario(idCliente, Long.parseLong(idCerca));
				for (Tavcercadisp t : listCercasUsuario) {
					// Buscamos si hay registro de la cerca solicitada y su
					// relacion con el dispositivo
					// esto lo sabemos por el estatus, si esta en cero es que el
					// registro no esta ocupado
					if((t.getFcNumeroSerie().equals(s) 
							&& t.getFiIdCerca().equals(new BigInteger(idCerca))
							&& t.getFiIdUsuario().equals(new BigInteger(theUserLogged.getFiIdUsuario())))){
						idCercaDisp = t.getFiId();
						break;
						
					}
				}

				Tavcercadisp cercaDisp = new Tavcercadisp();
				cercaDisp.setFcNumeroSerie(s);
				cercaDisp.setFcUsuarioModifico(principal.getName());
				cercaDisp.setFdFechaUltimaModificacion(sdf.parse(sdf
						.format(new Date())));
				cercaDisp.setFiIdCerca(new BigInteger(idCerca));
				cercaDisp.setFiIdStatus((byte) 1);
				cercaDisp.setFiIdUsuario(new BigInteger(theUserLogged
						.getFiIdUsuario()));

				if (idCercaDisp != "-1") {// Se encontro lugar para l registro
					cercaDisp.setFiId(idCercaDisp);
					fenceSvc.actualizaCercaDisp(cercaDisp);

				} else {// Se debe crear uno nuevo

					fenceSvc.insertaCercaDisp(cercaDisp);

				}

				idCercaDisp = "-1";
			}
			msg.setStatus(0);
			msg.setRegAfectados(serial.length);
			msg.setUserMessage("");
			return msg;
		} catch (NullPointerException e) {
			logger.error(e.getMessage());
			msg.setUserMessage("Error al procesar petición (V2F0002)");
		} catch (Exception e) {
			logger.error(e.getMessage());
			msg.setUserMessage("Error al procesar petición (V2F0003)");
		}
		return msg;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public @ResponseBody
	AjaxNotification deleteFence(String idCerca, Principal principal) {
		AjaxNotification msg = new AjaxNotification();
		
		//Se borra la cerca del catalogo de cercas
		Tavcatcerca tavCatCerca = (Tavcatcerca) fenceSvc.consulta(Tavcatcerca.class, idCerca);		
		fenceSvc.deleteFence(tavCatCerca);			
		
		//Borramos la aosiciacion
		fenceSvc.deleteFenceDisp(idCerca);
		
		msg.setStatus(0);
		msg.setUserMessage("Cerca borrada exitosamente");
		msg.setOtherInfo("");
		return msg;
		
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public @ResponseBody
	AjaxNotification saveFence(String id, String poly, String name,
			String color, String area, Principal principal) {

		logger.debug("Petición JSON para guardar geo-cerca");
		logger.debug("Nombre: " + name);
		logger.debug("Poligono: " + poly);
		logger.debug("Color:" + color);
		logger.debug("Area: " + area);
		AjaxNotification msg = new AjaxNotification();
		try {

			// Crear cerca
			Tavcatcerca cerca = new Tavcatcerca();
			cerca.setFcColor("" + Long.parseLong(color, 16));
			cerca.setFcNombre(name);
			cerca.setFcUsuarioModifico(principal.getName());
			cerca.setFdFechaUltimaModificacion(sdf.parse(sdf.format(new Date())));
			cerca.setFdPoligono(poly);
			cerca.setFiArea(Double.parseDouble(area));
			cerca.setFiIdStatus((byte) 1);
			if (id.equals("0"))
				cerca = fenceSvc.crearCerca(cerca);
			else {
				cerca.setFiIdCerca(id);
				fenceSvc.actualizaCerca(cerca);
			}


			msg.setStatus(0);
			msg.setUserMessage("Cerca guardada exitosamente");
			msg.setOtherInfo("");
			return msg;
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus(0);
			msg.setUserMessage("Ocurrió un error inesperado al procesar su solicitud. Revise los parámetros e intente nuevamente");
			msg.setOtherInfo("");
			return msg;
		}
	}

	@RequestMapping(value = "/{clientid}/readall", method = RequestMethod.GET)
	public @ResponseBody
	List<FenceIdView> getFencesByUser(
			@PathVariable("clientid") String clientid, Principal principal) {
		if (principal != null) {
			try {
				Long id = Long.parseLong(clientid);
				// Verificamos que la peticion de cercas se limite a las propias
				// if(principal.getName().equals(clientSvc.getCliente(id).getUser().getUsername())){
				List<FenceView> listCercas = fenceSvc.listCercas(id);
				List<FenceIdView> cercas = new ArrayList<FenceIdView>();
				String nombre;
				String nombreMasUno;

				for (int i = 0; i < listCercas.size(); i++) {
					
					if (i + 1 < listCercas.size()) {
						nombre =  listCercas.get(i).getNombre();
						nombreMasUno = listCercas.get(i + 1).getNombre();
						if (nombre.equals(nombreMasUno)) {
							continue;
						}
					}

					cercas.add(new FenceIdView(listCercas.get(i), devSvc.getDispXCerca(listCercas.get(i)
							.getId().toString())));
				}

				return cercas;

				// }
			} catch (NullPointerException npe) {
				logger.error(
						"Error al obtener cercas del usuario (NullPointerException)"
								+ clientid, npe);

			} catch (NumberFormatException nfe) {
				logger.error("Error al obtener cercas del usuario " + clientid,
						nfe);
			}

		}
		return null;
	}

}
