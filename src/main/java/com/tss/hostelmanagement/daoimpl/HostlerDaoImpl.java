package com.tss.hostelmanagement.daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.mysql.jdbc.Statement;
import com.tss.hostelmanagement.dao.HostlerDAO;
import com.tss.hostelmanagement.model.Hostler;

@Repository
public class HostlerDaoImpl implements HostlerDAO {
     @Autowired
	JdbcTemplate jdbcTemplate;

     public static final String INSERT_HOSTLER="insert into hostler ( address, age, amount, dateOfJoining, deleted, firstName, lastName, mobileNumber, name, qualification, roomId, sex ) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
     public static final String UPDATE_HOSTLER = "update hostler set address = ?, age = ?, amount = ?, dateOfJoining = ?,firstName = ?, lastName = ?, mobileNumber = ?, name = ?, qualification = ?, roomId = ?, sex = ? where hostlerId = ?";
     public final static String DELETE_HOSTLER = "delete from hostler where hostlerId = ?";
     public final static String SELECT_HOSTLER = "select hostlerId,address, age, amount, dateOfJoining,firstName, lastName, mobileNumber, name, qualification, roomId, sex from hostler where hostlerId = ?";
	@Override
	
	public Hostler find(Long hostlerid) {
		Hostler hostler = (Hostler)jdbcTemplate.queryForObject(
				SELECT_HOSTLER, new Object[] { hostlerid }, new HostlerRowMapper());
			
		return hostler;
	}
	
	@Override
	public boolean load(Hostler hostler) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Long insert(final Hostler hostler) {
	
		KeyHolder keyHolder=new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement preparedStatement=con.prepareStatement(INSERT_HOSTLER, Statement.RETURN_GENERATED_KEYS);
				
				preparedStatement.setString(1, hostler.getAddress());
				preparedStatement.setInt(2, hostler.getAge());
				preparedStatement.setBigDecimal(3, hostler.getAmount());
				preparedStatement.setDate(4,new Date( hostler.getDateOfJoining().getTime()));
				preparedStatement.setInt(5, hostler.getDeleted());
				preparedStatement.setString(6, hostler.getFirstName());
				preparedStatement.setString(7, hostler.getLastName());
				preparedStatement.setString(8, hostler.getMobileNumber());
				preparedStatement.setString(9, hostler.getName());
				preparedStatement.setString(10,hostler.getQualification());
				preparedStatement.setLong(11,hostler.getRoomId());
				preparedStatement.setString(12,hostler.getSex());
				return preparedStatement;
			}
		},keyHolder);
		
		Long hostlerId=Long.parseLong(keyHolder.getKeyList().get(0).get("hostlerId").toString());
		hostler.setHostlerId(hostlerId);
		return hostlerId;
	}

	@Override
	public int update(Hostler hostler) {
		
	
	
	        Object[] args = new Object[] {hostler.getAddress(),
	        		hostler.getAge(),
	        		hostler.getAmount(),
	        		hostler.getDateOfJoining(),
	        		//hostler.getDeleted(),
	        		hostler.getFirstName(),
	        		hostler.getLastName(),
	        		hostler.getMobileNumber(),
	        		hostler.getName(),
	        		hostler.getQualification(),
	        		hostler.getRoomId(),
	        		hostler.getSex(),
	        		hostler.getHostlerId()};
	         
	        int out = jdbcTemplate.update(UPDATE_HOSTLER, args);
	        if(out !=0){
	            System.out.println("update hostler id ="+hostler.getHostlerId());
	      
	        }
		return 0;
	}

	@Override
	public int delete(Long hostlerid) {
		    // Assign values to parameters
		    Object[] hostler = new Object[] {hostlerid};

		    
		    jdbcTemplate.update(DELETE_HOSTLER, hostler);
		
		return 0;
	}

	@Override
	public int delete(Hostler hostler) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean exists(Long hostlerid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean exists(Hostler hostler) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*@Override
	public int delete(Hostler hostler) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean exists(Long hostlerid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean exists(Hostler hostler) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}
     */
     
     
	
}
