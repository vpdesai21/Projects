/**
 * 
 */
package com.tcs.ilp.crud.beans;

/**
 * @author Neelesh(669049)
 * @Date 06/08/2012
 */
public class AmenityType {
	
	/**
	 * @param amenityId
	 * @param amenityTypeName
	 
	
	 */
	
	
	private String amenityTypeId;
	private String amenityTypeName;
	
	/**
	 * @return the amenityId
	 */
	
	public String getAmenityTypeId() {
		return amenityTypeId;
	}
	
	/**
	 * @param AmenityId the AmenityId to set
	 */
	public void setAmenityTypeId(String amenityTypeId) {
		this.amenityTypeId = amenityTypeId;
	}
	
	/**
	 * @return the amenityTypeName
	 */
	public String getAmenityTypeName() {
		return amenityTypeName;
	}
	
	/**
	 * @param amenityTypeName the amenityTypeName to set
	 */
	public void setAmenityTypeName(String amenityTypeName) {
		this.amenityTypeName = amenityTypeName;
	}
}
