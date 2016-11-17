package es.jmberea.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class HibernateBaseDao<ENTITY, VO> {

	@PersistenceContext
    protected EntityManager entityManager;

	@Autowired
	DozerBeanMapper mapperPersistencia;

	private Class<VO> voClass;

	private Class<ENTITY> entityClass;

	public HibernateBaseDao(Class<ENTITY> entityClass, Class<VO> voClass) {
		this.voClass = voClass;
		this.entityClass = entityClass;
	}

	protected VO toVO(ENTITY entity) {
		return mapperPersistencia.map(entity, voClass);
	}

	protected List<VO> toVO(List<ENTITY> entities) throws Exception {
		List<VO> vos = null;

		if (entities != null) {
			vos = new ArrayList<VO>();
			for (ENTITY entity : entities)
				vos.add(toVO(entity));
		}

		return vos;
	}

	protected ENTITY toENTITY(VO vo) {
		return mapperPersistencia.map(vo, entityClass);
	}

	protected List<ENTITY> toENTITY(List<VO> vos) throws Exception {
		List<ENTITY> entities = null;

		if (vos != null) {
			entities = new ArrayList<ENTITY>();
			for (VO vo : vos)
				entities.add(toENTITY(vo));
		}

		return entities;
	}
}
