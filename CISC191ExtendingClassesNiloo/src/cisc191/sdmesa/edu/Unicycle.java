package cisc191.sdmesa.edu;

import java.awt.Color;

/**
 * Lead Author(s):
 * 
 * @author
 * @author <<add additional lead authors here, with a full first and last name>>
 * 
 *         Other contributors: <<add additional contributors (mentors, tutors,
 *         friends) here, with contact information>>
 * 
 *         References: Morelli, R., & Walde, R. (2016). Java, Java, Java:
 *         Object-Oriented Problem Solving. Retrieved from
 *         https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 *         <<add more references here>>
 * 
 *         Version/date:
 * 
 *         Responsibilities of class: A Unicycle is a Cycle with only one wheel
 */

// TODO: Implement and comment all IS-A (inheritance) relationships

public class Unicycle extends Cycle {
	
	
	public Unicycle(String newMake) {
		super(newMake);
		this.numWheels = 1;
	}

	@Override
	public int getNumberOfWheels() {
		return this.numWheels;
	}

	@Override
	public Color getColor() {
		return this.color;
	}

	@Override
	public void setColor(Color newColor) {
		this.color = newColor;
	}
}
