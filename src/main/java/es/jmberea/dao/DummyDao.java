package es.jmberea.dao;

import java.util.List;

import es.jmberea.vo.DummyVO;

public interface DummyDao {
	public List<DummyVO> selectAll() throws Exception;
}
