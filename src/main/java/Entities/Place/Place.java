package Entities.Place;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Place {
	@Id
	@GeneratedValue
	private int id;

	private String name;
	private int fundationYear;
	private int population;
}
