/**
 * @package com.tcs.ilp.crud.service
 */
package com.tcs.ilp.crud.service;



import java.sql.SQLException;
import java.util.ArrayList;

import com.tcs.ilp.crud.beans.Amenity;
import com.tcs.ilp.crud.dao.AmenityDao;
import com.tcs.ilp.crud.utility.AmenityAlreadyExistsException;



/**
 * @author (Neelesh(669049))
 * @Date 06/08/2012
 * @version 1.0
 * @Creation Date 7-8-2012
 * @ History
 */



public class AmenityService {
	/**
	 * Attribute AmenityDao
	 */
	AmenityDao amenityDao;
	/**
	 * @author (Neelesh(669049))
	 * @add addAmenity Method 
	 * @return int 
	 * @description this method add Amenity 
	 */
	public int addAmenity(Amenity amenity)throws AmenityAlreadyExistsException,SQLException,ClassNotFoundException{
		int noOfAmenityAdded=0;
		amenityDao=new AmenityDao();
		try{
			noOfAmenityAdded=amenityDao.addAmenity(amenity);	
		}catch (AmenityAlreadyExistsException e) {
		
			throw e;
		}
		return noOfAmenityAdded;
		
	}
	
	/**
	 * @author (Neelesh(669049))
	 * @add getAmenity Method 
	 * @return Amenity 
	 * @description this method get Amenity
	 */
	public Amenity getAmenity(String amenityId)throws SQLException,ClassNotFoundException{
		amenityDao = new AmenityDao();
		Amenity amenity=amenityDao.getAmenity(amenityId);
		
		return amenity;
	}
	
	/**
	 * @author (Neelesh(669049))
	 * @method getAllAmenities() 
	 * @return ArrayList<Amenity> 
	 * @description this method get all Amenity 
	 */
	public ArrayList<Amenity> getAllAmenities()throws SQLException,ClassNotFoundException{
		amenityDao = new AmenityDao();
		ArrayList<Amenity> amenityList = amenityDao.getAllAmenities();
		return amenityList;
	}

	/**
	 * @author (Neelesh(669049))
	 * @param amenityTypeId<String>
	 * @method getAllAmenitiesByType 
	 * @return ArrayList<Amenity> 
	 * @description this method getAllAmenitiesByType
	 */
	public ArrayList<Amenity> getAllAmenitiesByType(String amenityTypeId)throws SQLException,ClassNotFoundException{
		amenityDao = new AmenityDao();
		ArrayList<Amenity> amenityList = amenityDao.getAllAmenitiesByType(amenityTypeId);
		return amenityList;
	}
	
	/**
	 * @author Mukul(675250)
	 * @method deleteAmenity 
	 * @param amenityId<String>
	 * @return int 
	 * @description this method delete Amenity 
	 */
	public int deleteAmenity (String amenityId)throws SQLException{
		int numberOfAmenityDeleted = 0;
		amenityDao = new AmenityDao();
		
		numberOfAmenityDeleted = amenityDao.deleteAmenity(amenityId);
		return numberOfAmenityDeleted;
	}

	/**
	 * @author (Mukul(675250))
	 * @method updateAmenity
	 * @param amenity<Amenity>
	 * @return int 
	 * @description this method update Amenity to the dao
	 */
	public int updateAmenity(Amenity amenity)throws SQLException{
		int numberOfAmenityUpdated = 0;
		amenityDao=new AmenityDao();
		
		numberOfAmenityUpdated = amenityDao.updateAmenity(amenity);
			
		return numberOfAmenityUpdated;
		
	}
	/**
	 * @author (Neelesh(669049))
	 * @method genarateId
	 * @return String 
	 * @description this method generate Amenity 
	 */
	public String genarateId() throws SQLException {
		amenityDao=new AmenityDao();
		return amenityDao.genarateId();
	}
	
}
