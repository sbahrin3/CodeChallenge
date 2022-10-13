package my.data.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author Shamsul Bahrin
 *
 */

@Entity
@Table(name="state")
public class State {
	
	@Id @Column(length=50)
	private String id;
	@Column(length=100)
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="state")
	private List<District> districts;
	
	@ManyToOne
	private Country country;
	
	public State() {
		setId(UIDGenerator.getUID());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<District> getDistricts() {
		return districts;
	}

	public void setDistricts(List<District> districts) {
		this.districts = districts;
	}
	
	

}
