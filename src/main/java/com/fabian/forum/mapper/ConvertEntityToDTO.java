package com.fabian.forum.mapper;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.fabian.forum.DTO.ForumeintragDTO;
import com.fabian.forum.entity.Forumeintrag;

/**
 * Konvertiert das Model zu einem Datentransfer-Objekt
 * @author fabian
 *
 */
@Component
public class ConvertEntityToDTO implements Converter<Forumeintrag, ForumeintragDTO>{

	@Override
	public ForumeintragDTO convert(Forumeintrag source) {
		ForumeintragDTO forumDTO = new ForumeintragDTO(source.getId(), source.getAntwort_id(), source.isAntwort(), source.getName(), source.getEmail(),
				source.getTitel(), source.getInhalt(), source.getZeit());
		return forumDTO;
	}

}
