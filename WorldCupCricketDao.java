package com.TKA.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.TKA.entity.CricketStaff;

@Repository
public class WorldCupCricketDao {
	@Autowired
	SessionFactory factory;
	
	public List<CricketStaff> allIndianCricketStaffList()
	{
		Session session = factory.openSession();
		
		Criteria criteria =session.createCriteria(CricketStaff.class);
		List<CricketStaff> staffList =criteria.list();
		return staffList;
	}

	
	//*******************************
		//To Send data Client to Server By Using PostMan   Step3
	public void insertCricketStaffdetail(CricketStaff staff) {
		
		 Session session = factory.openSession();
		 
		 Transaction tx = session.beginTransaction();
		 
		 session.save(staff);
		 tx.commit();
		 
	}


	public void updateCricketStaffdetail(CricketStaff staff) {
		
		Session session = factory.openSession();
		 
		 Transaction tx = session.beginTransaction();
		 
		 session.update(staff);
		 tx.commit();
		 
	}

}
