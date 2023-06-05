package com.mycompany.a2;

import com.codename1.util.MathUtil;

public class AttackStartegy implements IStrategy {
	private String name = "Attack Strategy";
	
	private PlayerRobot r;
	private NonPlayerRobot npr;
	
	AttackStartegy(GameWorld gw, NonPlayerRobot npr){
		
		this.npr = npr;
		
		GameObject tempGO;
		IIterator j = gw.getCollection().getIterator();
		while(j.hasNext()){
			tempGO = j.getNext();
			if(tempGO instanceof PlayerRobot){
				r = ((PlayerRobot)tempGO);
			}
		}
		
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
