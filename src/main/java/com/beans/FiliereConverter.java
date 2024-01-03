package com.beans;

import com.entities.Filiere;
import com.service.FiliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;


@ManagedBean
@Component
@Scope("session")
public class FiliereConverter implements Converter{

	@Autowired
	private FiliereService filiereService;
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value != null && value.trim().length()>0) {
			return this.filiereService.getById(Integer.parseInt(value));
		}
			
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null) {
			return String.valueOf(((Filiere) value).getId());
		}
		return null;
	}
	
}
