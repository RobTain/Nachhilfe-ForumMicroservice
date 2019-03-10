package com.fabian.forum.mapper;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.fabian.forum.DTO.ForumeintragDTO;
import com.fabian.forum.entity.Forumeintrag;

/**
 * Konvertiert das Datentransfer-Objekt zu dem Model
 * @author fabian
 *
 */
@Component
public class ConvertDTOToEntity implements Converter<ForumeintragDTO, Forumeintrag>{

	@Override
	public Forumeintrag convert(ForumeintragDTO source) {
		Forumeintrag forum = new Forumeintrag(source.getId(), source.getAntwort_id(), source.isAntwort(), source.getName(), source.getEmail(),
				source.getTitel(), source.getInhalt(), source.getZeit());
		return forum;
	}
	
	

}
