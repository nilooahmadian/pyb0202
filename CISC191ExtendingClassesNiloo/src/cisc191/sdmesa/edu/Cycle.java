package cisc191.sdmesa.edu;

import java.awt.Color;

/**
 * Lead Author(s):
 * @author 
 * @author 
 * <<add additional lead authors here, with a full first and last name>>
 * 
 * Other contributors:
 * <<add additional contributors (mentors, tutors, friends) here, with contact information>>
 * 
 * References:
 * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 * Retrieved from https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 * <<add more references here>>
 *  
 * Version/date: 
 * 
 * Responsibilities of class:
 * 
 */
/**
 * Only change sections that are marked with TODO
 */

//TODO: Implement and comment all IS-A (inheritance) relationships

public abstract class Cycle
{
	
	private String make;      //a cycle HAS-A make
	//protected ==> we can access in the sub-class
	protected int numWheels;    //a cycle HAS-A numWheels
	protected Color color;      //a cycle HAS-A color
	// A cycle has a unique frame number, that is *immutable*;
	// How are you going to make it immutable, so that it only gets one final number? 
	// (Hint: did you see the hint?)
	private int frameNumber = 1;
	private int actualFrameNumber;
	
	// A cycle has a make, that is immutable
	// TODO:
	
	public Cycle(String newMake)
	{
		// TODO
		this.make = newMake;
		
		//assign the frame number
		this.actualFrameNumber = frameNumber;
		
		//update frame number 
		frameNumber++;
		
		
	}

	abstract int getNumberOfWheels();

	/**
	 * 
	 * @return the color of the bike; can be null
	 */
	abstract Color getColor();

	/**
	 * Changes the color of the bike
	 * 
	 * @param newColor
	 */
	abstract void setColor(Color newColor);

	/**
	 * 
	 * @return make or brand that was set when the bike was made
	 */
	public String getMake()
	{
		// TODO
		return this.make;
	}
	
	/**
	 * 
	 * @return the unique serial number that was stamped in the frame when the bike was made
	 * @see https://www.eta.co.uk/bicycle-insurance/frequently-asked-questions/how-to-find-a-bicycle-frame-number/
	 */
	public int getFrameNumber()
	{
		return this.actualFrameNumber;
	}
	
	/**
	 *  @return true if the frame number are the same
	 */
	@Override
	public boolean equals(Object other)
	{
		// Hint: use instanceof
		// See: https://www.sitepoint.com/implement-javas-equals-method-correctly/
		if (!(other instanceof Cycle ))
			return false;
		
		return this.actualFrameNumber == ((Cycle) other).actualFrameNumber;
	}
	
	/**
	 * @return String describing the object, including type, make and frame number
	 */
	@Override
	public String toString()
	{
		//TODO:
		return "Hello, I'm a Cycle" + make + actualFrameNumber + color;
	}

}
