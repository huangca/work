package org.hch.yhw.auction.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.hch.yhw.auction.business.*;
import org.hch.yhw.auction.dao.*;
import org.hch.yhw.auction.model.*;
public class AdminDaoHibernate extends HibernateDaoSupport implements AdminDao{

	@Override
	public void delete(Admin user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Admin findAdminByNameAndPass(String username, String pass) {
		// TODO Auto-generated method stub
		
		List<Admin> ul=(List<Admin>)getHibernateTemplate()
		.find("from Admin a where a.username = ? and a.password = ?" ,
		new String[]{username , pass});
		//返回查询得到的第一个AuctionUser对象
		if (ul.size() == 1)
		{
			return (Admin)ul.get(0);
		}
		return null;
	}

	@Override
	public List<Admin> findAll() {
		// TODO Auto-generated method stub
		return (List<Admin>)getHibernateTemplate().find("from Admin");
	}

	@Override
	public Admin get(Integer id) {
		// TODO Auto-generated method stub
		return (Admin)getHibernateTemplate().get(Admin.class,id);
	}

	@Override
	public void save(Admin admin) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(admin);
		
	}

	@Override
	public void update(Admin user) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(user);
	}

}
