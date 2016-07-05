package com.tss.hostelmanagement.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tss.hostelmanagement.model.Hostel;

public class HostelRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	Hostel hostel = new Hostel();
	hostel.setHostelId(rs.getLong("hostelId"));
	hostel.setHostelAddress(rs.getString("hostelAddress"));
	hostel.setHostelName(rs.getString("hostelName"));
		return hostel;
	}

}
