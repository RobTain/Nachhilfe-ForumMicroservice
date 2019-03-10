package com.fabian.forum.DTO;

import java.time.LocalDateTime;

/**
 * Datentransfer-Object zu dem Model aus dem MVC-Pattern.
 * 
 * @author fabian
 *
 */
public class ForumeintragDTO {

	public ForumeintragDTO() {

	}

	public ForumeintragDTO(Integer id, Integer antwort_id, boolean antwort, String name, String email, String titel,
			String inhalt, LocalDateTime zeit) {
		super();
		this.id = id;
		this.antwort_id = antwort_id;
		this.antwort = antwort;
		this.name = name;
		this.email = email;
		this.titel = titel;
		this.inhalt = inhalt;
		this.zeit = zeit;
	}

	private Integer id;

	private Integer antwort_id;

	private boolean antwort;

	private String name;

	private String email;

	private String titel;

	private String inhalt;

	private LocalDateTime zeit;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAntwort_id() {
		return antwort_id;
	}

	public void setAntwort_id(Integer antwort_id) {
		this.antwort_id = antwort_id;
	}

	public boolean isAntwort() {
		return antwort;
	}

	public void setAntwort(boolean antwort) {
		this.antwort = antwort;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getInhalt() {
		return inhalt;
	}

	public void setInhalt(String inhalt) {
		this.inhalt = inhalt;
	}

	public LocalDateTime getZeit() {
		return zeit;
	}

	public void setZeit(LocalDateTime zeit) {
		this.zeit = zeit;
	}

}
