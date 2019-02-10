package com.query.QueryApp.model;

public class PlayerAffilations {

	private String nationality;
	private String flag;
	
	private String club;
	
	private String clubLogo;

	
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
		return " nationality=" + nationality + ", flag=" + flag + ", club=" + club
				+ ", clubLogo=" + clubLogo + "]";
	}
	
	
}
