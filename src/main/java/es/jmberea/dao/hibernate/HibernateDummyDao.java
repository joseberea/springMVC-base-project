package es.jmberea.dao.hibernate;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.jmberea.dao.DummyDao;
import es.jmberea.entity.Dummy;
import es.jmberea.vo.DummyVO;

@Transactional
@Repository
public class HibernateDummyDao extends AbstractHibernateBaseDao<Dummy, DummyVO> implements DummyDao {

	public HibernateDummyDao() {
		super(Dummy.class, DummyVO.class);
	}
}
