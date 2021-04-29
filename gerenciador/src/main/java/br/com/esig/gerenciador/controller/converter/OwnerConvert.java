package br.com.esig.gerenciador.controller.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.esig.gerenciador.model.Owner;
import br.com.esig.gerenciador.repository.OwnerRepository;

@Component
public class OwnerConvert implements Converter{
	
	@Autowired
	OwnerRepository ownerRepository;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Owner owner = ownerRepository.findOne(Long.parseLong(value, 10));
		return owner;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof Owner) {
			Owner owner = (Owner) value;
			return owner.getId().toString();
		}else {
			
			return null;
		}
	}

}
