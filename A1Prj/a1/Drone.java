package com.mycompany.a1;
import java.util.Random;
import com.codename1.charts.util.ColorUtil;
//ColorUtil.rgb(r, g, b) for any int color

public class Drone extends Movable{
//	size can be between 10 to 50
	public Drone(int size){
		super(ColorUtil.rgb(0, 0, 100), size);
		Random r = new Random();
		this.setSpeed(5 + r.nextInt(6));
		this.setHeading(r.nextInt(360));
	}

public void resetHeading(){
	Random r = new Random();
	this.setHeading(super.getHeading()+r.nextInt(5));
}
public void move(){
	
}
	
public String info(){
		
		String s = "";
		s = s + "Drone: Loc- " + + this.getLocation().getX() +", " + this.getLocation().getY() +" ";
		s = s + "Color: [" + ColorUtil.red(this.getColor()) + ", " + ColorUtil.green(this.getColor()) + ", " + ColorUtil.blue(this.getColor()) +"]" +" ";
		s = s + "Heading: " + this.getHeading()+" ";
		s = s + "Speed: " + this.getSpeed()+" ";
		s = s + "Size: " + this.getSize() + " ";
		return s;
	}
	
}
