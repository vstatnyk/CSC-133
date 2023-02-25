package com.mycompany.a1;
import com.codename1.ui.events.ActionListener; 
import com.codename1.ui.Label; 
import com.codename1.ui.TextField; 
import com.codename1.ui.events.ActionEvent; 
import java.lang.String;
import java.util.Vector; 

public class Game extends com.codename1.ui.Form{
	private GameWorld gw;
	
	Game(){
		gw = new GameWorld();
		gw.init();
		play();
		
	}

	private void play() { 
		Label myLabel=new Label("Enter a Command:"); 
		this.addComponent(myLabel); 
		final TextField myTextField=new TextField(); 
		this.addComponent(myTextField); 
		this.show(); 
	
		myTextField.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent evt) {
			String sCommand = myTextField.getText().toString(); 
			 myTextField.clear();
			 if(sCommand.length()!=0) {
				 switch (sCommand.charAt(0)) { 
				 
				//• ‘x’  – exit,  by  calling  the  method System.exit(0) to  terminate  the  program. Your 
				//program  should  confirm  the  user’s  intent  (see  ‘y’  and  ‘n’  commands  below)  to  quit  before 
				//actually exiting. 
				case 'x':
					System.out.println("Game exit");
					//• ‘y’ – user has confirmed the exit by saying yes. 
					gw.exit();
					//• ‘n’ – user has not confirmed the exit by saying no.
					break;
					
				//a’ – tell the game world to accelerate (immediately increase the speed of) the player robot 
				//by a small amount.  Note that the effect of acceleration is to be limited based on damage level, 
				//energy level, and maximum speed as described above.  
				case 'a':
					System.out.println("Robot accelerating");
					gw.getRobot().accelerate();  
					break;
					
				//• ‘b’ – tell the game world to  brake (immediately reduce the speed of) the player robot by a 
				//small amount.  Note that the minimum speed for a robot is zero. 
				case 'b': 
					System.out.println("Robot Braking");
					 gw.getRobot().brake(); 
					break; 
					
					//TODO
				//• ‘l’ (the letter “ell”) – tell the game world to change the steering direction of the player robot 
				//by 5 degrees to the left (in the negative direction on the compass).  Note that this changes the 
				//direction  of  the  robot’s  steering  wheel;  it  does  not  directly  (immediately)  affect  the  robot’s 
				//heading.  See the “tick” command, below. 
				case 'l':
					System.out.println("Robot turning left");
					gw.getRobot().goLeft();  
					break; 
				
					//TODO
				//• ‘r’ – tell the game world to change the steering direction of the player robot by 5 degrees to 
				//the right (in the positive direction on the compass).  As above, this changes the direction of the 
				//robot’s steering wheel, not the robot’s heading. 
				case 'r':
					System.out.println("Robot turning right");
					gw.getRobot().goRight();  
					break; 
					
				//• ‘c’ – PRETEND that the player robot has collided with some other robot; tell the game world 
				//that  this  collision  has  occurred.  (For this version of the program we won’t actually have any 
				//other  robot  in  the  simulation,  but  we  need  to  provide for  testing  the  effect of  such  collisions.)  
				//Colliding with another robot increases the damage level of the player robot and fades the color 
				//of the robot (i.e., the robot color becomes lighter red – throughout the game, the robot will have 
				//different shades of red); if the damage results in the player robot not being able to move then 
				//the game stops (the player loses a life). 
				case 'c': 
					System.out.println("Robots Colided");
					gw.robotCollision();  
					break;
					
				//• ‘a  number  between  1-9’–  PRETEND  that  the  player  robot  has  collided  with  the  base 
				//number  x  (which  must  have  a  value  between  1-9);  tell  the  game  world  that  this  collision  has 
				//occurred. The effect of moving over a base is to check to see whether the number x is exactly 
				//one greater than the base indicated by lastBaseReached field of the robot and if so to record in 
				//the robot the fact that the robot has now reached the next sequential base on the track (update 
				//the lastBaseReached field of the robot).
				case '1':
					System.out.println("Base 1 Reached");
					gw.baseCollision(1);
					break; 
				case '2':
					System.out.println("Base 2 Reached");
					gw.baseCollision(2);
					break; 
				case '3': 
					System.out.println("Base 3 Reached");
					gw.baseCollision(3);
					break; 
				case '4': 
					System.out.println("Base 4 Reached");
					gw.baseCollision(4);
					break; 
				case '5': 
					System.out.println("Base 5 Reached");
					gw.baseCollision(5);
					break; 
				case '6': 
					System.out.println("Base 6 Reached");
					gw.baseCollision(6);
					break; 
				case '7': 
					System.out.println("Base 7 Reached");
					gw.baseCollision(7);
					break; 
				case '8': 
					System.out.println("Base 8 Reached");
					gw.baseCollision(8);
					break; 
				case '9': 
					System.out.println("Base 9 Reached");
					gw.baseCollision(9);
					break; 
					
				//• ‘e’ – PRETEND that the player robot has collided with (intersected with) an energy station; 
				//tell the game world that this collision has occurred.  The effect of  colliding an energy station is 
				//to increase the robot’s energy level by the capacity of the energy station, reduce the capacity 
				//of the energy station to zero, fade the color of the energy station (e.g., change it to light green), 
				//and add a new energy station with randomly-specified size and location into the game.
				case 'e': 
					System.out.println("Energy Station reached");
					gw.energyStationCollision();
					break; 
				
				//•  ‘g’ – PRETEND that a  drone has flown over (collided with, gummed up) the player robot.  
				//The effect of colliding with a drone is to increase the damage to the robot as described above 
				//under the description of drones and fades the color of the robot (i.e., the robot color becomes 
				//lighter red).
				case 'g': 
					System.out.println("Robot Drone colission happened");
					gw.droneCollision();
					break; 	
				
				//•  ‘t’ – tell the game world that the “game clock” has ticked.   A clock tick in the game world 
				//has the following effects: (1) if the player robot moves (e.g., did not run out of energy or does 
				//not have the maximum damage or zero speed), then the robot’s  heading  should  be 
				//incremented or decremented by the robot’s steeringDirection (that is, the steering wheel turns 
				//the  robot)  (2)  Drones  also  update  their  heading  as  indicated  above.  (3)  all  moveable  objects 
				//are  told  to  update  their  positions  according  to  their  current  heading  and  speed,  and  (4)  the 
				//robot’s energy  level  is  reduced  by  the  amount  indicated  by  its  energyConsumptionRate.    (5) 
				//the elapsed time “game clock” is incremented  by  one  (the  game  clock  for  this  assignment  is 
				//simply a variable which increments with each tick). 
				case 't':
					System.out.println("Tick");
					gw.incClock();
					gw.getRobot().move();
					gw.getRobot().setEnergyLevel(gw.getRobot().getEnergyLevel()- gw.getRobot().getEnergyConsumptionRate());
					break; 
				
				//• ‘d’  –  generate  a  display  by  outputting  lines  of  text  on  the  console  describing  the  current 
				//game/player-robot state values. The display should include , .  
				//All output should be appropriately labeled in easily readable format. 
				case 'd':
					System.out.println("Displaying data");
					System.out.println("number of lives left: " + gw.getRobot().getLives());
					System.out.println("current  clock  value: " + gw.getClock());
					System.out.println("highest  base reached: " + gw.getRobot().getLastBaseReached());
					System.out.println("current robot energy level: " + gw.getRobot().getEnergyLevel());
					System.out.println("current robot damage level: " + gw.getRobot().getDamageLevel());
					break;
				
				//• ‘m’ – tell the game world to output a “map” showing the current world (see below). 
				case 'm': 
					System.out.println("map");
					gw.map();  
					break; 
					
				default:
					System.out.println("Default of Game switch statement invoked");
					}
				
	 			//add code to handle rest of the commands  
				} //switch 
			} //actionPerformed 
		} //new ActionListener() 
	); //addActionListener 
	} //play
}



 





  




//7 of 13  

  





  


