package edu.sdmesa.cisc191;

import java.awt.Color;

import edu.gatech.cc.DigitalPicture;
import edu.gatech.cc.Picture;
import edu.gatech.cc.Pixel;

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
 *         Responsibilities of class:
 * 
 */
public class Logic {

	/*
	 * Use the main method in this file to visually inspect the "filters" that you
	 * are applying to the image(s)! Please see the comment(s) for examples.
	 * 
	 */
	public static void main(String[] arg) {

		// Create a myPicture object from the provided file name.
		// If you use your own image, be sure to place it in the images folder of this
		// project
		DigitalPicture myPicture = new Picture("bees.png");
		myPicture.setTitle("Original Image");

		// Use the explore method of the object to view the picture.
		myPicture.explore();

		/*
		 * Apply the filter then invoke explorer again to view the changes. :)
		 * -----------------------------------------------------------------------------
		 * -------
		 */

		// Apply one of the filters then view the image again with explore!
		flipVertical(myPicture); // <----- Change this to one of the other filters that you have written
		myPicture.setTitle("After Filter"); // change the title of the JFrame
		myPicture.explore();

	}

	/**
	 * Alters the picture so that each pixel's blue channel has been zeroed out. All
	 * other channels remain the same
	 * 
	 * @param picture the image to be altered
	 */
	public static void zeroBlue(DigitalPicture picture) {

		// obtain a representation of the picture as a 2D array of Pixel objects
		Pixel[][] pixel2D = picture.getPixels2D();

		// Traverse the 2D array
		for (int row = 0; row < pixel2D.length; row++) {
			for (int col = 0; col < pixel2D[row].length; col++) {
				// invoke the setBlue method on each Pixel object
				Pixel temp = pixel2D[row][col];
				temp.setRed(0);
			}
		}

	} // closing bracket for zeroBlue
	
	/**
	 *Description of the method
	 *
	 * @param picture describe the parameter
	 */
	public static void blackAndWhite(DigitalPicture picture) {
		// obtain a representation of the picture as a 2D array of Pixel objects
		Pixel[][] pixel2D = picture.getPixels2D();

		// Traverse the 2D array
		for (int row = 0; row < pixel2D.length; row++) {
			for (int col = 0; col < pixel2D[row].length; col++) {
				// Code that goes inside nested for-loop

				// part 2 - Calculate the average!
				int val = (int) pixel2D[row][col].getAverage();

				// Part 3 - Set the new red, green, value to be the calculated average
				pixel2D[row][col].setRed(val);
				pixel2D[row][col].setGreen(val);
				pixel2D[row][col].setBlue(val);
			}
		}
	}// closing blackAndWhite
	
	/**
	 * 
	 * @param picture
	 */
	public static void negative(DigitalPicture picture) {
		Pixel[][] pixel2D = picture.getPixels2D();

		// Traverse the 2D array
		for (int row = 0; row < pixel2D.length; row++) {
			for (int col = 0; col < pixel2D[row].length; col++) {
				pixel2D[row][col].setRed(255 - pixel2D[row][col].getRed());
			}
		}
	}// closing negative

	/**
	 * Describe the method - high level - short & sweet 
	 * @param picture
	 * @param redIntensity
	 * @param greenBlueReduction
	 */
	public static void makeSunset(DigitalPicture picture, double redIntensity, double greenBlueReduction) {
		// 1) grab the 2D array of pixels (see previous method)
		Pixel[][] pixel2D = picture.getPixels2D();
		// 2) traverse the 2D array
		// in the body of the inner loop
		for (int row = 0; row < pixel2D.length; row++) {
			for (int col = 0; col < pixel2D[row].length; col++) {
				// multiply the redValues of each pixel by redIntensity
				pixel2D[row][col].setRed((int) (pixel2D[row][col].getRed() * redIntensity));
				// multiply the green & blue values of each pixel by greenBlueReduction
				pixel2D[row][col].setGreen((int) (pixel2D[row][col].getGreen() * greenBlueReduction));
				pixel2D[row][col].setBlue((int) (pixel2D[row][col].getBlue() * greenBlueReduction));
			}
		}

	}// closing makeSunset

	public static void flipHorizontal(DigitalPicture picture) {
		Pixel[][] pixel2D = picture.getPixels2D();
		for (int row = 0; row < pixel2D.length; row++) {
			for (int col = 0; col < pixel2D[row].length/2; col++) {
				//swap colors
				Color colorSwap = pixel2D[row][col].getColor();
				pixel2D[row][col].setColor(pixel2D[row][pixel2D[row].length-1-col].getColor());
				pixel2D[row][pixel2D[row].length-1-col].setColor(colorSwap);
			}
		}
	}//closing flipHorizontal
	
	public static void flipVertical(DigitalPicture picture) {
		Pixel[][] pixel2D = picture.getPixels2D();
		for (int row = 0; row < pixel2D.length; row++) {
			for (int col = 0; col < pixel2D[row].length/2; col++) {
				//swap colors
				Color colorSwap = pixel2D[row][col].getColor();
				pixel2D[row][col].setColor(pixel2D[pixel2D[row].length-1-col][col].getColor());
				pixel2D[pixel2D[row].length-1-col][col].setColor(colorSwap);
			}
		}
	}
	
	public static void blur(DigitalPicture picture) {
		
		//obtain a representation of the picture as a 2Darray of Pixel objects
		Pixel[][] pixel2D = picture.getPixels2D();
		
		//Traverse the 2D array
		for (int row = 0; row < pixel2D.length/2; row++) {
			for (int col = 0; col < pixel2D[row].length/2; col++) {
				//sum red, blue, and green for each pixel
				int sumRed = (int) (pixel2D[row][col].getRed() + 
						pixel2D[row][col + 1].getRed() + 
						pixel2D[row + 1][col].getRed()+
						pixel2D[row + 1][col + 1].getRed());
				
				int sumGreen = (int) (pixel2D[row][col].getGreen() + 
						pixel2D[row][col + 1].getGreen() + 
						pixel2D[row + 1][col].getGreen()+
						pixel2D[row + 1][col + 1].getGreen());
				
				int sumBlue = (int)(pixel2D[row][col].getBlue() + 
						pixel2D[row][col + 1].getBlue() + 
						pixel2D[row + 1][col].getBlue()+
						pixel2D[row + 1][col + 1].getBlue());
				
				//Divide sum by 4
				
				int aveRed = sumRed / 4;
				int aveGreen = sumGreen / 4;
				int aveBlue = sumBlue / 4;
				
				pixel2D[row][col].setGreen(aveGreen);
				pixel2D[row][col].setBlue(aveBlue);
				pixel2D[row][col].setRed(aveRed);
			}
		}
	}//closing blur
	

}
