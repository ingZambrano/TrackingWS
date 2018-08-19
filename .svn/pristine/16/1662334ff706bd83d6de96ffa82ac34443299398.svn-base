package com.avior.model.web;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component("commentValidator")
public class CommentValidator implements Validator {
	private Logger logger = LoggerFactory.getLogger(getClass());	

	@Override
	public boolean supports(Class<?> arg0) {
		// Solamente sirve para la clase Comment
		return Comment.class.equals(arg0);
	}

	@Override
	public void validate(Object form, Errors err) {
		/*REGEX para mail: cualquier num.(>0) de caracteres seguido por @ seguido por cualquier num(>0)
		 * un punto, y seguido de cualquier num de caracteres (>0) y despues cualquier cosa
		 * */
		Pattern p = Pattern.compile(".+@.+\\.[a-z]+.*");		
		
		logger.debug("[Validator] Validando comentario");		
		
		//Campos que no deben ser vacíos
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "email", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "nombre", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "comment", "NotEmpty");
		
		Comment comment = (Comment)form;
		logger.debug("Nombre: " + comment.getNombre());
		logger.debug("Email: " + comment.getEmail());
		logger.debug("Comentario: " + comment.getComment());
		
		Matcher m = p.matcher(comment.getEmail());
		if(!m.matches()){
			logger.debug("Email Invalido");
			err.rejectValue("email", "Invalid");
		}
		//Ya no hay mas que validar, el Nombre y Comentario es libre. 
	}

}
