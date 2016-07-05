package com.tss.hostelmanagement.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.mysql.jdbc.Statement;
import com.tss.hostelmanagement.dao.RoomDAO;
import com.tss.hostelmanagement.model.Hostler;
import com.tss.hostelmanagement.model.Room;

@Repository
public class RoomDaoimpl implements RoomDAO{
@Autowired
	JdbcTemplate jdbcTemplate;


public static final String ROOM_INSERT="insert into room ( deleted, hostelId, noOfBeds, roomNumber ) values ( ?, ?, ?, ? )";
public static final String ROOM_UPDATE="update room set hostelId = ?, noOfBeds = ?, roomNumber = ? where roomId = ?";
public static final String ROOM_DELETE="delete from room where roomId = ?";
public static final String ROOM_SELECT ="select roomId ,hostelId, noOfBeds, roomNumber from room where roomId = ?";
@Override
public Room find(Long roomid) {
	Room room = (Room)jdbcTemplate.queryForObject(
			ROOM_SELECT, new Object[] { roomid }, new RoomRowMapper());
		
	return room;
}
@Override
public boolean load(Room room) {
	// TODO Auto-generated method stub
	return false;
}
@Override
public Long insert(Room room) {
	
	KeyHolder keyHolder = new GeneratedKeyHolder();
	jdbcTemplate.update(new PreparedStatementCreator() {
		
		@Override
		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
		PreparedStatement preparedStatement = con.prepareStatement(ROOM_INSERT,Statement.RETURN_GENERATED_KEYS);
		preparedStatement.setLong(1,room.getDeleted());
		preparedStatement.setLong(2,room.getHostelId());
		preparedStatement.setString(3,room.getNoOfBeds());
		preparedStatement.setString(4,room.getRoomNumber());
		return preparedStatement;
		}
	},keyHolder);
	
	Long roomId=keyHolder.getKey().longValue();
	room.setRoomId(roomId);
	return roomId;
}
@Override
public int update(Room room) {
	Object[] args = new Object[] 
			{
		        room.getHostelId(),
		        room.getNoOfBeds(),
		        room.getRoomId(),
		        room.getRoomNumber()
					
			};
     
    int out = jdbcTemplate.update(ROOM_UPDATE, args);
    if(out !=0){
        System.out.println("update hostler id ="+room.getRoomId());
  
    }
return 0;
}
@Override
public int delete(Long roomid) {
	// TODO Auto-generated method stub
	return 0;
}
@Override
public int delete(Room room) {
	// TODO Auto-generated method stub
	return 0;
}
@Override
public boolean exists(Long roomid) {
	// TODO Auto-generated method stub
	return false;
}
@Override
public boolean exists(Room room) {
	// TODO Auto-generated method stub
	return false;
}
@Override
public long count() {
	// TODO Auto-generated method stub
	return 0;
}






}
