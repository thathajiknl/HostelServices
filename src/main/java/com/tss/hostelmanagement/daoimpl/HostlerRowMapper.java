package com.tss.hostelmanagement.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tss.hostelmanagement.model.Hostler;

public class HostlerRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Hostler hostler = new Hostler();
		hostler.setHostlerId(rs.getLong("hostlerId"));
		hostler.setAddress(rs.getString("address"));
		hostler.setAge(rs.getInt("age"));
		hostler.setAmount(rs.getBigDecimal("amount"));
		hostler.setDateOfJoining(rs.getDate("dateOfJoining"));
		hostler.setFirstName(rs.getString("firstName"));
	    hostler.setLastName(rs.getString("lastName")); 
	    hostler.setMobileNumber(rs.getString("mobileNumber"));
	    hostler.setName(rs.getString("name"));
	    hostler.setQualification(rs.getString("qualification"));
		hostler.setRoomid(rs.getLong("roomId"));
		hostler.setSex(rs.getString("sex"));
		
		return hostler;
	}

}
