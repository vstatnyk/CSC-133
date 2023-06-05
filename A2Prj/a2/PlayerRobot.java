package com.mycompany.a2;
//import Robot.java

public class PlayerRobot extends Robot{
	private static PlayerRobot instance;
	
	private PlayerRobot(int size){
		super(size);
	}
	
	public static PlayerRobot getInstatnce(){
		if (instance == null){
			instance = new PlayerRobot(10);
		}
		return instance;
	}
}