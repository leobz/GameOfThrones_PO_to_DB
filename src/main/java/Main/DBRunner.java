package Main;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

public class DBRunner {
	static void inicializateDB() {
		final EntityManager entityManager = PerThreadEntityManagers.getEntityManager();
		final EntityTransaction transaction = entityManager.getTransaction();
	}


}
