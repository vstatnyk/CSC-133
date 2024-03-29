package com.mycompany.a1;
import java.util.Random;

import com.codename1.charts.util.ColorUtil;

public class Robot extends Movable implements ISteerable {
	public Robot(int size, double x, double y) {
//		size has to equal base set by me
//		(e.g, size of all bases can be 10 and size of all robots can be 40)
		super(ColorUtil.rgb(0, 250, 0), size);
		this.setLocation(x, y);

		this.setSpeed(1);
		this.setHeading(0);
		lastBaseReached = 1;
		steeringDirection = 0;
//		energyConsumptionRate = 1;
		damageLevel = 0;
//		maximumSpeed = 10;
		energyLevel = 100;
	}
	
	public Robot(int size) {
//		size has to equal base set by me
//		(e.g, size of all bases can be 10 and size of all robots can be 40)
		super(ColorUtil.rgb(0, 250, 0), size);

		this.setSpeed(1);
		this.setHeading(0);
		lastBaseReached = 1;
		steeringDirection = 0;
//		energyConsumptionRate = 1;
		damageLevel = 0;
//		maximumSpeed = 10;
		energyLevel = 100;
	}
	

	private int lastBaseReached;
	private int steeringDirection; // + - 5 degrees in range 0-40
	private int energyConsumptionRate = 5;
	private int damageLevel; 
	private int maximumSpeed = 5;
	private int energyLevel;
	private int maxDamageLevel = 5;
	private int lives = 3;
	
	
	public int getSteeringDirection(){return this.steeringDirection;}
	public int getMaximumSpeed(){return this.maximumSpeed;}
	public int getEnergyLevel(){return this.energyLevel;}
	public int getEnergyConsumptionRate(){return this.energyConsumptionRate;}
	public int getDamageLevel(){return this.damageLevel;}
	public int getLastBaseReached(){return this.lastBaseReached;}
	public int getLives(){return this.lives;}
	public int getMaxDamageLevel(){return this.maxDamageLevel;}
	
	public void SetSteeringDirection(int sd){this.steeringDirection = sd;}
	public void setMaximumSpeed(int ms) {this.maximumSpeed = ms;}
	public void setEnergyLevel(int el){this.energyLevel = el;}
	public void setDamageLevel(int dl){this.damageLevel = dl;}
	public void setLastBaseReached(int lbr){this.lastBaseReached = lbr;}
	public void setLives(){this.lives--;}
	
	
	public void accelerate(){
		//needs energy level and damage level varibales to play affect
		if(this.getMaximumSpeed() < this.getSpeed()){
			this.setSpeed(this.getSpeed() + 1);
		}
		return;
	}
	
	public void brake(){
		int newSpeed = this.getSpeed() - 1;
		if (newSpeed < 0) {
			this.setSpeed(0);
			return;
		}
		this.setSpeed(newSpeed);
	}

	public void reset(double x, double y){
		this.setLocation(x, y);
		this.setSpeed(1);
		this.setHeading(0);
		lastBaseReached = 1;
		steeringDirection = 0;
//		energyConsumptionRate = 1;
		damageLevel = 0;
//		maximumSpeed = 10;
		energyLevel = 100;
		this.setColor(0, 250, 0);
		this.lives = this.lives -1;
		this.setMaximumSpeed(this.maxDamageLevel);
	};

	public void refilEnergyLevel(int el){
		
		this.energyLevel = this.energyLevel + el;
		if(this.energyLevel > 100) {
			this.energyLevel =100;
		}
	}
	
	public void decEnergyLevel(){
		this.energyLevel = this.energyLevel - this.energyConsumptionRate;
		if(this.energyLevel == 0) {
			this.setSpeed(0);
			System.out.println("drone is out of energy");
		}
	}
	
	public void goLeft(){
		if(this.steeringDirection != -40){
			this.steeringDirection = this.steeringDirection-5;
		}
		this.setHeading(this.getHeading()+this.getSteeringDirection());
	}
	
	public void goRight(){
		if(this.steeringDirection != 40){
			this.steeringDirection = this.steeringDirection+5;
		}
		this.setHeading(this.getHeading()+this.getSteeringDirection());
	}
	
	public String info(){
		
		String s = "";
		s = s + "Robot: Loc- " + + this.getLocation().getX() +", " + this.getLocation().getY() +" ";
		s = s + "Color: [" + ColorUtil.red(this.getColor()) + ", " + ColorUtil.green(this.getColor()) + ", " + ColorUtil.blue(this.getColor()) +"]" +" ";
		s = s + "Heading: " + this.getHeading()+" ";
		s = s + "Speed: " + this.getSpeed()+" ";
		s = s + "Size: " + this.getSize() + "\n    ";
		s = s + "Maximum Speed: " + this.getMaximumSpeed() +" ";
		s = s + "Steering Direction: " + this.getSteeringDirection() +" ";
		s = s + "Energy Level: " + this.getEnergyLevel() +" ";
		s = s + "Damage Level: " + this.getDamageLevel();
		return s;
	}
	
	
	
}
