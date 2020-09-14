package Entities.MilitaryForce;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import Entities.Place.Place;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class MilitaryForce {
	void atack_to(Place place) {
	}
}
