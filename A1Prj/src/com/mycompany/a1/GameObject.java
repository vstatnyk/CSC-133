package com.mycompany.a1;
import java.util.Random;
import com.codename1.charts.util.ColorUtil;


public abstract class GameObject {

	// Constructors
	public GameObject(int color, int size) {
		Random rand = new Random();
		
		this.size = size;
		this.color = color;
		
		double lowXY = size/2;
		double highX = 1024 - (size/2);
		double highY = 768 - (size/2);
//		double randomValue = rangeMin + (rangeMax - rangeMin)
		double x = rand.nextDouble() * (highX - lowXY);
		double y = rand.nextDouble() * (highY - lowXY);
//		double x = lowXY + (highX - lowXY) * rand.nextDouble();
//		double y = lowXY + (highY - lowXY) * rand.nextDouble();
		this.location = new Coordinate(x, y);
	}
	
	public GameObject(int color) {
		
		Random rand = new Random();
		this.size = 10 + (50 - 10) * rand.nextInt();
		
		double lowXY = size/2;
		double highX = 1024 - (size/2);
		double highY = 768 - (size/2);
//		double randomValue = rangeMin + (rangeMax - rangeMin)
		double x = rand.nextDouble() * (highX - lowXY);
		double y = rand.nextDouble() * (highY - lowXY);
//		double x = lowXY + (highX - lowXY) * rand.nextDouble();
//		double y = lowXY + (highY - lowXY) * rand.nextDouble();
		this.location = new Coordinate(x, y);
		
		this.color = color;
	}
	
	//Attributes
	private int size;
	private Coordinate location;
	private static int color;
	
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
		else{
			System.out.println("Error: this location is not possible due to size of the object\n GameObject.java line 52");
		}
//		location.setCoordinate(x,y);
	}
	
	public void setColor(int r, int g , int b){
		this.color = ColorUtil.rgb(r, g, b);
	}
	
	public int getColor(){
		return this.color;
	}
}
