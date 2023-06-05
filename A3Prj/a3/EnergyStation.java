package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;

public class EnergyStation extends Fixed implements IDrawable{
	private int capacity; //proportional to size
	
	public EnergyStation(){
		super(ColorUtil.rgb(100,0,0));
		capacity = this.getSize()/5;
	}
	
	public int getCapacity(){
		return this.capacity;
	}
	
	public void setCapacity(int c){
		this.capacity = c;
	}
	
	public boolean isEmpty(){
		if(this.capacity != 0){
			return false;
		}
		return true;
	}
	
	@Override
	public String info(){
		String s = "";
		s = s + "Energy Stattion: Loc- " + + this.getLocation().getX() +", " + this.getLocation().getY() +" ";
		s = s + "Color: [" + ColorUtil.red(this.getColor()) + ", " + ColorUtil.green(this.getColor()) + ", " + ColorUtil.blue(this.getColor()) +"]" +" ";
		s = s + "Size: " + this.getSize() + " ";
		s = s + "Capacity: " + this.getCapacity()+" ";
		return s;
	}
	
	@Override
	public void draw(Graphics g){
//		filled circle
		int x = (int)this.getLocation().getX();
		int y = (int)this.getLocation().getY();
		int radius = this.getSize()/2;
		
		//bound box
//		int[] xPoints = {x-(this.getSize() / 2), x + (this.getSize() / 2),x + (this.getSize() / 2), x-(this.getSize() / 2)};
//		int[] yPoints = {y + (this.getSize()/2), y + (this.getSize()/2), y - (this.getSize()/2), y - (this.getSize()/2)};
//		g.drawPolygon(xPoints, yPoints, 3);
		
		//base
		g.setColor(0x046307); //emerald green
		g.fillArc(x - radius, y - radius, radius * 2, radius * 2, 0, 360); // Draw a filled circle
		
		//number in the base
		String numberString = Integer.toString(this.getCapacity());
	    int numberWidth = g.getFont().stringWidth(numberString);
	    int numberHeight = g.getFont().getHeight();
	    int centerX = x - (numberWidth / 2);
	    int centerY = y - (numberHeight / 2);
	    g.setColor(0x000000);// Black
	    g.drawString(numberString, centerX, centerY);
		
	}



}