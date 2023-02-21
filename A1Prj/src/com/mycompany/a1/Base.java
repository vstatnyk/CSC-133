package com.mycompany.a1;
import com.codename1.charts.util.ColorUtil;

//ColorUtil.rgb(r, g, b) for any int color
public class Base extends Fixed{
//	size has to equal robot
//	not allowed to change color
//  not allowed to move
//	(e.g, size of all bases can be 10 and size of all robots can be 40)
	private int sequenceNumber;
	
	public Base(int sequenceNum) {
		super(10, ColorUtil.rgb(0, 100, 0));
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
	
}
