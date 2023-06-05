package com.mycompany.a2;

public class Coordinate {
	
	private double x;
	private double y;
	
	public Coordinate (double x, double y){
		this.x = x;
		this.y = y;
	};
	
	public Coordinate (){
		this.x = 0;
		this.y = 0;
	};
	
	public void setY(double y){
		this.y = y;
	};
	
	public void setX(double x){
		this.x = x;
	};
	
	public void setCoordinate(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public double getY(){
		return this.y;
	};
	
	public double getX(){
		return this.x;
	};

}

