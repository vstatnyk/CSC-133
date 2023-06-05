package com.mycompany.a4;

import com.codename1.util.MathUtil;

public class AttackStartegy implements IStrategy {
	private String name = "Attack Strategy";
	
	private PlayerRobot r;
	private NonPlayerRobot npr;
	
	AttackStartegy(GameWorld gw, NonPlayerRobot npr){
		
		this.npr = npr;
		this.r = (PlayerRobot)gw.getPlayerRobot();
//		changeStrat();
	}
	
	@Override
	public String getName(){return this.name;}
	
	@Override 
	public void changeStrat(){
		
		double goX = r.getLocation().getX();
		double goY = r.getLocation().getY();
		
		double currX = npr.getLocation().getX();
		double currY = npr.getLocation().getY();
		
		double newAngle = (double)(90 -  Math.toDegrees(MathUtil.atan2(((double)goX-currX),((double)goY-currY))));
		newAngle = 90 - newAngle;
		
		npr.setHeading((int)newAngle);
		
	};
}
