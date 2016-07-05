package com.tss.hostelmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tss.hostelmanagement.model.Room;
import com.tss.hostelmanagement.service.RoomService;

@RestController
public class RoomController {
@Autowired
RoomService roomService;
@RequestMapping(value="insert/room")
@ResponseBody
public Room insertRoom(@RequestBody Room room){
	roomService.insertRoom(room);
		return room;
}



@RequestMapping(value="update/room")
@ResponseBody
public Room updateRoom(@RequestBody Room room){
	roomService.updateRoom(room);
 return room;
} 

@RequestMapping(value="select/room/{roomId}")

@ResponseBody
public Room selectRoom(@PathVariable("roomId") Long roomId){
return 	roomService.findRoom(roomId);

}
}
