package br.com.tim.meutim.mock.facade;

public interface MeuTimFacade {

	Object getEntityByToken(String authorization, String entityName);

	void create(Object object, String msisdn, Class<?> clazz);

}
