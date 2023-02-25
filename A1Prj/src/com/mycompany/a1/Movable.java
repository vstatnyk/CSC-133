package com.mycompany.a1;
import java.util.Random;

public class Movable extends GameObject {
	private int heading;
	private int speed;
	
	public Movable(int size, int color, int speed, int heading){
		super(size, color);
		System.out.println(color);
		this.speed = speed;
		this.heading = heading;
	}
	
	public Movable(int color, int speed, int heading){
		super(color);
		this.speed = speed;
		this.heading = heading;
	}
	
	public Movable(int color){
		super(color);
	}
	
	public Movable(int color, int size){
		super(color, size);
	}
	
	public void move() {
		//update location based on heading, speed;
//		newLocation(x,y) = oldLocation(x,y) + (deltaX, deltaY), where 
//				deltaX = cos(θ)*speed,   
//				deltaY = sin(θ)*speed, 
		
		double deltaX = Math.cos(getHeading()) * this.speed;
		double deltaY = Math.sin(getHeading()) * this.speed;
		this.setLocation(this.getLocation().getX() + deltaX, this.getLocation().getY() + deltaY);
		
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public int getSpeed() {
		return this.speed;
	}
	
	public void setHeading(int heading) {
		this.heading = heading;
	}
	
	public int getHeading() {
		return this.heading;
	}
}

