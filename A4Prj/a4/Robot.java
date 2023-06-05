package com.mycompany.a4;
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
//		maximumSpeed ;
		energyLevel = 100;
	}
	
	public Robot(int size) {
//		size has to equal base set by me
//		(e.g, size of all bases can be 10 and size of all robots can be 40)
		super(ColorUtil.rgb(0, 250, 0), size);

		this.setSpeed(3);
		this.setHeading(0);
		maximumSpeed = 4;
		lastBaseReached = 1;
		steeringDirection = 0;
		damageLevel = 0;
		energyLevel = 100;
	}
	

	private int lastBaseReached;
	private int steeringDirection; // + - 5 degrees in range 0-40
	private double energyConsumptionRate = 0.1;
	private int damageLevel; 
	private int maximumSpeed = 4;
	private double energyLevel;
	private int maxDamageLevel =  50; //needs to change in NPR
	private int lives = 3;
	
	
	public int getSteeringDirection(){return this.steeringDirection;}
	public int getMaximumSpeed(){return this.maximumSpeed;}
	public double getEnergyLevel(){return this.energyLevel;}
	public double getEnergyConsumptionRate(){return this.energyConsumptionRate;}
	public int getDamageLevel(){return this.damageLevel;}
	public int getLastBaseReached(){return this.lastBaseReached;}
	public int getLives(){return this.lives;}
	public int getMaxDamageLevel(){return this.maxDamageLevel;}
	
	public void SetSteeringDirection(int sd){this.steeringDirection = sd;}
	public void setMaximumSpeed(int ms) {
		if(ms<2){
			this.maximumSpeed = 2;
		}
		else{
			this.maximumSpeed = ms;
		}
	}
	public void setEnergyLevel(double el){this.energyLevel = el;}
	public void setConsumptionRate(int el){this.energyConsumptionRate = el;}
	public void setDamageLevel(int dl){this.damageLevel = dl;}
	public void setMaxDamageLevel(int dl){this.maxDamageLevel = dl;}
	public void setLastBaseReached(int lbr){this.lastBaseReached = lbr;}
	public void setLives(){this.lives--;}
	
	
	public void accelerate(){
		//needs energy level and damage level varibales to play affect
//		System.out.println(this.getSpeed());
//		System.out.println(this.getMaximumSpeed());
		if(this.getMaximumSpeed() > this.getSpeed()){
			this.setSpeed(this.getSpeed()+1);
		}
		else{
			System.out.println("max speed is reached: " + this.getSpeed());
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
		maxDamageLevel = 10;
//		maximumSpeed = 10;
		energyLevel = 100;
		this.setColor(0, 250, 0);
		this.lives = this.lives - 1;
		this.setMaximumSpeed(10);
	};

	public void refilEnergyLevel(int el){
		
		this.energyLevel = this.energyLevel + el;
		if(this.energyLevel > 100) {
			this.energyLevel =100;
		}
	}
	
	public void decEnergyLevel(){
//		System.out.print("\n\n\n\n\n\n\n\n\n\n"+(this.energyLevel - this.energyConsumptionRate));
		this.energyLevel = this.energyLevel - this.energyConsumptionRate;
		if((int)this.energyLevel == 0) {
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
	
	@Override
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
