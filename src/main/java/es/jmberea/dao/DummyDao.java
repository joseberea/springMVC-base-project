package es.jmberea.dao;

import java.io.Serializable;
import java.util.List;

import es.jmberea.vo.DummyVO;
import exception.DaoException;

public interface DummyDao {
	public List<DummyVO> selectAll() throws DaoException;
	
	public DummyVO selectById(Serializable id) throws DaoException;
}
