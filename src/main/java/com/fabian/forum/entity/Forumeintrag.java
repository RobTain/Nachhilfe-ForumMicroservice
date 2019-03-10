
package com.fabian.forum.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Model des MVC Pattern
 * @author robsoft
 *
 */
@Entity(name = "FORUM_DB")
@Table(name = "FORUM")
public class Forumeintrag {

	public Forumeintrag(Integer id, Integer antwort_id, boolean antwort, String name, String email, String titel, String inhalt,
			LocalDateTime zeit) {
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

	Forumeintrag() {
		
	}
	
	
	
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer id;
	@Column(name = "ANTWORT_ID")
	private Integer antwort_id;
	@Column(name = "ANTWORT")
	private boolean antwort;
	@Column(name = "NAME")
	private String name;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "TITEL")
	private String titel;
	@Column(name = "INHALT")
	private String inhalt;
	@Column(name = "ZEIT")
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
