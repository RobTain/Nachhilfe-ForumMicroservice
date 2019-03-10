package com.fabian.forum.utils;

import org.springframework.stereotype.Component;

/**
 * Diese Klasse exportiert alle Ausgabefelder, welche nicht dynamisch aus der Datenbank generiert werden.
 * @author fabian
 *
 */
@Component
public class ForumStrings {
	
	public final static Integer ADMIN_ANTWORT_ID = 0;
	public final static String ADMIN_NAME = "Admin";
	public final static String ADMIN_EMAIL = "admin@hszg.de";
	public final static String ADMIN_TITEL = "Willkommen";
	public final static String ADMIN_INHALT = "Willkommen im Forum!";

	public final static String INDEX_HEADING = "Kleines Forum";
	public final static String INDEX_CELL1 = "Titel des Beitrags";
	public final static String INDEX_CELL2 = "geschrieben von";
	public final static String INDEX_CELL3 = "geschrieben am";
	
	public final static String CREATE_CONTRIBUTION_HEADING = "Beitrag erstellen";
	
	public final static String SAVED_CONTRIBUTION_MESSAGE = "Vielen Dank f\u00FCr Ihren Beitrag!";
	
	public final static String READ_CONTRIBUTION_HEADER = "Der Beitrag";
	public final static String READ_CONTRIBUTION_BOTTOM_HEADER = "Antworten zum Beitrag";
	
	public final static String REPLAY_CONTRIBUTION_HEADER = "Auf Beitrag antworten";
	
	public final static String SAVED_ANWSER_MESSAGE = "Vielen Dank f\u00FCr Ihre Antwort!";
	
}
