package com.dump.Dump.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Entity
public class PlayerTraits {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@NotNull
	@Column(name="player_traits_id")
	private long id;
	
	private String preferredPositioning;
	private String aggression;
	private String agility;
	private String balance;
	private String ballControl;
	private String composure;
	public long getId() {
		return id;
	}
	
	public String getPreferredPositioning() {
		return preferredPositioning;
	}

	public void setPreferredPositioning(String preferredPositioning) {
		this.preferredPositioning = preferredPositioning;
	}

	public String getAggression() {
		return aggression;
	}

	public void setAggression(String aggression) {
		this.aggression = aggression;
	}

	public String getAgility() {
		return agility;
	}

	public void setAgility(String agility) {
		this.agility = agility;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String getBallControl() {
		return ballControl;
	}

	public void setBallControl(String ballControl) {
		this.ballControl = ballControl;
	}

	public String getComposure() {
		return composure;
	}

	public void setComposure(String composure) {
		this.composure = composure;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "PlayerTraits [id=" + id + ", preferredPositioning=" + preferredPositioning + ", aggression="
				+ aggression + ", agility=" + agility + ", balance=" + balance + ", ball=" + ballControl  + ", composure=" + composure + "]";
	}
	
}
