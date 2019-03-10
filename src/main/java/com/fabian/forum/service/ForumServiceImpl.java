package com.fabian.forum.service;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabian.forum.DTO.ForumeintragDTO;
import com.fabian.forum.entity.Forumeintrag;
//import com.fabian.forum.entity.Forum;
import com.fabian.forum.mapper.ConvertDTOToEntity;
import com.fabian.forum.mapper.ConvertEntityToDTO;
import com.fabian.forum.repository.ForumRepository;

import ch.qos.logback.classic.Logger;

@Service
public class ForumServiceImpl implements ForumService {

	private Logger logger;
	private ForumRepository forumRepository;
	private ConvertDTOToEntity mapperDTOToEntity;
	private ConvertEntityToDTO mapperEntityToDTO;

	@Autowired
	public ForumServiceImpl(ForumRepository forumRepository, ConvertDTOToEntity mapperDTOToEntity,
			ConvertEntityToDTO mapperEntityToDTO) {
		this.logger = (Logger) LoggerFactory.getLogger(ForumServiceImpl.class);
		this.forumRepository = forumRepository;
		this.mapperDTOToEntity = mapperDTOToEntity;
		this.mapperEntityToDTO = mapperEntityToDTO;
	}


	@Override
	public List<ForumeintragDTO> getContributions() {
		logger.info("Calling Repository to get all contributions - ForumService.getContribution");		
		List<Forumeintrag> contributions = (List<Forumeintrag>) forumRepository.findAll();
		
		// Aussortieren aller Antwort-Beiträge
		List<ForumeintragDTO> contributionDTOs = new LinkedList<ForumeintragDTO>();
		for (Forumeintrag forumeintrag : contributions) {
			if (!forumeintrag.isAntwort()) {
				contributionDTOs.add(mapperEntityToDTO.convert(forumeintrag));
			}
		}
		return contributionDTOs;
	}
	
	

	@Override
	public void createContribution(ForumeintragDTO forumeintragDTO) {
		logger.info("Create new contribution - Set TimeStamp - ForumService.createContribution");
		forumeintragDTO.setZeit(LocalDateTime.now());
		logger.info("Create new contribution - Save Into Database - ForumService.createContribution");
		forumRepository.save(mapperDTOToEntity.convert(forumeintragDTO));
	}

	@Override
	public ForumeintragDTO getContribution(Integer id) {
		logger.info("find contribution by ID - ForumService.getContribution");
		Optional<Forumeintrag> forum = forumRepository.findById(id);
		return mapperEntityToDTO.convert(new Forumeintrag(forum.get().getId(), forum.get().getAntwort_id(),
				forum.get().isAntwort(), forum.get().getName(), forum.get().getEmail(), forum.get().getTitel(),
				forum.get().getInhalt(), forum.get().getZeit()));
	}

	@Override
	public List<ForumeintragDTO> getAnswers(Integer id) {
		logger.info("find all answers to a contribution - ForumServiceImpl.getAnswers()");
		List<Forumeintrag> contributions = (List<Forumeintrag>) forumRepository.findAll();
		
		// Aussortieren aller Beiträge
		List<ForumeintragDTO> contributionDTOs = new LinkedList<ForumeintragDTO>();
		for (Forumeintrag forumeintrag : contributions) {
			if (forumeintrag.isAntwort() && forumeintrag.getAntwort_id() == id) {
				contributionDTOs.add(mapperEntityToDTO.convert(forumeintrag));
			}
		}

		return contributionDTOs;
	}

}
