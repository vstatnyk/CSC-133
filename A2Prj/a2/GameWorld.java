package com.mycompany.a2;
import com.codename1.ui.events.ActionListener;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Label; 
import com.codename1.ui.TextField; 
import com.codename1.ui.events.ActionEvent; 
import java.lang.String; 
import java.util.Vector;
import java.util.Random;
import java.util.Observable;


public class GameWorld extends Observable {
	
	private PlayerRobot r;
	private int clock;
	private GameObjectCollection goc;
	private boolean sound;
	



	public void init(){
		
		//bases
		//set player location
		//NPC robots
		//energy station
		//drone
		//player robot
		
		double tempX = 0;
		double tempY = 0;
		
		Random rand = new Random();
		System.out.println("GameWorld init() invoked");
		
		goc = new GameObjectCollection();
		clock = 0;
		
		//new Robot
		this.r = PlayerRobot.getInstatnce();
		
		//add playerRobot and Bases
		for(int i = 1; i < 5; i++ ){
			goc.add(new Base(i));
			if (i == 1){
				GameObject tempGO;
				IIterator j = goc.getIterator();
				while(j.hasNext()){
					tempGO = j.getNext();
					if(tempGO instanceof Base && ((Base) tempGO).getSequence() == 1){
						tempX = tempGO.getLocation().getX();
						tempY = tempGO.getLocation().getY();
					}
				}
			}
		}
		
		//NPC robots
		for(int i = 0; i < 3; i++ ){
			NonPlayerRobot tempNPR = new NonPlayerRobot(10, tempX, tempY);
			
			int x =rand.nextInt(1);
			if(x == 0){
				tempNPR.setStrategy(new AttackStartegy(this, tempNPR));
			}
			else{
				tempNPR.setStrategy(new BaseStrategy(this, tempNPR));
			}
			
			goc.add(tempNPR);
		}
		
		//energy stations
		for(int i = 0; i < 2; i++ ){
			goc.add(new EnergyStation());
		}
		
		//drones
		for(int i = 0; i < 2; i++ ){
			goc.add(new Drone(10 + rand.nextInt(41)));
		}
		
		//Player Robot
		this.r.setLocation(tempX, tempY);
		goc.add(r);
		
		this.setChanged();
		this.notifyObservers(this);
		
	}
	
	public GameObjectCollection getCollection() {return this.goc;}
	public Robot getPlayerRobot() {return this.r;}
	public int getClock(){return this.clock;}
	public boolean getSound(){return this.sound;}
	public void setClock(int c){this.clock = c;}
	public void setSound(boolean tf){
		this.setChanged();
		this.notifyObservers(this);
		this.sound = tf;
	}
	public void incClock() {this.clock++;}
	
	//Commands
	
	
	
	public void changeStrategy(){
		GameObject tempGO;
		IIterator j = this.getCollection().getIterator();
		while(j.hasNext()){
			tempGO = j.getNext();
			if(tempGO instanceof NonPlayerRobot){
				if(((NonPlayerRobot)tempGO).getStrategy().getName() == "Attack Strategy"){
					((NonPlayerRobot)tempGO).setStrategy(new BaseStrategy(this, ((NonPlayerRobot)tempGO)));
					((NonPlayerRobot)tempGO).setLastBaseReached(((NonPlayerRobot)tempGO).getLastBaseReached()+1);
				}
				else{
					((NonPlayerRobot)tempGO).setStrategy(new AttackStartegy(this, ((NonPlayerRobot)tempGO)));
				}
			}
		}
		
		this.setChanged();
		this.notifyObservers(this);
		
	}
	
	public void tick() {
		this.incClock();
		this.getPlayerRobot().move();
		this.getPlayerRobot().setEnergyLevel(this.getPlayerRobot().getEnergyLevel()- this.getPlayerRobot().getEnergyConsumptionRate());
		
		//do same for every NPC
		GameObject tempGO;
		IIterator j = this.getCollection().getIterator();
		while(j.hasNext()){
			tempGO = j.getNext();
			if(tempGO instanceof NonPlayerRobot){
				((NonPlayerRobot)tempGO).move();
				((NonPlayerRobot)tempGO).setEnergyLevel(((NonPlayerRobot)tempGO).getEnergyLevel()- ((NonPlayerRobot)tempGO).getEnergyConsumptionRate());
			}
		}
		
		
		this.setChanged();
		this.notifyObservers(this);
		
	}
	
	public void accelerate(){
		this.r.accelerate();
		this.setChanged();
		this.notifyObservers(this);
	}
	
	public void goLeft(){
		this.r.goLeft();
		this.setChanged();
		this.notifyObservers(this);
	}
	
	public void goRight(){
		this.r.goRight();
		this.setChanged();
		this.notifyObservers(this);
	}
	
	public void brake(){
		this.r.brake();
		this.setChanged();
		this.notifyObservers(this);
	}
	
	public void droneCollision(){
		int fadeIncrement = 250/r.getMaxDamageLevel();
		
		double tempX = 0;
		double tempY = 0;
		GameObject tempBase;
		IIterator j = goc.getIterator();
		while(j.hasNext()){
			tempBase = j.getNext();
			if(tempBase instanceof Base && ((Base) tempBase).getSequence() == 1){
				tempX = tempBase.getLocation().getX();
				tempY = tempBase.getLocation().getY();
			}
		}
		
		this.r.setDamageLevel(this.r.getDamageLevel() + 1);
		this.r.setMaximumSpeed(this.r.getMaximumSpeed()-1);
		if(this.r.getDamageLevel() == this.r.getMaxDamageLevel()){
			this.r.reset(tempX, tempY);
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
		
		this.setChanged();
		this.notifyObservers(this);
	};
	
	public void robotCollision(){
		
		double tempX = 0;
		double tempY = 0;
		
		GameObject tempBase;
		IIterator j = goc.getIterator();
		while(j.hasNext()){
			tempBase = j.getNext();
			if(tempBase instanceof Base && ((Base) tempBase).getSequence() == 1){
				tempX = tempBase.getLocation().getX();
				tempY = tempBase.getLocation().getY();
			}
		}
		
		GameObject tempRobot;
		IIterator i = goc.getIterator();
		while(i.hasNext()){
			tempRobot = i.getNext();
			if(tempRobot instanceof NonPlayerRobot){
				((NonPlayerRobot)tempRobot).setDamageLevel(((NonPlayerRobot)tempRobot).getDamageLevel() + 1);
				((NonPlayerRobot)tempRobot).setMaximumSpeed(((NonPlayerRobot)tempRobot).getMaximumSpeed()-1);
				if(((NonPlayerRobot)tempRobot).getDamageLevel() == ((NonPlayerRobot)tempRobot).getMaxDamageLevel()){
					((NonPlayerRobot)tempRobot).reset(tempX, tempY);
					if(((NonPlayerRobot)tempRobot).getLives() == 0) {
						System.out.println("GAME OVER!");
						return;
					}
				}
				else{
					int fadeIncrement = 250/((NonPlayerRobot)tempRobot).getMaxDamageLevel();
					((NonPlayerRobot)tempRobot).setColor(ColorUtil.red(((NonPlayerRobot)tempRobot).getColor())+fadeIncrement, ColorUtil.green(((NonPlayerRobot)tempRobot).getColor())-fadeIncrement, ColorUtil.blue(((NonPlayerRobot)tempRobot).getColor()));
					if(((NonPlayerRobot)tempRobot).getSpeed()>((NonPlayerRobot)tempRobot).getMaximumSpeed()) {
						((NonPlayerRobot)tempRobot).setSpeed(((NonPlayerRobot)tempRobot).getMaximumSpeed());
					}
				}
			}
		}
		
		this.r.setDamageLevel(this.r.getDamageLevel() + 1);
		this.r.setMaximumSpeed(this.r.getMaximumSpeed()-1);
		if(this.r.getDamageLevel() == this.r.getMaxDamageLevel()){
			this.r.reset(tempX, tempY);
			if(this.r.getLives() == 0) {
				System.out.println("GAME OVER!");
				return;
			}
		}
		else{
			int fadeIncrement = 250/this.r.getMaxDamageLevel();
			this.r.setColor(ColorUtil.red(this.r.getColor())+fadeIncrement, ColorUtil.green(this.r.getColor())-fadeIncrement, ColorUtil.blue(this.r.getColor()));
			if(this.r.getSpeed()>this.r.getMaximumSpeed()) {
				this.r.setSpeed(this.r.getMaximumSpeed());
			}
		}
		this.setChanged();
		this.notifyObservers(this);
	}
	
	public void baseCollision(int bn){
		if (this.r.getLastBaseReached()+1 == bn){
			this.r.setLastBaseReached(bn);
			//temp 4 bases
			if(this.r.getLastBaseReached() == 4){
				System.out.println("Game over, you win! Total time: " + this.clock);
			}
		}
		else{
			System.out.println("Wrong base");
		}
		
//		
		this.setChanged();
		this.notifyObservers(this);
	};
	
	public void energyStationCollision(){
		
		GameObject tempGO;
		IIterator j = goc.getIterator();
		while(j.hasNext()){
			tempGO = j.getNext();
			if(tempGO instanceof EnergyStation && !(((EnergyStation)tempGO).isEmpty())){
				this.r.refilEnergyLevel(((EnergyStation)tempGO).getCapacity());
				((EnergyStation)tempGO).setCapacity(0);
				((EnergyStation)tempGO).setColor(0, 100, 0);
				break;
			}
		}
		
		IIterator i = goc.getIterator();
		while(i.hasNext()){
			tempGO = i.getNext();
		}
		goc.add(new EnergyStation());
		
		
		this.setChanged();
		this.notifyObservers(this);
	}
	
	public void exit(){
		System.out.println("GameWorld exit() invoked");
		System.exit(0);
	}
	   
	   
	}