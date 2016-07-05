package com.tss.hostelmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tss.hostelmanagement.model.Hostler;
import com.tss.hostelmanagement.service.HostlerService;

@RestController
public class HostlerController {
	
	@Autowired
	HostlerService hostlerService;
	
	@RequestMapping(value="/insert/hostler")
	@ResponseBody
	public Hostler insertHostler(@RequestBody Hostler hostler){
		hostlerService.insertHostler(hostler);
		return hostler;
	}


	@RequestMapping(value="/update/hostler")
	@ResponseBody
	public Hostler updateHostler(@RequestBody Hostler hostler){
	hostlerService.updateHostler(hostler);
	return hostler;
}
	
	@RequestMapping(value="/select/hostler/{hostlerId}")
	@ResponseBody
	public Hostler selectHostler(@PathVariable("hostlerId") Long hostlerId){
	return hostlerService.findHostler(hostlerId);
}

	@RequestMapping(value="/delete/hostler/{hostlerId}")
	@ResponseBody
	public Long deleteHostler(@PathVariable("hostlerId") Long hostlerId){
	 return hostlerService.deleteHostler(hostlerId);
}

}
