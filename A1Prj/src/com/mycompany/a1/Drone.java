package com.mycompany.a1;
import java.util.Random;
import com.codename1.charts.util.ColorUtil;
//ColorUtil.rgb(r, g, b) for any int color

public class Drone extends Movable{
//	size can be between 10 to 50
	public Drone(int size){
		super(ColorUtil.rgb(0, 0, 100), size);
		Random r = new Random();
		this.setSpeed(5 + (10 - 5) * r.nextInt());
		this.setHeading(heading = 0 + 359 * r.nextInt());
	}
	
}
