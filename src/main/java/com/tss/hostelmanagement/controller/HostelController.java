package com.tss.hostelmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tss.hostelmanagement.model.Hostel;
import com.tss.hostelmanagement.model.Hostler;
import com.tss.hostelmanagement.service.HostelService;

@RestController
public class HostelController {

	@Autowired 
	
	HostelService hostelService;
	
	@RequestMapping (value="insert/hostel")
		@ResponseBody
	public Hostel inserHostel(@RequestBody Hostel hostel){
		hostelService.inserHostel(hostel);
	 return hostel;
	}
	
	@RequestMapping(value="update/hostel")
	@ResponseBody
	public Hostel updateHostel(@RequestBody Hostel hostel)	{
	hostelService.updateHostel(hostel);
return hostel;
 }
	
	@RequestMapping(value="/select/hostel/{hostelId}")
	@ResponseBody
	public Hostel selectHostel(@PathVariable("hostelId") Long hostelId){
	return hostelService.findHostel(hostelId);
}
	
	@RequestMapping(value="/delete/hostel/{hostelId}")
	@ResponseBody
	public Long deleteHostel(@PathVariable("hostelId") Long hostelId){
	 return hostelService.deleteHostle(hostelId);
}
	
}
