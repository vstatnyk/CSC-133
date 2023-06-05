package com.mycompany.a3;
//import Robot.java

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;

public class PlayerRobot extends Robot implements IDrawable{
	private static PlayerRobot instance;
	private GameWorld gw;
	
	private PlayerRobot(int size, GameWorld gw){
		super(size);
		this.gw = gw;
	}
	
	public static PlayerRobot getInstatnce(GameWorld gw){
		if (instance == null){
			instance = new PlayerRobot(100, gw);
		}
		return instance;
	}
	
	@Override
	public  void draw(Graphics g){
//		unfilled square
		
		
		int x = (int)this.getLocation().getX();
		int y = (int)this.getLocation().getY();
		//base
		g.setColor(ColorUtil.rgb(255,0,0)); //red
		int[] xPoints = {x-(this.getSize() / 2), x + (this.getSize() / 2),x + (this.getSize() / 2), x-(this.getSize() / 2)};
		int[] yPoints = {y + (this.getSize()/2), y + (this.getSize()/2), y - (this.getSize()/2), y - (this.getSize()/2)};
		g.fillPolygon(xPoints, yPoints, 4);
		


	}
	
	public void handleCollision(GameObject otherObject){
//		if (this.getCollisionVector().contains(otherObject)){
			
			
			
			if(otherObject instanceof NonPlayerRobot){
//				System.out.println("COLLISION\n\n\n");
				if (this.getCollisionVector().contains(otherObject)){
					System.out.println("removed\n\n\n");
					this.getCollisionVector().remove(otherObject);
				}
				else{
					this.getCollisionVector().add(otherObject);
					
					
					this.setDamageLevel(this.getDamageLevel() + 1);
					this.setMaximumSpeed(this.getMaximumSpeed()-this.getDamageLevel());
					int fadeIncrement = 250/this.getMaxDamageLevel();
					this.setColor(ColorUtil.red(this.getColor())+fadeIncrement, ColorUtil.green(this.getColor())-fadeIncrement, ColorUtil.blue(this.getColor()));
					if(this.getSpeed()>this.getMaximumSpeed()) {
						this.setSpeed(this.getMaximumSpeed());
					}
					
					
					
					((NonPlayerRobot)otherObject).setDamageLevel(this.getDamageLevel() + 1);
					((NonPlayerRobot)otherObject).setMaximumSpeed(this.getMaximumSpeed()-1);
					fadeIncrement = 250/((NonPlayerRobot)otherObject).getMaxDamageLevel();
					((NonPlayerRobot)otherObject).setColor(ColorUtil.red(this.getColor())+fadeIncrement, ColorUtil.green(this.getColor())-fadeIncrement, ColorUtil.blue(this.getColor()));
					if(((NonPlayerRobot)otherObject).getSpeed()>((NonPlayerRobot)otherObject).getMaximumSpeed()) {
						((NonPlayerRobot)otherObject).setSpeed(((NonPlayerRobot)otherObject).getMaximumSpeed());
					}
				}
			}
			if(otherObject instanceof Base){
				if (this.getLastBaseReached()+1 == ((Base)otherObject).getSequence()){
					this.setLastBaseReached(((Base)otherObject).getSequence());
					//temp 4 bases
					
				}
				else{
					System.out.println("Wrong base");
				}
			}
			if(otherObject instanceof Drone){
				if (this.getCollisionVector().contains(otherObject)){
					this.getCollisionVector().remove(otherObject);
				}
				else{
					this.getCollisionVector().add(otherObject);
					
					
					this.setDamageLevel(this.getDamageLevel() + 1);
					this.setMaximumSpeed(this.getMaximumSpeed()-1);
					int fadeIncrement = 250/this.getMaxDamageLevel();
					this.setColor(ColorUtil.red(this.getColor())+fadeIncrement, ColorUtil.green(this.getColor())-fadeIncrement, ColorUtil.blue(this.getColor()));
					if(this.getSpeed()>this.getMaximumSpeed()) {
						this.setSpeed(this.getMaximumSpeed());
					}
				}
			}
			if(otherObject instanceof EnergyStation && !(((EnergyStation)otherObject).isEmpty())){
				this.refilEnergyLevel(((EnergyStation)otherObject).getCapacity());
				((EnergyStation)otherObject).setCapacity(0);
				((EnergyStation)otherObject).setColor(0, 100, 0);
				gw.getCollection().add(new EnergyStation());
				
			}
//		}
	}
	
}