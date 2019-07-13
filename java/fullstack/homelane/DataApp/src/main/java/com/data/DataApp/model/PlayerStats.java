package com.data.DataApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PlayerStats {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@NotNull
	@Column(name="player_stats_id")
	@JsonIgnore
	private long id;
	
	
	private String shotPower; 
	private String slidingTackle;
	private String sprintSpeed;
	private String stamina;
	private String standingTackle;
	private String strength;
	private String vision;
	private String headingAccuracy;
	private String interceptions;
	private String jumping;
	private String longPassing;
	private String longShots;
	private String marking;
	private String penalties;
	private String freeKickAccuracy;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getShotPower() {
		return shotPower;
	}
	public void setShotPower(String shotPower) {
		this.shotPower = shotPower;
	}
	public String getSlidingTackle() {
		return slidingTackle;
	}
	public void setSlidingTackle(String slidingTackle) {
		this.slidingTackle = slidingTackle;
	}
	public String getSprintSpeed() {
		return sprintSpeed;
	}
	public void setSprintSpeed(String sprintSpeed) {
		this.sprintSpeed = sprintSpeed;
	}
	public String getStamina() {
		return stamina;
	}
	public void setStamina(String stamina) {
		this.stamina = stamina;
	}
	public String getStandingTackle() {
		return standingTackle;
	}
	public void setStandingTackle(String standingTackle) {
		this.standingTackle = standingTackle;
	}
	public String getStrength() {
		return strength;
	}
	public void setStrength(String strength) {
		this.strength = strength;
	}
	public String getVision() {
		return vision;
	}
	public void setVision(String vision) {
		this.vision = vision;
	}
	public String getHeadingAccuracy() {
		return headingAccuracy;
	}
	public void setHeadingAccuracy(String headingAccuracy) {
		this.headingAccuracy = headingAccuracy;
	}
	public String getInterceptions() {
		return interceptions;
	}
	public void setInterceptions(String interceptions) {
		this.interceptions = interceptions;
	}
	public String getJumping() {
		return jumping;
	}
	public void setJumping(String jumping) {
		this.jumping = jumping;
	}
	public String getLongPassing() {
		return longPassing;
	}
	public void setLongPassing(String longPassing) {
		this.longPassing = longPassing;
	}
	public String getLongShots() {
		return longShots;
	}
	public void setLongShots(String longShots) {
		this.longShots = longShots;
	}
	public String getMarking() {
		return marking;
	}
	public void setMarking(String marking) {
		this.marking = marking;
	}
	public String getPenalties() {
		return penalties;
	}
	public void setPenalties(String penalties) {
		this.penalties = penalties;
	}
	public String getFreeKickAccuracy() {
		return freeKickAccuracy;
	}
	public void setFreeKickAccuracy(String freeKickAccuracy) {
		this.freeKickAccuracy = freeKickAccuracy;
	}
	@Override
	public String toString() {
		return "PlayerStats [id=" + id + ", shotPower=" + shotPower + ", slidingTackle=" + slidingTackle
				+ ", sprintSpeed=" + sprintSpeed + ", stamina=" + stamina + ", standingTackle=" + standingTackle
				+ ", strength=" + strength + ", vision=" + vision + ", headingAccuracy=" + headingAccuracy
				+ ", interceptions=" + interceptions + ", jumping=" + jumping + ", longPassing=" + longPassing
				+ ", longShots=" + longShots + ", marking=" + marking + ", penalties=" + penalties
				+ ", freeKickAccuracy=" + freeKickAccuracy + "]";
	}
	
	
}
