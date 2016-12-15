package es.jmberea.dao.hibernate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;

import exception.DaoException;

public abstract class AbstractHibernateBaseDao<ENTITY, VO> implements HibernateBaseDao<ENTITY, VO> {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	private Class<VO> voClass;

	private Class<ENTITY> entityClass;

	@PersistenceContext
	protected EntityManager entityManager;

	@Autowired
	protected DozerBeanMapper mapperPersistencia;

	public AbstractHibernateBaseDao(Class<ENTITY> entityClass, Class<VO> voClass) {
		this.voClass = voClass;
		this.entityClass = entityClass;
	}

	public String getEntityClassName() {
		return entityClass.getSimpleName();
	}

	public List<VO> selectAll() throws DaoException {
		List<VO> result = null;

		try {
			CriteriaBuilder builder = entityManager.getCriteriaBuilder();
			CriteriaQuery<ENTITY> criteria = builder.createQuery(entityClass);

			Root<ENTITY> root = criteria.from(entityClass);
			criteria.select(root);

			result = toVo(entityManager.createQuery(criteria).getResultList());
		} catch (Exception e) {
			throw new DaoException("Error fetching all entities", e);
		}
		
		return result;
	}

	public List<VO> selectAll(String sortFieldName, boolean asc) throws DaoException {
		List<VO> result = null;

		try {
			CriteriaBuilder builder = entityManager.getCriteriaBuilder();
			CriteriaQuery<ENTITY> criteria = builder.createQuery(entityClass);

			Root<ENTITY> root = criteria.from(entityClass);
			criteria.select(root);
			criteria.orderBy(asc ? builder.asc(root.get(sortFieldName)) : builder.desc(root.get(sortFieldName)));

			result = toVo(entityManager.createQuery(criteria).getResultList());
		} catch (Exception e) {
			throw new DaoException("Error fetching all entities order by " + sortFieldName + (asc ? "asc" : "desc"), e);
		}
		
		return result;
	}

	public VO selectById(Serializable id) throws DaoException {
		VO result = null;

		if (id == null) {
			throw new DaoException("Null entity id '" + getEntityClassName() + "'");
		}

		try {
			ENTITY entity = entityManager.find(entityClass, id);

			result = toVo(entity);
		} catch (Exception e) {
			throw new DaoException("Error fetching entities by id", e);
		}

		return result;
	}

	public List<VO> selectByField(String field, String fieldValue) throws DaoException {
		List<VO> result = null;

		if (field == null) {
			throw new DaoException("Null entity field '" + field + "':'" + getEntityClassName() + "'");
		}

		try {
			CriteriaBuilder builder = entityManager.getCriteriaBuilder();
			CriteriaQuery<ENTITY> criteria = builder.createQuery(entityClass);

			Root<ENTITY> root = criteria.from(entityClass);
			criteria.select(root);
			criteria.where(builder.equal(root.get(field), fieldValue));

			result = toVo(entityManager.createQuery(criteria).getResultList());
		} catch (Exception e) {
			throw new DaoException("Error fetching entities by field " + field, e);
		}

		return result;
	}

	public VO insert(VO vo) throws DaoException {
		VO result = null;
		if (vo == null) {
			throw new DaoException("Null entity '" + getEntityClassName() + "'");
		}

		try {
			ENTITY entity = toEntity(vo);
			entityManager.persist(entity);
			entityManager.flush();

			result = toVo(entity);
		} catch (Exception e) {
			throw new DaoException("Error saving entity '" + getEntityClassName() + "'", e);
		}

		return result;
	}

	public List<VO> insert(List<VO> vos) throws DaoException {
		List<VO> result = null;
		if (vos == null) {
			throw new DaoException("Null entity collection '" + getEntityClassName() + "'");
		}

		result = new ArrayList<VO>();
		for (VO vo : vos) {
			result.add(insert(vo));
		}

		return result;
	}

	public void update(VO vo) throws DaoException {
		if (vo == null) {
			throw new DaoException("Null entity '" + getEntityClassName() + "'");
		}

		ENTITY entity = toEntity(vo);
		entityManager.merge(entity);

		entityManager.flush();
	}

	public void delete(VO vo) throws DaoException {
		if (vo == null) {
			throw new DaoException("Null entity '" + getEntityClassName() + "'");
		}

		ENTITY entity = toEntity(vo);
		entityManager.remove(entity);
		entityManager.flush();
	}

	public void deleteById(Serializable id) throws DaoException {
		if (id == null) {
			throw new DaoException("Null entity id '" + getEntityClassName() + "'");
		}
		delete(selectById(id));
	}

	public int delete(List<VO> vos) throws DaoException {
		if (vos == null) {
			throw new DaoException("Null entity collection '" + getEntityClassName() + "'");
		}
		for (VO vo : vos) {
			delete(vo);
		}

		return vos.size();
	}

	protected VO toVo(ENTITY entity) throws DaoException {
		if (entity != null) {
			return (VO) mapperPersistencia.map(entity, voClass);
		}

		return null;
	}

	protected List<VO> toVo(List<ENTITY> entities) throws DaoException {
		List<VO> vos = null;

		if (entities != null) {
			vos = new ArrayList<VO>();
			for (ENTITY entity : entities)
				vos.add(toVo(entity));
		}

		return vos;
	}

	protected ENTITY toEntity(VO vo) throws DaoException {
		if (vo != null) {
			return (ENTITY) mapperPersistencia.map(vo, entityClass);
		}

		return null;
	}

	protected List<ENTITY> toEntity(List<VO> vos) throws DaoException {
		List<ENTITY> entities = null;

		if (vos != null) {
			entities = new ArrayList<ENTITY>();
			for (VO vo : vos)
				entities.add(toEntity(vo));
		}

		return entities;
	}
}
