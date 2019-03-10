package com.fabian.forum.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.fabian.forum.DTO.ForumeintragDTO;

import com.fabian.forum.service.ForumService;
import com.fabian.forum.utils.ForumStrings;

import ch.qos.logback.classic.Logger;

/**
 * Diese Klasse stellt die Schnittstelle zwischen der dem Controller und der View da. Alle Anfragen an die Datenbank
 * werden hier verarbeitet.
 * @author fabian
 */
@Controller
public class ForumController {

	private Logger logger;
	private ForumService forumService;

	/**
	 * Konstruktor der Klasse - Einlesen externer Klassen mittels Dependency Injection.
	 * @param forumService Service-Klasse zum Bearbeiten von Anfragen an die Datenbank.
	 */
	@Autowired
	public ForumController(ForumService forumService) {
		this.forumService = forumService;
		this.logger = (Logger) LoggerFactory.getLogger(ForumController.class);
		logger.info("Create initial admin entry");
		forumService.createContribution(new ForumeintragDTO(Integer.MAX_VALUE, 0, false, "Admin", "admin@hszg.de",
				"Willkommen", "Willkommen im Forum!", null));
	}

	/**
	 * Baut die Seite index.jsp mit Logik aus dem Backend auf.
	 * @param model Mithilfe der ModelMap können Variablen aus dem Backend in der View angezeigt werden.
	 * @return index.jsp
	 */
	@GetMapping(value = "")
	public String getIndex(ModelMap model) {
		
		// Die Attribute auf die Seite befüllen
		model.addAttribute("heading", ForumStrings.INDEX_HEADING);
		model.addAttribute("cell1", ForumStrings.INDEX_CELL1);
		model.addAttribute("cell2", ForumStrings.INDEX_CELL2);
		model.addAttribute("cell3", ForumStrings.INDEX_CELL3);
		model.addAttribute("forum", forumService.getContributions());
		return "index";
	}

	/**
	 * Baut die Seite beitrag-erstellen.jsp mit Logik aus dem Backend auf
	 * @param model Mithilfe der ModelMap können Variablen aus dem Backend in der View angezeigt werden.
	 * @return beitrag-erstellen.jsp
	 */
	@GetMapping(value = "/beitrag-erstellen")
	public String createContribution(ModelMap model) {
		model.addAttribute("heading", ForumStrings.CREATE_CONTRIBUTION_HEADING);
		return "beitrag-erstellen";
	}


	/**
	 * Bearbeitet die action aus der HTML-Form auf der Seite beitrag-erstellen.jsp und erstellt einen
	 * neuen Beitrag in der Datenbank.
	 * @param name Name des Erstellers
	 * @param email Email des Erstellers
	 * @param titel Titel des Erstellers
	 * @param inhalt Inhalt des Erstellers
	 * @param model Mithilfe der ModelMap können Variablen aus dem Backend in der View angezeigt werden.
	 * @return beitrag-speichern.jsp
	 */
	@PostMapping(value = "/createPost")
	public String createPostAction(@RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("titel") String titel, @RequestParam("inhalt") String inhalt, ModelMap model) {
		logger.info("Calling Service to create an new Contribution - ForumController.createPostAction");
		forumService
				.createContribution(new ForumeintragDTO(Integer.MAX_VALUE, 0, false, name, email, titel, inhalt, null));
		model.addAttribute("info", ForumStrings.SAVED_CONTRIBUTION_MESSAGE);
		return "beitrag-speichern";
	}

	/**
	 * Zeigt den Beitrag und die Antworten auf beitrag-lesen.jsp an.
	 * @param httpServletRequest Auslese der ID aus dem Link.
	 * @param model Mithilfe der ModelMap können Variablen aus dem Backend in der View angezeigt werden.
	 * @return beitrag-lesen.jsp
	 */
	@GetMapping(value = "/{id}")
	public String readContributionAction(HttpServletRequest httpServletRequest, ModelMap model) {
		logger.info("Calling Service to get certain Contribution by ID- ForumController.readContributionAction");
		ForumeintragDTO forumeintragDTO = forumService.getContribution(
				Integer.parseInt(httpServletRequest.getRequestURL().toString().replace("http://localhost:8080/", "")));

		// Die Attribute auf die Seite befüllen
		model.addAttribute("heading", ForumStrings.READ_CONTRIBUTION_HEADER);
		model.addAttribute("titel", forumeintragDTO.getTitel());
		model.addAttribute("name", forumeintragDTO.getName());
		model.addAttribute("email", forumeintragDTO.getEmail());
		model.addAttribute("zeit", forumeintragDTO.getZeit());
		model.addAttribute("inhalt", forumeintragDTO.getInhalt());
		model.addAttribute("bottomHeading", ForumStrings.READ_CONTRIBUTION_BOTTOM_HEADER);
		model.addAttribute("id", forumeintragDTO.getId());
		
		logger.info("Calling Service to get all answers by ID- ForumController.readContributionAction");
		List<ForumeintragDTO> answers = forumService.getAnswers(forumeintragDTO.getId());
		model.addAttribute("answers", answers);
		
		return "beitrag-lesen";
	}

	/**
	 * Bearbeitung des Links Antworten (Auf Beitrag antworten) auf der Seite betrag-lesen.jsp
	 * @param httpServletRequest Auslese der ID aus dem Link.
	 * @param model Mithilfe der ModelMap können Variablen aus dem Backend in der View angezeigt werden.
	 * @return beitrag-antwort.jsp
	 */
	@GetMapping(value = "/antworten/{id}")
	public String replyContribution(HttpServletRequest httpServletRequest, ModelMap model) {
		model.addAttribute("heading", ForumStrings.REPLAY_CONTRIBUTION_HEADER);
		model.addAttribute("id", Integer.parseInt(
				httpServletRequest.getRequestURL().toString().replace("http://localhost:8080/antworten/", "")));
		return "beitrag-antwort";
	}

	/**
	 * Erstellt eine neue Antwort und speichert diese in der Datenbank ab.
	 * @param name Name des Erstellers
	 * @param email Email des Erstellers
	 * @param titel Titel des Erstellers
	 * @param inhalt Inhalt des Erstellers
	 * @param httpServletRequest Auslese der ID aus dem Link.
	 * @param model Mithilfe der ModelMap können Variablen aus dem Backend in der View angezeigt werden.
	 * @return beitrag-speichern.jsp
	 */
	@PostMapping(value = "/antworten/createAnswer/{id}")
	public String createAnswerAction(@RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("titel") String titel, @RequestParam("inhalt") String inhalt,
			HttpServletRequest httpServletRequest, ModelMap model) {
		forumService.createContribution(new ForumeintragDTO(Integer.MAX_VALUE,
				Integer.parseInt(httpServletRequest.getRequestURL().toString()
						.replace("http://localhost:8080/antworten/createAnswer/", "")),
				true, name, email, titel, inhalt, null));
		model.addAttribute("info", ForumStrings.SAVED_ANWSER_MESSAGE);
		return "beitrag-speichern";
	}
}
