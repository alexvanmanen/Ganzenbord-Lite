package model;
import java.util.Random;

import view.DiceView;

public class Dice {

	private int numberOfDots; 
	private int numberOfSides;
	private DiceView view;
	Random random = new Random();
	
	public Dice(int numberOfSides){
		this.numberOfSides = numberOfSides;
	}
	
	public void roll(){
		this.numberOfDots = random.nextInt(numberOfSides) + 1;
		view.update(numberOfDots);
	}
	
	public int getNumberOfDots(){
		return this.numberOfDots;
	}

	public void registrate(DiceView view) {
		this.view = view;
	}
}
