package com.data.DataApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class PlayerDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@NotNull
	@Column(name="player_details_id")
	@JsonIgnore
	private long id;
	
	@JsonProperty("name")
	@Column(name="name")
	@NotNull
	private String name;
	
	@JsonProperty("age")
	@Column(name="age")
	@NotNull
	private int age;
	
	@JsonProperty("photo")
	@Column(name="photo")
	@NotNull
	private String photo;
	
	@JsonProperty("value")
	@Column(name="value")
	@NotNull
	private String value;
	
	@JsonProperty("wage")
	@Column(name="wage")
	@NotNull
	private String wage;
	
	@JsonProperty("potential")
	@Column(name="potential")
	@NotNull
	private long potential;
	
	@JsonProperty("overall")
	@Column(name="overall")
	@NotNull
	private long overall;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getWage() {
		return wage;
	}

	public void setWage(String wage) {
		this.wage = wage;
	}

	public long getPotential() {
		return potential;
	}

	public void setPotential(long potential) {
		this.potential = potential;
	}

	public long getOverall() {
		return overall;
	}

	public void setOverall(long overall) {
		this.overall = overall;
	}

	@Override
	public String toString() {
		return "PlayerDetails [id=" + id + ", name=" + name + ", age=" + age + ", photo=" + photo + ", value=" + value
				+ ", wage=" + wage + ", potential=" + potential + ", overall=" + overall + "]";
	}
	
	
}
