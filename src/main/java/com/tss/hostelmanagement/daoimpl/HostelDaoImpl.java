package com.tss.hostelmanagement.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.mysql.jdbc.Statement;
import com.tss.hostelmanagement.dao.HostelDAO;
import com.tss.hostelmanagement.model.Hostel;
import com.tss.hostelmanagement.model.Hostler;


@Repository
public class HostelDaoImpl implements HostelDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	
	public static final String INSERT_HOSTEL="insert into hostel ( deleted, hostelAddress, hostelName ) values ( ?, ?, ? )";  
    public static final String UPDATE_HOSTEL = "update hostel set  hostelAddress = ?, hostelName = ? where hostelId = ?";
	public static final String DELETE_HOSTEL = "delete from hostel where hostelId = ?";
	public static final String SELECT_HOSTEL = "select hostelId, hostelAddress, hostelName  from hostel where hostelId = ?";
	@Override
	public Hostel find(Long hostelid) {
		Hostel hostel = (Hostel)jdbcTemplate.queryForObject(
				SELECT_HOSTEL, new Object[] { hostelid }, new HostelRowMapper());
			
		return hostel;
	}
		

	@Override
	public boolean load(Hostel hostel) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Long insert(Hostel hostel) {
	    
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement preparedStatement=con.prepareStatement(INSERT_HOSTEL, Statement.RETURN_GENERATED_KEYS);
				preparedStatement.setLong(1,hostel.getDeleted());
				preparedStatement.setString(2,hostel.getHostelAddress());
				preparedStatement.setString(3,hostel.getHostelName());
				return preparedStatement;
				}
			
		},keyHolder);
		Long hostelId=keyHolder.getKey().longValue();
		hostel.setHostelId(hostelId);
		return hostelId;
	}

	@Override
	public int update(Hostel hostel) {
      
		Object[] args = new Object[] {
				 
				 hostel.getHostelAddress(),
				 hostel.getHostelName(),
		         hostel.getHostelId()};
         
        int out = jdbcTemplate.update(UPDATE_HOSTEL, args);
        if(out !=0){
            System.out.println("update hostler id ="+hostel.getHostelId());
      
        }
	return 0;
}


	@Override
	public int delete(Long hostelid) {
  Object[] hostel = new Object[] {hostelid};

	    
	    jdbcTemplate.update(DELETE_HOSTEL, hostel);
	
	return 0;

	}

	@Override
	public int delete(Hostel hostel) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean exists(Long hostelid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean exists(Hostel hostel) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	} 

}
