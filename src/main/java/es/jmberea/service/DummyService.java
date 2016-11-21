package es.jmberea.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

import es.jmberea.vo.DummyVO;
import exception.ServiceException;

@Component("dummyService")
public interface DummyService {
	public List<DummyVO> getAll() throws ServiceException;
	
	public DummyVO getById(Serializable id) throws ServiceException;
}
