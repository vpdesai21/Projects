package com.tcs.ilp.crud.beans;

import org.apache.log4j.Logger;


/**
 * This the NewsAndEvents Bean class.
 * @author sangeet(675067)
 * @class NewsAndEvents
 * @createdDate 06/08/2012
 *
 */



public class NewsAndEvents 

{   
    public static final Logger logger=Logger.getLogger(NewsAndEvents.class);
	private String eventNewsId;
	private String eventNewsName;
	private String eventDateTime;
	private String eventImage;
	private String eventNewsDescription;
	
	//getters and setters
	
	public String getEventNewsId() {
		return eventNewsId;
	}
	public void setEventNewsId(String eventNewsId) {
		this.eventNewsId = eventNewsId;
	}
	public String getEventNewsName() {
		return eventNewsName;
	}
	public void setEventNewsName(String eventNewsName) {
		this.eventNewsName = eventNewsName;
	}
	public String getEventDateTime() {
		return eventDateTime;
	}
	public void setEventDateTime(String eventDateTime) {
		this.eventDateTime = eventDateTime;
	}
	public String getEventImage() {
		return eventImage;
	}
	public void setEventImage(String eventImage) {
		this.eventImage = eventImage;
	}
	public String getEventNewsDescription() {
		return eventNewsDescription;
	}
	public void setEventNewsDescription(String eventNewsDescription) {
		this.eventNewsDescription = eventNewsDescription;
	}
	
	//default constructor
	
	
	public NewsAndEvents() 
	{
		
	}
	
	//parametrized constructor
	
	
	public NewsAndEvents(String eventNewsId, String eventNewsName,
			String eventDateTime, String eventImage, String eventNewsDescription) {
		
		this.eventNewsId = eventNewsId;
		this.eventNewsName = eventNewsName;
		this.eventDateTime = eventDateTime;
		this.eventImage = eventImage;
		this.eventNewsDescription = eventNewsDescription;
	}
	
	
	/**
	 * This is the display method.
	 * @author Sangeet Mishra(675067)
	 *
	 */
	
	
	public void display()
	{
		logger.info("Event And News ID"+this.eventNewsId);
		logger.info("Event And News Name"+this.eventNewsName);
		logger.info("Event And News Date and Time"+this.eventDateTime);
		logger.info("Event And News Image"+this.eventImage);
		logger.info("Event And News Description"+this.eventNewsDescription);
	}
	
	/**
	 * This is the getEventDate() method.It is used to extract the event 
	 * date from the event date and time field.
	 * 
	 * @author Sangeet Mishra(675067)
	 * @return String values
	 */
	
	
	public String getEventDate()
	{
		String date = this.eventDateTime.substring(0, 10); 
		
		return (date.trim());
	}
	
	
	/**
	 * This is the getEventTime() method.It is used to extract the event 
	 * time from the event date and time field.
	 * @author Sangeet Mishra(675067)
	 * @return String values
	 */
	

	public String[] getEventTime()
	{

		String time = this.eventDateTime.substring(10,this.eventDateTime.length()); 
		
		String[] values = new String[2];
		values[0] = time.substring(0,3);
		values[1] = time.substring(4,6); 
		
		return (values);
	}
	
	
}
//==================End Class NewsAndEvents=======================
