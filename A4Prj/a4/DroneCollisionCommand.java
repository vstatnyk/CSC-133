package com.mycompany.a4;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;

public class DroneCollisionCommand implements ActionListener {
	private GameWorld gw;
	
	public DroneCollisionCommand(GameWorld gw){
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
    {
		System.out.println("Robot Drone colission happened");
		gw.droneCollision();
    }

}