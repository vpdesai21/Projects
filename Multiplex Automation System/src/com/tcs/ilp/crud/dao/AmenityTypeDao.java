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


import com.tcs.ilp.crud.beans.AmenityType;
import com.tcs.ilp.crud.utility.ConnectionUtil;
import com.tcs.ilp.crud.utility.Constants;

/**
 * @author Neelesh(669049)
 * @Date 07/08/2012
 */
public class AmenityTypeDao {

	public static final Logger logger = Logger.getLogger(AmenityTypeDao.class);
	 
	 /**
	  * @author 669049
	  * @param amenityTypeId
	  * @return AmenityType
	  * @throws SQLException
	  * @throws ClassNotFoundException
	  * @description getAmenityType from DB
	  */
	public AmenityType getAmenityType(String amenityTypeId)throws SQLException,ClassNotFoundException{
		logger.info("I entered the method getAmenityType()");
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		AmenityType amenityType = null;


		// code for connecting to database and executing select query

		try {
			con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM "+Constants.TBL_AMENITY_TYPES+" WHERE "+Constants.AMENITY_TYPE_ID+"=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, amenityTypeId);

			rs = pst.executeQuery();
			if (rs.next()) {
				amenityTypeId = rs.getString(Constants.AMENITY_TYPE_ID);
				String amenityTypeName = rs.getString(Constants.AMENITY_TYPE_NAME);
				
			
				amenityType=new AmenityType();
				amenityType.setAmenityTypeId(amenityTypeId);
				amenityType.setAmenityTypeName(amenityTypeName);
				
			}
		} catch (SQLException se) {
			se.printStackTrace();
			logger.debug("Exception have occured " + se);
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
				logger.debug("Exception have occured " + se);
				throw se;
			}
		}
		logger.debug("getAmenityType pass");
		return amenityType;
	}

	 /**
	  * @author 669049
	  * @return ArrayList<AmenityType>
	  * @throws SQLException
	  * @throws ClassNotFoundException
	  * @description getAllAmenityType from DB
	  */
	public ArrayList<AmenityType> getAllAmenityTypes() throws SQLException,ClassNotFoundException{
	
		logger.info("I entered the method getAllAmenityTypes()");
		ArrayList<AmenityType> amenityTypeList = new ArrayList<AmenityType>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM "+Constants.TBL_AMENITY_TYPES;
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				AmenityType amenityType=new AmenityType();
				String amenityTypeId=rs.getString(Constants.AMENITY_TYPE_ID);
				String amenityTypeName=rs.getString(Constants.AMENITY_TYPE_NAME);
				amenityType.setAmenityTypeId(amenityTypeId);
				amenityType.setAmenityTypeName(amenityTypeName);

				amenityTypeList.add(amenityType);

			
			}
		} catch (SQLException se) {
			se.printStackTrace();
			logger.debug("Exception "+se);
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
				logger.debug("Exception "+se);
				throw se;
			}
		}
		logger.debug("get All Amenity Type Pass");
		return amenityTypeList;

	}
}