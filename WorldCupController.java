package com.TKA.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.TKA.entity.CricketStaff;
//import com.TKA.entity.CricketStaff;
import com.TKA.service.WorldCupCricketService;

@RestController
public class WorldCupController {
	
	@Autowired
	WorldCupCricketService service;
	
	@GetMapping("/")
	public String TestApi()
	{
		return "Testing is Done....";
	}
	
	@GetMapping("getallstaff")
	public List<CricketStaff> fetchallstaff()
	{
		return service.fetchallstaff();
	}
	
	@GetMapping("getmedicalstaffcount")
	public int fetchMedicalDeptCount() {
		return service.fetchMedicalDeptCount();
	}
	
	@GetMapping("getstaffnamewithage")
	public HashMap<String,Integer> fetchStaffNamewithAge()
	{
		return service.fetchStaffNamewithAge();
	}
	
	@GetMapping("getNameStartWithp")
	public List<String> getNameStartWithp(){
		return service.getNameStartWithp();
	}
	
	@GetMapping("getNamewhoBelowAge40")
	public List<String> getNamewhoBelowAge40()
	{
		return service.getNamewhoBelowAge40();
	}
	
	@GetMapping("getNameSerciceDept")
	public ArrayList<String> getNameSerciceDept()
	{
		return service.getNameSerciceDept();
	}
	
	@GetMapping("getSumOfExpOfPlayerDept")
	public int getSumOfExpOfPlayerDept()
	{
		return service.getSumOfExpOfPlayerDept();
	}
	
	@GetMapping("getNameWhoseExpMorethan10")
	public List<String> getNameWhoseExpMorethan10()
	{
		return service.getNameWhoseExpMorethan10();
	}
	
	@GetMapping("getMostExpPlayerName")
	public ArrayList<String> getMostExpPlayerName()
	{
		return service.getMostExpPlayerName();
	}
	
	//***********************
	//To Send data Client to Server By Using PostMan   Step1
	
	@PostMapping("insertCricketStaff")
	public void insertCricketStaffdetails(@RequestBody CricketStaff staff)
	{
		service.insertCricketStaffdetail(staff);
	}
	
	//To Update data form Client to Server By Using PostMan  Step1
	@PutMapping("updatecricketstaff")
	public void updateCricketStaffdetail(@RequestBody CricketStaff staff)
	{
		service.updateCricketStaffdetail(staff);
	}
	
	//****************************
	//Use @pathvarible to fetch No.of record on database asper Your
	//Dept requriment
	//Most Use in Industry
	//Only work on controller and service layer  step 1
	
	@GetMapping("getallstaffasperdept/{deptName}")
	public int fetchALlStaffasPerDept(@PathVariable String deptName)
	{
		System.err.println(deptName);
		return service.fetchALlStaffasPerDept(deptName);
	}
	
	// By Using @RquestParam 
	
	@GetMapping("getallstaffaspardeptRequestParam")
	public int fetchALlStaffasPerDeptRequestParam(@RequestParam String deptName,@RequestParam String age)
	{
		System.err.println(deptName);
		System.err.println(age);
		
		return service.fetchALlStaffasPerDeptRequestParam(deptName);
	}
}
