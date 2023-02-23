package com.mycompany.a1;
import java.util.Random;

import com.codename1.charts.util.ColorUtil;

public class Robot extends Movable implements ISteerable {
	public Robot(int size, double x, double y) {
//		size has to equal base set by me
//		(e.g, size of all bases can be 10 and size of all robots can be 40)
		super(ColorUtil.rgb(50, 70, 20), size);
		this.setLocation(x, y);
		this.setSpeed(1);
		this.setHeading(0);
		lastBaseReached = 1;
		steeringDirection = 0;
		energyConsumptionRate = 1;
		damageLevel = 0;
		maximumSpeed = 10;
		energyLevel = 100;
	}
	
	public Robot(int size) {
//		size has to equal base set by me
//		(e.g, size of all bases can be 10 and size of all robots can be 40)
		super(ColorUtil.rgb(50, 70, 20), size);

		this.setSpeed(1);
		this.setHeading(0);
		lastBaseReached = 1;
		steeringDirection = 0;
		energyConsumptionRate = 1;
		damageLevel = 0;
		maximumSpeed = 10;
		energyLevel = 100;
	}
	
	private int lastBaseReached;
	private int steeringDirection; // + - 5 degrees in range 0-40
	private int energyConsumptionRate;
	private int damageLevel; 
	private int maximumSpeed;
	private int energyLevel;

	
	
	
	public int getSteeringDirection(){return this.steeringDirection;}
	public int getMaximumSpeed(){return this.maximumSpeed;}
	public int getEnergyLevel(){return this.energyLevel;}
	public int getEnergyConsumptionRate(){return this.energyConsumptionRate;}
	public int getDamageLevel(){return this.damageLevel;}
	public int getLastBaseReached(){return this.lastBaseReached;}
	
	public void SetSteeringDirection(int sd){this.steeringDirection = sd;}
	public void getMaximumSpeed(int ms) {this.maximumSpeed = ms;}
	public void getEnergyLevel(int el){this.energyLevel = el;}
	public void getEnergyConsumptionRate(int ecr){this.energyConsumptionRate = ecr;}
	public void getDamageLevel(int dl){this.damageLevel = dl;}
	public void getLastBaseReached(int lbr){this.lastBaseReached = lbr;}
	
	public String info(){
		
		String s = "";
		s = s + "Robot: Loc- " + + this.getLocation().getX() +", " + this.getLocation().getY() +" ";
		s = s + "Color: [" + ColorUtil.red(this.getColor()) + ", " + ColorUtil.green(this.getColor()) + ", " + ColorUtil.blue(this.getColor()) +"]" +" ";
		s = s + "Heading: " + this.getHeading()+" ";
		s = s + "Speed: " + this.getSpeed()+" ";
		s = s + "Size: " + this.getSize() + "\n    ";
		s = s + "Steering Direction: " + this.getMaximumSpeed() +" ";
		s = s + "Steering Direction: " + this.getSteeringDirection() +" ";
		s = s + "Energy Level: " + this.getEnergyLevel() +" ";
		s = s + "Damage Level: " + this.getDamageLevel();
		return s;
	}
	
	
	
}
