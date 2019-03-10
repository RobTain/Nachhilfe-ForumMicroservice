package com.fabian.forum.service;

import java.util.List;

import com.fabian.forum.DTO.ForumeintragDTO;

/**
 * Diese Klasse stellt die Schnittstelle zwischen dem Controller und der Datenbankanfrage übers Repository dar.
 * @author fabian
 *
 */
public interface ForumService {

	/**
	 * Holt alle Beiträge aus der Datenbank, wobei Antwort-Beiträge aussortiert werden.
	 * @return Liste an Beiträgen
	 */
	List<ForumeintragDTO> getContributions();

	/**
	 * Legt einen neuen Beitrag in die Datenbank an.
	 * @param Model
	 */
	void createContribution(ForumeintragDTO forumDTO);

	/**
	 * Holt einen bestimmten (id) Beitrag aus der Datenbank)
	 * @param id ID des Beitrags
	 * @return Model
	 */
	ForumeintragDTO getContribution(Integer id);

	/**
	 * Holt alle Antworten zu einem bestimmten Beitrag aus der Datenbank
	 * @param id ID des Beitrags
	 * @return Liste an Antworten
	 */
	List<ForumeintragDTO> getAnswers(Integer id);
	
}
