package org.hch.yhw.auction.dao.impl;

import java.util.List;

import org.hch.yhw.auction.dao.BigKindDao;
import org.hch.yhw.auction.model.Bigkind;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BigKindDaoHibernate extends HibernateDaoSupport implements BigKindDao {

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Bigkind bigkind) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Bigkind> findAll() {
		// TODO Auto-generated method stub
		return  (List<Bigkind>)getHibernateTemplate().find("from Bigkind");
		
	}

	@Override
	public Bigkind get(Integer id) {
		// TODO Auto-generated method stub
		return (Bigkind)getHibernateTemplate().get(Bigkind.class,id);
	}

	@Override
	public void save(Bigkind bigkind) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(bigkind);
	}

	@Override
	public void update(Bigkind bigkind) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(bigkind);
	}

}
