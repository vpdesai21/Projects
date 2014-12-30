/**
 * 
 */
package test.com.tcs.ilp.crud.test_dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.tcs.ilp.crud.beans.Amenity;
import com.tcs.ilp.crud.beans.AmenityType;
import com.tcs.ilp.crud.dao.AmenityDao;
import com.tcs.ilp.crud.dao.AmenityTypeDao;
import com.tcs.ilp.crud.utility.AmenityAlreadyExistsException;



/**
 * @author Neelesh(669049)
 * @Date 08/08/2012
 */
public class AmenityCrudTestCase {



		/**
		 * @param args
		 */
		AmenityDao amenityDao = new AmenityDao();
		AmenityTypeDao amenityTypeDao=new AmenityTypeDao();
		/**
		 * @author 675250
		 * @throws AmenityAlreadyExistsException
		 * @throws SQLException
		 * @throws ClassNotFoundException
		 */
		public void addAmenityTestCase() throws AmenityAlreadyExistsException, SQLException, ClassNotFoundException{
			AmenityType amenityType =amenityTypeDao.getAmenityType("1");
		
			Amenity amenity=new Amenity();
			amenity.setAmenityId("1");
			amenity.setAmenityName("FoodCourt");
			amenity.setAmenityType(amenityType);
			amenity.setAmenityImage("1");
			amenity.setAmenityDescription("1");
		
			//System.out.println("calling addAmenity..");
			int numberOfRowsInserted = amenityDao.addAmenity(amenity);
			if(numberOfRowsInserted==1){
				System.out.println("Amenity Successfully added");
				System.out.println("Test Case Passed: addAmenityTestCase");
			}else{
				System.out.println("Amenity adition failed");
				System.out.println("Test Case Failed: addAmenityTestCase");
			}
		}
		/**
		 * @author 675250
		 * @throws AmenityAlreadyExistsException
		 * @throws SQLException
		 * @throws ClassNotFoundException
		 */
		public void updateAmenityTestCase() throws AmenityAlreadyExistsException, SQLException, ClassNotFoundException{
			AmenityType amenityType =amenityTypeDao.getAmenityType("1");
		
			Amenity amenity=new Amenity();
			amenity.setAmenityId("1");
			amenity.setAmenityName("Mukul");
			amenity.setAmenityType(amenityType);
			amenity.setAmenityImage("2");
			amenity.setAmenityDescription("2");
			int numberOfRowsAffected=amenityDao.updateAmenity(amenity);
			if(numberOfRowsAffected==1){
				System.out.println("Amenity Successfully updated");
				System.out.println("Test Case Passed: updateAmenityTestCase");
			}else{
				System.out.println("Amenity updation failed");
				System.out.println("Test Case Failed: updateAmenityTestCase");
			}
		}

		/**
		 * @author 675250
		 * @throws AmenityAlreadyExistsException
		 * @throws SQLException
		 */
		public void deleteAmenityTestCase()throws AmenityAlreadyExistsException, SQLException{
			int numberOfAmenityDeleted = 0;
			String amenityId="1";
			System.out.println("Going to delete the Amenity with:");
			System.out.println("Amenity ID:"+amenityId);
			numberOfAmenityDeleted = amenityDao.deleteAmenity(amenityId);
			
			if(numberOfAmenityDeleted==1){
				System.out.println("Test Case Passed: deleteAmenityTestCase");
			}else{
				System.out.println("Test Case Failed: deleteAmenityTestCase");
			}
			
		}
		/**
		 * @author 669049
		 * @throws SQLException
		 * @throws ClassNotFoundException
		 */
	public void getAmenityTestCase() throws SQLException, ClassNotFoundException{
			

			
				Amenity amenity=amenityDao.getAmenity("1");
				System.out.println("Amenity Id: "+amenity.getAmenityId());
				System.out.println("Amenity Name: "+amenity.getAmenityName());
				System.out.println("Amenity Type: "+amenity.getAmenityType().getAmenityTypeId());
				System.out.println("Amenity Image: "+amenity.getAmenityImage());
				System.out.println("Amenity Description: "+amenity.getAmenityDescription());
			if(amenity!=null){
				System.out.println("Test Case Passed: getAmenityTestCase");
			}else{
			System.out.println("Test Case Failed: getAmenityTestCase");
		}
	}
	/**
	 * @author 669049
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	   public void getAllAmenitiesTestCase() throws SQLException, ClassNotFoundException{
			
			ArrayList <Amenity> amenityList = amenityDao.getAllAmenities();
			for(int i=0; i<amenityList.size(); i++){
				Amenity amenity=amenityList.get(i);
				System.out.println("Amenity Id: "+amenity.getAmenityId());
				System.out.println("Amenity Name: "+amenity.getAmenityName());
				System.out.println("Amenity Type: "+amenity.getAmenityType().getAmenityTypeId());
				System.out.println("Amenity Image: "+amenity.getAmenityImage());
				System.out.println("Amenity Description: "+amenity.getAmenityDescription());
			}
			if(amenityList.size()>0){
				System.out.println("Test Case Passed: getAllAmenitiesTestCase");
			}else{
			System.out.println("Test Case Failed: getAllAmenitiesTestCase");
		}
			
		
			
		}
	   /**
	    * @author 669049
	    * @param args
	    * @throws AmenityAlreadyExistsException
	    * @throws SQLException
	    */
		
	public static void main(String[] args) throws AmenityAlreadyExistsException, SQLException {
		AmenityCrudTestCase amenityTestCase=new AmenityCrudTestCase();
			try {
				amenityTestCase.addAmenityTestCase();
			
			amenityTestCase.updateAmenityTestCase();
				
			amenityTestCase.getAmenityTestCase();
			amenityTestCase.getAllAmenitiesTestCase();
			amenityTestCase.deleteAmenityTestCase();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

	}
