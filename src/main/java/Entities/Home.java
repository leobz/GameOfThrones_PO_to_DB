package Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import Entities.MilitaryForce.MilitaryForce;
import Entities.Place.Place;

@Entity
public class Home implements Foundable {
	@Id
	@GeneratedValue
	private int id;

	private String name;
	private int patrimony;
	private int fundationYear;

	@ManyToOne
	Place place;
	@OneToMany
	MilitaryForce militaryForce;

	public String originPlaceName() {
		// TODO
		return "";
	}

	@Override
	public int fundationYear() {
		// TODO
		return 0;
	}

}
