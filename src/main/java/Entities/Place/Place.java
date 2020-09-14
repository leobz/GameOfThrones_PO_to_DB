package Entities.Place;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Place {
	@Id
	@GeneratedValue
	private int id;

	private String name;
	private int fundationYear;
	private int population;
}
