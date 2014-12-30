/**
 * 
 */
package test.com.tcs.ilp.crud.test_dao;


import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.tcs.ilp.crud.beans.AmenityType;
import com.tcs.ilp.crud.dao.AmenityTypeDao;





/**
 * @author Neelesh(669049)
 * @Date 08/08/2012
 *
 */
public class AmenityTypeCrudTestCase {

	AmenityTypeDao amenityTypeDao= new AmenityTypeDao();
	public static final Logger logger = Logger.getLogger(AmenityTypeCrudTestCase.class);
	/**
	 * Neelesh
	 */
	
	public void getAmenityTypeTestCase(){
		AmenityType amenityType=null;
		try{
			amenityType =amenityTypeDao.getAmenityType("1");
		}catch(SQLException e){
			logger.error(e);
			logger.error("Test Case Failed: getAmenityTestCase1");	
		}catch (ClassNotFoundException e) {
			logger.error(e);
			logger.error("Test Case Failed: getAmenityTestCase2");
		}
		
		
		
	if(amenityType!=null){
		logger.debug("AmenityType Id: "+amenityType.getAmenityTypeId());
		logger.debug("AmenityType Name: "+amenityType.getAmenityTypeName());
		logger.debug("Test Case Passed: getAmenityTTypeestCase");
	}else{
		logger.error("Test Case Failed: getAmenityTypeTestCase3");
}
}
	
	/**
	 * MUKUL(675250)
	 */
	
public void getAllAmenityTypesTestCase(){
	
	ArrayList<AmenityType> amenityTypeList=null;;
	try {
		amenityTypeList = amenityTypeDao.getAllAmenityTypes();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	for(int i=0; i<amenityTypeList.size(); i++){
		AmenityType amenityType=amenityTypeList.get(i);
		logger.debug("AmenityType Id: "+amenityType.getAmenityTypeId());
		logger.debug("AmenityType Name: "+amenityType.getAmenityTypeName());
	}
	if(amenityTypeList.size()>0){
		logger.debug("Test Case Passed: getAllAmenityTypeTestCase");
	}else{
		logger.error("Test Case Failed: getAllAmenityTypeTestCase");
}
	

	
}
/**
 * 
 * @MUKUL(675250)
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AmenityTypeCrudTestCase amenityTypeCrudTestCase=new AmenityTypeCrudTestCase();
		amenityTypeCrudTestCase.getAmenityTypeTestCase();
		amenityTypeCrudTestCase.getAllAmenityTypesTestCase();
		

	}

}
