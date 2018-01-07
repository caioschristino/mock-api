package br.com.tim.meutim.mock.util;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.transaction.UserTransaction;

public class HibernateUtil {

	@PersistenceContext(type = PersistenceContextType.TRANSACTION)
	private EntityManager entityManager;

	@Resource
	private UserTransaction userTransaction;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public UserTransaction getUserTransaction() {
		return userTransaction;
	}

}
