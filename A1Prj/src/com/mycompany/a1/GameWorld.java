package com.mycompany.a1;
import com.codename1.ui.events.ActionListener; 
import com.codename1.ui.Label; 
import com.codename1.ui.TextField; 
import com.codename1.ui.events.ActionEvent; 
import java.lang.String; 

public class GameWorld {
	   public void init(){
	      //code here to create the
	      //initial game objects/setup
		   
	}
	public void exit(){}
	   // additional methods here to
	   // manipulate world objects and
	   // related game state data
	}



//private void play() 
//{ 
//Label myLabel=new Label("Enter a Command:"); 
//this.addComponent(myLabel); 
//final TextField myTextField=new TextField(); 
//this.addComponent(myTextField); 
//this.show(); 
//
//myTextField.addActionListener(new ActionListener(){ 
//
// public void actionPerformed(ActionEvent evt) { 
//    
// String sCommand=myTextField.getText().toString(); 
// myTextField.clear(); 
// switch (sCommand.charAt(0)) { 
//  case 'x': 
//   gw.exit();  
//   break; 
//  //add code to handle rest of the commands  
// } //switch 
//} //actionPerformed 
//   } //new ActionListener() 
//); //addActionListener 
//} //play



//a’ – tell the game world to accelerate (immediately increase the speed of) the player robot 
//by a small amount.  Note that the effect of acceleration is to be limited based on damage level, 
//energy level, and maximum speed as described above.   

//• ‘b’ – tell the game world to  brake (immediately reduce the speed of) the player robot by a 
//small amount.  Note that the minimum speed for a robot is zero. 

//• ‘l’ (the letter “ell”) – tell the game world to change the steering direction of the player robot 
//by 5 degrees to the left (in the negative direction on the compass).  Note that this changes the 
//direction  of  the  robot’s  steering  wheel;  it  does  not  directly  (immediately)  affect  the  robot’s 
//heading.  See the “tick” command, below. 

//• ‘r’ – tell the game world to change the steering direction of the player robot by 5 degrees to 
//the right (in the positive direction on the compass).  As above, this changes the direction of the 
//robot’s steering wheel, not the robot’s heading.   

//• ‘c’ – PRETEND that the player robot has collided with some other robot; tell the game world 
//that  this  collision  has  occurred.  (For this version of the program we won’t actually have any 
//other  robot  in  the  simulation,  but  we  need  to  provide for  testing  the  effect of  such  collisions.)  
//Colliding with another robot increases the damage level of the player robot and fades the color 
//of the robot (i.e., the robot color becomes lighter red – throughout the game, the robot will have 
//different shades of red); if the damage results in the player robot not being able to move then 
//the game stops (the player loses a life). 

//• ‘a  number  between  1-9’–  PRETEND  that  the  player  robot  has  collided  with  the  base 
//number  x  (which  must  have  a  value  between  1-9);  tell  the  game  world  that  this  collision  has 
//occurred. The effect of moving over a base is to check to see whether the number x is exactly 
//one greater than the base indicated by lastBaseReached field of the robot and if so to record in 
//  
// 7 of 13 
//the robot the fact that the robot has now reached the next sequential base on the track (update 
//the lastBaseReached field of the robot).   

//• ‘e’ – PRETEND that the player robot has collided with (intersected with) an energy station; 
//tell the game world that this collision has occurred.  The effect of  colliding an energy station is 
//to increase the robot’s energy level by the capacity of the energy station, reduce the capacity 
//of the energy station to zero, fade the color of the energy station (e.g., change it to light green), 
//and add a new energy station with randomly-specified size and location into the game.   

//•  ‘g’ – PRETEND that a  drone has flown over (collided with, gummed up) the player robot.  
//The effect of colliding with a drone is to increase the damage to the robot as described above 
//under the description of drones and fades the color of the robot (i.e., the robot color becomes 
//lighter red). 

//•  ‘t’ – tell the game world that the “game clock” has ticked.   A clock tick in the game world 
//has the following effects: (1) if the player robot moves (e.g., did not run out of energy or does 
//not have the maximum damage or zero speed), then the robot’s  heading  should  be 
//incremented or decremented by the robot’s steeringDirection (that is, the steering wheel turns 
//the  robot)  (2)  Drones  also  update  their  heading  as  indicated  above.  (3)  all  moveable  objects 
//are  told  to  update  their  positions  according  to  their  current  heading  and  speed,  and  (4)  the 
//robot’s energy  level  is  reduced  by  the  amount  indicated  by  its  energyConsumptionRate.    (5) 
//the elapsed time “game clock” is incremented  by  one  (the  game  clock  for  this  assignment  is 
//simply a variable which increments with each tick).   

//• ‘d’  –  generate  a  display  by  outputting  lines  of  text  on  the  console  describing  the  current 
//game/player-robot state values. The display should include (1) the number of lives left, (2) the 
//current  clock  value  (elapsed  time),  (3)  the  highest  base  number  the  robot  has  reached 
//sequentially  so  far,  (4)  the  robot’s current  energy  level  and  (5)  robot’s current damage  level.  
//All output should be appropriately labeled in easily readable format. 

//• ‘m’ – tell the game world to output a “map” showing the current world (see below). 

//• ‘x’  – exit,  by  calling  the  method System.exit(0) to  terminate  the  program. Your 
//program  should  confirm  the  user’s  intent  (see  ‘y’  and  ‘n’  commands  below)  to  quit  before 
//actually exiting.   

//• ‘y’ – user has confirmed the exit by saying yes. 

//• ‘n’ – user has not confirmed the exit by saying no.