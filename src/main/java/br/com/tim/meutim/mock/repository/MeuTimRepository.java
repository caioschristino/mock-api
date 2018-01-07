package br.com.tim.meutim.mock.repository;

import javax.transaction.Transactional;

import br.com.tim.meutim.mock.util.HibernateUtil;

public class MeuTimRepository extends HibernateUtil {

	public Object getEntityByToken(String authorization, String entityName) {
		return getEntityManager().createQuery("from " + entityName + " e where e.token = :token")
				.setParameter("token", authorization).getSingleResult();
	}

	@Transactional
	public void create(Object object, String msisdn, Class<?> clazz) {
		this.removeIfExists(msisdn, clazz);
		getEntityManager().persist(object);
		getEntityManager().flush();
	}

	private void removeIfExists(String token, Class<?> clazz) {
		Object savedObject = getEntityManager().find(clazz, token);
		if (savedObject != null) {
			getEntityManager().remove(savedObject);
		}
	}
}
