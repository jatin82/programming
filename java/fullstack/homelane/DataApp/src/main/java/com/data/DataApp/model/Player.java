package com.data.DataApp.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Player")
public class Player {

	public static int property = 64;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@NotNull
	@Column(name="id")
	@JsonIgnore
	private long id;
	
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne( cascade= {CascadeType.MERGE,CascadeType.PERSIST})
	@JoinColumn(name="player_details_id", nullable = false)
	private PlayerDetails details;
	
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne( cascade= {CascadeType.MERGE,CascadeType.PERSIST})
	@JoinColumn(name="player_affilations_id", nullable = false)
	private PlayerAffilations affilations;
	
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne( cascade= {CascadeType.MERGE,CascadeType.PERSIST})
	@JoinColumn(name="player_stats_id", nullable = false)
	private PlayerStats stats;
	
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne( cascade= {CascadeType.MERGE,CascadeType.PERSIST})
	@JoinColumn(name="player_traits_id", nullable = false)
	private PlayerTraits traits;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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
		return "Player [id=" + id + ", details=" + details + ", affilations=" + affilations + ", stats=" + stats
				+ ", traits=" + traits + "]";
	}
	
	
}
