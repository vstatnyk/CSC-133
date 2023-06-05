package com.mycompany.a3;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;

public class RobotCollisionCommand implements ActionListener {
	private GameWorld gw;
	public RobotCollisionCommand(GameWorld gw){
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent evt)
    {
		System.out.println("Robots Colided");
		gw.robotCollision(); 
    }
	
}

