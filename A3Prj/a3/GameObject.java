package com.mycompany.a3;
import java.util.Random;
import java.util.Vector;
import java.lang.Math;
import com.codename1.charts.util.ColorUtil;
import com.codename1.util.MathUtil;


public abstract class GameObject implements ICollider{

	
	
	// Constructors
	public GameObject(int color, int size) {
		Random rand = new Random();
		
		this.size = size;
		this.color = color;
		
//		hX 1464
//		lX 304
//		HY 1745
//		lY 189
//		
//		int lowXY = size/2;
		int lowX = (size/2)+304;
		int lowY = (size/2)+73;
		int highX = 1860 - (size/2);
		int highY = 1233 - (size/2);
		
		double x = rand.nextInt((highX - lowX) + 1) + lowX;
		double y = rand.nextInt((highY - lowY) + 1) + lowY;
//		double x = lowX + rand.nextInt(highX);
//		double y = lowY + rand.nextInt(highY);
		
		this.location = new Coordinate(x, y);
	}
	
	public GameObject(int color) {
		
		Random rand = new Random();
		this.size =  50 + rand.nextInt(100);
		
		int lowX = (size/2)+304;
		int lowY = (size/2)+73;
		int highX = 1860 - (size/2);
		int highY = 1233 - (size/2);

		double x = rand.nextInt((highX - lowX) + 1) + lowX;
		double y = rand.nextInt((highY - lowY) + 1) + lowY;

		this.location = new Coordinate(x, y);
		
		this.color = color;
	}
	
	//Attributes
	private int size;
	private Coordinate location;
	private int color;
	private Vector<GameObject> collisionVector = new Vector<GameObject>();
	
	//Methods
	public int getSize(){
		return size;
	}
	
	public Coordinate getLocation(){
		return location;
	}
	
	public void setLocation(double x, double y){
		int lowX = (size/2)+304;
		int lowY = (size/2)+73;
		int highX = 1860 - (size/2);
		int highY = 1233 - (size/2);
		
		
		if(x <= highX && y <= highY && x >= lowX && y >= lowY){
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
	
	public Vector<GameObject> getCollisionVector() {return this.collisionVector;}
	
	public String info(){return "default";}
	
	@Override
	public boolean collidesWith(GameObject otherObject){

		double thisX = this.getLocation().getX();
		double thisY = this.getLocation().getY();
		double otherX = ((GameObject)otherObject).getLocation().getX();
		double otherY = ((GameObject)otherObject).getLocation().getY();
				
		double deltaX = thisX - otherX;
		double deltaY = thisY - otherY;
		
		double distance = ((int) (MathUtil.pow((int)deltaX, 2)) + (int) (MathUtil.pow((int)deltaY, 2)));
		
		int radius1= this.getSize() / 2;
		int radius2= ((GameObject)otherObject).getSize() / 2;
		
		int result= (int) (MathUtil.pow((int)radius1, 2)+ 2 * radius1 * radius2 + (int) (MathUtil.pow((int)radius2, 2)));
		if (distance <= result){return true;}
		
		return false;
	}
	
	@Override
	public void handleCollision(GameObject otherObject){
		
	}
}
