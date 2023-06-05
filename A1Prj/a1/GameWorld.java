package com.mycompany.a1;
import com.codename1.ui.events.ActionListener;
import com.codename1.charts.util.ColorUtil;
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
	private int clock;




	public void init(){
		Random rand = new Random();
		//code here to create the
		//initial game objects/setup
		System.out.println("GameWorld init() invoked");
		
		clock = 0;
		
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
	public int getClock(){return this.clock;}
	public void setClock(int c){this.clock = c;}
	public void incClock() {this.clock++;}
	
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
	
	public void droneCollision(){
		int fadeIncrement = 250/r.getMaxDamageLevel();
		this.r.setDamageLevel(this.r.getDamageLevel() + 1);
		this.r.setMaximumSpeed(this.r.getMaximumSpeed()-1);
		if(this.r.getDamageLevel() == this.r.getMaxDamageLevel()){
			this.r.reset(bases.get(0).getLocation().getX(), bases.get(0).getLocation().getY());
			if(this.r.getLives() == 0) {
				System.out.println("Game over, you failed!");
				exit();
				return;
			}
		}
		else{
			this.r.setColor(ColorUtil.red(this.r.getColor())+fadeIncrement, ColorUtil.green(this.r.getColor())-fadeIncrement, ColorUtil.blue(this.r.getColor()));
			if(this.r.getSpeed()>this.r.getMaximumSpeed()) {
				this.r.setSpeed(this.r.getMaximumSpeed());
			}
		}
	};
	
	public void robotCollision(){
		int fadeIncrement = 250/r.getMaxDamageLevel();
		this.r.setDamageLevel(this.r.getDamageLevel() + 1);
		this.r.setMaximumSpeed(this.r.getMaximumSpeed()-1);
		if(this.r.getDamageLevel() == this.r.getMaxDamageLevel()){
			this.r.reset(bases.get(0).getLocation().getX(), bases.get(0).getLocation().getY());
			if(this.r.getLives() == 0) {
				System.out.println("GAME OVER!");
				return;
			}
		}
		else{
			this.r.setColor(ColorUtil.red(this.r.getColor())+fadeIncrement, ColorUtil.green(this.r.getColor())-fadeIncrement, ColorUtil.blue(this.r.getColor()));
			if(this.r.getSpeed()>this.r.getMaximumSpeed()) {
				this.r.setSpeed(this.r.getMaximumSpeed());
			}
		}
	}
	
	public void baseCollision(int bn){
		if (this.r.getLastBaseReached()+1 == bn){
			this.r.setLastBaseReached(bn);
			if(this.r.getLastBaseReached() == bases.size()){
				System.out.println("Game over, you win! Total time: " + this.clock);
			}
		}
		else{
			System.out.println("Wrong base");
		}
	};
	
	public void energyStationCollision(){
		for(int i = 0; i< this.energyStations.size(); i++){
			if(!this.energyStations.get(i).isEmpty()){
				this.r.refilEnergyLevel(this.energyStations.get(i).getCapacity());
				this.energyStations.get(i).setCapacity(0);
				this.energyStations.get(i).setColor(0, 100, 0);
				break;
			}
		}
		this.energyStations.add(new EnergyStation());
	}
	
	public void exit(){
		
		System.out.println("GameWorld exit() invoked");
		System.exit(0);
	}
	   
	   
	}