package com.mycompany.a2;

import com.codename1.util.MathUtil;

public class BaseStrategy implements IStrategy {
	private String name = "Base Strategy";
	
	private Base b;
	private NonPlayerRobot npr;
	
	BaseStrategy(GameWorld gw, NonPlayerRobot npr){
		
		this.npr = npr;
		
		GameObject tempGO;
		IIterator j = gw.getCollection().getIterator();
		while(j.hasNext()){
			tempGO = j.getNext();
			if(tempGO instanceof Base && ((Base) tempGO).getSequence()-1 == npr.getLastBaseReached()){
				b = ((Base) tempGO);
			}
		}
		
	}
	
	@Override
	public String getName(){return this.name;}
	
	@Override 
	public void changeStrat(){
		double goX = b.getLocation().getX();
		double goY = b.getLocation().getY();
		
		double currX = npr.getLocation().getX();
		double currY = npr.getLocation().getY();
		
		double newAngle = (double)(90 -  Math.toDegrees(MathUtil.atan2(((double)goX-currX),((double)goY-currY))));
		newAngle = 90 - newAngle;
		
		npr.setHeading((int)newAngle);
	};
}