package com.mycompany.a2;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;

public class GoRightCommand implements ActionListener {
	private GameWorld gw;
	public GoRightCommand(GameWorld gw){
//		super("Right");
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
    {
		System.out.println("Robot turning Right");
		gw.goRight(); 
    }
	
}