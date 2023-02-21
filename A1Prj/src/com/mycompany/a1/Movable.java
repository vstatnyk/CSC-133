package com.mycompany.a1;
import java.util.Random;

public class Movable extends GameObject {
	protected int heading;
	protected int speed;
	
	public Movable(int size, int color, int speed, int heading){
		super(size, color);
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

