package com.query.QueryApp.model;

public class Player {

	private PlayerDetails details;
	private PlayerAffilations affilations;
	private PlayerStats stats;
	private PlayerTraits traits;

	public PlayerDetails getDetails() {
		return details;
	}

	public void setDetails(PlayerDetails details) {
		this.details = details;
	}

	public PlayerAffilations getAffilations() {
		return affilations;
	}

	public void setAffilations(PlayerAffilations affilations) {
		this.affilations = affilations;
	}

	public PlayerStats getStats() {
		return stats;
	}

	public void setStats(PlayerStats stats) {
		this.stats = stats;
	}

	public PlayerTraits getTraits() {
		return traits;
	}

	public void setTraits(PlayerTraits traits) {
		this.traits = traits;
	}

	@Override
	public String toString() {
		return " details=" + details + ", affilations=" + affilations + ", stats=" + stats
				+ ", traits=" + traits + "]";
	}
	
	
}
