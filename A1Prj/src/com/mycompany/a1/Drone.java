package com.mycompany.a1;
import java.util.Random;

public class Drone extends Movable{
//	size can be between 10 to 50
	public Drone(int size){
		Random r = new Random();
		super(size);
		speed = 5 + (10 - 5) * r.nextInt();
		heading = 0 + 359 * r.nextInt();
		
	}
	
}
