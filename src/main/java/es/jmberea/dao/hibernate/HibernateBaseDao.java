package es.jmberea.dao.hibernate;

import java.io.Serializable;
import java.util.List;

/**
 * Interface dao base Hibernate 4 de la capa de persistencia.
 *
 * @author  SIGE
 * @version 1.0.0
 */
public interface HibernateBaseDao<ENTITY, VO> {

	public List<VO> selectAll() throws Exception;
	
	public List<VO> selectAll(String sortFieldName, boolean asc) throws Exception;
	
	public VO selectById(Serializable id) throws Exception;
	
	public List<VO> selectByField(String field, String fieldValue) throws Exception;

	public VO insert(VO vo) throws Exception;
	
	public List<VO> insert(List<VO> vos) throws Exception;
	
	public void update(VO vo) throws Exception;

	public void delete(VO vo) throws Exception;
	
	public void deleteById(Serializable id) throws Exception;
	
	public int delete(List<VO> vos) throws Exception;
}
