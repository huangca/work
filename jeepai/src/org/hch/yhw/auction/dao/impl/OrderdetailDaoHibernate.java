package org.hch.yhw.auction.dao.impl;

import java.util.List;

import org.hch.yhw.auction.dao.OrderdetailDao;
import org.hch.yhw.auction.model.Orderdetail;
import org.hch.yhw.auction.model.Orderyi;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class OrderdetailDaoHibernate extends HibernateDaoSupport implements OrderdetailDao {

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(get(id));
	}

	@Override
	public void delete(Orderdetail orderyi) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(orderyi);
	}

	@Override
	public List<Orderdetail> findAll() {
		// TODO Auto-generated method stub
		return	(List<Orderdetail>)getHibernateTemplate()
		.find("from Orderdetail");
	}

	@Override
	public List<Orderdetail> findByOrderyi(Integer orderyiid) {
		// TODO Auto-generated method stub
		return	(List<Orderdetail>)getHibernateTemplate()
		.find("from Orderdetail as od where od.orderyi.orderId = ?",orderyiid );
	
	}

	@Override
	public Orderdetail get(Integer id) {
		// TODO Auto-generated method stub
		return (Orderdetail)getHibernateTemplate().get(Orderdetail.class, id);
	}

	@Override
	public void save(Orderdetail orderyi) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(orderyi);

	}

	@Override
	public void update(Orderdetail orderyi) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(orderyi);
	}

}
