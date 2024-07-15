package com.TKA.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CricketStaff {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int Staffid;
	String StaffName;
	String StaffDept;
	int StaffAge;
	int NoofYeartoBCCI;
	public CricketStaff() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CricketStaff(String staffName, String staffDept, int staffAge, int noofYeartoBCCI) {
		super();
		StaffName = staffName;
		StaffDept = staffDept;
		StaffAge = staffAge;
		NoofYeartoBCCI = noofYeartoBCCI;
	}
	public int getStaffid() {
		return Staffid;
	}
	public void setStaffid(int staffid) {
		Staffid = staffid;
	}
	public String getStaffName() {
		return StaffName;
	}
	public void setStaffName(String staffName) {
		StaffName = staffName;
	}
	public String getStaffDept() {
		return StaffDept;
	}
	public void setStaffDept(String staffDept) {
		StaffDept = staffDept;
	}
	public int getStaffAge() {
		return StaffAge;
	}
	public void setStaffAge(int staffAge) {
		StaffAge = staffAge;
	}
	public int getNoofYeartoBCCI() {
		return NoofYeartoBCCI;
	}
	public void setNoofYeartoBCCI(int noofYeartoBCCI) {
		NoofYeartoBCCI = noofYeartoBCCI;
	}
	@Override
	public String toString() {
		return "CricketStaff [Staffid=" + Staffid + ", StaffName=" + StaffName + ", StaffDept=" + StaffDept
				+ ", StaffAge=" + StaffAge + ", NoofYeartoBCCI=" + NoofYeartoBCCI + "]";
	}
	
	

}


