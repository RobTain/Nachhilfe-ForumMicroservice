package com.fabian.forum.repository;

import org.springframework.data.repository.CrudRepository;


import com.fabian.forum.entity.Forumeintrag;

/**
 * Schnittstelle zwischen Datenbank und Service-Schicht. Da das CrudRepository alle gängigen CRUD
 * Funktionen bietet, hat diese Klasse keine zusätzliche Funktionalität.
 * @author fabian
 *
 */
public interface ForumRepository extends CrudRepository<Forumeintrag, Integer> {

	
}
