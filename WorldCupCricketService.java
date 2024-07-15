package com.TKA.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.TKA.Dao.WorldCupCricketDao;
import com.TKA.entity.CricketStaff;

@Service
public class WorldCupCricketService {
	
	@Autowired
	WorldCupCricketDao dao;
	
	public List<CricketStaff> fetchallstaff()
	{
      List<CricketStaff> allstaffList=dao.allIndianCricketStaffList();
		return allstaffList;
	}
	
	// No of count Medical department
	
	public int fetchMedicalDeptCount()
	{
		List<CricketStaff> allstafflist= dao.allIndianCricketStaffList();
		
		ArrayList<CricketStaff> servicestaff =new ArrayList<>();
		for(CricketStaff staff:allstafflist)
		{
			if(staff.getStaffDept().equals("service"))
			{
				servicestaff.add(staff);
			}
		}
		return servicestaff.size();
	}
	
	//Fetch Name with age of all staff
	
	public HashMap<String,Integer> fetchStaffNamewithAge()
	{
		List<CricketStaff> allstafflist= dao.allIndianCricketStaffList();
		
		HashMap<String,Integer> nameWithAgeStaff =new HashMap<>();
		for(CricketStaff staff : allstafflist)
		{
			nameWithAgeStaff.put(staff.getStaffName(),staff.getStaffAge());
		}
		return nameWithAgeStaff;
	}
	
    //All Player Name Whose Start with p
	
	public List<String> getNameStartWithp()
	{
		List<CricketStaff> allstafflist= dao.allIndianCricketStaffList();
		
		ArrayList<String> cricektstaff =new ArrayList<>();
		for(CricketStaff staff:allstafflist)
		{
			if(staff.getStaffName().startsWith("p"))
			{
				 cricektstaff.add(staff.getStaffName());
			}
		}
		return  cricektstaff;
	}
	
	//All Player Name who are below age 40
	
	public List<String> getNamewhoBelowAge40()
	{
		List<CricketStaff> allstafflist= dao.allIndianCricketStaffList();
		
		ArrayList<String> cricektstaff =new ArrayList<>();
		for(CricketStaff staff:allstafflist)
		{
			if(staff.getStaffAge()<40)
			{
				 cricektstaff.add(staff.getStaffName());
			}
		}
		return  cricektstaff;
	}
	
	// Fetch Only the Medical Dept
	
	public ArrayList<String> getNameSerciceDept()
	{
		List<CricketStaff> allstafflist= dao.allIndianCricketStaffList();
		
		ArrayList<String> servicestaff =new ArrayList<>();
		for(CricketStaff staff:allstafflist)
		{
			if(staff.getStaffDept().equals("service"))
			{
				servicestaff.add(staff.getStaffName());
			}
		}
		return servicestaff;
	}
	
	//Addition of exp Year of Player dept
	
	public int getSumOfExpOfPlayerDept()
	{
		List<CricketStaff> allstafflist= dao.allIndianCricketStaffList();
		
		int addexperiance =0;
	//	ArrayList<CricketStaff> servicestaff =new ArrayList<>();
		for(CricketStaff staff:allstafflist)
		{
			if(staff.getStaffDept().equals("player"))
			{
				addexperiance = addexperiance + staff.getNoofYeartoBCCI();
			}
		}
		return addexperiance;
	}
	
	//All Player Name Whose exp is more than 10
	
	public List<String> getNameWhoseExpMorethan10()
	{
		List<CricketStaff> allstafflist= dao.allIndianCricketStaffList();
		
		ArrayList<String> cricektstaff =new ArrayList<>();
		for(CricketStaff staff:allstafflist)
		{
			if(staff.getStaffAge()>10)
			{
				 cricektstaff.add(staff.getStaffName());
			}
		}
		return  cricektstaff;
	}
	
	//To Fetch Most Exp Player Name of Cricket
	
	public ArrayList<String> getMostExpPlayerName()
	{
		List<CricketStaff> allstafflist= dao.allIndianCricketStaffList();
		
		
	ArrayList<String> servicestaff =new ArrayList<>();
	 
	int max =0;
		for(CricketStaff staff:allstafflist)
		{
			if(max< staff.getNoofYeartoBCCI())
			{
			max = staff.getNoofYeartoBCCI();	
			}
		}
		
		for(CricketStaff staff:allstafflist)
		{
			if(max == staff.getNoofYeartoBCCI())
			{
				servicestaff.add(staff.getStaffName());	
			}
		}
		
		return servicestaff;
	}
     //*******************************
	//To Send data Client to Server By Using PostMan   Step2
	public void insertCricketStaffdetail(CricketStaff staff) {
		
		dao.insertCricketStaffdetail(staff);
		
	}
	
	//To Update data form Client to Server By Using PostMan  Step2
	public void updateCricketStaffdetail(CricketStaff staff) {
		dao.updateCricketStaffdetail(staff);
	}
	
	//Use @pathvarible to fetch No.of record on database asper Your
		//Dept requriment
		//Most Use in Industry
		//Only work on controller and service layer  step 2
	public int fetchALlStaffasPerDept(String deptName)
	{
        List<CricketStaff> allstafflist= dao.allIndianCricketStaffList();
		
		ArrayList<CricketStaff> servicestaff =new ArrayList<>();
		for(CricketStaff staff:allstafflist)
		{
			if(staff.getStaffDept().equalsIgnoreCase(deptName))
			{
				servicestaff.add(staff);
			}
		}
		return servicestaff.size();
	
	}

	public int fetchALlStaffasPerDeptRequestParam(String deptName) {
		
        List<CricketStaff> allstafflist= dao.allIndianCricketStaffList();
		
		ArrayList<CricketStaff> servicestaff =new ArrayList<>();
		for(CricketStaff staff:allstafflist)
		{
			if(staff.getStaffDept().equalsIgnoreCase(deptName))
			{
				servicestaff.add(staff);
			}
		}
		return servicestaff.size();
		
		
	}
}

