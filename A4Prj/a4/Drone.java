package com.mycompany.a4;
import java.util.Random;
import com.codename1.charts.util.ColorUtil;
//ColorUtil.rgb(r, g, b) for any int color
import com.codename1.ui.Graphics;

public class Drone extends Movable implements IDrawable{
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
	
	Random rand = new Random();
	this.setHeading(this.getHeading()+rand.nextInt(12)-4);
	
	double theta = Math.toRadians(this.getHeading());
    int deltaX = (int) ((this.getSpeed()) * Math.cos(theta));
    int deltaY = (int) ((this.getSpeed()) * Math.sin(theta));
    
	this.setLocation(this.getLocation().getX() + deltaX, this.getLocation().getY() + deltaY);
}

@Override
public String info(){
		
		String s = "";
		s = s + "Drone: Loc- " + + this.getLocation().getX() +", " + this.getLocation().getY() +" ";
		s = s + "Color: [" + ColorUtil.red(this.getColor()) + ", " + ColorUtil.green(this.getColor()) + ", " + ColorUtil.blue(this.getColor()) +"]" +" ";
		s = s + "Heading: " + this.getHeading()+" ";
		s = s + "Speed: " + this.getSpeed()+" ";
		s = s + "Size: " + this.getSize() + " ";
		return s;
	}


@Override
public void draw(Graphics g){
//	unfilled isosceles triangles
	int x = (int)this.getLocation().getX();
	int y = (int)this.getLocation().getY();
	
	//base
	g.setColor(0x000000); //Black
	int[] xPoints = {x-(this.getSize() / 2), x + (this.getSize() / 2), x};
	int[] yPoints = {y - (this.getSize()/2), y- (this.getSize()/2), y + (this.getSize()/2)};
	g.fillPolygon(xPoints, yPoints, 3);
	

}
	
}
