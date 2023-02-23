package com.mycompany.a1;
import com.codename1.ui.events.ActionListener; 
import com.codename1.ui.Label; 
import com.codename1.ui.TextField; 
import com.codename1.ui.events.ActionEvent; 
import java.lang.String; 
import java.util.Vector;
import java.util.Random;

public class GameWorld {
	
	private Robot r;
	private Vector<Base> bases = new Vector<Base>();
	private Vector<EnergyStation> EnergyStations = new Vector<EnergyStation>();
	private Vector<Drone> Drones = new Vector<Drone>();
	
	



	public void init(){
		Random rand = new Random();
		//code here to create the
		//initial game objects/setup
		System.out.println("GameWorld init() invoked");
		
		//new Robot
		this.r = new Robot(10);
		System.out.print("\n" + r.info() + "\n");
		
		//Bases
		for(int i = 1; i < 4; i++ ){
			bases.add(new Base(i));
		}
		for(int i = 0; i < bases.size(); i++ ){
			System.out.println(bases.get(i).info());
		}
		
		r.setLocation(bases.get(0).getLocation().getX(), bases.get(0).getLocation().getY());
		
		//energy stations
		for(int i = 1; i < 4; i++ ){
			EnergyStations.add(new EnergyStation());
		}
		for(int i = 0; i < EnergyStations.size(); i++ ){
			System.out.println(EnergyStations.get(i).info());
		}
		
		//drones
		for(int i = 1; i < 4; i++ ){
			Drones.add(new Drone(10 + rand.nextInt(41)));
		}
		for(int i = 0; i < Drones.size(); i++ ){
			System.out.println(Drones.get(i).info());
		}
		

	}

	public void exit(){System.out.println("GameWorld exit() invoked");}
	   // additional methods here to
	   // manipulate world objects and
	   // related game state data
	   
	}