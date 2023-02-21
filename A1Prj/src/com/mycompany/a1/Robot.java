package com.mycompany.a1;
import java.util.Random;

import com.codename1.charts.util.ColorUtil;

public class Robot extends Movable {
	public Robot(int size, double x, double y) {
//		size has to equal base set by me
//		(e.g, size of all bases can be 10 and size of all robots can be 40)
		super(ColorUtil.rgb(50, 70, 20), size);
		this.setLocation(x, y);
		lastBaseReached = 1;
		speed = 1;
		heading = 0;
		steeringDirection = 0;
	}
	
	int steeringDirection; // + - 5 degrees in range 0-40
	int maximumSpeed;
	int energyLevel;
	int energyConsumptionRate;
	int damageLevel; 
	int lastBaseReached;
}
