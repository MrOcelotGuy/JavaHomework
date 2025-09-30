package chapter18.retail;

public class DvdMovie implements RetailItem {
	private String title; // The DVD's title
	private int runningTime; // Running time in minutes
	private double retailPrice; // The DVD's retail price

	public DvdMovie(String dvdTitle, int runTime, double dvdPrice) {
		title = dvdTitle;
		runningTime = runTime;
		retailPrice = dvdPrice;
	}

	public String getTitle() {
		return title;
	}

	public int getRunningTime() {
		return runningTime;
	}

	public double getRetailPrice() {
		return retailPrice;
	}
}