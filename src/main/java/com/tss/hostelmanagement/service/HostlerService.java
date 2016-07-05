package com.tss.hostelmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tss.hostelmanagement.dao.HostlerDAO;
import com.tss.hostelmanagement.model.Hostler;

@Service
public class HostlerService {
    
	@Autowired
	HostlerDAO hostlerDAO;

	public void insertHostler(Hostler hostler){
		hostlerDAO.insert(hostler);
	}


  public void updateHostler(Hostler hostler){
	   hostlerDAO.update(hostler);
   }

  
  public Hostler  findHostler(Long hostlerid){
	return  hostlerDAO.find(hostlerid);
  
  }

  public long deleteHostler(Long hostlerid){
 
 return hostlerDAO.delete(hostlerid);
  }
}
