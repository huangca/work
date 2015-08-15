package org.hch.yhw.auction.dao.impl;

import java.util.List;

import org.hch.yhw.auction.dao.OrderyiDao;
import org.hch.yhw.auction.model.AuctionUser;
import org.hch.yhw.auction.model.Orderyi;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class OrderyiDaoHibernate extends HibernateDaoSupport implements OrderyiDao {

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(get(id));
	}
	@SuppressWarnings("unchecked")
	@Override
	public void delete(Orderyi orderyi) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(orderyi);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Orderyi> findAll() {
		// TODO Auto-generated method stub
		return (List<Orderyi>)getHibernateTemplate()
		.find("from Orderyi");
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Orderyi> findByMember(Integer userId) {
		// TODO Auto-generated method stub
		return (List<Orderyi>)getHibernateTemplate()
		.find("from Orderyi as o where o.auctionUser.id = ?",userId);
	
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Orderyi> findBySign(boolean flag) {
		// TODO Auto-generated method stub
		return (List<Orderyi>)getHibernateTemplate()
		.find("from Orderyi as o where o.sign = ?",flag);
	
	}

	@Override
	public Orderyi get(Integer id) {
		// TODO Auto-generated method stub
		return (Orderyi)getHibernateTemplate().get(Orderyi.class,id);

	}

	@Override
	public void save(Orderyi orderyi) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(orderyi);
	}

	@Override
	public void update(Orderyi orderyi) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(orderyi);
	}
	
	//¸ù¾ÝorderyiidËÑ¶©µ¥
	public Orderyi findByOrderyiid(String Orderyiid)
	{
		try{
		return (Orderyi)getHibernateTemplate()
		.find("from Orderyi as o where o.orderyiid = ?",Orderyiid).get(0);
		}catch(Exception e){e.printStackTrace();
		return null;
		}
		}

}
