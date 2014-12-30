/**
 * 
 */
package com.tcs.ilp.crud.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.tcs.ilp.crud.beans.AmenityType;
import com.tcs.ilp.crud.dao.AmenityTypeDao;



/**
 * @author Neelesh(669049)
 * @Date 06/08/2012
 *
 */
public class AmenityTypeService {
	/**
	 * @param AmenityType
	 * @param ArrayList<AmenityType>
	 * @param AmenityTypeDao
	 * 
	 */
	AmenityType amenityType = null;
	ArrayList<AmenityType> amenityList = null;
	AmenityTypeDao amenityTypeDao=new AmenityTypeDao();
	
	/**
	 * 
	 * @param amenityTypeId <String>
	 * @return AmenityType
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @description this method getAmenityType
	 */
	public AmenityType getAmenityType(String amenityTypeId)throws SQLException,ClassNotFoundException{
		amenityType=amenityTypeDao.getAmenityType(amenityTypeId);
		return amenityType;
	}

	/**
	 * 
	 * @return ArrayList<AmenityType>
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @description this method getAllAmenityTypes
	 */
	public ArrayList<AmenityType> getAllAmenityTypes()throws SQLException,ClassNotFoundException{
		
		return amenityTypeDao.getAllAmenityTypes();
		
		 }
}
