package es.jmberea.dao.hibernate;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.jmberea.dao.DummyDao;
import es.jmberea.entity.Dummy;
import es.jmberea.vo.DummyVO;

@Transactional
@Repository
public class HibernateDummyDao extends HibernateBaseDao<Dummy, DummyVO> implements DummyDao {

	public HibernateDummyDao() {
		super(Dummy.class, DummyVO.class);
	}
	
	@Override
	public List<DummyVO> selectAll() throws Exception {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Dummy> criteria = builder.createQuery( Dummy.class );
		
		Root<Dummy> root = criteria.from( Dummy.class );
		criteria.select( root );
		criteria.where( builder.equal( root.get( "description" ), "dummy1" ) );

		List<Dummy> l = entityManager.createQuery( criteria ).getResultList();
		
		return toVO(l);
	}

}
