package com.mycompany.a2;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;

import java.util.Observable;

public class ScoreView implements Observer {
	
	private GameWorld gw;
	
	Label livesPrompt;
	Label lives;
	Label clockPrompt;
	Label clock;
	Label basePrompt;
	Label base;
	Label energyPrompt;
	Label energy;
	Label damagePrompt;
	Label damage;
	Label soundPrompt;
	Label sound;
	
	
//	//• ‘d’  –  generate  a  display  by  outputting  lines  of  text  on  the  console  describing  the  current 
//	//game/player-robot state values. The display should include , .  
//	//All output should be appropriately labeled in easily readable format. 
//	case 'd':
//		System.out.println("Displaying data");
//		System.out.println("number of lives left: " + gw.getRobot().getLives());
//		System.out.println("current  clock  value: " + gw.getClock());
//		System.out.println("highest  base reached: " + gw.getRobot().getLastBaseReached());
//		System.out.println("current robot energy level: " + gw.getRobot().getEnergyLevel());
//		System.out.println("current robot damage level: " + gw.getRobot().getDamageLevel());
//		break;
	
	
	public ScoreView(Form th, GameWorld gw){
		Container TopContainer = new Container((new BoxLayout(BoxLayout.X_AXIS)));
		TopContainer.getAllStyles().setPadding(5, 5,60, 0);
		
		clockPrompt = new Label("Time: ");
		clock = new Label("0");
		TopContainer.add(clockPrompt);
		TopContainer.add(clock);
		
		livesPrompt = new Label("Lives Left: ");
		lives = new Label(""+gw.getPlayerRobot().getLives());
		TopContainer.add(livesPrompt);
		TopContainer.add(lives);
		
		basePrompt = new Label("Player Last Base Reached: ");
		base = new Label(""+gw.getPlayerRobot().getLastBaseReached());
		TopContainer.add(basePrompt);
		TopContainer.add(base);
		
		energyPrompt = new Label("Player Energy Level: ");
		energy = new Label(""+gw.getPlayerRobot().getEnergyLevel());
		TopContainer.add(energyPrompt);
		TopContainer.add(energy);
		
		damagePrompt = new Label("Player Damage Level: ");
		damage = new Label(""+gw.getPlayerRobot().getDamageLevel());
		TopContainer.add(damagePrompt);
		TopContainer.add(damage);
		
		soundPrompt = new Label("Sound: ");
		sound = new Label("ON");
		TopContainer.add(soundPrompt);
		TopContainer.add(sound);
		
		TopContainer.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.BLUE));
		th.add(BorderLayout.NORTH,TopContainer);
	}
	
	public void update(Observable observable, Object data) {
		gw = (GameWorld) data;
		lives.setText(""+gw.getPlayerRobot().getLives());
		clock.setText(""+gw.getClock());
		base.setText(""+gw.getPlayerRobot().getLastBaseReached());
		energy.setText(""+gw.getPlayerRobot().getEnergyLevel());
		damage.setText(""+gw.getPlayerRobot().getDamageLevel());
		if(gw.getSound()){
			sound.setText("ON");
		}
		else{
			sound.setText("OFF");
		}
		
		
	}
}
