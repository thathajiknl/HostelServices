package com.tss.hostelmanagement.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tss.hostelmanagement.model.Room;

public class RoomRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Room room = new Room();
		room.setHostelId(rs.getLong("hostelId"));
		room.setNoOfBeds(rs.getString("noOfBeds"));
		room.setRoomId(rs.getLong("roomId"));
		room.setRoomNumber(rs.getString("roomNumber"));
		return room;
	}

}
