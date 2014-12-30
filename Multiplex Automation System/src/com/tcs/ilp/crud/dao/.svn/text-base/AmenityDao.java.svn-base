/**
 * 
 */
package com.tcs.ilp.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;


import com.tcs.ilp.crud.beans.Amenity;
import com.tcs.ilp.crud.beans.AmenityType;
import com.tcs.ilp.crud.utility.AmenityAlreadyExistsException;
import com.tcs.ilp.crud.utility.ConnectionUtil;
import com.tcs.ilp.crud.utility.Constants;

/**
 * @author (Neelesh(669049))
 * @Date 06/08/2012
 * @version 1.0
 * @Creation Date 7-8-2012
 * @ History
 */
public class AmenityDao {

	ArrayList<Amenity> amenityList=new ArrayList<Amenity>();
	Amenity amenity=null;
	public static final Logger logger = Logger.getLogger(AmenityDao.class);
	 
	 /**
	  * @added addAmenity method by Neelesh (669049)
	  * @param amenity
	  * @return int
	  * @throws AmenityAlreadyExistsException
	  * @throws SQLException
	  * @throws ClassNotFoundException
	  * @description addAmenity to DB
	  */
	public int addAmenity(Amenity amenity)throws AmenityAlreadyExistsException,SQLException,ClassNotFoundException{
		Connection connection=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		int noOfRowAffected=0;
		try{
		Amenity existingAmenity=getAmenity(amenity.getAmenityId());
		if(existingAmenity!=null){
			throw new AmenityAlreadyExistsException();
		}
		
		
			connection=ConnectionUtil.getConnection();
			String sql="INSERT INTO "+Constants.TBL_AMENITIES +" VALUES (?,?,?,?,?)";
			stmt=connection.prepareStatement(sql);
			stmt.setString(1, amenity.getAmenityId());
			stmt.setString(2, amenity.getAmenityName());
			stmt.setString(3, amenity.getAmenityType().getAmenityTypeId());
			stmt.setString(4,amenity.getAmenityImage());
			stmt.setString(5,amenity.getAmenityDescription());
			
			noOfRowAffected=stmt.executeUpdate();
			
		}catch(SQLException sqlException){
			sqlException.printStackTrace();
			logger.debug(sqlException);
			throw sqlException;
		}
			
			finally{
		
			try{
			if(stmt!=null)stmt.close();
			if(rs!=null)rs.close();
			if(connection!=null)connection.close();
			}catch (SQLException e) {
				e.printStackTrace();
				logger.debug(e);
				throw e;
			}
		}
		return noOfRowAffected;
	}
	
	
	
	 /**
	  *  @added By Mukul(675250)
	  * @param amenity
	  * @return noOfRowAffected
	  * @throws SQLException
	  * @description updateAmenity to DB
	  */
	public int updateAmenity(Amenity amenity)throws SQLException{
		logger.info("I entered in updateAmenity...");
		Connection connection=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		int noOfRowAffected=0;
		try{
			connection=ConnectionUtil.getConnection();
			
			stmt=connection.prepareStatement("UPDATE "+Constants.TBL_AMENITIES+" SET "
					+Constants.AMENITY_NAME+" =?, "+Constants.AMENITY_TYPE_ID+" =?, "+Constants.AMENITY_IMAGE+" =?, "+Constants.AMENITY_DESCRIPTION+" =?"
					+" WHERE "+Constants.AMENITY_ID+" =? ");


			stmt.setString(1, amenity.getAmenityName());

			stmt.setString(2, amenity.getAmenityType().getAmenityTypeId());
			stmt.setString(3, amenity.getAmenityImage());
			stmt.setString(4, amenity.getAmenityDescription());
			
			stmt.setString(5, amenity.getAmenityId());

			noOfRowAffected=stmt.executeUpdate();
		}catch(SQLException sqlException){
			sqlException.printStackTrace();
			logger.debug(sqlException);
			throw sqlException;
		}finally{
			try{
			if(stmt!=null)stmt.close();
			if(rs!=null)rs.close();
			if(connection!=null)connection.close();
			}catch (SQLException e) {
				e.printStackTrace();
				logger.debug(e);
				throw e;
			}
		}
		return noOfRowAffected;
	}
	
	/**
	 * @ added By Mukul(675250)
	 * @param amenityId
	 * @return noOfRowAffected
	 * @throws SQLException
	 * @description deleteAmenity from DB
	 */
	public int deleteAmenity(String amenityId)throws SQLException{
		Connection connection=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		int noOfRowAffected=0;
		
		try{
			connection=ConnectionUtil.getConnection();
			
			stmt=connection.prepareStatement("DELETE FROM "+Constants.TBL_AMENITIES+" WHERE "+Constants.AMENITY_ID+"=?" );
			stmt.setString(1,amenityId);


			noOfRowAffected=stmt.executeUpdate();
		}catch(SQLException sqlException){
			sqlException.printStackTrace();
			logger.debug(sqlException);
			throw sqlException;
		}finally{
			try{
			if(stmt!=null)stmt.close();
			if(rs!=null)rs.close();
			if(connection!=null)connection.close();
			}catch (SQLException e) {
				
				e.printStackTrace();
				logger.debug(e);
				throw e;
			}
		}
		return noOfRowAffected;
	}
	
	
	 /**
	  * @added By Neelesh(669049)
	  * @param amenityId
	  * @return Amenity
	  * @throws SQLException
	  * @throws ClassNotFoundException
	  * @description getAmenity from DB
	  */
	public Amenity getAmenity(String amenityId)throws SQLException ,ClassNotFoundException{

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

    	AmenityTypeDao amenityTypeDao = new AmenityTypeDao();

		// code for connecting to database and executing select query

		try {
			con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM "+Constants.TBL_AMENITIES+" WHERE "+Constants.AMENITY_ID+"=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, amenityId);

			rs = pst.executeQuery();
			
			if (rs.next()) {
				amenityId = rs.getString(Constants.AMENITY_ID);
				String amenityName = rs.getString(Constants.AMENITY_NAME);
				String amenityTypeId = rs.getString(Constants.AMENITY_TYPE_ID);
				String amenityImage = rs.getString(Constants.AMENITY_IMAGE);
				String amenityDescription = rs.getString(Constants.AMENITY_DESCRIPTION);
				
				AmenityType amenityType = amenityTypeDao.getAmenityType(amenityTypeId);

				amenity = new Amenity();
				amenity.setAmenityId(amenityId);
				amenity.setAmenityName(amenityName);
				amenity.setAmenityType(amenityType);
				amenity.setAmenityImage(amenityImage);
				amenity.setAmenityDescription(amenityDescription);
				
				
			}
		} catch (SQLException se) {
			se.printStackTrace();
			logger.error("Exception have occured " + se);
			throw se;
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (rs != null)
					rs.close();
				if (con != null)
					ConnectionUtil.closeConnection(con);
			} catch (SQLException se) {
				se.printStackTrace();
				logger.error(se);
				throw se;
			} 
		}
		return amenity;
	}
	 
	/**
	 * @added By Neelesh(669049)
	 * @return ArrayList<Amenity>
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @description getAllAmenity to DB
	 */
	public ArrayList<Amenity> getAllAmenities()throws SQLException,ClassNotFoundException {
		logger.info("I entered the method getAllAmenities()");
		ArrayList<Amenity> amenityList = new ArrayList<Amenity>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		AmenityTypeDao amenityTypeDao = new AmenityTypeDao();
		try {
			con = ConnectionUtil.getConnection();
			String sql="SELECT * FROM "+Constants.TBL_AMENITIES;
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				amenity = new Amenity();
				String amenityId = rs.getString(Constants.AMENITY_ID);
				String amenityName = rs.getString(Constants.AMENITY_NAME);
				String amenityTypeId = rs.getString(Constants.AMENITY_TYPE_ID);
				String amenityImage = rs.getString(Constants.AMENITY_IMAGE);
				String amenityDescription = rs.getString(Constants.AMENITY_DESCRIPTION);
				

				
				AmenityType amenityType = amenityTypeDao.getAmenityType(amenityTypeId);

				amenity.setAmenityId(amenityId);
				amenity.setAmenityName(amenityName);
				amenity.setAmenityType(amenityType);
				amenity.setAmenityImage(amenityImage);
				amenity.setAmenityDescription(amenityDescription);
				amenityList.add(amenity);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (rs != null)
					rs.close();
				if (con != null)
					ConnectionUtil.closeConnection(con);
			} catch (SQLException se) {
				throw se;
			
			}
		}
		return amenityList;

	}
	/**
	 * @author Neelesh(669049)
	 * @param amenityTypeId
	 * @return ArrayList<Amenity>
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @description getAllAmenitiesByType from DB
	 */
	public ArrayList<Amenity> getAllAmenitiesByType(String amenityTypeId)throws SQLException,ClassNotFoundException {
		logger.info("I entered the method getAllAmenitiesByType()");
		ArrayList<Amenity> amenityList = new ArrayList<Amenity>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		AmenityTypeDao amenityTypeDao = new AmenityTypeDao();
		try {
			con = ConnectionUtil.getConnection();
			String sql="SELECT * FROM "+Constants.TBL_AMENITIES+" WHERE "+Constants.AMENITY_TYPE_ID+" =?";
			pst = con.prepareStatement(sql);
			pst.setString(1, amenityTypeId);
			rs = pst.executeQuery();
			while (rs.next()) {
				amenity = new Amenity();
				String amenityId = rs.getString(Constants.AMENITY_ID);
				String amenityName = rs.getString(Constants.AMENITY_NAME);
				amenityTypeId = rs.getString(Constants.AMENITY_TYPE_ID);
				String amenityImage = rs.getString(Constants.AMENITY_IMAGE);
				String amenityDescription = rs.getString(Constants.AMENITY_DESCRIPTION);
				

				
				AmenityType amenityType = amenityTypeDao.getAmenityType(amenityTypeId);

				amenity.setAmenityId(amenityId);
				amenity.setAmenityName(amenityName);
				amenity.setAmenityType(amenityType);
				amenity.setAmenityImage(amenityImage);
				amenity.setAmenityDescription(amenityDescription);
				amenityList.add(amenity);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (rs != null)
					rs.close();
				if (con != null)
					ConnectionUtil.closeConnection(con);
			} catch (SQLException se) {
				throw se;
			
			}
		}
		return amenityList;

	}
	/**
	 * @author Neelesh(669049)
	 * @return String
	 * @throws SQLException
	 * @descrition generate Id
	 */
	public String genarateId() throws SQLException{
		String newAmenityId=null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getConnection();
		
			String sql = "SELECT TEST_SEQ.nextval INTO : NEW FROM DUAL";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
		
			if (rs.next()) {
				newAmenityId = new String(""+rs.getInt(1));	
			
			}
		} catch (SQLException se) {
			se.printStackTrace();
			logger.error("Exception have occured " + se);
			throw se;
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (rs != null)
					rs.close();
				if (con != null)
					ConnectionUtil.closeConnection(con);
			} catch (SQLException se) {
				se.printStackTrace();
				logger.error(se);
				throw se;
			} 
		}

		return newAmenityId;
	}
}
