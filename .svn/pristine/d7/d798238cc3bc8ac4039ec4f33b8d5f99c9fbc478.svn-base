package com.avior.controller;

import java.math.BigInteger;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.avior.model.tav.Tavusuario;
import com.avior.model.tav.Tavusuariodisp;
import com.avior.model.view.DispXAutoView;
import com.avior.model.view.RegistroView;
import com.avior.services.ManageDispositivos;
import com.avior.services.ManageUsers;

@Controller
@RequestMapping("/tracking")
public class TrackingController {
	private ManageDispositivos devSvc;
	private ManageUsers usrSvc;

	
	private Logger logger = LoggerFactory.getLogger(getClass());	
	
	@Autowired
	public void setDevSvc(ManageDispositivos devSvc){
		this.devSvc = devSvc;
	}	
	@Autowired
	public void setUsrSvc(ManageUsers usrSvc){
		this.usrSvc = usrSvc;
	}
	
	
	
	@RequestMapping
	public String mainTrack(Model model, Principal principal){
		String maps = "include";
			
		Tavusuario theUser = usrSvc.getUsuario(principal.getName());
		List<Tavusuariodisp> listDispXUs = usrSvc.getDispXUsuario(new BigInteger(theUser.getFiIdUsuario()));
		List<DispXAutoView> dispositivos = this.generarDispositivos(listDispXUs);		
		// ______________Terminan validaciones___________________
		RegistroView lastPos = null;
		if(!listDispXUs.isEmpty()){
			lastPos = devSvc.getUltimoPunto(listDispXUs.get(0).getFcNumeroserie());
			model.addAttribute("lastPosition", lastPos);
			logger.debug("Ultima posicion " + lastPos);
		}
		
		model.addAttribute("maps", maps);		
		model.addAttribute("autos", dispositivos);		
		model.addAttribute("loggedUser", theUser);		
		
		logger.debug("Dispositivos del cliente: " + dispositivos.size());
		model.addAttribute("pageType", "map");
		return "tracking";
	}	
	
	private List<DispXAutoView> generarDispositivos(List<Tavusuariodisp> listTav){
		
		List <DispXAutoView> ret= new ArrayList<DispXAutoView>();
		DispXAutoView aux;
		for(Tavusuariodisp t: listTav){
			aux = new DispXAutoView();
			aux.setAlias(t.getFcAliasDispositivo());
			aux.setIdCerca(null);
			aux.setNroSerie(t.getFcNumeroserie());
			aux.setIdCliente(t.getFiIdUsuario().longValue());
			ret.add(aux);
		}
		 
		 return ret;
	}
}
