package es.jmberea.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.jmberea.dao.DummyDao;
import es.jmberea.service.DummyService;
import es.jmberea.vo.DummyVO;

@Service("dummyService")
public class DummyServiceImpl implements DummyService {

	@Autowired
	private DummyDao dummyDao;
	
	@Override
	public List<DummyVO> getAll() throws Exception {
		return dummyDao.selectAll();
	}

}
