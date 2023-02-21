package com.mycompany.a1;
import java.util.Random;
import com.codename1.charts.util.ColorUtil;


public abstract class GameObject {

	// Constructors
	public GameObject(int size, int r, int g, int b) {
		Random r = new Random();
		
		this.size = size;
		this.color = ColorUtil.rgb(r, g, b);
		
		double lowXY = size/2;
		double highX = 1024 - (size/2);
		double highY = 768 - (size/2);
//		double randomValue = rangeMin + (rangeMax - rangeMin)
		double x = lowXY + (highX - lowXY) * r.nextDouble();
		double y = lowXY + (highY - lowXY) * r.nextDouble();
		this.location = new Coordinate(x, y);
	}
	
	public GameObject(int color) {
		this.color = color;
	}
	
	//Attributes
	private int size;
	private Coordinate location;
	private int color;
	
	//Methods
	public int getSize(){
		return size;
	}
	
	public Coordinate getLocation(){
		return location;
	}
	
	public void setLocation(double x, double y){
		double lowXY = size/2;
		double highX = 1024 - (size/2);
		double highY = 768 - (size/2);
		
		if(x <= highX && y <= highY && x >= lowXY && y >= lowXY){
			location.setCoordinate(x,y);
		}
//		else print out not possible location
		
//		location.setCoordinate(x,y);
	}
	
	public void setColor(int r, int g , int b){
		this.color = ColorUtil.rgb(r, g, b);
	}
	
	public int getColor(){
		return this.color;
	}
}
