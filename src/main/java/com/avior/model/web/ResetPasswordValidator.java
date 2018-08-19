package com.avior.model.web;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.avior.model.tav.Tavusuario;
import com.avior.services.ManageUsers;


@Component("rstPwdValidator")
public class ResetPasswordValidator implements Validator {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ManageUsers userSvc;
	
	

	@Override
	public boolean supports(Class<?> clazz) {		
		return ResetPasswordForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		logger.debug("Validando el form para resetear contraseña");
		ResetPasswordForm form = (ResetPasswordForm)target;
	
		
		if(form.getEmail() != null && !form.getEmail().equals("")){
			/*REGEX para mail: cualquier num.(>0) de caracteres seguido por @ seguido por cualquier num(>0)
			 * un punto, y seguido de cualquier num de caracteres (>0) y despues cualquier cosa
			 * */
			Pattern p = Pattern.compile(".+@.+\\.[a-z]+.*");
			Matcher m = p.matcher(form.getEmail());
			if(!m.matches()){
				errors.rejectValue("email", "Invalid");
			}else{
								
				Tavusuario theUser = userSvc.getUsuario(form.getEmail());		
										
				if(theUser == null){
					errors.rejectValue("email", "NotFound");
				}
			}
		}else{
			//Rechaza ambos campos
			errors.rejectValue("email", "NotEmpty");
//			errors.rejectValue("username", "NotEmpty");
		}		
	}

}
