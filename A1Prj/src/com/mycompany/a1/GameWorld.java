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
	private Vector<EnergyStation> energyStations = new Vector<EnergyStation>();
	private Vector<Drone> drones = new Vector<Drone>();
	
	



	public void init(){
		Random rand = new Random();
		//code here to create the
		//initial game objects/setup
		System.out.println("GameWorld init() invoked");
		
		//new Robot
		this.r = new Robot(10);
//		System.out.print("\n" + r.info() + "\n");
		
		//Bases
		for(int i = 1; i < 5; i++ ){
			bases.add(new Base(i));
		}
//		for(int i = 0; i < bases.size(); i++ ){
//			System.out.println(bases.get(i).info());
//		}
		
		r.setLocation(bases.get(0).getLocation().getX(), bases.get(0).getLocation().getY());
		
		//energy stations
		for(int i = 0; i < 2; i++ ){
			energyStations.add(new EnergyStation());
		}
//		for(int i = 0; i < energyStations.size(); i++ ){
//			System.out.println(energyStations.get(i).info());
//		}
		
		//drones
		for(int i = 0; i < 2; i++ ){
			drones.add(new Drone(10 + rand.nextInt(41)));
		}
//		for(int i = 0; i < drones.size(); i++ ){
//			System.out.println(drones.get(i).info());
//		}
		

	}
	
	public Robot getRobot() {return this.r;}
	public Vector getBases() {return this.bases;}
	public Vector getEnergyStations() {return this.energyStations;}
	public Vector getDrones() {return this.drones;}

	public void map(){
		System.out.print("\n" + r.info() + "\n");
		for(int i = 0; i < bases.size(); i++ ){
			System.out.println(bases.get(i).info());
		}
		for(int i = 0; i < energyStations.size(); i++ ){
			System.out.println(energyStations.get(i).info());
		}
		for(int i = 0; i < drones.size(); i++ ){
			System.out.println(drones.get(i).info());
		}
	
	
	}
	
	public void robotColissoin() {
		
	}
	public void baseColission() {
		
	}
	public void droneCollison() {
		
	}
	
	public void exit(){
		System.out.println("GameWorld exit() invoked");
		System.exit(0);
	}
	   
	   
	}