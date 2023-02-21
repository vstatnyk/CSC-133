package com.mycompany.a1;

public class Base extends Fixed{
//	size has to equal robot
//	not allowed to change color
//  not allowed to move
//	(e.g, size of all bases can be 10 and size of all robots can be 40)
	private int sequenceNumber;
	
	public Base(int sequenceNum) {
		super();
		this.sequenceNumber = sequenceNum;
	}
}
