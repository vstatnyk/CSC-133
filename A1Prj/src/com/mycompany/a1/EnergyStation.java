package com.mycompany.a1;

import com.codename1.charts.util.ColorUtil;

public class EnergyStation extends Fixed{
	private int capacity; //proportional to size
	
	public EnergyStation(){
		super(ColorUtil.rgb(100,0,0));
		capacity = this.getSize();
	}
	
	public int getCapacity(){
		return this.capacity;
	}
	
	public boolean isEmpty(){
		if(this.capacity != 0){
			return false;
		}
		return true;
	}
	
	public String info(){
		String s = "";
		s = s + "Energy Stattion: Loc- " + + this.getLocation().getX() +", " + this.getLocation().getY() +" ";
		s = s + "Color: [" + ColorUtil.red(this.getColor()) + ", " + ColorUtil.green(this.getColor()) + ", " + ColorUtil.blue(this.getColor()) +"]" +" ";
		s = s + "Size: " + this.getSize() + " ";
		s = s + "Capacity: " + this.getCapacity()+" ";
		return s;
	}
}
