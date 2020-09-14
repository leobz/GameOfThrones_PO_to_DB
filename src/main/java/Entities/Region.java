package Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import Entities.Place.Casttle;
import Entities.Place.City;
import Entities.Place.Place;

@Entity
public class Region extends Foundable {

	@Id
	@GeneratedValue
	private int id;

	@ManyToMany
	List<Place> place = new ArrayList<Place>();

	String name;

	@ManyToMany
	public List<Casttle> casttles() {
		// TODO
		return new ArrayList<Casttle>();
	}
	@ManyToMany
	public List<City> cities() {
		// TODO
		return new ArrayList<City>();
	}

	@Override
	public int fundationYear() {
		// TODO
		return 0;
	}

}
