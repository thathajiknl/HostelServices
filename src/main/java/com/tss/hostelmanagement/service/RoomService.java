package com.tss.hostelmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tss.hostelmanagement.dao.RoomDAO;
import com.tss.hostelmanagement.model.Room;

@Service
public class RoomService {
	@Autowired
	RoomDAO roomDao;
	public void insertRoom(Room room){
		roomDao.insert(room);
	}

	
	public void updateRoom(Room room){
		roomDao.update(room);
	}

  public Room findRoom( Long roomid ) {
	  
  return roomDao.find(roomid);
  
  
  }
  }

