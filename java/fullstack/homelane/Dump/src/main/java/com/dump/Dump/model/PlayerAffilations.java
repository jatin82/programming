package com.dump.Dump.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class PlayerAffilations {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@NotNull
	@Column(name="player_affilations_id")
	private long id;
	
	@JsonProperty("nationality")
	@Column(name="nationality")
	@NotNull
	private String nationality;
	
	@JsonProperty("flag")
	@Column(name="flag")
	@NotNull
	private String flag;
	
	@JsonProperty("club")
	@Column(name="club")
	@NotNull
	private String club;
	
	@JsonProperty("clubLogo")
	@Column(name="clubLogo")
	@NotNull
	private String clubLogo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	public String getClubLogo() {
		return clubLogo;
	}

	public void setClubLogo(String clubLogo) {
		this.clubLogo = clubLogo;
	}

	@Override
	public String toString() {
		return "PlayerAffilations [id=" + id + ", nationality=" + nationality + ", flag=" + flag + ", club=" + club
				+ ", clubLogo=" + clubLogo + "]";
	}
	
	
}
