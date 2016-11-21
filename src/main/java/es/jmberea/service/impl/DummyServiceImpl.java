package es.jmberea.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.jmberea.dao.DummyDao;
import es.jmberea.service.DummyService;
import es.jmberea.vo.DummyVO;
import exception.DaoException;
import exception.ServiceException;

@Service("dummyService")
public class DummyServiceImpl implements DummyService {

	@Autowired
	private DummyDao dummyDao;
	
	public List<DummyVO> getAll() throws ServiceException {
		try {
			return dummyDao.selectAll();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}
	
	public DummyVO getById(Serializable id) throws ServiceException {
		try {
			return dummyDao.selectById(id);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

}
