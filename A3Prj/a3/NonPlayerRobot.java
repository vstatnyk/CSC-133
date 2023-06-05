package com.mycompany.a3;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;

public class NonPlayerRobot extends Robot implements IDrawable{
	
	private IStrategy strategy;
	private GameWorld gw;
	
	
	public NonPlayerRobot(int size, GameWorld gw){
		super(size);
		this.setConsumptionRate(0);
		this.setMaxDamageLevel(5000);
		this.setMaximumSpeed(1);
		this.setSpeed(this.getMaximumSpeed());
		this.gw = gw;
		
		
	}
	
	public NonPlayerRobot(int size, double x, double y, GameWorld gw){
		super(size, x, y);
		
		
		Random rand = new Random();
		int lowX = (size/2)+304;
		int lowY = (size/2)+73;
		int highX = 1464 - (size/2);
		int highY = 1233 - (size/2);
		x = rand.nextInt((highX - lowX) + 1) + lowX;
		y = rand.nextInt((highY - lowY) + 1) + lowY;
		
		this.setLocation(x, y);
		
		this.setConsumptionRate(0);
		this.setMaxDamageLevel(100);
		this.setMaximumSpeed(1);
		this.setSpeed(this.getMaximumSpeed());
		this.setLastBaseReached(0);
		this.gw = gw;
		
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
	
	@Override
	public void setMaximumSpeed(int ms) {}
//	
	@Override
	public void draw(Graphics g){
//		unfilled square
		
		
		int x = (int)this.getLocation().getX();
		int y = (int)this.getLocation().getY();
		//base
		g.setColor(ColorUtil.rgb(255,0,0)); //red
		int[] xPoints = {x-(this.getSize() / 2), x + (this.getSize() / 2),x + (this.getSize() / 2), x-(this.getSize() / 2)};
		int[] yPoints = {y + (this.getSize()/2), y + (this.getSize()/2), y - (this.getSize()/2), y - (this.getSize()/2)};
		g.drawPolygon(xPoints, yPoints, 4);
	}
	
	@Override
	public void handleCollision(GameObject otherObject){
		System.out.println("COLLISION");
//		if (this.getCollisionVector().contains(otherObject)){
			if(otherObject instanceof PlayerRobot){
				
				if (this.getCollisionVector().contains(otherObject)){
					this.getCollisionVector().remove(otherObject);
				}
				else{
					this.getCollisionVector().add(otherObject);
					
					
					this.setDamageLevel(this.getDamageLevel() + 1);
//					this.setMaximumSpeed(this.getMaximumSpeed()-1);
					int fadeIncrement = 250/this.getMaxDamageLevel();
					this.setColor(ColorUtil.red(this.getColor())+fadeIncrement, ColorUtil.green(this.getColor())-fadeIncrement, ColorUtil.blue(this.getColor()));
					if(this.getSpeed()>this.getMaximumSpeed()) {
						this.setSpeed(this.getMaximumSpeed());
					}
//					
					((PlayerRobot)otherObject).setDamageLevel(this.getDamageLevel() + 1);
					((PlayerRobot)otherObject).setMaximumSpeed(this.getMaximumSpeed()-1);
					 fadeIncrement = 250/((PlayerRobot)otherObject).getMaxDamageLevel();
					((PlayerRobot)otherObject).setColor(ColorUtil.red(this.getColor())+fadeIncrement, ColorUtil.green(this.getColor())-fadeIncrement, ColorUtil.blue(this.getColor()));
					if(((PlayerRobot)otherObject).getSpeed()>((PlayerRobot)otherObject).getMaximumSpeed()) {
						((PlayerRobot)otherObject).setSpeed(((PlayerRobot)otherObject).getMaximumSpeed());
					}
				}
			}
			if(otherObject instanceof NonPlayerRobot){
//				if (this.getCollisionVector().contains(otherObject)){
//					this.getCollisionVector().remove(otherObject);
//				}
//				else{
//					this.getCollisionVector().add(otherObject);
//					
//					
//					this.setDamageLevel(this.getDamageLevel() + 1);
////					this.setMaximumSpeed(this.getMaximumSpeed()-1);
//					int fadeIncrement = 250/this.getMaxDamageLevel();
//					this.setColor(ColorUtil.red(this.getColor())+fadeIncrement, ColorUtil.green(this.getColor())-fadeIncrement, ColorUtil.blue(this.getColor()));
//					if(this.getSpeed()>this.getMaximumSpeed()) {
//						this.setSpeed(this.getMaximumSpeed());
//					}
//					
//					((NonPlayerRobot)otherObject).setDamageLevel(this.getDamageLevel() + 1);
////					((NonPlayerRobot)otherObject).setMaximumSpeed(this.getMaximumSpeed()-1);
//					fadeIncrement = 250/((NonPlayerRobot)otherObject).getMaxDamageLevel();
//					((NonPlayerRobot)otherObject).setColor(ColorUtil.red(this.getColor())+fadeIncrement, ColorUtil.green(this.getColor())-fadeIncrement, ColorUtil.blue(this.getColor()));
//					if(((NonPlayerRobot)otherObject).getSpeed()>((NonPlayerRobot)otherObject).getMaximumSpeed()) {
//						((NonPlayerRobot)otherObject).setSpeed(((NonPlayerRobot)otherObject).getMaximumSpeed());
//					}
//				}
			}
			if(otherObject instanceof Base){
				if (this.getLastBaseReached()+1 == ((Base)otherObject).getSequence()){
					this.setLastBaseReached(((Base)otherObject).getSequence());
					this.gw.checkEnd();
//					this.gw.brake();
					this.setStrategy(new BaseStrategy(this.gw,this));
					this.invokeStrategy();
					//temp 4 bases
					
				}
				else{
					System.out.println("Wrong base");
				}
			}
			if(otherObject instanceof Drone){
//				if (this.getCollisionVector().contains(otherObject)){
//					this.getCollisionVector().remove(otherObject);
//				}
//				else{
//					this.getCollisionVector().add(otherObject);
//					
//					
//					this.setDamageLevel(this.getDamageLevel() + 1);
//					this.setMaximumSpeed(this.getMaximumSpeed()-1);
//					int fadeIncrement = 250/this.getMaxDamageLevel();
//					this.setColor(ColorUtil.red(this.getColor())+fadeIncrement, ColorUtil.green(this.getColor())-fadeIncrement, ColorUtil.blue(this.getColor()));
//					if(this.getSpeed()>this.getMaximumSpeed()) {
//						this.setSpeed(this.getMaximumSpeed());
//					}
//				}
			}
			if(otherObject instanceof EnergyStation && !(((EnergyStation)otherObject).isEmpty())){
				this.refilEnergyLevel(((EnergyStation)otherObject).getCapacity());
				((EnergyStation)otherObject).setCapacity(0);
				((EnergyStation)otherObject).setColor(0, 100, 0);
			}
		}
//	}
	
}
