package com.mycompany.a3;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;

public class GoLeftCommand implements ActionListener {
	private GameWorld gw;
	public GoLeftCommand(GameWorld gw){
//		super("Left");
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
    {
		System.out.println("Robot turning left");
		gw.goLeft(); 
    }
	
}
