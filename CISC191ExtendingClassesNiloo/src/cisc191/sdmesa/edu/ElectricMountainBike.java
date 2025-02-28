package cisc191.sdmesa.edu;

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
 * ElectricMountainBike is a Bicyle that is Movable, Gearable, and Electric
 */

// TODO: Implement and comment all IS-A (inheritance) and IS (implements) relationships separately

public class ElectricMountainBike extends Bicycle implements Gearable, Electric
{
	private int gearNumber;
	private int chargeAmount;
	
	public ElectricMountainBike(String newMake) {
		super(newMake);
		this.gearNumber = 1;
		
	}

	@Override
	public int getGear() {
		return this.gearNumber;
	}
	
	public void gearUp() {
		gearNumber++;
	}
	
	public void gearDown() {
		gearNumber--;
	}
	
	@Override
	public int getCharge() {
		return this.chargeAmount;
	}
	
	@Override
	public void charge(int chargeAmount) {
		 this.chargeAmount = chargeAmount;
	}
	
}
