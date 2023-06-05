package com.mycompany.a2;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;

public class NonPlayerRobot extends Robot{
	
	private IStrategy strategy;
	
	
	public NonPlayerRobot(int size){
		super(size);
		this.setConsumptionRate(0);
		this.setMaxDamageLevel(10);
		this.setSpeed(this.getMaximumSpeed());
	}
	
	public NonPlayerRobot(int size, double x, double y){
		super(size, x, y);
	}
	
	public void setStrategy(IStrategy strategy) {this.strategy = strategy;}
	public IStrategy getStrategy(){return this.strategy;}
	
	public void invokeStrategy(){
		strategy.changeStrat();
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
		s = s + "Current strategy: " + this.getStrategy().getName();
		return s;
	}
}
