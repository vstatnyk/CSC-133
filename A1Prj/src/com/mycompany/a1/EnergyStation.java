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
}
