package org.hch.yhw.auction.dao.impl;

import java.util.List;

import org.hch.yhw.auction.dao.OrderiDao;
import org.hch.yhw.auction.model.Orderi;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class OrderiDaoHibernate extends HibernateDaoSupport implements OrderiDao{

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(get(id));
	}

	@Override
	public void delete(Orderi orderi) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(orderi);
	}

	@SuppressWarnings("unchecked")
	@Override
	
	public List<Orderi> findAll() {
		// TODO Auto-generated method stub
		return (List<Orderi>)getHibernateTemplate()
		.find("from Orderi");
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Orderi> findByMember(Integer userId) {
		// TODO Auto-generated method stub
		return (List<Orderi>)getHibernateTemplate()
		.find("from Orderi as o where o.auctionUser.id = ? order by o.createtime desc ",userId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Orderi> findBySign(boolean flag) {

		return (List<Orderi>)getHibernateTemplate()
		.find("from Orderi as o where o.sign = ?",flag);
	}

	@Override
	public Orderi get(Integer id) {
		// TODO Auto-generated method stub
		
		return (Orderi)getHibernateTemplate().get(Orderi.class, id);
	}

	@Override
	public void save(Orderi orderi) {
		getHibernateTemplate().save(orderi);
		
	}

	@Override
	public void update(Orderi orderi) {
		getHibernateTemplate().update(orderi);
		
		
	}
  public Orderi findByOrderi(String orderId){
	  return  (Orderi)getHibernateTemplate()
	  .find("from Orderi as o where o.orderiid=?", orderId).get(0);
	  
	  
  }
}
