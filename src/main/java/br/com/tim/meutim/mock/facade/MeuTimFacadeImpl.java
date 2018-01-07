package br.com.tim.meutim.mock.facade;

import javax.inject.Inject;

import br.com.tim.meutim.mock.repository.MeuTimRepository;

public class MeuTimFacadeImpl implements MeuTimFacade {

	@Inject
	MeuTimRepository meuTimRepository;

	@Override
	public Object getEntityByToken(String authorization, String entityName) {
		return meuTimRepository.getEntityByToken(authorization, entityName);
	}

	@Override
	public void create(Object object, String msisdn, Class<?> clazz) {
		meuTimRepository.create(object, msisdn, clazz);
	}

}
