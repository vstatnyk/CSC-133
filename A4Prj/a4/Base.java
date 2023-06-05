package com.mycompany.a4;
import java.util.Arrays;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;

//ColorUtil.rgb(r, g, b) for any int color
public class Base extends Fixed implements IDrawable{
//	size has to equal robot
//	not allowed to change color
//  not allowed to move
//	(e.g, size of all bases can be 10 and size of all robots can be 40)
	private int sequenceNumber;
	
	public Base(int sequenceNum) {
		super(ColorUtil.rgb(0, 100, 0), 100);
		this.sequenceNumber = sequenceNum;
	}
	
	public Base(int sequenceNum, int size) {
		super(ColorUtil.rgb(0, 100, 0), size);
		this.sequenceNumber = sequenceNum;
	}
	
	@Override
    public void setColor(int r, int g, int b){
        System.out.println("Error: you are not allowed to change color of the bases\nBase.java line 17");
    }
	
	public int getSequence(){
        return this.sequenceNumber;
    }
	
	public void setSequence(int sequenceNumber){
       this.sequenceNumber = sequenceNumber;
    }
	
	@Override
	public String info(){
		String s = "";
		s = s + "Base: Loc- " + + this.getLocation().getX() +", " + this.getLocation().getY() +" ";
		s = s + "Color: [" + ColorUtil.red(this.getColor()) + ", " + ColorUtil.green(this.getColor()) + ", " + ColorUtil.blue(this.getColor()) +"]" +" ";
		s = s + "Size: " + this.getSize() + " ";
		s = s + "Sequence Number: " + this.getSequence()+" ";
		return s;
	}
	
	
//	implements IDrawable
	@Override
	public void draw(Graphics g){
//		filled isosceles triangles
		int x = (int)this.getLocation().getX();
		int y = (int)this.getLocation().getY();
		
		//base
		g.setColor(0x00ABAB5); //Tiffany blue
		int[] xPoints = {x-(this.getSize() / 2), x + (this.getSize() / 2), x};
		int[] yPoints = {y - (this.getSize()/2), y- (this.getSize()/2), y + (this.getSize()/2)};
		g.fillPolygon(xPoints, yPoints, 3);
		
		//number in the base
		String numberString = Integer.toString(this.getSequence());
	    int numberWidth = g.getFont().stringWidth(numberString);
	    int numberHeight = g.getFont().getHeight();
	    int centerX = (xPoints[0] + xPoints[1] + xPoints[2]) / 3;
	    int centerY = (yPoints[0] + yPoints[1] + yPoints[2]) / 3;
	    x = centerX - (numberWidth / 2);
	    y = centerY - (numberHeight / 2);
	    g.setColor(0xFFFFFF);// Black
	    g.drawString(numberString, x, y);
		
		
		g.setColor(0x000000);
		g.drawString(""+this.getSequence(), x, y);
	}
}
