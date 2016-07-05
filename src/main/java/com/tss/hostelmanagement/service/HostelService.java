package com.tss.hostelmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tss.hostelmanagement.dao.HostelDAO;
import com.tss.hostelmanagement.model.Hostel;
import com.tss.hostelmanagement.model.Hostler;

@Service
public class HostelService {
	@Autowired
	HostelDAO hostelDAO;
	
	
	public void inserHostel(Hostel hostel){
	  
	hostelDAO.insert(hostel);
	}
	
	public void updateHostel(Hostel hostel){
		hostelDAO.update(hostel);
		
	}
	
	  public Hostel  findHostel(Long hostelid){
		
			return  hostelDAO.find(hostelid);
		  }
	  public long deleteHostle(Long hostlerid){
		  
		  return hostelDAO.delete(hostlerid);
		   }

}
