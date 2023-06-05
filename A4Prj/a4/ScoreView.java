package com.mycompany.a4;
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

public class ScoreView extends Container implements Observer {
	
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
	
	
	public ScoreView(){
		super(new BoxLayout(BoxLayout.X_AXIS));
		this.getAllStyles().setPadding(5, 5,60, 0);
		
		clockPrompt = new Label("Time: ");
		clock = new Label("0");
		this.add(clockPrompt);
		this.add(clock);
		
		livesPrompt = new Label("Lives Left: ");
		lives = new Label("3");
		this.add(livesPrompt);
		this.add(lives);
		
		basePrompt = new Label("Player Last Base Reached: ");
		base = new Label("1");
		this.add(basePrompt);
		this.add(base);
		
		energyPrompt = new Label("Player Energy Level: ");
		energy = new Label("100");
		this.add(energyPrompt);
		this.add(energy);
		
		damagePrompt = new Label("Player Damage Level: ");
		damage = new Label("0");
		this.add(damagePrompt);
		this.add(damage);
		
		soundPrompt = new Label("Sound: ");
		sound = new Label("ON");
//		sound = new Label("OFF");
		this.add(soundPrompt);
		this.add(sound);
		
		this.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.BLUE));
		
	}
	
	public void update(Observable observable, Object data) {
//		System.out.println("n\n\n\n\nupdate called:current soudn: "+gw.getSound());
		gw = (GameWorld) data;
		lives.setText(""+gw.getPlayerRobot().getLives());
		clock.setText(""+gw.getClock()/1000);
		base.setText(""+gw.getPlayerRobot().getLastBaseReached());
		energy.setText(""+(int)gw.getPlayerRobot().getEnergyLevel());
		damage.setText(""+gw.getPlayerRobot().getDamageLevel());
		if(gw.getSound() == true){
			sound.setText("ON");
		}
		else{
			sound.setText("OFF");
		}
		
		
	}
}
