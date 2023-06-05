package com.mycompany.a3;
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
	
	public void move(double time) {
		double theta = Math.toRadians(90 - this.getHeading());
        int deltaX = (int) ((this.speed) * Math.cos(theta));
        int deltaY = (int) ((this.speed) * Math.sin(theta));
		this.setLocation(this.getLocation().getX() + deltaX, this.getLocation().getY() + deltaY);
		
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public int getSpeed() {
		return this.speed;
	}
	
	public void setHeading(int heading) {
		if(heading >359){
			this.heading = heading%360;
			return;
		}
		else if(heading < 0) {
			this.heading = 360+heading;
			return;
		}
		this.heading = heading;
		 
	}
	
	public int getHeading() {
		return this.heading;
	}
}

